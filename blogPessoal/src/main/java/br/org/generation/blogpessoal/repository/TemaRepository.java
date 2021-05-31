package br.org.generation.blogpessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import br.org.generation.blogpessoal.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
