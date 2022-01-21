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
        panelContents.setBackground(Color.white);
        frame.add(panelContents);
        frame.add(panelMenubar);

        SizePaintListener SPL = new SizePaintListener();
        ColorPaintListener CPL = new ColorPaintListener();
        ClearListener CL = new ClearListener(panelContents);
        Graphics g = panelContents.getGraphics();
        MousePaintListener listener = new MousePaintListener(panelContents, SPL, CPL);
        panelContents.addMouseListener(listener);
        panelContents.addMouseMotionListener(listener);


        JMenuBar menubar = new JMenuBar();
        JMenu menuColor = new JMenu("Color");
        JMenu menuSize = new JMenu("Size");
        JMenu menuClear = new JMenu("Clear");
        menubar.add(menuColor);
        menubar.add(menuSize);
        menubar.add(menuClear);


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

        for(String labelClear: ClearListener.colorLabels()) {
            JMenuItem menu_clearColors = new JMenuItem(labelClear);
            menu_clearColors.addActionListener(CL);
            menuClear.add(menu_clearColors);
        }



        frame.setJMenuBar(menubar);

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

        JColorChooser iroErabu = new JColorChooser();
        panelContents.add(iroErabu);
        iroErabu.setVisible(false);
        JButton chooseColor = new JButton("choose color");
        chooseColor.setBounds(100, 5, 70, 40);
        ButtonListener close = new ButtonListener(listener, iroErabu);
        chooseColor.addActionListener(close);
        panelMenubar.add(chooseColor);

        frame.setVisible(true);

    }

}
