import java.awt.Graphics;

public class DrawPanel {
    private Graphics g;
    DrawPanel(Graphics g){
        this.g = g;
    }
    public void drawLine(int x1, int y1, int x2, int y2) {
        this.g.drawLine(x1, y1, x2, y2);
    }
}
