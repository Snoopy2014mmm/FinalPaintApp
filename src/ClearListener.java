import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class ClearListener implements ActionListener {
    private JPanel panel;

    public ClearListener(JPanel panel) {
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        this.panel.setVisible(false);
        this.panel.setVisible(true);

    }

}
