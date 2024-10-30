package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BancoParticipante {

    public static void adicionarParticipante (Participante participante){

        try (Connection connection = ConexaoBanco.getConnections()){

            PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_participantes (id, nome, email) VALUES (?, ?, ?)");

            ps.setInt(1, participante.getId());
            ps.setString(2, participante.getNome());
            ps.setString(3, participante.getEmail());

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                participante.setId(rs.getInt(1));
            }
        }
        catch (Exception e){

            e.printStackTrace();

        }
    }

    public static Participante buscarParticipantePorEmail (String email) {

        throw new RuntimeException("O email " + email + " não existe em nosso Banco de Dados.");
    }

    public static void removerParticipante (int id) {

        try (Connection connection = ConexaoBanco.getConnections()){

            PreparedStatement ps = connection.prepareStatement("DELETE FROM tb_participantes WHERE id = ?");

            ps.setInt(1, id );
            ps.execute();
        }
        catch (Exception e ){

            e.printStackTrace();

        }

    }

}
