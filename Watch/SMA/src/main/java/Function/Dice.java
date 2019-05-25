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
        int check;
        while(true) {
            super.display(0,0,0,randomNumber,0,0,0);
            check = super.GUI_btn();
            if (check == 5) if(setDice()==1)return; // ok2초 누르면 다이스 세팅모드 진입
            else if (check == 3) rollDice(); //ok버튼 누르면 다이스 굴림
            else if (check == 4) break; // menu버튼 누르면 나오기
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e){}
        }
    }

    public int setDice(){
        int check;
        while(true) {
            super.display(0,0,0,diceNum,0,0,0);
            check = super.GUI_btn();
            if (check==1||check==2)changeDiceNum(); // up이나 down버튼 누르면 다이스 개수 변경
            else if(check==4)return 1;
            else if(check==3)break;
            try {
                Thread.sleep(100);
            }catch(InterruptedException e){}
        }
        return 0;
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
