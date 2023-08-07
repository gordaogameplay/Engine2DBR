package main.entidades;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entidade {

    protected BufferedImage sprite;
    protected int x;
    protected int y;
    protected int largura;
    protected int altura;

    public Entidade(BufferedImage sprite, int x, int y, int largura, int altura) {
        this.sprite = sprite;
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public abstract void atualizar();
    public abstract void desenhar(Graphics2D g);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
}

