package Manage;

import Function.*;
import GUI.GUI;

public class Change_Mode extends GUI {
    private Select_Mode select_mode;
    private Alarm_Manager alarm_manager;
    private Dice dice;
    private RR rr;
    private Stop_Watch stop_watch;
    private Time time;
    private Timer timer;
    private int input=0;
    private int mode; // 0 : select menu, 1 : alarm, 2:Dice
    public static void main(String[] args) {
        Change_Mode watch = new Change_Mode();
        watch.changeMode();
    }
    public Change_Mode() {
        select_mode = new Select_Mode();
        alarm_manager = new Alarm_Manager();
        dice = new Dice();
        rr = new RR();
         stop_watch = new Stop_Watch();
        time = new Time();
        timer = new Timer();
        mode=6;
    }

    public void changeMode(){
        for(;;) {

            if (mode == 0) {
                //time.run();
            }
            else if (mode == 1) {
                // stop_watch.run();
            }
            else if (mode == 2) {
                // alarm_manager.run();
            }
            else if (mode == 3) {
                // timer.run();
            }
            else if (mode == 4) {
                dice.run(input);
                display(dice.getDis());
            }
            else if (mode == 5) {
                rr.run(input);
            }
            else if (mode == 6){
                select_mode.setMode();
                select_mode.run(input);
            }
            input = GUI_btn();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            if(input==4)nextMode();
            if(input==6)mode=6;
        }
    }
    private void nextMode(){
        while(true){
            mode = (mode+1)%6;
            if(select_mode.checkMode(mode)==1)return;
        }
    }
}