/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CompromissoDao;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Compromisso;
import model.Contato;

/**
 *
 * @author Aluno
 */
public class CompromissoController {

    private Date formatarData(String data) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return new Date(formatter.parse(data).getTime());
    }

    private Date formatarHora(String data) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return new Date(formatter.parse(data).getTime());
    }

    public void salvar(String observacao, String dataCompromisso, String horaCompromisso, Contato contato) throws SQLException, ParseException {

        Compromisso compromisso = new Compromisso();

        compromisso.setObservacao(observacao);
        compromisso.setDataCompromisso(formatarData(dataCompromisso));
        compromisso.setHoraCompromisso(formatarHora(horaCompromisso));
        compromisso.setContato(contato);
        
        System.out.println(String.valueOf(formatarHora(horaCompromisso)));

        new CompromissoDao().insertCompromisso(compromisso);

    }

    public void alterar(int id, String observacao, String dataCompromisso, String horaCompromisso)
            throws ParseException, SQLException {

        Compromisso compromisso = new Compromisso();
        compromisso.setId(id);
        compromisso.setObservacao(observacao);
        compromisso.setDataCompromisso(formatarData(dataCompromisso));
        compromisso.setHoraCompromisso(formatarHora(horaCompromisso));

        new CompromissoDao().updateCompromisso(compromisso);
    }

    public List<Compromisso> listar() {

        CompromissoDao dao = new CompromissoDao();

        try {
            return dao.listCompromisso();
        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return null;
    }

    public List<Compromisso> listarContato(int id) throws SQLException {
        CompromissoDao dao = new CompromissoDao();

        return dao.listContatoCompromisso(id);
    }

    public void deletar(int id) throws SQLException {

        new CompromissoDao().deleteCompromisso(id);

    }

}
