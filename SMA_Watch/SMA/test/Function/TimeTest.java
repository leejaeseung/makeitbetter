package Function;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {


    @Test
    public void getSystemClock() {
        Time test=new Time();
        assertNotNull(test.getSystemClock());
    }

}