/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CompromissoController;
import controller.ContatoController;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import model.Compromisso;
import model.Contato;
import static view.ContatoFrame.contatoList;

/**
 *
 * @author Aluno
 */
public class CompromissoFrame extends JFrame {

    private JLabel observacao, contato, data, loc, hora;
    private JButton save, delete, update, irLoc, limpar, primeiro, anterior, proximo, ultimo, voltar;
    private JTextField tObservacao, tContato, tData, tHora;
    private CompromissoController compromissoController;
    private ContatoController contatoController;
    private int cont = 0;

    private List<Compromisso> compromissoList = new CompromissoController().listar();

    public CompromissoFrame() {
        super("Compromisso");
        configTela();
        setLayout(null);

        Container tela = getContentPane();
        tela.setBackground(new Color(214, 219, 223));

        contato = new JLabel("Contato");
        contato.setForeground(Color.BLACK);
        contato.setBounds(10, 3, 100, 30);
        tela.add(contato);

        tContato = new JTextField();
        tContato.setFont(new Font("Arial", 0, 12));
        tContato.setBounds(10, 33, 265, 20);
        tela.add(tContato);

        data = new JLabel("Data");
        data.setForeground(Color.BLACK);
        data.setBounds(10, 53, 100, 30);
        tela.add(data);

        tData = new JTextField();
        tData.setFont(new Font("Arial", 0, 12));
        tData.setBounds(10, 83, 100, 20);
        tela.add(tData);

        hora = new JLabel("Hora");
        hora.setForeground(Color.BLACK);
        hora.setBounds(155, 53, 100, 30);
        tela.add(hora);

        tHora = new JTextField();
        tHora.setFont(new Font("Arial", 0, 12));
        tHora.setBounds(155, 83, 100, 20);
        tela.add(tHora);

        observacao = new JLabel("Observação");
        observacao.setForeground(Color.BLACK);
        observacao.setBounds(10, 103, 100, 30);
        tela.add(observacao);

        tObservacao = new JTextField();
        tObservacao.setBounds(10, 133, 265, 20);
        tela.add(tObservacao);

        save = new JButton("Salvar");
        save.setBounds(290, 33, 75, 20);
        save.setBackground(new Color(244, 246, 246));
        save.setBorder(new LineBorder(Color.black));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickSave();
            }
        });
        tela.add(save);

        delete = new JButton("Excluir");
        delete.setBounds(290, 83, 75, 20);
        delete.setBackground(new Color(244, 246, 246));
        delete.setBorder(new LineBorder(Color.black));
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
        update.setBackground(new Color(244, 246, 246));
        update.setBorder(new LineBorder(Color.black));
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickUpdate();
            }
        });
        tela.add(update);

        limpar = new JButton("Limpar");
        limpar.setBounds(105, 183, 75, 20);
        limpar.setBackground(new Color(244, 246, 246));
        limpar.setBorder(new LineBorder(Color.black));
        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickClear();
            }
        });
        tela.add(limpar);

        voltar = new JButton("Voltar");
        voltar.setBounds(290, 183, 75, 20);
        voltar.setBackground(new Color(244, 246, 246));
        voltar.setBorder(new LineBorder(Color.black));
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
        primeiro.setBackground(new Color(244, 246, 246));
        primeiro.setBorder(new LineBorder(Color.black));
        primeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickFirst();
            }
        });
        tela.add(primeiro);

        anterior = new JButton("<<");
        anterior.setBounds(55, 183, 50, 20);
        anterior.setBackground(new Color(244, 246, 246));
        anterior.setBorder(new LineBorder(Color.black));
        anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickAnt();
            }
        });
        tela.add(anterior);

        proximo = new JButton(">>");
        proximo.setBounds(174, 183, 50, 20);
        proximo.setBackground(new Color(244, 246, 246));
        proximo.setBorder(new LineBorder(Color.black));
        proximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onClickProx();
            }
        });
        tela.add(proximo);

        ultimo = new JButton(">|");
        ultimo.setBounds(223, 183, 50, 20);
        ultimo.setBackground(new Color(244, 246, 246));
        ultimo.setBorder(new LineBorder(Color.black));
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
        if (cont != compromissoList.size() - 1) {
            getValores(++cont);
        }
    }

    private void onClickLast() {
        try {
            cont = compromissoList.size() - 1;
            getValores(cont);
        } catch (IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(null, "Não possui nenhum endereço", "ENDEREÇO", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void getValores(int index) {
        contatoController = new ContatoController();

        if (index <= compromissoList.size() - 1) {
            try {
                Compromisso compromissoAtual = compromissoList.get(index);
                tContato.setText(contatoController.buscarContatoPorId(compromissoAtual.getId()));
                tData.setText(String.valueOf(compromissoAtual.getDataCompromisso()));
                tHora.setText(String.valueOf(compromissoAtual.getHoraCompromisso()));
                tObservacao.setText(compromissoAtual.getObservacao());
            } catch (SQLException ex) {
                System.err.println(ex);
            }

        }
    }

    private void onClickSave() {
        compromissoController = new CompromissoController();
        contatoController = new ContatoController();
        
        System.out.println(tHora.getText());
        try {
            Contato contato = contatoController.buscaContatoPorNome(tContato.getText());

            compromissoController.salvar(tObservacao.getText(), tData.getText(), tHora.getText(), contato);
            JOptionPane.showMessageDialog(null, "Salvo!!", "Endereço", JOptionPane.INFORMATION_MESSAGE);
            onClickClear();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir\n" + ex, "Error!", JOptionPane.WARNING_MESSAGE);
        } catch (ParseException ex) {
            Logger.getLogger(CompromissoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void onClickDelete() {
        compromissoController = new CompromissoController();

        int id = ((Compromisso) compromissoList.get(cont)).getId();
        try {
            compromissoController.deletar(id);
            JOptionPane.showMessageDialog(null, "Salvo !");
            onClickClear();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    private void onClickUpdate() {
        compromissoController = new CompromissoController();

        int id = ((Compromisso) compromissoList.get(cont)).getId();

        try {
            compromissoController.alterar(id, tHora.getText(), tObservacao.getText(), tData.getText());
            JOptionPane.showMessageDialog(null, "Alteração salva com sucesso!");
            onClickClear();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a alteração!\n" + ex);

        } catch (ParseException ex) {
            Logger.getLogger(CompromissoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void onClickClear() {
        tHora.setText(null);
        tData.setText(null);
        tObservacao.setText(null);
        tContato.setText(null);
    }

    public static void main(String[] args) {
        new CompromissoFrame().setVisible(true);
    }

}
