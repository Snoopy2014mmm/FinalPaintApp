import java.awt.*;

public class Rainbow{
    private int count;
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

    public Rainbow() {
        count = 0;
    }
    public void changeToRainbow(Graphics g){
        g.setColor(colors[count]);
        count++;
        if (colors.length == count){
            count = 0;
        }
    }

}
