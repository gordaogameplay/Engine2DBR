package main.ferramentas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarregarRecursos {

    public static BufferedImage carregarSpriteOpaco(final String caminho){

        Image imagem = null;

        try {
            imagem = ImageIO.read(new File(caminho));
        } catch (IOException ex) {
            Logger.getLogger(CarregarRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        BufferedImage imagemAcelerada = gc.createCompatibleImage(imagem.getWidth(null),imagem.getHeight(null) , Transparency.OPAQUE);

        Graphics g = imagemAcelerada.getGraphics();
        g.drawImage(imagem, 0, 0, null);
        g.dispose();
        return imagemAcelerada;

    }

    public static BufferedImage carregarSpriteTransparente(final String caminho){
        Image imagem = null;

        try {
            imagem = ImageIO.read(new File(caminho));
        } catch (IOException ex) {
            Logger.getLogger(CarregarRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }

        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        BufferedImage imagemAcelerada = gc.createCompatibleImage(imagem.getWidth(null),imagem.getHeight(null),Transparency.TRANSLUCENT);

        Graphics g = imagemAcelerada.getGraphics();
        g.drawImage(imagem, 0, 0, null);
        g.dispose();
        return imagemAcelerada;
    }

    public static String lerArquivoTexto(final String caminho){

        String conteudo = "";

        InputStream entradaBytes = ClassLoader.getSystemResourceAsStream(caminho);

        BufferedReader leitor = new BufferedReader(new InputStreamReader(entradaBytes));

        String linha;

        try{
            while((linha = leitor.readLine()) != null){
                conteudo += linha;
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(entradaBytes != null){
                    entradaBytes.close();
                }
                if(leitor != null){
                    leitor.close();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }

        return conteudo;
    }

    public static Font carregarFonte(final String caminho){
        Font fonte = null;

        InputStream entradaBytes = ClassLoader.getSystemResourceAsStream(caminho);

        try {
            fonte = Font.createFont(Font.TRUETYPE_FONT, entradaBytes);
        } catch (FontFormatException ex) {
            Logger.getLogger(CarregarRecursos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CarregarRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return fonte;
    }

}

