package org.example;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        ConexaoBanco.getConnections();
        BancoEvento.adicionarEvento(new Evento("Gabriela", "Jaragua", "22/10/2024", "aaaaa"));

    }

    public static Evento adicionarEvento () {

    }
}