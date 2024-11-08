package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {


        int resposta1 ;
        int resposta;


        do {
            System.out.println("Você já possui cadastro?\n1 - SIM\n2 - NÃO ");
            resposta1  = sc.nextInt();

            if (resposta1 == 1) {

                if ( entrar() == 0 ){
                    resposta1 = 3;
                }


            } else if (resposta1 == 2) {

                cadastrar();

            } else {
                System.out.println("Este número não é uma opção. Tente novamente!");
            }

        }while (resposta1 != 1 && resposta1 != 2);


        do {
            System.out.println("Digite o número do menu correspondente a ação desejada: ");
            System.out.println("---------------MENU---------------");
            System.out.println("1 - Cadastrar Evento ");
            System.out.println("2 - Remover Evento ");
            System.out.println("3 - Buscar Evento por Nome ");
            System.out.println("4 - Ver todos os Eventos ");
            System.out.println("5 - Cadastrar Participante ");
            System.out.println("6 - Remover Participante ");
            System.out.println("7 - Buscar Participante por Email");
            System.out.println("8 - Fazer Inscrição ");
            System.out.println("9 - Remover Inscrição ");
            System.out.println("10 - Buscar Inscrição por Id ");
            System.out.println("11 - Buscar todos os Participantes ");
            System.out.println("12 - Buscar todas as Inscrições ");
            System.out.println("0 - Sair");
            System.out.println("----------------------------------");


            resposta = sc.nextInt();

            switch (resposta) {

                case 1 :

                    adicionarEvento();

                    break;

                case 2 :

                    apagarEvento();

                    break;

                case 3 :

                    buscarEventoPorNome();

                    break;

                case 4 :

                    mostrarTodosOsEventos();

                    break;

                case 5 :

                    adicionarParticipante();

                    break;

                case 6 :

                    apagarParticipante();

                    break;

                case 7 :

                    pesquisaParaBuscarParticipantePorEmail();

                    break;

                case 8 :

                    inscricao();

                    break;

                case 9 :

                    apagarInscricao();

                    break;

                case 10 :

                    buscarInscricaoPorId();

                    break;

                case 11:

                    buscarTodosOsParticipantes();

                    break;

                case 12:

                    buscarTodasAsInscricoes();

                    break;



                case 0 :
                    System.exit(0);

                    break;

                default:
                    System.out.println("Esse número não está no MENU ");
            }

        }while (resposta != 0);

    }

    public static void cadastrar () {

        System.out.println("CADASTRO");
        adicionarParticipante();

    }

    public static int entrar () {

        System.out.println("LOGIN");

        System.out.println("Digite o seu id de cadastro ");
        int id = sc.nextInt();

        try {
            BancoParticipante.buscarParticipantePorId( id );
            return 1;
        } catch ( RuntimeException e ) {
            System.out.println("Não foi possível localizar o id " + id );
            return 0;
        }


    }


    public static Evento adicionarEvento () {

        System.out.println("Digite o nome do evento: ");
        String nome = sc.next();

        System.out.println("Digite o local do evento: ");
        String local = sc.next();

        System.out.println("Digite a data: ");
        String data = sc.next();

        System.out.println("Digite a descrição do evento: ");
        String descricao = sc.next();

        return BancoEvento.adicionarEvento(new Evento(nome,local,data,descricao));

    }

    public static void apagarEvento () {

        System.out.println("Insira o número id do evento que você deseja deletar: ");
        int id = sc.nextInt();
        BancoEvento.removerEvento(id);
        System.out.println("Evento " + id + " Removido com Sucesso!");

    }

    public static void buscarEventoPorNome () {

        System.out.println("Digite o nome do evento que você deseja buscar: ");
        String nomeEvento = sc.next();

        System.out.println("EVENTO " + nomeEvento);
        System.out.println(BancoEvento.buscarEventoPorNome(nomeEvento));

    }

    public static List<Evento> mostrarTodosOsEventos () {

        System.out.println(BancoEvento.buscarTodosOsEventos());
        return BancoEvento.buscarTodosOsEventos();

    }
    public static Participante adicionarParticipante () {

        System.out.println("Digite o nome do participante do evento: ");
        String nome = sc.next();

        System.out.println("Digite o email do participante do evento: ");
        String email = sc.next();

        return BancoParticipante.adicionarParticipante(new Participante(nome, email));
    }

    public static void pesquisaParaBuscarParticipantePorEmail () {

        System.out.println("Digite o email do participante que você deseja buscar: ");
        String email = sc.next();

        System.out.println("PARTICIPANTE DE EMAIL: " + email );

        System.out.println(BancoParticipante.buscarParticipantePorEmail(email)) ;

    }

    public static void apagarParticipante () {

        System.out.println("Digite o id do participante que você deseja deletar: ");
        int id = sc.nextInt();
        BancoParticipante.removerParticipante(id);
        System.out.println("Participante " + id + " Removido com Sucesso!");

    }

    public static List<Participante> buscarTodosOsParticipantes () {

        System.out.println("------TODOS OS PARTICIPANTES------");
        System.out.println(BancoParticipante.buscarTodosOsParticipantes());
        return BancoParticipante.buscarTodosOsParticipantes();


    }
    public static Inscricao inscricao () {

        BancoEvento.buscarTodosOsEventos();

        System.out.println("Digite o nome do Evento que você deseja inscrever: ");
        String nome = sc.next();

        Evento evento = BancoEvento.buscarEventoPorNome(nome);


        System.out.println("Digite o email do participante que você deseja inscrever");
        String email = sc.next();

        Participante participante = BancoParticipante.buscarParticipantePorEmail(email);

        System.out.println("----------------------------");
        System.out.println("Inscrição feita com Sucesso");
        System.out.println("----------------------------");


        return BancoInscricao.inscreverParticipante(new Inscricao(evento, participante));

    }

    public static List<Inscricao> buscarTodasAsInscricoes () {

        System.out.println("------------TODOS AS INSCRIÇÕES------------");
        System.out.println(BancoInscricao.buscarTodasAsIncricoes());
        return BancoInscricao.buscarTodasAsIncricoes();

    }

    public static void buscarInscricaoPorId () {

        System.out.println("Digite o id da Inscrição que você deseja pesquisar: ");
        int id = sc.nextInt();

        System.out.println("INSCRIÇÃO " + id);

        System.out.println(BancoInscricao.buscarInscricaoPorId(id));


    }

    public static void apagarInscricao () {

        System.out.println("Digite o id da Incrição que você deseja apagar: ");
        int id = sc.nextInt();

        BancoInscricao.removerInscricao(id);

        System.out.println("Inscrição " + id + " Removida com Sucesso!");
    }

}