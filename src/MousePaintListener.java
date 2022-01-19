import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.event.MouseInputListener;

public class MousePaintListener implements MouseInputListener {
    private int limit;
    private ArrayList<Integer> listX = new ArrayList<Integer>();
    private ArrayList<Integer> listY = new ArrayList<Integer>();
    private Graphics g;

    private int lastx;
    private int lasty;
    private int newx;
    private int newy;
    private DrawPanel panel;
    private boolean isSmooth;

    public MousePaintListener(Graphics g) {
        limit = 1;
        this.g = g;
        panel = new DrawPanel(this.g);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        int star = 10;
        double rad = 36.0;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        listX.add(e.getX());
        listY.add(e.getY());

        lastx = e.getX();
        lasty = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ

        if(limit == 1) {
            this.g.fillOval(e.getX(), e.getY(), 2, 2);
            reset();

        }else if(limit == 2) {
            this.g.drawLine(listX.get(0), listY.get(0), e.getX(), e.getY());

            if(listX.size() == 1) return;
            this.g.drawLine(listX.get(1), listY.get(1), e.getX(), e.getY());
            reset();


        }else if(limit == 3) {
            this.g.drawLine(listX.get(0), listY.get(0), e.getX(), e.getY());

            if(listX.size() == 1) return;
            this.g.drawLine(listX.get(1), listY.get(1), e.getX(), e.getY());
            this.g.drawLine(listX.get(0), listY.get(0), listX.get(1), listY.get(1));
            if(listX.size() == 2) return;
            reset();

        }

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


        if(isSmooth) {
            newx = e.getX();
            newy = e.getY();
            panel.drawLine(lastx, lasty, newx, newy);
            lastx = newx;
            lasty = newy;
        }


    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ

    }


    public void setLimit(int i) {
        // TODO 自動生成されたメソッド・スタブ
        limit = i;
    }
    public void reset() {
        listX = new ArrayList<Integer>();
        listY = new ArrayList<Integer>();
    }

    public void setIsSmooth(boolean b) {
        // TODO 自動生成されたメソッド・スタブ
        isSmooth = b;
    }

}
