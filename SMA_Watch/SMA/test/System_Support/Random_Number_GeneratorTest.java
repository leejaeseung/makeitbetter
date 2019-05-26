package System_Support;

import org.junit.Test;

import static org.junit.Assert.*;

public class Random_Number_GeneratorTest {

    @Test
    public void getRandom() {
        Random_Number_Generator test=new Random_Number_Generator();
        assertNotNull(test.getRandom());
    }
}