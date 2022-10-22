/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Aluno
 */
public class AgendaPrincipal extends JFrame {

    private JLabel contato, endereco;
    private JButton btnCon, btnEnd;

    public AgendaPrincipal() {
        configTela();
        Container tela = getContentPane();

        contato = new JLabel("Contatos");
        contato.setFont(new Font("Arial", 0, 18));
        contato.setForeground(Color.black.darker());
        contato.setBounds(45, 10, 100, 50);
        tela.add(contato);

        btnCon = new JButton();
        btnCon.setBounds(55, 60, 50, 50);
        btnCon.setIcon(new ImageIcon(getClass().getResource("/images/contato.jpeg")));
        btnCon.setBackground(tela.getBackground());
        btnCon.addActionListener(new EventoBotao());
        tela.add(btnCon);

        endereco = new JLabel("Endereço");
        endereco.setFont(new Font("Arial", 0, 18));
        endereco.setForeground(Color.black.darker());
        endereco.setBounds(200, 10, 100, 50);
        tela.add(endereco);

        btnEnd = new JButton();
        btnEnd.setBounds(210, 60, 50, 50);
        btnEnd.setIcon(new ImageIcon(getClass().getResource("/images/endereco.jpeg")));
        btnEnd.setBackground(tela.getBackground());
        btnEnd.addActionListener(new EventoBotao());
        tela.add(btnEnd);

    }

    private class EventoBotao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCon) {
                dispose();
                new ContatoFrame().setVisible(true);
            } else {
                dispose();
                new EnderecoFrame().setVisible(true);
            }
        }

    }

    private void configTela() {
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        new AgendaPrincipal().setVisible(true);
    }

}