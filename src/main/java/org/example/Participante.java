package org.example;

public class Participante {

    private int id ;
    private String nome ;
    private String email ;


    public Participante() {
    }

    public Participante(int id, String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.id = id;
    }

    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;
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
        return "\n------------------" +
                "\nParticipante" +
                "\nId = " + id +
                "\nNome = " + nome  +
                "\nEmail = " + email +
                "\n------------------"
                ;
    }
}
