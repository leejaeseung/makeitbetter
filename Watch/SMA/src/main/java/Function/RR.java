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
        while(true) {
            int check = GUI_btn();
            display(5,0,0,ratio,1,1,8);
                if (check == 5) setRR();
                else if (check == 3) playRR();
                else if(check==4||check==6)
                    break;
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e){}
        }
    }

    private void setRR(){
        while(true) {
            int check = GUI_btn();
            display(5, 0, 0, ratio, 1, 1, 7);
                if (check == 1) up();
                else if (check == 2) down();
                else if(check==4||check==6||check==5)
                    break;
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e){}
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