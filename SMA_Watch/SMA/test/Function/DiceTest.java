package Function;
import org.junit.Test;
import static org.junit.Assert.*;
public class DiceTest {
    @Test
    public void setDice() {
        Dice test = new Dice();
        test.setDice(1);
        assertEquals(test.getDis()[3],2);
    }
    @Test(timeout=1000)
    public void testchangeDiceNum() {
        Dice test = new Dice();
        test.changeDiceNum();
    }
    @Test(timeout=1000)
    public void rollDice() {
        Dice test = new Dice();
        test.rollDice();
    }
    @Test
    public void getDis() {
        Dice test=new Dice();
        int disNum = 0;
        int isSet = 8;
        int [] dis = new int[] {4,0,0,disNum,0,0,isSet};
        assertArrayEquals(dis,test.getDis());
    }
}