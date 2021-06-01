package br.org.generation.blogpessoal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.org.generation.blogpessoal.model.Postagem;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo);

}
