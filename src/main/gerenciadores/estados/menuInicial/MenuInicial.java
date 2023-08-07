package main.gerenciadores.estados.menuInicial;

import main.ferramentas.Constantes;
import main.ferramentas.Fonte;
import main.gerenciadores.GestorControles;
import main.gerenciadores.estados.EstadoJogo;
import main.telaPrincipal.DesenharTela;

import java.awt.*;


public class MenuInicial {

    private static final Rectangle botaoJogar = new Rectangle(Constantes.LARGURA_JOGO / 2 - 100, 50, 250, 50);
    private static final Rectangle botaoConfig = new Rectangle(Constantes.LARGURA_JOGO / 2 - 100, 150, 250, 50);
    private static final Rectangle botaoSair = new Rectangle(Constantes.LARGURA_JOGO / 2 - 100, 250, 250, 50);

    private static Fonte fonte = new Fonte(Constantes.CAMINHO_FONTE);

    private static int tamanhoFonte = 30;

    public static void desenharMenu(Graphics2D g) {
        // Desenhar fundo do menu


        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constantes.LARGURA_JOGO, Constantes.ALTURA_JOGO);

        // Desenhar botões
        g.setColor(Color.WHITE);
        g.setFont(fonte.getFonte());
        fonte.setStyle(Font.BOLD);
        fonte.setSize(tamanhoFonte);

        g.draw(botaoJogar);
        g.drawString("Jogar", botaoJogar.x + 85, botaoJogar.y + 35);

        g.draw(botaoConfig);
        g.drawString("Config", botaoConfig.x + 85, botaoConfig.y + 35);

        g.draw(botaoSair);
        g.drawString("Sair", botaoSair.x + 95, botaoSair.y + 35);
    }

    public static void atualizarMenu(final DesenharTela dt) {
        if (GestorControles.mouse.isBotaoClicado()) {
            Point mousePos = GestorControles.mouse.getPosicao();

            Point gameWindowLocation = dt.getLocationOnScreen(); // Obtém a posição da janela do jogo na tela do computador

            int mouseX = mousePos.x - gameWindowLocation.x;
            int mouseY = mousePos.y - gameWindowLocation.y;

            if (botaoJogar.contains(mouseX, mouseY)) {
                dt.setEstadoJogo(EstadoJogo.JOGANDO);
            } else if (botaoConfig.contains(mouseX, mouseY)) {
                // Ação do botão Configurações
            } else if (botaoSair.contains(mouseX, mouseY)) {
                System.exit(0); // Sair do programa
            }
        }
    }

}
