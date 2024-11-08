package org.example;

public class Inscricao {

    private int id ;
    private Evento evento ;
    private Participante participante ;

    public Inscricao(Evento evento, Participante participante, int id) {
        this.evento = evento;
        this.participante = participante;
        this.id = id;
    }

    public Inscricao(Evento evento, Participante participante) {
        this.evento = evento;
        this.participante = participante;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    @Override
    public String toString() {
        return "\n------------------"+
                "\nINSCRIÇÃO" +
                "\nId = " + id +
                "\nEvento = " + evento +
                "\nParticipante = " + participante +
                "\n------------------"
                ;
    }
}
