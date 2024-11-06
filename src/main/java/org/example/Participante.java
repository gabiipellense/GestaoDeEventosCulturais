package org.example;

public class Participante {

    private int id ;
    private String nome ;
    private String email ;

    private String senha ;

    public Participante(String senha) {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Participante(String nome, String email) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Participante" +
                "\nId = " + id +
                "\nNome = " + nome  +
                "\nEmail = " + email  +
                "\nSenha = " + senha
                ;
    }
}
