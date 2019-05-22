import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testclass {

    @Test
    public void testAdd() {
        assertEquals(42, Integer.sum(19, 23));
    }

    @Test
    public void testAdd2() {
        assertEquals(43, Integer.sum(19, 23));
    }
}
