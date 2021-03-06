import java.awt.*;
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
    private Container container;
    private SizePaintListener SPL;
    private ColorPaintListener CPL;
    private ClearListener CL;
    private Rainbow rainbow;
    private Color customColor;

    public MousePaintListener(Container container, SizePaintListener SPL, ColorPaintListener CPL) {
        limit = 1;
        this.container = container;
        panel = new DrawPanel(this.container.getGraphics());
        this.SPL = SPL;
        this.CPL = CPL;
        rainbow = new Rainbow();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        if(limit == 5){
            g = g();
            g.drawLine(e.getX(), e.getY()-20, e.getX(), e.getY()+20);
            g.drawLine(e.getX()-20, e.getY(), e.getX()+20, e.getY());
        }

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
        g = g();
        if(limit == 2) {
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
        panel = new DrawPanel(g());

        if(limit == 1 || limit == 4 || limit == 6 || limit == 7) {
            if(limit == 4){
                Graphics eraserColorGraphics = g();
                eraserColorGraphics.setColor(container.getBackground());
                panel = new DrawPanel(eraserColorGraphics);
            }
            if(limit == 6){
                Graphics rainbowColorGraphics = g();
                rainbow.changeToRainbow(rainbowColorGraphics);
                panel = new DrawPanel(rainbowColorGraphics);
            }
            if(limit == 7){
                Graphics customColorGraphics = g();
                customColorGraphics.setColor(customColor);
                panel = new DrawPanel(customColorGraphics);
            }
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
    private Graphics g(){
        Graphics g = container.getGraphics();
        SPL.changeSize(g);
        CPL.changeColor(g);
        return g;
    }

    public void setCustomColor(Color customColor) {
        this.customColor = customColor;
    }
}
