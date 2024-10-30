package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BancoInscricao {

    public static void inscreverParticipante (int eventoId, int participanteId) {


        try (Connection connection = ConexaoBanco.getConnections()){

            PreparedStatement ps = connection.prepareStatement("INSERT INTO tb_inscricoes (eventoId, participanteId ) VALUES ( ?, ? )");

            ps.setInt(1, eventoId);
            ps.setInt(2, participanteId );

        }
        catch (Exception e ){

            e.printStackTrace();

        }

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
