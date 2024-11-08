package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    public static List<Inscricao> buscarTodasAsIncricoes  () {

        try (Connection connection = ConexaoBanco.getConnections()){

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tb_inscricoes");

            ResultSet rs = ps.executeQuery();
            List<Inscricao> inscricoes = new ArrayList<>();

                while (rs.next()) {

                    inscricoes.add(new Inscricao(
                            BancoEvento.buscarEventoPorId(rs.getInt("eventoId")),
                            BancoParticipante.buscarParticipantePorId(rs.getInt("participanteId")),
                            rs.getInt("id")
                    ));
                }

            return inscricoes;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException ("Nenhum registro de inscrição cadastrado ");
    }

    public static Inscricao buscarInscricaoPorId (int id) {

        try (Connection connection = ConexaoBanco.getConnections()){

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tb_inscricao WHERE id = ?");

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Evento eventoId = BancoEvento.buscarEventoPorId(rs.getInt("eventoId"));
                Participante participanteId = BancoParticipante.buscarParticipantePorId(rs.getInt("participanteId"));
                int idProcura = rs.getInt("id");

                return new Inscricao(eventoId,participanteId,idProcura);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException ("Inscrição " + id + " não encontrada.");
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
