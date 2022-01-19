import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Set;

public class SizePaintListener implements ActionListener {
    private Float size = 10f;
    private static HashMap<String, Float> sizes = new HashMap<>(){
        {
            put("thin", 1f);
            put("normal", 10f);
            put("thick", 30f);

        }
    };


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        JMenuItem selectedSize = (JMenuItem) e.getSource();
        this.size = sizes.get(selectedSize.getText());


    }
    public static String[] sizeLabels(){
        Set<String> keys = sizes.keySet();
        return keys.toArray(new String[0]);
    }
    public void changeSize(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        BasicStroke bs = new BasicStroke(size);
        g2.setStroke(bs);
    }

}
