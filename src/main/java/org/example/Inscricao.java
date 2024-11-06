package org.example;

public class Inscricao {

    private int id ;
    private Evento evento ;
    private Participante participante ;

    public Inscricao(int eventoId, int participanteId) {
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
}
