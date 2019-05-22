import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI extends JFrame{
    public GUI(){


        setSize(618,647);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Watch");

        JButton ok=new JButton("OK");
        JButton menu=new JButton("MENU");
        JButton up=new JButton("UP");
        JButton down=new JButton("DOWN");

        MyActionListener listener=new MyActionListener();

        ok.addActionListener(listener);
        menu.addActionListener(listener);
        up.addActionListener(listener);
        down.addActionListener(listener);

        ok.setSize(80,80);
        ok.setLocation(0,0);
        menu.setSize(80,80);
        menu.setLocation(0,520);
        up.setSize(80,80);
        up.setLocation(520,0);
        down.setSize(80,80);
        down.setLocation(520,520);


        add(ok);
        add(menu);
        add(up);
        add(down);

        setVisible(true);
    }
    private class MyActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();

            if(b.getText().equals("UP")) {
                System.out.println("UPUPUPUP");
            }
            else if(b.getText().equals("DOWN")) {

            }
            else if(b.getText().equals("OK")){

            }
            else if(b.getText().equals("MENU")){

            }
        }

    }
}

