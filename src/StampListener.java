import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.event.MouseInputListener;
import javax.swing.plaf.basic.BasicBorders;

public class StampListener implements MouseInputListener {
    private Container container;
    private Graphics g;

    public StampListener(Container container) {
        this.container = container;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        g = g();
        g.drawLine(e.getX(), e.getY()-20, e.getX(), e.getY()+20);
        g.drawLine(e.getX()-20, e.getY(), e.getX()+20, e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ



    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        }




    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ

    }


    private Graphics g(){
        Graphics g = container.getGraphics();
        return g;
    }

}
