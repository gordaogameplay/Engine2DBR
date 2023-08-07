package main.ferramentas;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class SpriteUtils {

    // Rotaciona um sprite na direção horizontal
    public static BufferedImage flipHorizontal(BufferedImage sprite) {
        BufferedImage flipped = new BufferedImage(sprite.getWidth(), sprite.getHeight(), sprite.getType());
        Graphics2D g2d = flipped.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(-1, 1);
        at.translate(-sprite.getWidth(), 0);
        g2d.drawImage(sprite, at, null);
        g2d.dispose();
        return flipped;
    }

    // Rotaciona um sprite na direção vertical
    public static BufferedImage flipVertical(BufferedImage sprite) {
        BufferedImage flipped = new BufferedImage(sprite.getWidth(), sprite.getHeight(), sprite.getType());
        Graphics2D g2d = flipped.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(1, -1);
        at.translate(0, -sprite.getHeight());
        g2d.drawImage(sprite, at, null);
        g2d.dispose();
        return flipped;
    }

    // Rotaciona um sprite na direção horizontal e vertical
    public static BufferedImage flipBoth(BufferedImage sprite) {
        BufferedImage flipped = new BufferedImage(sprite.getWidth(), sprite.getHeight(), sprite.getType());
        Graphics2D g2d = flipped.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(-1, -1);
        at.translate(-sprite.getWidth(), -sprite.getHeight());
        g2d.drawImage(sprite, at, null);
        g2d.dispose();
        return flipped;
    }

    // Rotaciona um sprite na direção vertical e depois na horizontal
    public static BufferedImage flipVerticalAndHorizontal(BufferedImage sprite) {
        return flipHorizontal(flipVertical(sprite));
    }

    // Rotaciona um sprite na direção horizontal e depois na vertical
    public static BufferedImage flipHorizontalAndVertical(BufferedImage sprite) {
        return flipVertical(flipHorizontal(sprite));
    }
}
