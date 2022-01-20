
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonListener implements ActionListener {
    private MousePaintListener MPL;
    private JColorChooser iroErabu;

    public ButtonListener(MousePaintListener MPL, JColorChooser iroErabu){
        this.MPL = MPL;
        this.iroErabu = iroErabu;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO 自動生成されたメソッド・スタブ
        JButton button = (JButton)e.getSource();
        if(button.getText().equals("choose color")){
            button.setText("close");
            iroErabu.setVisible(true);
        }else if(button.getText().equals("close")){
            button.setText("choose color");
            iroErabu.setVisible(false);
            MPL.setCustomColor(iroErabu.getColor());
            MPL.setLimit(7);
        }



    }


}
