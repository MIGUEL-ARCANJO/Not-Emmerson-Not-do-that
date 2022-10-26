/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        super("Agenda");
        configTela();
        Container tela = getContentPane();
        tela.setBackground(new Color(214, 219, 223));
        contato = new JLabel("Contatos");
        contato.setFont(new Font("Arial", 0, 18));
        contato.setForeground(Color.black.darker());
        contato.setBounds(45, 10, 100, 50);
        tela.add(contato);

        btnCon = new JButton();
        btnCon.setBounds(55, 60, 50, 50);
        btnCon.setIcon(new ImageIcon(getClass().getResource("/images/contato.png")));
        btnCon.setBackground(tela.getBackground());
        btnCon.setBorder(null);
        btnCon.addActionListener(new EventoBotao());
        btnCon.addMouseListener(new EventoBotao());
        tela.add(btnCon);

        endereco = new JLabel("Endereço");
        endereco.setFont(new Font("Arial", 0, 18));
        endereco.setForeground(Color.black.darker());
        endereco.setBounds(200, 10, 100, 50);
        tela.add(endereco);

        btnEnd = new JButton();
        btnEnd.setBounds(213, 60, 50, 50);
        btnEnd.setIcon(new ImageIcon(getClass().getResource("/images/endereco.png")));
        btnEnd.setBorder(null);
        btnEnd.setBackground(tela.getBackground());
        btnEnd.addActionListener(new EventoBotao());
        btnEnd.addMouseListener(new EventoBotao());
        tela.add(btnEnd);

    }

    private class EventoBotao implements ActionListener, MouseListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCon) {
                dispose();
                new ContatoFrame().setVisible(true);
            } else if(e.getSource() == btnEnd) {
                dispose();
                new EnderecoFrame().setVisible(true);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (e.getSource() == btnCon) {
                btnCon.setBorder(new LineBorder(Color.black));
            } else if(e.getSource() == btnEnd) {
                btnEnd.setBorder(new LineBorder(Color.black));
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (e.getSource() == btnCon) {
                btnCon.setBorder(null);
            } else if(e.getSource() == btnEnd) {
                btnEnd.setBorder(null);
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
