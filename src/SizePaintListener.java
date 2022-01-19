import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SizePaintListener implements ActionListener {
    private Graphics g;
    private int size;

    public SizePaintListener(Graphics g, int size) {
        this.g = g;
        this.size = size;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        Graphics2D g2 = (Graphics2D)g;
        BasicStroke bs = new BasicStroke(size);
        g2.setStroke(bs);

    }

}
