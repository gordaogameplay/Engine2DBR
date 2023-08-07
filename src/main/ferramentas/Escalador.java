package main.ferramentas;

public class Escalador {

    private int larguraJogo;
    private int alturaJogo;
    private int larguraTela;
    private int alturaTela;

    public Escalador(int larguraJogo, int alturaJogo, int larguraTela, int alturaTela) {
        this.larguraJogo = larguraJogo;
        this.alturaJogo = alturaJogo;
        this.larguraTela = larguraTela;
        this.alturaTela = alturaTela;
    }

    public int escalarX(int x) {
        return x * larguraTela / larguraJogo;
    }

    public int escalarY(int y) {
        return y * alturaTela / alturaJogo;
    }

    public int escalarLargura(int largura) {
        return largura * larguraTela / larguraJogo;
    }

    public int escalarAltura(int altura) {
        return altura * alturaTela / alturaJogo;
    }
}
