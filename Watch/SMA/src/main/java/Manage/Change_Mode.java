package Manage;

import Function.*;

public class Change_Mode {
    private Alarm_Manager alarm_manager;
    private Dice dice;
    private RR rr;
    private Stop_Watch stop_watch;
    private Time time;
    private Timer timer;


    public Change_Mode() {
        alarm_manager = new Alarm_Manager();
        dice = new Dice();
        rr = new RR();
        stop_watch = new Stop_Watch();
        time = new Time();
        timer = new Timer();
    }
    private int mode[] = new int[4] ;
    public void changeSet(){
        for(int i=0;i<4;i++){
            mode[i]=-1;
        }
    }
    public void startMenu(int n){
        for(int i=0;i<4;i++){
            if(mode[i]==-1)mode[i]=n;
        }
    }
    public void changeMode(){
        for(int i=0;;i++){
            if(mode[i]==0){
                time.run();
            }
            else if(mode[i]==1){
               // stop_watch.run();
            }
            else if(mode[i]==2){
               // alarm_manager.run();
            }
            else if(mode[i]==3){
               // timer.run();
            }
            else if(mode[i]==4){
                dice.run();
            }
            else if(mode[i]==5){
                rr.run();
            }
            i=i%4;
        }
    }
}
