package System_Support;
import Function.*;

public class System_Clock2 implements Runnable {
    private int hour;
    private int minute;
    private int sec;
    private int flag;
    private Buzzer buzzer;
    private Timer timer;
    private Alarm alarm;
    private int sflag;

    public System_Clock2(int h, int m, int s, Timer t) {
        hour = h;
        minute = m;
        sec = s;
        flag = 0;
        timer = t;
        sflag = 0;
    }

    public System_Clock2(int h, int m, int s, Alarm a) {
        hour = h;
        minute = m;
        sec = s;
        flag = 0;
        alarm = a;
        sflag = 1;
    }

    public void Flag() {
        flag = 0;
    }

    public void run() {
        flag = 1;
        switch (sflag) {
            case 0:
                while (flag == 1) {
                    if (sec == 0 && minute == 0 && hour == 0) {
                        buzzer = new Buzzer();
                        timer.setBuzzerFlag(1);
                        timer.setBuzzer(buzzer);
                        break;
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sec--;

                    if (sec == -1) {
                        minute--;
                        sec = 59;
                    }
                    if (minute == -1) {
                        hour--;
                        minute = 59;
                    }
                }
                break;
            case 1:
                while (flag == 1) {
                    if (sec == 0 && minute == 0 && hour == 0) {
                        buzzer = new Buzzer();
                        alarm.setBuzzerFlag(1);
                        alarm.setBuzzer(buzzer);
                        sec = 0;
                        minute = 0;
                        hour = 24;
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    sec--;
                    System.out.println(hour+" "+minute+" "+sec);
                    if (sec == -1) {
                        minute--;
                        sec = 59;
                    }
                    if (minute == -1) {
                        hour--;
                        minute = 59;
                    }
                }
                break;
        }

    }

    public int[] getClock() {
        int[] arr = new int[3];
        arr[0] = hour;
        arr[1] = minute;
        arr[2] = sec;
        return arr;
    }

}