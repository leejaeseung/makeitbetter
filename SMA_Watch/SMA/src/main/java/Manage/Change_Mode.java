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
        time = new Time();
        alarm_manager = new Alarm_Manager(time);
        dice = new Dice();
        rr = new RR();
         stop_watch = new Stop_Watch();
        timer = new Timer();
        mode=6;
    }

    public void changeMode(){
        select_mode.setMode();
        for(;;) {

            if (mode == 0) {

                time.run(input);
                display(time.getDis());
            }
            else if (mode == 1) {
                stop_watch.run(input);
                display(stop_watch.getDis());
            }
            else if (mode == 2) {
                alarm_manager.run(input);
                display(alarm_manager.getDis());
            }
            else if (mode == 3) {
                timer.run(input);
                display(timer.getDis());
            }
            else if (mode == 4) {
                dice.run(input);
                display(dice.getDis());
            }
            else if (mode == 5) {
                rr.run(input);
                display(rr.getDis());
            }
            else if (mode == 6){
                if(select_mode.run(input)==1)nextMode();
                display(select_mode.getDis());
            }
            input=0;
            try {
                Thread.sleep(100);
                repaint();
            } catch (InterruptedException e) {
            }
            input = super.GUI_btn();
            if(input!=0&&(rr.getBuzzerFlag()==1)){
                rr.setBuzzerFlag();
                input=0;
            }
            if(input!=0&&(timer.getBuzzerFlag()==1)){
                timer.setBuzzerFlag();
                input=0;
            }
            if(input==4)nextMode();
            if(input==6){
                System.out.println(10);
                mode=6;
                select_mode.setMode();
            }
        }
    }
    private void nextMode(){
        while(true){
            mode = (mode+1)%6;
            if(select_mode.checkMode(mode)==1)return;
        }
    }
}