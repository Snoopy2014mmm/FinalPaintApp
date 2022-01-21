import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

public class ClearListener implements ActionListener {
    private Color color;
    private static HashMap<String, Color> colors = new HashMap<>(){
        {
            put("black", Color.BLACK);
            put("red", Color.red);
            put("pink", Color.pink);
            put("blue", Color.BLUE);
            put("purple", new Color(70, 0, 160));
            put("gray", Color.gray);
            put("green", Color.green);
            put("magenta", Color.magenta);
            put("orange", Color.orange);
            put("yellow", Color.yellow);
        }
    };
    private JPanel panel;

    public ClearListener(JPanel panel){
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        this.panel.setVisible(false);
        JMenuItem selected = (JMenuItem) e.getSource();
        this.color = colors.get(selected.getText());
        this.panel.setBackground(color);
        this.panel.setVisible(true);
    }
    public static String[] colorLabels(){
        Set<String> keys = colors.keySet();
        return keys.toArray(new String[0]);
    }

}