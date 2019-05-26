package Function;

import org.junit.Test;

import static org.junit.Assert.*;

public class RRTest {

    @Test
    public void getBuzzerFlag() {
        RR test=new RR();
        assertNotNull(test.getBuzzerFlag());
    }
}