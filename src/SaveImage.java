import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class SaveImage implements ActionListener {

    final private Container container;

    public SaveImage(Container panelContent) {
        this.container = panelContent;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        BufferedImage bi = new BufferedImage(500, 460, BufferedImage.TYPE_INT_RGB);
        var graphics2D = bi.createGraphics();
        container.printAll(graphics2D);
        try{
            ImageIO.write(bi, "jpeg", new File("clip.jpeg"));
        }
        catch(IOException ioe){
            System.out.println("Clip write help: " + ioe.getMessage());
        }
    }
}
