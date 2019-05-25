package Function;

import System_Support.Random_Number_Generator;
public class Dice {

    private int diceNum;
    Random_Number_Generator random;

    public Dice()
    {
        diceNum = 1;
        random = new Random_Number_Generator();
        random.setModeNum(6);
    }

    public void run(){
        while(ture) {
            int check = GUI_dice();
            if (check == 0) setDice();
            else if (check == 1) rollDice();
            else break;
        }
    }

    public void setDice(){
        while(true) {
            if (GUI_setDice()==0)changeDiceNum();
            else break;
        }
    }


    public int changeDiceNum()
    {
        if(diceNum == 1)
        {   diceNum++; random.setModeNum(12); }
        else
        {    diceNum--; random.setModeNum(6); }
        return diceNum;
    }

    public int rollDice()
    {
        return random.getRandom();
    }
}
