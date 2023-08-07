package main.telaPrincipal;

import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {

    private String titulo;

   // private final ImageIcon icone;
    public Tela(final String titulo, final DesenharTela tela){
        this.titulo = titulo;
        configurarJanela(tela);
    }
    public void configurarJanela(final DesenharTela tela){
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(tela, BorderLayout.CENTER); // Adiciona o Canvas ao painel
        add(tela,BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void atualizarTitulo(String novoTitulo) {
        setTitle(titulo + novoTitulo);
    }
}
