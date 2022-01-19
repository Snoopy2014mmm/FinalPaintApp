import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {
    private MousePaintListener listener;
    private Graphics g;

    public ButtonListener(MousePaintListener listener, Graphics g) {
        this.listener = listener;
        this.g = g;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ

        //色追加されたら，hashmapに改良はあり！
        JButton b = (JButton)e.getSource();
        if(b.getText().compareTo("直線") == 0) {
            listener.setLimit(2);
        }else if(b.getText().compareTo("三角") == 0) {
            listener.setLimit(3);
        }else if(b.getText().compareTo("なめらかな曲線") == 0) {
            listener.setIsSmooth(true);
        }

    }


}
