package Function;
import System_Support.*;
import GUI.*;

public class Time extends  GUI{
    private System_Clock system_clock;
    private int hour;
    private int minute;
    private int second;
    private int date;
    private int month;
    private int day;

    public Time(){
        system_clock = new System_Clock();
        date = 2000;
        month = 1;
        day = 1;
        hour = 0;
        minute = 0;
        second = 0;
    }
    public void run(){
        int check;
       // check=time(system_clock);
      //  if(check==0)enterSetMode();
    }
    public void enterSetMode(){

    }
}
