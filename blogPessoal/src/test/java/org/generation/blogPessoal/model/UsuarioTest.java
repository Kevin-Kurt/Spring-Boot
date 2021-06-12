package org.generation.blogpessoal.model;

import javax.validation.Validation;
import javax.validation.Validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {

    public Usuario usuario;

    @Autowired
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @BeforeEach
    public void start(){
        usuario = new Usuario("Isaque","isaquec","123456789");
    }
    
    @Test
    public void testValidationAtributos()
    {
        
        usuario.setNome("Helias");
        usuario.setUsuario("heliasc");
        usuario.setSenha("");

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuario);

        System.out.println(violations.toString());
        assertTrue(violations.isEmpty());

    }

    @Test
    public void testValidationAtributosNulls()
    {

        Usuario usuarioErro = new Usuario();

        usuarioErro.setUsuario("asasasasas");
        usuarioErro.setNome("weqweqwewq");
        usuarioErro.setSenha("2213132123");
        

        Set<ConstraintViolation<Usuario>> violations = validator.validate(usuarioErro);

        System.out.println(violations.toString());
        assertFalse(violations.isEmpty());

    }
}
