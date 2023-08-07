package main.Sprite;

import java.awt.image.BufferedImage;

public class Sprites {

    protected BufferedImage sprite;
    private int largura;
    private int altura;

    public Sprites(final BufferedImage sprite) {
        this.sprite = sprite;
        this.largura = sprite.getWidth();
        this.altura = sprite.getHeight();
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
