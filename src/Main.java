import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        // TODO 自動生成されたメソッド・スタブ
        JFrame frame = new JFrame("お絵かきソフト");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        JPanel panelMenubar = new JPanel();
        JPanel panelContents = new JPanel();
        panelMenubar.setBounds(0, 0, 500, 40);
        panelContents.setBounds(0, 40, 500, 460);
        panelMenubar.setBackground(Color.pink);
        panelContents.setBackground(Color.green);
        frame.add(panelContents);
        frame.add(panelMenubar);

        SizePaintListener SPL = new SizePaintListener();
        ColorPaintListener CPL = new ColorPaintListener();
        Graphics g = panelContents.getGraphics();
        MousePaintListener listener = new MousePaintListener(panelContents, SPL, CPL);
        panelContents.addMouseListener(listener);
        panelContents.addMouseMotionListener(listener);


        JMenuBar menubar = new JMenuBar();
        JMenu menuColor = new JMenu("Color");
        JMenu menuSize = new JMenu("Size");
        menubar.add(menuColor);
        menubar.add(menuSize);


        for(String label: ColorPaintListener.colorLabels()) {
            JMenuItem menu_colors = new JMenuItem(label);
            menu_colors.addActionListener(CPL);
            menuColor.add(menu_colors);
        }


        for(String labelSize: SizePaintListener.sizeLabels()){
            JMenuItem menu_sizes= new JMenuItem(labelSize);
            menu_sizes.addActionListener(SPL);
            menuSize.add(menu_sizes);
        }



        frame.setJMenuBar(menubar);

        JButton clearButton = new JButton("clear");
        clearButton.setBounds(5, 80, 70, 40);
        panelMenubar.add(clearButton);
        ClearListener ClearListener = new ClearListener(panelContents);
        clearButton.addActionListener(ClearListener);

        JButton saveImage = new JButton("saveImage");
        saveImage.setBounds(5, 200, 70, 40);
        panelMenubar.add(saveImage);
        SaveImage makeImage = new SaveImage(panelContents);
        saveImage.addActionListener(makeImage);

        JComboBox<ComboBoxItem> cb1 = new JComboBox<>();
        cb1.addItem(new ComboBoxItem(1, "pen"));
        cb1.addItem(new ComboBoxItem(2, "straight"));
        cb1.addItem(new ComboBoxItem(3, "triangle"));
        cb1.addItem(new ComboBoxItem(4, "eraser"));
        cb1.addItem(new ComboBoxItem(5, "stamp"));
        cb1.addItem(new ComboBoxItem(6, "rainbow"));
        cb1.setSelectedIndex(0);
        cb1.addItemListener(new ComboBoxListener(listener));
        cb1.setBounds(5, 5, 80, 30);
        panelMenubar.add(cb1);

        frame.setVisible(true);

    }

}
