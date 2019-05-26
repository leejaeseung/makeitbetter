package System_Support;

import org.junit.Test;

import static org.junit.Assert.*;

public class System_ClockTest {

    @Test
    public void getClock() {
        System_Clock test=new System_Clock(0,0,0,0,0,0);
        assertNotNull(test.getClock());
    }
}