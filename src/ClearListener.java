import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ClearListener implements ActionListener {
    private Graphics g;
    private JPanel panel;
    private boolean isClear;
    private Color presentColor;

    public ClearListener(Graphics g, JPanel panel) {
        this.g = g;
        this.panel = panel;
        presentColor = g.getColor();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        g.setColor(panel.getBackground());
        g.fillOval(0, 0, 600, 600);
        g.setColor(presentColor);

    }

}
