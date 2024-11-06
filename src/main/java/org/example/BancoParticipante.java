package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoParticipante {

    public static Participante adicionarParticipante(Participante participante) {

        try (Connection connection = ConexaoBanco.getConnections()) {

            PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_participantes (id, nome, email) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, participante.getId());
            ps.setString(2, participante.getNome());
            ps.setString(3, participante.getEmail());

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                participante.setId(rs.getInt(1));
            }
        } catch (Exception e) {

            e.printStackTrace();

        }
        return participante;
    }

    public static Participante buscarParticipantePorEmail(String email) {

        try (Connection connection = ConexaoBanco.getConnections()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tb_participantes WHERE email = ?");

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String nome = rs.getString("nome");
                String emailProcurado = rs.getString("email");
                return new Participante(nome, emailProcurado);

            }

        }
        catch (Exception e ) {

            e.printStackTrace();

        }
        throw new RuntimeException("O email " + email + " não existe em nosso Banco de Dados.");
    }

    public static void removerParticipante(int id) {

        try (Connection connection = ConexaoBanco.getConnections()) {

            PreparedStatement ps = connection.prepareStatement("DELETE FROM tb_participantes WHERE id = ?");

            ps.setInt(1, id);
            ps.execute();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}

