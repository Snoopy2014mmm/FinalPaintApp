import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComboBoxListener extends JFrame implements ActionListener {
    private MousePaintListener listener;
    private Graphics g;
    private Color presentColor;
    private boolean isEraser;
    private JPanel panel;

    public ComboBoxListener(MousePaintListener listener, Graphics g, JPanel panel){
        this.g = g;
        this.listener = listener;
        presentColor = g.getColor();
        isEraser = false;
        this.panel = panel;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        JComboBox cb = (JComboBox)e.getSource();
        if(cb.getSelectedItem() == "pen") {
            isEraser = false;
            listener.setIsSmooth(true);
        }else if(cb.getSelectedItem() == "straight") {
            isEraser = false;
            listener.setLimit(2);
        }else if(cb.getSelectedItem() == "triangle") {
            isEraser = false;
            listener.setLimit(3);
        }else if(cb.getSelectedItem() == "eraser") {
            isEraser = true;
        }
        if(isEraser) {
            g.setColor(panel.getBackground());
        }else {
            g.setColor(presentColor);
        }
    }

}