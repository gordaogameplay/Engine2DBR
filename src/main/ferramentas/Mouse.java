package main.ferramentas;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {

    private Point posicao;
    private boolean botaoClicado;

    public Mouse() {
        posicao = new Point(0, 0);
        botaoClicado = false;
    }

    public void atualizar(){
        posicao.x = (int) MouseInfo.getPointerInfo().getLocation().getX();
        posicao.y = (int) MouseInfo.getPointerInfo().getLocation().getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            botaoClicado = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            botaoClicado = false;
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        posicao.x = e.getX();
        posicao.y = e.getY();
    }

    public boolean isBotaoClicado() {
        return botaoClicado;
    }

    public Point getPosicao() {
        return posicao.getLocation();
    }
}
