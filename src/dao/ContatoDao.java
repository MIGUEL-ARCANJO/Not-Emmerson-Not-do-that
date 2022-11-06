package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contato;

public class ContatoDao extends GenericDao {

    public void salvar(Contato contato) throws SQLException {
        String insert = "INSERT INTO CONTATOS(nome, apelido, data_nascimento) VALUES(?,?,?)";
        save(insert, contato.getNome(), contato.getApelido(), contato.getDtNascimento());
    }

    public void alterar(Contato contato) throws SQLException {
        String update = "UPDATE CONTATOS "
                + "SET nome = ?, apelido = ?, data_nascimento = ? "
                + "WHERE id = ?";
        update(update, contato.getId(), contato.getNome(),
                contato.getApelido(), contato.getDtNascimento());
    }

    public void excluir(long id) throws SQLException {
        String delete = "DELETE FROM CONTATOS WHERE id = ?";
        delete(delete, id);
    }

    public List<Contato> findContatos() throws SQLException {
        List contatos = new ArrayList();

        String select = "SELECT * FROM CONTATOS";

        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Contato contato = new Contato();
            contato.setId(rs.getLong("id"));
            contato.setNome(rs.getString("nome"));
            contato.setApelido(rs.getString("apelido"));
            contato.setDtNascimento(rs.getDate("data_nascimento"));
            contatos.add(contato);
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return contatos;
    }

    public Contato findByName(String nome) throws SQLException {
        String select = "SELECT * FROM CONTATOS WHERE nome LIKE (?)";
        Contato contato = null;
        PreparedStatement stmt
                = getConnection().prepareStatement(select);

        stmt.setString(1, "%"+nome+"%");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            contato = new Contato();
            contato.setId(rs.getLong("id"));
            contato.setNome(rs.getString("nome"));
            contato.setApelido(rs.getString("apelido"));
            contato.setDtNascimento(rs.getDate("data_nascimento"));
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return contato;
    }
}
