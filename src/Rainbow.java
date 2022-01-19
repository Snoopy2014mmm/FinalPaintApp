import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rainbow implements ActionListener {
    private Graphics g;
    private int count;
    private Color presentColor;
    private static final Color[] colors = {
            new Color(255, 0, 0),
            new Color(255, 40, 0),
            new Color(255, 80, 0),
            new Color(255, 120, 0),
            new Color(255, 160, 0),
            new Color(255, 200, 0),
            new Color(255, 240, 0),
            new Color(215, 240, 0),
            new Color(150, 200, 0),
            new Color(100, 200, 0),
            new Color(50, 180, 0),
            new Color(0, 135, 0),
            new Color(0, 145, 80),
            new Color(0, 145, 120),
            new Color(0, 145, 200),
            new Color(0, 145, 255),
            new Color(0, 120, 220),
            new Color(0, 110, 190),
            new Color(70, 0, 160),
            new Color(140, 0, 130),
    };

    public Rainbow(Graphics g) {
        this.g = g;
        count = 0;
        presentColor = g.getColor();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        g.setColor(colors[count]);
        if(count > 19) {
            count = 0;
        }else {
            count++;
        }

    }

}
