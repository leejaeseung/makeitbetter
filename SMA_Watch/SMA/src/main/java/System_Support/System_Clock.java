package System_Support;
public class System_Clock implements Runnable {
    private int month;
    private int date;
    private int day;
    private int hour;
    private int minute;
    private int sec;
    private int[] mlimit;
    private int flag;

    public System_Clock(int m, int d, int d2, int h, int m2, int s) {
        flag = 0;
        month = m;
        date = d;
        day = d2;
        hour = h;
        minute = m2;
        sec = s;
        mlimit = new int[13];
        mlimit[1] = 31;
        mlimit[2] = 28;
        mlimit[3] = 31;
        mlimit[4] = 30;
        mlimit[5] = 31;
        mlimit[6] = 30;
        mlimit[7] = 31;
        mlimit[8] = 31;
        mlimit[9] = 30;
        mlimit[10] = 31;
        mlimit[11] = 30;
        mlimit[12] = 31;
    }

    public void Flag() {
        flag = 0;
    }

    @Override
    public void run() {
        flag = 1;
        while (flag == 1) {
            sec++;
            if (sec == 60) {
                minute++;
                sec = 0;
            }
            if (minute == 60) {
                hour++;
                minute = 0;
            }
            if (hour == 24) {
                date++;
                day++;
                hour = 0;
            }
            if (day == 8)
                day = 1;

            if (mlimit[month] + 1 == date) {
                date = 1;
                month++;
            }

            if (month == 13) {
                month = 1;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int[] getClock() {
        int[] arr = new int[6];
        arr[0] = month;
        arr[1] = date;
        arr[2] = day;
        arr[3] = hour;
        arr[4] = minute;
        arr[5] = sec;
        return arr;
    }
}