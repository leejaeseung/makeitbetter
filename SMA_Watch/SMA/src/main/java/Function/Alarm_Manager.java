package Function;

public class Alarm_Manager {
    private Alarm alarm[] = new Alarm[5];
    private int isset;
    private int[] dis;
    private int armindex;

    public Alarm_Manager(Time t) {
        for (int i = 0; i < 5; i++) {
            alarm[i] = new Alarm(t);
        }
        isset = 8;
        armindex = 0;
        dis = alarm[armindex].getInform();
    }

    public void run(int check) {
        if (isset == 8) {                       //셋 모드가 아닐 때
            if (check == 5)                    //OK가 2초 눌리면 셋모드가 됨
            {
                isset = 7;
                dis[6] = isset;
            } else                            //아니면 알람 선택
            {
                selectAlarm(check);
            }
        } else {                               //셋 모드일 때
            if (check == 5)                    //OK가 2초 눌리면 선택 모드가 됨
            {
                isset = 8;
                alarm[armindex].activate();
            } else {
                setAlarm(check);
            }
        }
    }

    private void selectAlarm(int check) {
        if (check == 1) up();
        if (check == 2) down();
        if (check == 3) {
            alarm[armindex].activate();
        }
        dis = alarm[armindex].getInform();
    }

    private void setAlarm(int check) {
        alarm[armindex].setThis(check);
        dis = alarm[armindex].getInform();
        dis[6] = isset;
    }

    private void up() {
        if (armindex < 4) {
            armindex++;
        } else {
            armindex = 0;
        }
    }

    private void down() {
        if (armindex > 0)
            armindex--;
        else
            armindex = 4;
    }

    public int[] getDis() {
        return dis;
    }
}