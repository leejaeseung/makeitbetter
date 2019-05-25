package Function;

import System_Support.Random_Number_Generator;
public class Dice {

    private int diceNum;
    private int randomNumber
    Random_Number_Generator random;

    public Dice()
    {
        diceNum = 1;
        random = new Random_Number_Generator();
        random.setModeNum(6);
        randomNumber=random.getRandom();
    }

    public void run(){
        while(true) {
            int check = GUI_dice(randomNumber);
            if (check == 0) setDice();
            else if (check == 1) rollDice();
            else break;
        }
    }

    public void setDice(){
        while(true) {
            if (GUI_setDice(diceNum)==0)changeDiceNum();
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
        randomnumber = random.getRandom();
    }
}
