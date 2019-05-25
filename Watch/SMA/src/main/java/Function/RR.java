package Function;

import GUI.GUI;
import System_Support.Buzzer;
import System_Support.Random_Number_Generator;
public class RR extends GUI
{
    private int ratio;
    private int answer;
    private Random_Number_Generator random;
    private Buzzer buzzer;

    public RR()
    {
        ratio = 6; answer = 1;
        random = new Random_Number_Generator();
        buzzer = new Buzzer();
    }

    public void run(){
        for(;;) {
            int check = GUI_RR();
            if (check == 0) setRR();
            else if (check == 1) playRR();
            else break;
        }
    }

    private void setRR(){
        while(true) {
            if (GUI_setRR()==0)up();
            else if(GUI_setRR()==1)down();
            else break;
        }
    }

    private int up()
    {
        if(ratio<10) {
            ratio++;
        }
        return ratio;
    }

    private int down()
    {
        if(ratio > 1)
            ratio--;
        return ratio;
    }

    public void playRR()
    {
        random.setModeNum(ratio);
        int ranNum = random.getRandom();
        if(ranNum == answer)
        {
            buzzer.start();
        }
    }
}