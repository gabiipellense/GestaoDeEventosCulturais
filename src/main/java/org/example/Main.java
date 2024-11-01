package org.example;

import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {

        ConexaoBanco.getConnections();
        BancoEvento.adicionarEvento(new Evento("Gabriela", "Jaragua", "22/10/2024", "aaaaa"));

    }

    public static Evento adicionarEvento () {

        System.out.println("Digite o nome do evento: ");
        String nome = sc.next();

        System.out.println("Digite o lococal do evento: ");
        String local = sc.next();

        System.out.println("Digite a data: ");
        String data = sc.next();

        System.out.println("Digite a descrição do evento: ");
        String descricao = sc.next();

        return BancoEvento.adicionarEvento(new Evento(nome,local,data,descricao));

    }

    public static void apagarEvento () {

    }

    public static Participante adicionarParticipante () {

        System.out.println("Digite o nome do participante do evento: ");
        String nome = sc.next();

        System.out.println("Digite o email do participante do evento: ");
        String email = sc.next();

        return BancoParticipante.adicionarParticipante(new Participante(nome, email));
    }

    public static Participante PesquisaParaBuscarParticipantePorEmail () {

    }

    public static void apagarParticipante () {

    }
    public static Inscricao inscricao () {


    }

    public static void apagarDescricao () {

    }

}