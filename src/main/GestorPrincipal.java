package main;

import main.ferramentas.Constantes;
import main.gerenciadores.GestorControles;
import main.gerenciadores.estados.EstadoJogo;
import main.telaPrincipal.DesenharTela;
import main.telaPrincipal.Tela;

public class GestorPrincipal {
    private volatile boolean emFuncionamento = false;
    private String titulo;
    private int largura;
    private int altura;
    private static int fps = 0;
    private static int aps = 0;
    private static DesenharTela dt;
    private static Tela tela;


    public static void main(String[] args) {
        GestorPrincipal gp = new GestorPrincipal("Engine2D", Constantes.LARGURA_JOGO, Constantes.ALTURA_JOGO);
        gp.inicializar();
        gp.loopPrincipal();
    }

    public GestorPrincipal(final String titulo, final int largura, final int altura) {
        this.titulo = titulo;
        this.largura = largura;
        this.altura = altura;
    }

    private void atualizar() {
        GestorControles.teclado.atualizar();
        GestorControles.mouse.atualizar();
        dt.atualizar();
        finalizar();
    }

    private void inicializar() {
        emFuncionamento = true;
        dt = new DesenharTela(Constantes.LARGURA_JOGO, Constantes.ALTURA_JOGO);
        tela = new Tela(titulo, dt);

    }

    private void desenhar() {
        dt.desenhar();
    }

    private synchronized void finalizar() {
        if (GestorControles.teclado.isEsc()) {
           dt.setEstadoJogo(EstadoJogo.MENU);
        }
    }

    private void loopPrincipal() {
        int atualizacaoAcumuladas = 0;
        int framesAcumulados = 0;
        final int NS_POR_SEGUNDO = 1000000000;
        final int APS_OBJETIVO = 60;
        final double NS_POR_ATUALIZACAO = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaAtualizacao = System.nanoTime();
        long referenciaContador = System.nanoTime();

        double tempoPassado;
        double delta = 0;

        while (emFuncionamento) {

            final long inicioLoop = System.nanoTime();
            tempoPassado = inicioLoop - referenciaAtualizacao;

            referenciaAtualizacao = inicioLoop;

            delta += tempoPassado / NS_POR_ATUALIZACAO;


            while (delta >= 1) {
                atualizar();
                atualizacaoAcumuladas++;

                delta--;
            }
            desenhar();
            framesAcumulados++;

            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                aps = atualizacaoAcumuladas;
                fps = framesAcumulados;
                // Atualizar o título da janela com as taxas de FPS e APS
                titulo = "Engine2D FPS: " + fps + " APS: " + aps ;
                tela.atualizarTitulo(titulo);
                atualizacaoAcumuladas = 0;

                framesAcumulados = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public static int getFps() {
        return fps;
    }

    public static int getAps() {
        return aps;
    }
}
