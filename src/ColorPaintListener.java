import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

public class ColorPaintListener implements ActionListener {
    private Color color = Color.black;
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ

        JMenuItem selected = (JMenuItem) e.getSource();
        this.color = colors.get(selected.getText());

    }
    public static String[] colorLabels(){
        Set<String> keys = colors.keySet();
        return keys.toArray(new String[0]);
    }
    public void changeColor(Graphics g){
        g.setColor(color);
    }

}
