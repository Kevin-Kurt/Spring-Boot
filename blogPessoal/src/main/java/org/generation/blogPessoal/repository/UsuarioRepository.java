package org.generation.blogpessoal.repository;

import java.util.*;
import org.generation.blogpessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Optional<Usuario> findByUsuario(String usuario);
    public List<Usuario> findAllByUsuarioContainingIgnoreCase(String usuario);
    public Usuario findFirstByUsuario(String usuario);
}
