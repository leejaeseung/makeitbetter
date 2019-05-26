package System_Support;

import javax.swing.*;
import java.awt.*;

public class Buzzer extends JFrame implements Runnable{
    private JLabel mesage=new JLabel();
    private int time;

    public Buzzer(){
        time=0;
        setLayout();
        setLabel();

        Thread th=new Thread(this);
        th.start();

    }
    private void setLayout(){
        setTitle("Buzzer");
        setSize(150,150);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    private void setLabel(){

        this.mesage.setOpaque(true);
        this.mesage.setBackground(new Color(0,0,0,0));
        this.mesage.setBounds(50,50,150,20);
        this.mesage.setForeground(Color.black);

        this.mesage.setText("!!!!!!Buzzer!!!!!!");

        add(this.mesage);
    }

    public void stopBuzzer()
    {
        dispose();
    }
    public void run(){
        while(time!=30) {
            time++;
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e){}
        }
        stopBuzzer();
    }
}