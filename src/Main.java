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


        Graphics g = panelContents.getGraphics();
        MousePaintListener listener = new MousePaintListener(g);
        panelContents.addMouseListener(listener);
        panelContents.addMouseMotionListener(listener);


        JMenuBar menubar = new JMenuBar();
        JMenu menuColor = new JMenu("Color");
        JMenu menuSize = new JMenu("Size");
        menubar.add(menuColor);
        menubar.add(menuSize);

        for(String label: ColorPaintListener.colorLabels()) {
            JMenuItem menu_colors = new JMenuItem((label));
            menu_colors.addActionListener(new ColorPaintListener(g));
            menuColor.add(menu_colors);
        }

        JPanel panel = new JPanel();
        JMenuItem menu_thin = new JMenuItem("thin");
        menu_thin.addActionListener(new SizePaintListener(g, 1));
        JMenuItem menu_normal = new JMenuItem("normal");
        menu_normal.addActionListener(new SizePaintListener(g, 3));
        JMenuItem menu_thick = new JMenuItem("thick");
        menu_thick.addActionListener(new SizePaintListener(g, 10));


        menuSize.add(menu_thin);
        menuSize.add(menu_normal);
        menuSize.add(menu_thick);

        frame.setJMenuBar(menubar);

        JButton clearButton = new JButton("clear");
        clearButton.setBounds(5, 80, 70, 40);
        panelMenubar.add(clearButton);
        ClearListener ClearListener = new ClearListener(g, panel);
        clearButton.addActionListener(ClearListener);



        JComboBox<String> cb1 = new JComboBox<>();
        cb1.addItem("pen");
        cb1.addItem("straight");
        cb1.addItem("triangle");
        cb1.addItem("eraser");
        cb1.setSelectedIndex(1);
        cb1.setEnabled(true);
        cb1.addActionListener(new ComboBoxListener(listener, g, panel));
        cb1.setBounds(5, 5, 80, 30);
        panelMenubar.add(cb1);

	     /*JPanel panelbar = new JPanel();
	     panelbar.setBounds(100, 100, 1000, 50);
	     panelbar.add(menubar);
	     panelbar.add(cb1);
	     panelbar.add(clearButton);
	     frame.add(panelbar);*/


        frame.setVisible(true);

    }

}
