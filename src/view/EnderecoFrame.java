/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EnderecoController;
import dao.EnderecoDao;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import model.Contato;
import model.Endereco;

/**
 *
 * @author Aluno
 */
public class EnderecoFrame extends JFrame {

    private JLabel complemento, bairro, nmrCasa, loc, cep;
    private JButton save, delete, update, irLoc, limpar, primeiro, anterior, proximo, ultimo, voltar;
    private JTextField tComplemento, tBairro, tCasa, tCep;
    private EnderecoController cc;
    private int cont = 0;
    private Long key;

    private List enderecoList = new EnderecoController().listaEndereco();

    public EnderecoFrame() {
        super("Endereço");
        configTela();
        setLayout(null);

        Container tela = getContentPane();

        bairro = new JLabel("Bairro");
        bairro.setForeground(Color.BLACK);
        bairro.setBounds(10, 3, 100, 30);
        tela.add(bairro);

        tBairro = new JTextField();
        tBairro.setFont(new Font("Arial", 0, 12));
        tBairro.setBounds(10, 33, 265, 20);
        tela.add(tBairro);

        nmrCasa = new JLabel("Número");
        nmrCasa.setForeground(Color.BLACK);
        nmrCasa.setBounds(10, 53, 100, 30);
        tela.add(nmrCasa);

        tCasa = new JTextField();
        tCasa.setFont(new Font("Arial", 0, 12));
        tCasa.setBounds(10, 83, 100, 20);
        tela.add(tCasa);

        cep = new JLabel("CEP");
        cep.setForeground(Color.BLACK);
        cep.setBounds(155, 53, 100, 30);
        tela.add(cep);

        tCep = new JTextField();
        tCep.setFont(new Font("Arial", 0, 12));
        tCep.setBounds(155, 83, 100, 20);
        tela.add(tCep);

        complemento = new JLabel("Complemento");
        complemento.setForeground(Color.BLACK);
        complemento.setBounds(10, 103, 100, 30);
        tela.add(complemento);

        tComplemento = new JTextField();
        tComplemento.setBounds(10, 133, 265, 20);
        tela.add(tComplemento);

        save = new JButton("Salvar");
        save.setBounds(290, 33, 75, 20);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickSave();
            }
        });
        tela.add(save);

        delete = new JButton("Excluir");
        delete.setBounds(290, 83, 75, 20);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickDelete();
            }
        }
        );
        tela.add(delete);

        update = new JButton("Alterar");
        update.setBounds(290, 133, 75, 20);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickUpdate();
            }
        });
        tela.add(update);

        limpar = new JButton("Limpar");
        limpar.setBounds(105, 183, 75, 20);
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickClear();
            }
        });
        tela.add(limpar);

        voltar = new JButton("Voltar");
        voltar.setBounds(290, 183, 75, 20);
        voltar.setBackground(Color.GRAY.brighter());
        voltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AgendaPrincipal().setVisible(true);
            }
        });
        tela.add(voltar);

        primeiro = new JButton("|<");
        primeiro.setBounds(5, 183, 50, 20);
        primeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickFirst();
            }
        });
        tela.add(primeiro);

        anterior = new JButton("<<");
        anterior.setBounds(55, 183, 50, 20);
        anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickAnt();
            }
        });
        tela.add(anterior);

        proximo = new JButton(">>");
        proximo.setBounds(174, 183, 50, 20);
        proximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickProx();
            }
        });
        tela.add(proximo);

        ultimo = new JButton(">|");
        ultimo.setBounds(223, 183, 50, 20);
        ultimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickLast();
            }
        });
        tela.add(ultimo);

    }

    private void configTela() {
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void onClickFirst() {
        cont = 0;
        getValores(cont);
    }

    private void onClickAnt() {
        if (cont != 0) {
            getValores(--cont);
        }
    }

    private void onClickProx() {
        if (cont != enderecoList.size() - 1) {
            getValores(++cont);
        }
    }

    private void onClickLast() {
        try {
            if(cont != 0){
            cont = enderecoList.size() - 1;
            getValores(cont);
            }
        }catch(IndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "Não possui nenhum endereço", "ENDEREÇO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void getValores(int index) {
        if (index <= enderecoList.size() - 1) {
            Endereco endAtual = (Endereco) enderecoList.get(index);
            tBairro.setText(endAtual.getBairro());
            tCasa.setText(String.valueOf(endAtual.getNmrCasa()));
            tCep.setText(endAtual.getCep());
            tComplemento.setText(endAtual.getRua());
        }
    }

    private void onClickSave() {
        cc = new EnderecoController();
        try {
            cc.save(tCep.getText(), tBairro.getText(), tComplemento.getText(), Integer.parseInt(tCasa.getText()));
            JOptionPane.showMessageDialog(null, "Salvo!!", "Endereço", JOptionPane.INFORMATION_MESSAGE);
            onClickClear();
            enderecoList = new EnderecoController().listaEndereco();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir\n" + ex, "Error!", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void onClickDelete() {
        cc = new EnderecoController();

        long id = ((Endereco) enderecoList.get(cont)).getId();

        try {
            cc.delete(id);
            JOptionPane.showMessageDialog(null, "Salvo !");
            onClickClear();
            enderecoList = new EnderecoController().listaEndereco();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    private void onClickUpdate() {
        cc = new EnderecoController();

        long id = 0L;

        if (key == null) {
            id = ((Endereco) enderecoList.get(cont)).getId();
        } else {
            id = key;
            key = null;
        }

        try {
            cc.update(id, tCep.getText(), tBairro.getText(), tComplemento.getText(), Integer.parseInt(tCasa.getText()));
            JOptionPane.showMessageDialog(null, "Alteração salva com sucesso!");
            onClickClear();
            enderecoList = new EnderecoController().listaEndereco();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a alteração!\n" + ex);

        }
    }

    private void onClickClear() {
        tCep.setText(null);
        tCasa.setText(null);
        tComplemento.setText(null);
        tBairro.setText(null);
    }

}
