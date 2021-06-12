package org.generation.blogpessoal.model;

public class UserLogin {

    private String nome;
    private String usuario;
    private String senha;
    private String token;

    public UserLogin(Usuario usuario) {
        this.nome = usuario.getNome();
        this.usuario = usuario.getUsuario();
        this.senha = usuario.getSenha();
    }

    public UserLogin(){

    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    
}
