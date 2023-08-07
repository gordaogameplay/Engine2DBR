package main.telaPrincipal;


import main.ElementosPrincipais;
import main.ferramentas.*;
import main.gerenciadores.GestorControles;
import main.gerenciadores.estados.EstadoJogo;
import main.gerenciadores.estados.menuInicial.MenuInicial;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class DesenharTela extends Canvas {
    private Teclado teclado;
    private Mouse mouse;
    private int altura;
    private int largura;
    private Fonte fonte;
    private int tamanhoFonte = 25;
    private EstadoJogo estadoJogo;
    public DesenharTela (final int largura, final int altura){

        this.altura = altura;
        this.largura = largura;
        this.fonte = new Fonte(Constantes.CAMINHO_FONTE);
        this.estadoJogo = EstadoJogo.MENU;
        setIgnoreRepaint(true);
        setPreferredSize(new Dimension(largura,altura));
        setFocusable(true);
        addKeyListener(GestorControles.teclado);
        addMouseListener(GestorControles.mouse);
        requestFocus();
    }
    public DesenharTela (final Fonte fonte, final int tamanhoFonte, final int largura, final int altura){
        this.fonte = fonte;
        this.tamanhoFonte = tamanhoFonte;
        this.altura = altura;
        this.largura = largura;
        this.fonte = new Fonte(Constantes.CAMINHO_FONTE);
        setIgnoreRepaint(true);
        setPreferredSize(new Dimension(largura,altura));
        setFocusable(true);
        addKeyListener(GestorControles.teclado);
        requestFocus();
    }

    public void desenhar(){
        final BufferStrategy buffer = getBufferStrategy();
        if(buffer == null){
            createBufferStrategy(4);
            return;
        }

        final Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
        g.setBackground(Color.BLACK);
        g.setFont(fonte.getFonte());
        fonte.setStyle(Font.BOLD);
        fonte.setSize(tamanhoFonte);

        //teste
        /////////////////////////////////////////////////////////
        // Desenhar o menu se necessário
        if (estadoJogo == EstadoJogo.MENU) {
            MenuInicial.desenharMenu(g);
            g.setFont(fonte.getFonte());
            fonte.setStyle(Font.BOLD);
            fonte.setSize(tamanhoFonte);
            g.setColor(Color.green);
            DesenhoDebug.desenharString(g, "Engine2D", Constantes.LARGURA_JOGO - 120, Constantes.ALTURA_JOGO-330);
        }

        // Atualizar o menu se necessário
        if (estadoJogo == EstadoJogo.JOGANDO) {
            DesenhoDebug.desenharRetanguloCheio(g,0,0,Constantes.LARGURA_JANELA_COMPLETA,Constantes.ALTURA_JANELA_COMPLETA, new Color(0xff5893ff));
            g.setColor(Color.green);
            DesenhoDebug.desenharString(g, "Engine2D", Constantes.LARGURA_JOGO - 120, Constantes.ALTURA_JOGO-330);
            ElementosPrincipais.jogador.desenhar(g);
        }
        /////////////////////////////////////////////////////////
        //teste

        g.dispose();
        buffer.show(); // Mostra o buffer
    }
    public void atualizar(){
        ElementosPrincipais.jogador.atualizar();
        GestorControles.teclado.atualizar();
        GestorControles.mouse.atualizar();
        MenuInicial.atualizarMenu(this);
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public Fonte getFonte() {
        return fonte;
    }

    public void setFonte(Fonte fonte) {
        this.fonte = fonte;
    }

    public int getTamanhoFonte() {
        return tamanhoFonte;
    }

    public void setTamanhoFonte(int tamanhoFonte) {
        this.tamanhoFonte = tamanhoFonte;
    }

    public EstadoJogo getEstadoJogo() {
        return estadoJogo;
    }

    public void setEstadoJogo(EstadoJogo estadoJogo) {
        this.estadoJogo = estadoJogo;
    }

    public DesenharTela getCanvas(){
        return this.getCanvas();
    }
}
