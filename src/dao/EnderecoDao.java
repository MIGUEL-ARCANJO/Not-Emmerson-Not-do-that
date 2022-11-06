/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.cj.protocol.Resultset;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Endereco;

/**
 *
 * @author Aluno
 */
public class EnderecoDao extends GenericDao {

    public void insert(Endereco endereco) throws SQLException {

        String sql = "INSERT INTO Endereco(cep ,bairro , nmrCasa, complemento) VALUES (?,?,?,?) ";
        save(sql, endereco.getCep(), endereco.getBairro(), endereco.getNmrCasa(), endereco.getRua());
    }

    public void update(Endereco endereco) throws SQLException {
        String sql = "UPDATE Endereco set cep = ?, bairro = ?, complemento = ?, nmrCasa = ? WHERE idEnd = ?";
        update(sql, endereco.getId(),endereco.getCep(), endereco.getBairro(), endereco.getRua(), endereco.getNmrCasa());

    }

    public void delete(long id) throws SQLException {
        String sql = "DELETE FROM Endereco WHERE idEnd= ?";
        delete(sql, id);
    }

    public List listEndereco() throws SQLException {
        List enderecos = new ArrayList();

        String sql = "SELECT * FROM Endereco";

        PreparedStatement stmt = getConnection().prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Endereco end = new Endereco();
            end.setId(rs.getLong("idEnd"));
            end.setCep(rs.getString("cep"));
            end.setRua(rs.getString("complemento"));
            end.setNmrCasa(rs.getInt("nmrCasa"));
            end.setBairro(rs.getString("bairro"));

            enderecos.add(end);
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return enderecos;
    }

    public List listEnderecoApelido(String apelido) throws SQLException {
        List enderecos = new ArrayList();

        String sql = "SELECT C.apelido, E.cep, E.complemento, E.bairro, E.nmrCasa FROM Contatos C, Endereco E WHERE C.id = E.idEnd;";
        Endereco end = null;
        
        PreparedStatement stmt = getConnection().prepareStatement(sql);

        ResultSet rs = stmt.executeQuery();
        stmt.setString(1, apelido);
        while (rs.next()) {
            end = new Endereco();
            end.setId(rs.getLong("idEnd"));
            end.setCep(rs.getString("cep"));
            end.setRua(rs.getString("complemento"));
            end.setNmrCasa(rs.getInt("nmrCasa"));
            end.setBairro(rs.getString("bairro"));

            enderecos.add(end);
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return enderecos;
    }

}
