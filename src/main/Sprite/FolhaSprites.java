package main.Sprite;



import main.ferramentas.CarregarRecursos;

import java.awt.image.BufferedImage;

public class FolhaSprites {

    private int larguraFolhaSprites;
    private int alturaFolhaSprites;
    private int larguraSprite;
    private int alturaSprite;

    private Sprites[] sprites;

    private BufferedImage[] sprite;

    public FolhaSprites(final String caminho, final int tamanhoSprite, final boolean opaca) {

        final BufferedImage imagem;

        if(opaca){
            imagem = CarregarRecursos.carregarSpriteOpaco(caminho);
        }else{
            imagem = CarregarRecursos.carregarSpriteTransparente(caminho);
        }
        larguraSprite = tamanhoSprite;
        alturaSprite = tamanhoSprite;
        larguraFolhaSprites = imagem.getWidth();
        alturaFolhaSprites = imagem.getHeight();

        larguraFolhaSprites = larguraFolhaSprites / tamanhoSprite;
        alturaFolhaSprites = alturaFolhaSprites / tamanhoSprite;

        sprites = new Sprites[larguraFolhaSprites * alturaFolhaSprites];

        preencherArraySprites(imagem);
    }

    public FolhaSprites(final String caminho, final int larguraSprite, final int alturaSprite, final boolean opaca){
        final BufferedImage imagem;

        if(opaca){
            imagem = CarregarRecursos.carregarSpriteOpaco(caminho);
        }else{
            imagem = CarregarRecursos.carregarSpriteTransparente(caminho);
        }

        larguraFolhaSprites = imagem.getWidth();
        alturaFolhaSprites = imagem.getHeight();

        larguraFolhaSprites = larguraFolhaSprites / larguraSprite;
        alturaFolhaSprites = alturaFolhaSprites / alturaSprite;

        this.larguraSprite = larguraSprite;
        this.alturaSprite = alturaSprite;

        sprites = new Sprites[larguraFolhaSprites * alturaFolhaSprites];

        preencherArraySprites(imagem);
    }

    private void preencherArraySprites(final BufferedImage imagem) {
        for (int y = 0 ; y < alturaFolhaSprites; y ++){
            for(int x = 0; x < larguraFolhaSprites; x ++){
                int posicaoX = x * larguraSprite;
                int posicaoY = y * larguraSprite;
                sprites[x + y * larguraFolhaSprites] = new Sprites(imagem.getSubimage(posicaoX,posicaoY,larguraSprite,alturaSprite));
            }
        }
    }



    public Sprites getSprites(final int indice) {
        return sprites[indice];
    }
    public Sprites getSprites(final int x, final int y){
        return sprites[x + y * larguraFolhaSprites];
    }
}
