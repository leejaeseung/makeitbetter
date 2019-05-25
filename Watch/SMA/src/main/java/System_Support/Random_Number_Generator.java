package System_Support;

import java.util.Random;
public class Random_Number_Generator {
    private int modeNum;
    private Random random;
    public Random_Number_Generator()
    {
        modeNum = 1;
        random = new Random();
    }
    public void setModeNum(int mNum)
    {
        modeNum = mNum;
    }

    public int getRandom()
    {
        return random.nextInt(modeNum)+1;
    }
}