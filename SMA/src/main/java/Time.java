import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Time extends Frame{
    private Label lbl;
    private int m;
    private int d;
    private int h;
    private int min;
    private int sec;
    public Time(){
        lbl = new Label("시간표시", Label.CENTER);

        this.m=0;
        this.d=0;
        this.h=0;
        this.min=0;
        this.sec=0;

        add("Center", lbl);
        setBounds(200, 200, 300, 200);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                System.exit(0);
            }
        });

        Clock dis=new Clock(sec);

        while(true)
        {
            this.sec = dis.get();
            display();
            System.out.println(this.sec);
            try{
                Thread.sleep(1000);
            }catch(Exception ex){}
        }
    }
    public void display(){
        lbl.setText(this.m+"-"+this.d+"   "+this.h+":"+this.min+":"+this.sec);
    }
}
