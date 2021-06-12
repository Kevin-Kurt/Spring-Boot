package org.generation.blogpessoal.controller;

import java.util.List;
import org.generation.blogpessoal.model.Postagem;
import org.generation.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // DECLANDO A CLASSE COMO CONTROLLER
@RequestMapping("/postagens")
@CrossOrigin("*") //ACEITANDO REQUISIÇÕES DE QUALQUER ORIGEM
public class PostagemConstroller {
	
	@Autowired // ADICIONANDO A CLASSE POSTAGEM REPOSITORY DENTRO DO CONTROLLER
	private PostagemRepository classerepo;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> PegarTudo(){
		return ResponseEntity.ok(classerepo.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> PegarPorId(@PathVariable long id){
		return classerepo.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> PegarTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(classerepo.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@PostMapping
	public ResponseEntity<Postagem> postar(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(classerepo.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> editar(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(classerepo.save(postagem));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		classerepo.deleteById(id);
	}
	
}
