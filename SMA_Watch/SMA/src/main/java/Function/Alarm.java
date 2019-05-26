package Function;
import System_Support.*;
public class Alarm {
    private int [] time=new int[3];                //0=hour,1=min,2=sec
    private int cursor;
    private int state;
    private int [] inform;
    //변수1-------------------------------------------------
    private Time t;
    private int[] startTime = new int[3];
    private int[] gapTime = new int[3];
    private System_Clock2 sc;
    private Thread thread;
    private int buzzerFlag;
    private Buzzer buzzer;
    //변수1-------------------------------------------------
    public Alarm(Time t){
        time[0]=0;
        time[1]=0;
        time[2]=0;
        cursor=0;
        state=10;
        this.t = t;
        buzzerFlag = 0;
        buzzer = null;
    }
    public int [] getInform(){
        inform=new int[]{2,time[0],time[1],time[2],1,1,state};
        return inform;
    }
    private int[] getGapTime(int[] t1, int[] t2) //t1 이 알람설정된시간 t2가 현재시간
    {
        System.out.println(t1[0]+" "+t1[1]+" "+t1[2]);
        System.out.println(t2[3]+" "+t2[4]+" "+t2[5]);
        int ret[] = new int[3];
        int tmp1,tmp2,tmp;
        tmp1 = 3600*t1[0]+60*t1[1]+t1[0];
        tmp2 = 3600*t2[3]+60*t2[4]+t2[5];
        if(tmp1>tmp2)tmp=tmp1-tmp2;
        else tmp=(tmp1+3600*24)-tmp2;
        ret[0] = tmp/3600;
        tmp=tmp%3600;
        ret[1] = tmp/60;
        tmp=tmp%60;
        ret[2] = tmp;
        System.out.println(ret[0]+" "+ret[1]+" "+ret[2]);
        return ret;

    }
    public void activate(){
        if(state==9)
        {
            state=10;
            if(sc != null) {
                sc.Flag();
                sc = null;
            }
        }
        else //알람 on
        {
            System.out.println(10000);
            state=9;
            startTime = t.getSystemClock(); //현재시간 가져옴
            gapTime = getGapTime(time, startTime); //알람설정된 시간과
            sc = new System_Clock2(gapTime[0], gapTime[1], gapTime[2], this);
            thread = new Thread(sc, "내부클럭");
            thread.start();
        }
    }
    public void setThis(int check){
        if(check==1)                    //현재 커서 값 증가
        {
            if(cursor!=0) {
                if (time[cursor] < 59) {
                    time[cursor]++;
                } else {
                    time[cursor] = 0;
                }
            }
            else
            {
                if (time[cursor] < 23) {
                    time[cursor]++;
                } else {
                    time[cursor] = 0;
                }
            }
        }
        if(check==2)                    //현재 커서 값 감소
        {
            if(cursor!=0) {
                if (time[cursor] > 0) {
                    time[cursor]--;
                } else {
                    time[cursor] = 59;
                }
            }
            else
            {
                if (time[cursor] >0) {
                    time[cursor]--;
                } else {
                    time[cursor] = 23;
                }
            }
        }
        if(check==3)                    //커서 변경
        {
            if(cursor<2) {
                cursor++;
            }
            else
            {
                cursor=0;
            }
        }
    }
    public int isbuzzer() //위에서 buzzerFlag 값을 가져가는 getter
    {
        return buzzerFlag;
    }
    public void setBuzzerFlag(int b) //위에서 buzzer끄고 timer 객체의 buzzerflag를 0으로 만들어줄때 써야됨
    {
        buzzerFlag = b;
    }

    public Buzzer getBuzzer() //위에서 buzzer 가져가는함수
    {
        return buzzer;
    }
    public void setBuzzer(Buzzer b) //system_clock에서 버저가 울리면 그때 생성된 buzzer객체를 timer 객체에 있는 buzzer함수에 설정해주는거
    {
        buzzer = b;
    }
    public int getstate(){
        return state;
    }
}