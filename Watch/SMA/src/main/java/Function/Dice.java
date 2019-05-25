package Function;
import GUI.*;

import System_Support.Random_Number_Generator;
public class Dice extends GUI{

    private int diceNum;
    private int randomNumber;
    Random_Number_Generator random;

    public Dice()
    {
        diceNum = 1;
        random = new Random_Number_Generator();
        random.setModeNum(6);
        randomNumber=random.getRandom();
    }

    public void run(){
        System.out.println("dice run");
        while(true) {
            int check = GUI_btn();
            System.out.println("dice run2");
            if (check == 5) setDice();
            else if (check == 3) rollDice();
            else break;
        }
    }

    public void setDice(){
        while(true) {
            System.out.println("dice run3");
            if (GUI_btn()==1||GUI_btn()==2)changeDiceNum();
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

    public void rollDice()
    {
        randomNumber = random.getRandom();
    }
}
