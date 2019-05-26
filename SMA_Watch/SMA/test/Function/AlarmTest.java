package Function;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlarmTest {
    @Test(timeout=1000)
    public void getInform() {
        Time t=new Time();
        Alarm test=new Alarm(t);
        int[] time = new int[3];
        time[0] = 0;
        time[1] = 0;
        time[2] = 0;
        int state = 10;
        int []inform = new int[]{2, time[0], time[1], time[2], 0, 0, state};
        test.getInform();
    }
    @Test
    public void activate() {
        Time t=new Time();
        Alarm test=new Alarm(t);
        int state = 10;
        test.activate();
        assertEquals(test.getstate(),9);
    }
}