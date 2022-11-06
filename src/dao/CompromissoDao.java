/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Compromisso;

/**
 *
 * @author Aluno
 */
public class CompromissoDao extends GenericDao{
 
    public void insertCompromisso(Compromisso compromisso) throws SQLException{
        
        String sql = "insert into compromisso(id, observacao, dataCompromisso, horaCompromisso, idContato) values(DEFAULT, ?, ?, ?, ?)";
        
        save(sql, compromisso.getObservacao(), compromisso.getDataCompromisso(), compromisso.getHoraCompromisso(), compromisso.getContato().getId());
        
    }
    
    public List<Compromisso> listCompromisso() throws SQLException{
        
        String sql = "select * from compromisso";
        
        ArrayList<Compromisso> compromissos = new ArrayList<>();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        stmt = getConnection().prepareStatement(sql);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            Compromisso compromisso = new Compromisso();
            
            compromisso.setId(rs.getInt("id"));
            compromisso.setObservacao(rs.getString("observacao"));
            compromisso.setDataCompromisso(rs.getDate("dataCompromisso"));
            compromisso.setHoraCompromisso(rs.getDate("horaCompromisso"));
            compromisso.getContato().setId(rs.getLong("id_contatos"));
            compromisso.getContato().setNome(rs.getString("nome_contatos"));
            
            compromissos.add(compromisso);
            
        }
        
        return compromissos;
    }
    
    public List<Compromisso> listContatoCompromisso(int id) throws SQLException{
        String sql = "select Contatos.nome, Compromisso.descricao, Compromisso.dataCompromisso, Compromisso.horaCompromisso from Contatos, Compromisso where Contatos.id = ?";
        
        ArrayList<Compromisso> compromissos = new ArrayList<>();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        stmt = getConnection().prepareStatement(sql);
        rs = stmt.executeQuery();
        
        stmt.setInt(1, id);
        
        while(rs.next()){
            Compromisso compromisso = new Compromisso();
            
            compromisso.setId(rs.getInt("id"));
            compromisso.setObservacao(rs.getString("observacao"));
            compromisso.setDataCompromisso(rs.getDate("dataCompromisso"));
            compromisso.setHoraCompromisso(rs.getDate("horaCompromisso"));
            compromisso.getContato().setId(rs.getLong("id_contatos"));
            
            compromissos.add(compromisso);
            
        }
        
        return compromissos;
    }
    
    public void updateCompromisso(Compromisso compromisso) throws SQLException{
        
        String sql = "update compromisso set observacao = ?, dataCompromisso = ?, horaCompromisso = ? where id = ?";
        
        update(sql, compromisso.getId(), compromisso.getObservacao(), compromisso.getDataCompromisso(), compromisso.getHoraCompromisso());
    }
    
    public void deleteCompromisso(int id) throws SQLException{
        
        String sql = "delete from compromisso where id = ?";
        
        delete(sql, id);
        
    }
    
}
