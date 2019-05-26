package System_Support;

public class System_Clock implements Runnable{
    int clock = 0;
    int hour;
    int minute;
    int sec;


    public System_Clock(int h, int m, int s)
    {
        hour = h;
        minute = m;
        sec = s;
    }
    @Override
    public void run()
    {
        while(true)
        {
            sec++;
            if(sec == 60)
            {
                minute++;
                sec = 0;
            }
            if(minute == 60)
            {
                hour++;
                minute = 0;
            }
            if(hour == 24)
                hour = 0;
            try
            {
                Thread.sleep(1000);
            }catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
    public int[] getClock(){
        int[] arr = new int[3];
        arr[0] = hour;
        arr[1] = minute;
        arr[2] = sec;
        return arr;
    }


}