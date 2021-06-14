package org.generation.blogPessoal.repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
 
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @BeforeAll
    public void start(){
        Usuario usuario = new Usuario("Chefe", "0y", "9xxxxxxxxx9");
        if (usuarioRepository.findFirstByNome(usuario.getNome() == null))
        usuarioRepository.save(usuario);

        usuario = new Usuario("Danilo", "0y", "8xxxxxxxxx8");
        if (usuarioRepository.findFirstByNome(usuario.getNome() == null))
        usuarioRepository.save(usuario);

        usuario = new Usuario("Oliver", "0y", "7xxxxxxxxx7");
        if (usuarioRepository.findFirstByNome(usuario.getNome() == null))
        usuarioRepository.save(usuario);

        usuario = new Usuario("Graciele", "0y", "5xxxxxxxxx5");
        if (usuarioRepository.findFirstByNome(usuario.getNome() == null))
        usuarioRepository.save(usuario);    
    }

    @Test
    public void findByNomeRetornaContato() throws Exception{
        Usuario usuario = usuarioRepository.findFirstByNome("Chefe");
        assertTrue(usuario.getNome().equals("Chefe"));
    
    }

    @Test
    public void findAllByNomeIgnoreCaseRetornaTresUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAllByNomeIgnoreCaseContaining("chefe");
        assertEquals(3, usuarios.size());    
    }

    @AfterAll
    public void end(){
        usuarioRepository.deleteAll();
    }
    
}
