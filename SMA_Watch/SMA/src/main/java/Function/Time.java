package Function;
import System_Support.*;
public class Time {
    private System_Clock system_clock;
    private int hour;
    private int minute;
    private int second;
    private int date;
    private int month;
    private int day;
    private int isSet;
    private int[] dis;
    private int[] monthDate;
    private int setNow;
    public Time(){
        system_clock = new System_Clock(1,1,0,0,0,0);
        Thread t = new Thread(system_clock,"내부클럭");
        t.start();
        month = 1;
        date = 1;
        day = 1;
        hour = 0;
        minute = 0;
        second = 0;
        isSet=8;
        dis = new int[]{0,hour,minute,second,month,date,day};
        monthDate = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    }

    public int[] getSystemClock() {
        return system_clock.getClock();
    }

    public void run(int input){
        if (isSet == 8) {
            if (input == 5) {
                enterSetMode();
            }
            else {
                updateTime();
            }
        }
        else {
            if (input == 5) {
                exitSetMode();
            }
            else{
                setMode(input);
            }
        }
    }
    private void enterSetMode(){
        isSet = 7;
        setNow=0;
    }
    private void exitSetMode(){
        setTime();
        isSet = 8;
    }
    private void setMode(int input){
        if(setNow==0){
            if(input==1) month = (month%12)+1; // up이면 월 증가;
            else if(input==2) month = ((month+10)%12)+1; // down이면 월 감소;
            else if(input==3) setNow=(setNow+1)%5;
        }
        else if(setNow==1){
            if(input==1) date = (date)%monthDate[month]+1; // up이면 일 증가;
            else if(input==2) date = (date+monthDate[month]-2)%date+monthDate[month]+1; // down이면 일 감소;
            else if(input==3) setNow=(setNow+1)%5;
        }
        else if(setNow==2){
            if(input==1) day = (day+1)%7; // up이면 요일 증가;
            else if(input==2) day = (day+6)%7; // down이면 요일 감소;
            else if(input==3) setNow=(setNow+1)%5;
        }
        else if(setNow==3){
            if(input==1) hour = (hour+1)%24; // up이면 시간 증가;
            else if(input==2) hour = (hour+23)%24; // down이면 시간 감소;
            else if(input==3) setNow=(setNow+1)%5;
        }
        else if(setNow==4){
            if(input==1) minute = (minute+1)%60; // up이면 분 증가;
            else if(input==2) minute = (minute+59)%60; // down이면 분 감소;
            else if(input==3) setNow=(setNow+1)%5;
        }
    }
    private void updateTime(){
        int[] clock = system_clock.getClock();
        month = clock[0];
        date =  clock[1];
        day= clock[2];
        hour=clock[3];
        minute=clock[4];
        second=clock[5];
    }

    private void setTime(){
        system_clock.Flag();
        system_clock = new System_Clock(month,date,day,hour,minute,0);
        Thread t = new Thread(system_clock,"내부클럭");
        t.start();
    }
    public int[] getDis(){
        dis[1]=hour;
        dis[2]=minute;
        dis[3]=second;
        dis[4]=month;
        dis[5]=date;
        dis[6]=day;
        return dis;
    }
}