package main.entidades;

import main.Sprite.FolhaSprites;
import main.ferramentas.Constantes;
import main.ferramentas.DesenhoDebug;
import main.ferramentas.SpriteUtils;
import main.ferramentas.Teclado;
import main.gerenciadores.GestorControles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {

    private int velocidade;
    private int estadoMovimento; // 0: idle, 1: direita, 2: esquerda, 3: correr
    private boolean viradoParaDireita; // true se o jogador estiver virado para a direita
    private FolhaSprites sprites;
    private BufferedImage imagemAtual;
    private int frameAtual;
    private long tempoUltimaMovimentacao;
    private int x = Constantes.LARGURA_JOGO / 2; // Posição inicial no centro da tela
    private int y = Constantes.ALTURA_JOGO / 2 + 130; // Posição inicial no centro da tela

    private int largura;
    private int altura;
    private int indiceSpriteAtual = 0;
    private long ultimoTempoTrocaSprite = System.currentTimeMillis();
    private long intervaloTrocaSprite = 200;
    private boolean parado = true;
    private int posX = x - largura / 2 + 300;
    private int posY = y - altura / 2 + 300;
    private double velocidadeY; // Velocidade vertical para o pulo
    private boolean noChao; // Flag para verificar se o jogador está no chão
    private boolean pulando;
    private final double GRAVIDADE = 0.5; // Valor da gravidade
    private final double VELOCIDADE_PULO = -10; // Valor da velocidade inicial do pulo
    private final int ALTURA_MAXIMA_PULO = 20; // Altura máxima do pulo
    public Player() {
        velocidade = 1; // ajuste a velocidade conforme necessário
        estadoMovimento = 0;
        viradoParaDireita = true; // começa virado para a direita

        sprites = new FolhaSprites(Constantes.CAMINHO_JOGADOR,Constantes.TAMANHO_SPRITE, false);

        imagemAtual = sprites.getSprites(0).getSprite();
        tempoUltimaMovimentacao = System.currentTimeMillis();
        largura = Constantes.TAMANHO_SPRITE;
        altura = Constantes.TAMANHO_SPRITE;
        pulando = false;
    }

    public void atualizar() {
        animacaoIdle();
        movimentar();
        if(GestorControles.teclado.isDireita()){
            transicaoSpritesDireita();
        }else if(GestorControles.teclado.isEsquerda()){
            transicaoSpritesEsquerda();
        }

        if (GestorControles.teclado.isPular() && noChao) {
            iniciarPulo();
        }


        if (pulando) {
            atualizarPulo();
        } else if (y >= Constantes.ALTURA_JOGO / 2 + 130) {
            y = Constantes.ALTURA_JOGO / 2 + 130;
            noChao = true;
            velocidadeY = 0;
        } else {
            noChao = false;
            velocidadeY += GRAVIDADE;
        }
        y += velocidadeY;
    }
    public void animacaoIdle(){
        long tempoAtual = System.currentTimeMillis();
        if(viradoParaDireita) {
            if (tempoAtual - ultimoTempoTrocaSprite > intervaloTrocaSprite && parado) {
                // Troca de sprite somente se o intervalo de tempo for atingido
                ultimoTempoTrocaSprite = tempoAtual;
                indiceSpriteAtual = (indiceSpriteAtual + 1) % 4; // Ajuste para o índice correto do sprite
                imagemAtual = sprites.getSprites(indiceSpriteAtual).getSprite();
            }
        }else{
            if (tempoAtual - ultimoTempoTrocaSprite > intervaloTrocaSprite && parado) {
                // Troca de sprite somente se o intervalo de tempo for atingido
                ultimoTempoTrocaSprite = tempoAtual;
                indiceSpriteAtual = (indiceSpriteAtual + 1) % 4; // Ajuste para o índice correto do sprite
                imagemAtual = SpriteUtils.flipHorizontal(sprites.getSprites(indiceSpriteAtual).getSprite());
            }
        }
    }
    private void iniciarPulo() {
        if (y >= Constantes.ALTURA_JOGO / 2 + 130 - ALTURA_MAXIMA_PULO) {
            pulando = true;
            velocidadeY = VELOCIDADE_PULO;
        }
    }

    private void atualizarPulo() {
        velocidadeY += GRAVIDADE;

        // Verifica se o jogador atingiu a altura máxima do pulo
        if (velocidadeY >= 0 || y <= Constantes.ALTURA_JOGO / 2 + 130 - ALTURA_MAXIMA_PULO) {
            pulando = false;
        }
    }
    public void mover(int dx, int dy) {
        // Calcula a nova posição do jogador
        int novaPosX = x + dx * velocidade;

        // Verifica se a nova posição está dentro dos limites da tela
        if (novaPosX >= 0 && novaPosX + largura <= Constantes.LARGURA_JOGO) {
            x = novaPosX;
        }

        // Atualiza a direção do personagem para a animação
        viradoParaDireita = (dx > 0);

        // Atualiza a posição para desenho
        posX = x - largura / 2 + 300;
        posY = y - altura / 2 + 300;
    }

    public void movimentar() {
        int velocidadeAtual = velocidade; // Velocidade padrão

        if (GestorControles.teclado.isCorrer()) {
            velocidadeAtual *= 2; // Dobrar a velocidade ao correr
        }

        if (GestorControles.teclado.isDireita()) {
            mover(velocidadeAtual, 0);
            parado = false; // O jogador está se movendo, portanto, não está parado
        } else if (GestorControles.teclado.isEsquerda()) {
            mover(-velocidadeAtual, 0);
            parado = false; // O jogador está se movendo, portanto, não está parado
        } else {
            estadoMovimento = 0; // Idle
            parado = true; // O jogador está parado
            animacaoIdle();
        }
    }
    private void transicaoSpritesDireita() {

        long tempoAtual = System.currentTimeMillis();
        if (tempoAtual - ultimoTempoTrocaSprite > intervaloTrocaSprite) {
            // Troca de sprite somente se o intervalo de tempo for atingido
            ultimoTempoTrocaSprite = tempoAtual;

            // Alternar entre os sprites de transição para a direita
            int[] spritesDireita = {6, 7, 8, 9, 10, 11};
            indiceSpriteAtual = spritesDireita[frameAtual];
            imagemAtual = sprites.getSprites(indiceSpriteAtual).getSprite();

            frameAtual = (frameAtual + 1) % spritesDireita.length;
        }
    }
    private void transicaoSpritesEsquerda() {

        long tempoAtual = System.currentTimeMillis();
        if (tempoAtual - ultimoTempoTrocaSprite > intervaloTrocaSprite) {
            // Troca de sprite somente se o intervalo de tempo for atingido
            ultimoTempoTrocaSprite = tempoAtual;

            // Alternar entre os sprites de transição para a direita
            int[] spritesDireita = {6, 7, 8, 9, 10, 11};
            indiceSpriteAtual = spritesDireita[frameAtual];

            imagemAtual = SpriteUtils.flipHorizontal(sprites.getSprites(indiceSpriteAtual).getSprite());

            frameAtual = (frameAtual + 1) % spritesDireita.length;
        }
    }
    public void desenhar(Graphics2D g) {
        DesenhoDebug.desenharSprite(g, imagemAtual, x, y);
    }
}
