package Function;

import System_Support.Buzzer;
import System_Support.Random_Number_Generator;
public class RR {
    private int ratio;
    private int answer;
    private int isSet;                    //7이면 setmode
    private int[] dis;
    private int disNum;
    private Random_Number_Generator random;
    private Buzzer buzzer;
    private int buzzerFlag;

    public RR() {
        ratio = 6;
        answer = 1;
        isSet = 8;
        disNum = ratio;
        random = new Random_Number_Generator();
        dis = new int[]{5, 0, 0, disNum, 0, 0, isSet};
        isSet = 8;
        buzzerFlag = 0;
    }

    public void run(int check) {
        if (isSet == 8) {
            if (check == 5) {
                enterSetMode();
            } else if (check == 3)
                playRR();
        } else {
            if (check == 5)
                exitSetMode();
            else
                setRR(check);
        }
    }

    private void enterSetMode() {
        isSet = 7;
    }

    private void exitSetMode(){
        isSet =8;
    }
    private void setRR(int check){
        if (check == 1) up();
        else if (check == 2) down();
        disNum=ratio;
    }

    private void up()
    {
        if(ratio<10) {
            ratio++;
        }
        else
        {
            ratio=2;
        }
    }

    private void down()
    {
        if(ratio > 2)
            ratio--;
        else
            ratio=10;
    }
    private void playRR()
    {
        random.setModeNum(ratio);
        int ranNum = random.getRandom();
        if(ranNum == answer)
        {
            buzzer = new Buzzer();
            buzzerFlag=1;
        }
        disNum=ratio;
    }
    public int getBuzzerFlag(){
        return buzzerFlag;
    }
    public void setBuzzerFlag(){
        buzzerFlag=0;
        buzzer.stopBuzzer();
    }
    public int [] getDis(){
        dis[3]=disNum;
        dis[6]=isSet;
        return dis;
    }
}