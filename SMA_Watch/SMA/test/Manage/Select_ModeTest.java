package Manage;

import org.junit.Test;

import static org.junit.Assert.*;

public class Select_ModeTest {

    @Test
    public void run() {
        Select_Mode test=new Select_Mode();
        assertEquals(test.run(5),0);
    }

    @Test
    public void checkMode() {
        Select_Mode test=new Select_Mode();
        assertNotNull(test.checkMode(2));
    }
}