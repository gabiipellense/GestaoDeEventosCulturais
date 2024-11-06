package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoInscricao {

    public static Inscricao inscreverParticipante (Inscricao inscricao) {


        try (Connection connection = ConexaoBanco.getConnections()){

            PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_inscricoes (eventoId, participanteId ) VALUES ( ?, ? )", Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, inscricao.getEvento().getId());
            ps.setInt(2, inscricao.getParticipante().getId() );

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()){
                inscricao.setId(rs.getInt(1));
            }

        }
        catch (Exception e ){

            e.printStackTrace();

        }

        return inscricao;

    }

    public static void removerInscricao (int id) {

        try (Connection connection = ConexaoBanco.getConnections()) {

            PreparedStatement ps = connection.prepareStatement("DELETE FROM tb_inscricoes WHERE id = ?");

            ps.setInt(1,id);
            ps.execute();
        }
        catch (Exception e){

            e.printStackTrace();

        }

    }
}
