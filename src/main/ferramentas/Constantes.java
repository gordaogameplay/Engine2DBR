package main.ferramentas;

import java.awt.Font;
public final class Constantes {

    public static final int TAMANHO_SPRITE = 32;
    public static int TAMANHO_CURSOR = 0;

    public static int LARGURA_JOGO = 640;
    public static int ALTURA_JOGO = 360;

    public static int LARGURA_JANELA_COMPLETA = 1280; // 1920
    public static int ALTURA_JANELA_COMPLETA = 720;  //1080

    public static double FATOR_ESCALADO_X = (double)LARGURA_JANELA_COMPLETA / (double)LARGURA_JOGO;
    public static double FATOR_ESCALADO_Y = (double)ALTURA_JANELA_COMPLETA / (double)ALTURA_JOGO;

    public static int CENTRO_JANELA_X = LARGURA_JOGO / 2;
    public static int CENTRO_JANELA_Y = ALTURA_JOGO / 2;

    public static int CENTROX_JOGADOR = Constantes.LARGURA_JOGO / 2 - Constantes.TAMANHO_SPRITE /2 + 1;
    public static int CENTROY_JOGADOR = Constantes.ALTURA_JOGO / 2 - Constantes.TAMANHO_SPRITE /2 + 7;

    public static int FPS;

    public static String CAMINHO_MAPA = "main/recursos/mapas/01.bh";
    public static String CAMINHO_MAPATESTE = "src/main/recursos/cenario/cenarioteste.png";
    public static String CAMINHO_MAPA2 = "main/recursos/mapas/02.bh";
    public static String CAMINHO_ICONE_MOUSE = "src/main/recursos/imagens/icone/iconeCursor.png";
    public static String CAMINHO_JOGADOR = "src/main/recursos/entidades/player.png";
    public static String CAMINHO_ICONE_JANELA = "src/main/recursos/imagens/icone/iconeJanela.png";
    public static String CAMINHO_LOGOTIPO = "src/main/recursos/imagens/icone/logoTeste.png";//Classe GestorJogo
    public static String CAMINHO_OBJETOS_ARMAS = "src/main/recursos/imagens/folhasObjetos/armas.png";
    public static String CAMINHO_OBJETOS_DISPAROS = "src/main/recursos/imagens/folhasObjetos/armas.png";
    public static String CAMINHO_FONTE = "main/recursos/font/px10.ttf";

    public static Font FONTE_PIXEL = CarregarRecursos.carregarFonte(CAMINHO_FONTE);

    //esta constante é apenas para lembrar que na classe mapa o caminho para as folhas de sprites dos mapas sejam essa
    //NAO DA PRA COLOCAR ESSA CONSTANTE NO NOSSO METODO DE MAPAS É APENAS PARA LEMBRAR O CAMINHO
    public static String FOLHA_SPRITE_MAPA = "src/main/recursos/imagens/folhasSprites/";
    public static String FOLHA_SPRITE_OBJETOS = "src/main/recursos/imagens/folhasObjetos/1.png";


    //constantes temporarias para o logo
    public static double LOGOX = ALTURA_JOGO / 32 * 45 - 20 ;
    public static double LOGOY = LARGURA_JOGO / 32 * 15 - 50 ;


}
