package Function;
import System_Support.*;
import GUI.*;

public class Time extends GUI {
    private System_Clock system_clock;
    private int hour;
    private int minute;
    private int second;
    private int date;
    private int month;
    private int day;
    private int[] month_info= {31,28,31,30,31,30,31,31,30,31,30,31};

    public Time() {
        system_clock = new System_Clock(0, 0, 0);
        Thread t = new Thread(system_clock, "내부클럭");
        t.start();
        date = 2000;
        month = 1;
        day = 1;
        hour = 0;
        minute = 0;
        second = 0;
    }

    public void run() {
        int check;
        while (true) {
            updateTime();
            super.display(0, hour, minute, second, month, day, date);
            check = super.GUI_btn();
            if (check == 5) if (setMode(0, hour, minute, second, month, day, date) == 1) return; // ok2초 누르면 타임 세팅모드 진입
            else if (check == 4) break; // menu버튼 누르면 나오기
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    public int setMode(int mode, int hour, int minute, int second, int month, int day, int date) {
        int check;
        while (true) {
            super.display(mode, hour, minute, second, month, day, date);
            check = super.GUI_btn();
            if (check == 3) break; // ok2초 누르면 타임 세팅모드 진입
            else if(check==1)second=(second+1)%60;
            else if(check==2)second=(second+59)%60;
            else if (check == 4) return 1; // menu버튼 누르면 나오기
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        while (true) {
            super.display(mode, hour, minute, second, month, day, date);
            check = super.GUI_btn();
            if (check == 3) break; // ok2초 누르면 다음 세팅모드 진입
            else if(check==1)minute=(minute+1)%60;
            else if(check==2)minute=(minute+59)%60;
            else if (check == 4) return 1; // menu버튼 누르면 나오기
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        while (true) {
            super.display(mode, hour, minute, second, month, day, date);
            check = super.GUI_btn();
            if (check == 3) break; // ok2초 누르면 다음 세팅모드 진입
            else if(check==1)hour=(hour+1)%24;
            else if(check==2)hour=(hour+23)%24;
            else if (check == 4) return 1; // menu버튼 누르면 나오기
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        while (true) {
            super.display(mode, hour, minute, second, month, day, date);
            check = super.GUI_btn();
            if (check == 3) break; // ok2초 누르면 다음 세팅모드 진입
            else if(check==1)day=(day)%month_info[month-1]+1;
            else if(check==2)day=(day+month_info[month-1]-2)%month_info[month-1]+1;
            else if (check == 4) return 1; // menu버튼 누르면 나오기
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        while (true) {
            super.display(mode, hour, minute, second, month, day, date);
            check = super.GUI_btn();
            if (check == 3) break; // ok2초 누르면 다음 세팅모드 진입
            else if(check==1)month=(month)%24+1;
            else if(check==2)month=(month+22)%60+1;
            else if (check == 4) return 1; // menu버튼 누르면 나오기
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        while (true) {
            super.display(mode, hour, minute, second, month, day, date);
            check = super.GUI_btn();
            if (check == 3) break; // ok2초 누르면 다음 세팅모드 진입
            else if(check==1)date=(date+1)%7;
            else if(check==2)date=(date+6)%7;
            else if (check == 4) return 1; // menu버튼 누르면 나오기
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
        setTime(hour,minute,second);
        this.month=month;
        this.day=day;
        this.date=date;
        return 0;
    }


    public void setTime(int h, int m, int s) {
        system_clock = new System_Clock(h, m, s);
        Thread t = new Thread(system_clock, "내부클럭");
        t.start();
        hour = h;
        minute = m;
        second = s;
    }

    public void updateTime() {
        hour = system_clock.getClock()[0];
        minute = system_clock.getClock()[1];
        second = system_clock.getClock()[2];
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}