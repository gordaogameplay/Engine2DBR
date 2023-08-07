package main.ferramentas;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

public class Fonte {

    private Font fonte;
    private int tamanhoFonte;

    private int tipoFonte;

    public Fonte(final String caminho) {
        fonte = CarregarRecursos.carregarFonte(caminho);
    }


    public Font getFonte(){
        return fonte;
    }

    public int getStyle(){
        return fonte.getStyle();
    }

    public int getSize(){
        return fonte.getSize();
    }

    public void setSize(int size){
        fonte = fonte.deriveFont((float)size);
    }
    public void setStyle(int style) {
        fonte = fonte.deriveFont(style);
    }

    public String getFontFamily() {
        return fonte.getFamily();
    }

    public String getFontName() {
        return fonte.getFontName();
    }
    // Método para criar uma fonte derivada com diferentes estilos e tamanho
    public Font createDerivedFont(int style, int size) {
        return fonte.deriveFont(style, (float) size);
    }
    // Exemplos de estilos pré-definidos
    public Font getTituloFonte() {
        return fonte.deriveFont(Font.BOLD, 24);
    }
    public Font getTextoFonte() {
        return fonte.deriveFont(Font.PLAIN, 16);
    }
    // Definir a cor da fonte
    public Font setCor(Font font, Color cor) {
        Map<TextAttribute, Object> atributos = new HashMap<>();
        atributos.put(TextAttribute.FOREGROUND, cor);
        return font.deriveFont(atributos);
    }

}
