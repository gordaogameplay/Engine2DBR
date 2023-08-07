package main.ferramentas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Teclado implements KeyListener {

    private boolean[] teclas;
    public boolean cima;
    public boolean baixo;
    public boolean esquerda;
    public boolean direita;
    public boolean pular;
    public boolean correr;

    public boolean esc;

    public Teclado() {
        teclas = new boolean[256];
    }

    public void atualizar() {
        cima = teclas[KeyEvent.VK_W] || teclas[KeyEvent.VK_UP];
        baixo = teclas[KeyEvent.VK_S] || teclas[KeyEvent.VK_DOWN];
        esquerda = teclas[KeyEvent.VK_A] || teclas[KeyEvent.VK_LEFT];
        direita = teclas[KeyEvent.VK_D] || teclas[KeyEvent.VK_RIGHT];
        pular = teclas[KeyEvent.VK_SPACE];
        correr = teclas[KeyEvent.VK_SHIFT];
        esc = teclas[KeyEvent.VK_ESCAPE];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não precisamos usar esse método para nosso propósito
    }

    public boolean[] getTeclas() {
        return teclas;
    }

    public void setTeclas(boolean[] teclas) {
        this.teclas = teclas;
    }

    public boolean isCima() {
        return cima;
    }

    public void setCima(boolean cima) {
        this.cima = cima;
    }

    public boolean isBaixo() {
        return baixo;
    }

    public void setBaixo(boolean baixo) {
        this.baixo = baixo;
    }

    public boolean isEsquerda() {
        return esquerda;
    }

    public void setEsquerda(boolean esquerda) {
        this.esquerda = esquerda;
    }

    public boolean isDireita() {
        return direita;
    }

    public void setDireita(boolean direita) {
        this.direita = direita;
    }

    public boolean isPular() {
        return pular;
    }

    public void setPular(boolean pular) {
        this.pular = pular;
    }

    public boolean isCorrer() {
        return correr;
    }

    public void setCorrer(boolean correr) {
        this.correr = correr;
    }

    public boolean isEsc() {
        return esc;
    }

    public void setEsc(boolean esc) {
        this.esc = esc;
    }
}
