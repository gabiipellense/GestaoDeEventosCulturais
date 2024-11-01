package org.example;

import java.sql.*;

public class BancoEvento {

    public static Evento adicionarEvento (Evento evento){

        try (Connection connection = ConexaoBanco.getConnections()){

            PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_eventos (id, nome, local ,data, descricao) VALUES (?, ?, ?, ?, ?", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1,evento.getId());
            ps.setString(2, evento.getNome());
            ps.setString(3, evento.getLocal());
            ps.setString(4, evento.getData());
            ps.setString(5,evento.getDescricao());

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next() ) {
                evento.setId(rs.getInt(1));
            }

        }
        catch (Exception e ) {

            e.printStackTrace();
        }
        return evento;
    }

    public static Evento buscarEventoPorNome (String nome) {

        try (Connection connection = ConexaoBanco.getConnections()){

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tb_eventos WHERE nome = ? ");
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("id");
                String nomeProcurado = rs.getString("nome");
                String local = rs.getString("local");
                String data = rs.getString("data");
                String descricao = rs.getString("descricao");
                return new Evento (id, nomeProcurado, local, data, descricao);

            }
        }
        catch (Exception e) {

            e.printStackTrace();

        }

        throw  new RuntimeException("O evento cultural " + nome + " não foi encontrado.");

    }

    public static void removerEvento (int id) {

        try (Connection connection = ConexaoBanco.getConnections()){

            PreparedStatement ps = connection.prepareStatement("DELETE FROM tb_eventos WHERE id = ?");

            ps.setInt(1, id);
            ps.execute();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}