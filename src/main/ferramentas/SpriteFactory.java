package main.ferramentas;

import java.awt.image.BufferedImage;

public class SpriteFactory {

    private BufferedImage spriteSheet;
    private CarregarRecursos recursos;
    private int spriteSize;

    public SpriteFactory(BufferedImage spriteSheet, CarregarRecursos recursos, int spriteSize) {
        this.spriteSheet = spriteSheet;
        this.recursos = recursos;
        this.spriteSize = spriteSize;
    }

}
