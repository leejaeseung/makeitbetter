import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame{
    public GUI(){
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Watch");

        setLayout(new FlowLayout());
        JButton ok=new JButton("OK");
        JButton menu=new JButton("MENU");
        JButton up=new JButton("UP");
        JButton down=new JButton("DOWN");

        add(ok);
        add(menu);
        add(up);
        add(down);

        setVisible(true);
    }
}

