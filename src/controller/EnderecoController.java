/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ContatoDao;
import dao.EnderecoDao;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Endereco;

/**
 *
 * @author Migas
 */
public class EnderecoController {

    public void save(String cep, String bairro, String complemento, int nmrCasa) throws SQLException {
        Endereco end = new Endereco(cep, complemento, bairro, nmrCasa);

        new EnderecoDao().insert(end);
    }

    public void delete(long id) throws SQLException {
        new EnderecoDao().delete(id);
    }

    public void update(long id,String cep, String bairro, String complemento, int nmrCasa) throws SQLException {
        Endereco end = new Endereco();
        end.setId(id);
        end.setCep(cep);
        end.setBairro(bairro);
        end.setRua(complemento);
        end.setNmrCasa(nmrCasa);
        new EnderecoDao().update(end);
    }

    public List listaEndereco() {
        EnderecoDao dao = new EnderecoDao();
        try {
            return dao.listEndereco();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Problemas ao localizar contaton"
                    + e.getLocalizedMessage()
            );
        }
        return null;
    }

    public void listApelido(String apelido) throws SQLException {
        new EnderecoDao().listEnderecoApelido(apelido);
    }

}
