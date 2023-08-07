package main.ferramentas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class DesenhoDebug {

    private static int objetosDesenhados = 0;

    public static void desenharImagem(final Graphics g, final BufferedImage img, final int x, final int y){
        objetosDesenhados++;
        g.drawImage(img, x, y, null);
    }

    public static void desenharImagem(final Graphics g, final BufferedImage img, final Point p){
        objetosDesenhados++;
        g.drawImage(img, p.x, p.y, null);
    }

    public static void desenharString(final Graphics g,final String s, final int x, final int y){
        objetosDesenhados++;
        g.drawString(s, x, y);
    }

    public static void desenharString(final Graphics g,final String s, final Point p){
        objetosDesenhados++;
        g.drawString(s, p.x, p.y);
    }

    public static void desenharString(final Graphics g,final String s, final int x, final int y, final Color c){
        objetosDesenhados++;
        g.setColor(c);
        g.drawString(s, x, y);
    }

    public static void desenharString(final Graphics g,final String s, final Point p, final Color c){
        objetosDesenhados++;
        g.setColor(c);
        g.drawString(s, p.x, p.y);
    }

    public static void desenharRetanguloCheio(final Graphics g, final int x, final int y, final int largura, final int altura){
        objetosDesenhados++;
        g.fillRect(x, y, largura, altura);
    }

    public static void desenharRetanguloCheio(final Graphics g, final Rectangle r){
        objetosDesenhados++;
        g.fillRect(r.x,r. y, r.width, r.height);
    }

    public static void desenharRetanguloCheio(final Graphics g, final int x, final int y, final int largura, final int altura, final Color c){
        objetosDesenhados++;
        g.setColor(c);
        g.fillRect(x, y, largura, altura);
    }

    public static void desenharRetanguloCheio(final Graphics g, final Rectangle r, final Color c){
        objetosDesenhados++;
        g.setColor(c);
        g.fillRect(r.x,r. y, r.width, r.height);
    }

    public static void desenharRetanguloContorno(final Graphics g, final int x, final int y, final int largura, final int altura){
        objetosDesenhados++;
        g.drawRect(x, y, largura, altura);
    }

    public static void desenharRetanguloContorno(final Graphics g, final Rectangle r){
        objetosDesenhados++;
        g.drawRect(r.x,r. y, r.width, r.height);
    }

    public static void desenharRetanguloContorno(final Graphics g, final int x, final int y, final int largura, final int altura, final Color c){
        objetosDesenhados++;
        g.setColor(c);
        g.drawRect(x, y, largura, altura);
    }

    public static void desenharRetanguloContorno(final Graphics g, final Rectangle r, final Color c){
        objetosDesenhados++;
        g.setColor(c);
        g.drawRect(r.x,r. y, r.width, r.height);
    }

    public static int getObjetosDesenhados() {
        return objetosDesenhados;
    }

    public static void reiniciarObjetos() {
        objetosDesenhados = 0;
    }

    public static void desenharSprite(final Graphics g, final BufferedImage sprite, final int x, final int y) {
        objetosDesenhados++;
        g.drawImage(sprite, x, y, null);
    }

    public static void desenharSprite(final Graphics g, final BufferedImage sprite, final Point p) {
        objetosDesenhados++;
        g.drawImage(sprite, p.x, p.y, null);
    }

    public static void desenharSprite(final Graphics g, final BufferedImage sprite, final int x, final int y, final int largura, final int altura) {
        objetosDesenhados++;
        g.drawImage(sprite, x, y, largura, altura, null);
    }

    public static void desenharSprite(final Graphics g, final BufferedImage sprite, final Point p, final int largura, final int altura) {
        objetosDesenhados++;
        g.drawImage(sprite, p.x, p.y, largura, altura, null);
    }

    public static void desenharSprite(final Graphics g, final BufferedImage sprite, final int x, final int y, final Color c) {
        objetosDesenhados++;
        g.setColor(c);
        g.drawImage(sprite, x, y, null);
    }

    public static void desenharSprite(final Graphics g, final BufferedImage sprite, final Point p, final Color c) {
        objetosDesenhados++;
        g.setColor(c);
        g.drawImage(sprite, p.x, p.y, null);
    }


}
