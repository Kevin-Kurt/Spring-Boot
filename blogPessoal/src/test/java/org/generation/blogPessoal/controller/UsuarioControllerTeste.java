package org.generation.blogpessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.blogpessoal.model.UserLogin;
import org.generation.blogpessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTeste {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private Usuario usuario;
    private Usuario usuarioupd;

    
	@BeforeAll
    public void start(){
        usuario = new Usuario("Isaque","isaquec","123456");
        usuarioupd = new Usuario (1L, "Isaque Costa","isaquebosta","123456");
    }

	@Disabled
	@Test
	public void cadastrarUsuarios() {
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuario);
		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuario/cadastrar", HttpMethod.POST, request, Usuario.class);
				assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
	}
	
	
	@Test
	public void logarUsuarios() {
		UserLogin userLogin = new UserLogin(usuario);
		HttpEntity<UserLogin> request = new HttpEntity<UserLogin>(userLogin);
		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuario/logar", HttpMethod.POST, request, Usuario.class);
				assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	
	@Test
	public void mostrarTodosUsuarios() {
		ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("isaquec", "123456")
				.exchange("/usuario", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	
	@Test
	public void putUsuarios() {
		HttpEntity<Usuario> request = new HttpEntity<Usuario>(usuarioupd);
		ResponseEntity<Usuario> resposta = testRestTemplate.exchange("/usuario/atualizar", HttpMethod.PUT, request, Usuario.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	
	@Test
	public void deleteUsuarios() {
		ResponseEntity<String> resposta = testRestTemplate.withBasicAuth("Isaque", "123456")
				.exchange("/usuario/1", HttpMethod.DELETE, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}

    
}