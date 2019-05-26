package Function;
import System_Support.*;

public class Timer
{
    private int setHour;
    private int setMinute;
    private int setSec;
    private int hour;
    private int minute;
    private int sec;
    private System_Clock2 sc;
    private Thread t;
    private int isSet;
    private int isRun;
    private int setNow;
    private int[] dis;
    private int buzzerFlag;
    private Buzzer buzzer;

    public Timer()
    {
        hour = 1;
        minute = 0;
        sec = 0;
        setHour=1;
        setMinute=0;
        setSec=0;
        isSet=8;
        isRun=0;
        sc = new System_Clock2(setHour,setMinute,setMinute,this);
        dis = new int[]{3,hour,minute,sec,0,0,isSet};
        buzzer=null;
    }
    public void run(int input){
        if (isSet == 7) {
            if (input == 5) {
                enterSetMode();
            }
            else  {
                setMode(input);
            }
        }
        else {
            if (input == 5) {
                exitSetMode();
            }
            else if (input==1){ // 실행
                if(isRun==0)startTimer();
                else pauseTimer();
            }
            else if(input==2&&isRun==0){
                resetTimer();
            }
            else {
                updateTimer();
            }
        }
    }
    private void enterSetMode(){
        isSet=8;
        resetTimer();
    }
    private void exitSetMode(){
        isSet=7;
        setNow=0;
    }
    private void setMode(int input){
        if(setNow==0) {
            if(input==1)setHour=(setHour+1)%24;
            else if(input==2)setHour=(setHour+23)%24;
            else if(input==3)setNow=1;
        }
        else if(setNow==1){
            if(input==1)setMinute=(setMinute+1)%60;
            else if(input==2)setMinute=(setMinute+59)%60;
            else if(input==3)setNow=2;
        }
        else if(setNow==2){
            if(input==1)setSec=(setSec+1)%60;
            else if(input==2)setSec=(setSec+59)%60;
            else if(input==3)setNow=0;
        }
    }
    public int getBuzzerFlag() //위에서 buzzerFlag 값을 가져가는 getter
    {
        return buzzerFlag;
    }
    public void setBuzzerFlag() //위에서 buzzer끄고 timer 객체의 buzzerflag를 0으로 만들어줄때 써야됨
    {
        isRun=0;
        buzzerFlag=0;
        sc = new System_Clock2(setHour, setMinute, setSec,this);
        updateTimer();
    }
    public void setBuzzer(Buzzer flag){
        buzzer=flag;
    }
    public void setBuzzerFlag(int flag){
        buzzerFlag=flag;
    }
    public void updateTimer()
    {
        int[] arr = sc.getClock();
        hour = arr[0];
        minute = arr[1];
        sec = arr[2];
    }

    public void startTimer()
    {
        isRun=1;
        t = new Thread(sc, "내부클럭");
        t.start();
    }

    public void pauseTimer()
    {
        isRun=0;
        sc.Flag();
        sc = new System_Clock2(hour, minute, sec,this);
        updateTimer();
    }

    public void resetTimer()
    {
        hour=setHour;
        minute=setMinute;
        sec=setSec;
        pauseTimer();
    }
    public int[] getDis(){
        if(isSet==8){
            dis[1]=hour;
            dis[2]=minute;
            dis[3]=sec;
            dis[6]=isSet;
        }
        else{
            dis[1]=setHour;
            dis[2]=setMinute;
            dis[3]=setSec;
            dis[6]=isSet;
        }
        return dis;
    }
}