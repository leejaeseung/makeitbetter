package Function;
import System_Support.*;

public class Stop_Watch {
    private System_Clock sc;
    private int hour;
    private int minute;
    private int sec;
    private int[][] record;
    private int top;
    private int top2;
    private int[] dis;
    private int isrun;
    private int[] rec;

    public Stop_Watch() {
        sc = new System_Clock(0, 0, 0, 0, 0, 0);
        hour = 0;
        minute = 0;
        sec = 0;
        record = new int[3][3];
        top = -1;
        top2 = -1;
        isrun = 0;
        dis = new int[7];
        rec = new int[3];
    }

    private void Record() {
        if (top < 2) {
            updateSW();
            top++;
            record[top][0] = hour;
            record[top][1] = minute;
            record[top][2] = sec;

        }
    }

    private int[] getRecord() {
        if (top2 == 2) {
            top2 = 0;
        } else
            top2++;

        int arr[] = new int[3];
        arr[0] = record[top2][0];
        arr[1] = record[top2][1];
        arr[2] = record[top2][2];
        return arr;
    }


    private void updateSW() {
        int[] arr = sc.getClock();
        hour = arr[3];
        minute = arr[4];
        sec = arr[5];
    }

    public void run(int check) {
        if (isrun == 0)                    //SW가 안돌고 있을 때
        {
            if (check == 1)                //SW 실행
            {
                startSW();
            }
            if (check == 2)           //SW 초기화
            {
                resetSW();
            }
            if (check == 3)           //기록 확인
            {
                showRecord();
            }
        } else                            //SW가 돌고 있을 때
        {
            if (check == 1)            //정지
            {
                pauseSW();
            } else if (check == 3)            //기록 저장
            {
                Record();
            } else                        //아무것도 안누르면 시간 보여줌
            {
                hour = sc.getClock()[3];
                minute = sc.getClock()[4];
                sec = sc.getClock()[5];
            }
        }
    }
    private  void showRecord(){
        rec = getRecord();
        hour = rec[0];
        minute = rec[1];
        sec = rec[2];
    }
    private void startSW() {
        Thread t = new Thread(sc, "내부클럭");
        t.start();
        isrun = 1;
    }

    private void pauseSW() {
        updateSW();
        sc.Flag();
        sc = new System_Clock( 0, 0, 0, hour, minute, sec);
        isrun = 0;
    }

    private void resetSW() {
        hour = 0;
        minute = 0;
        sec = 0;
        record = new int[3][3];
        sc.Flag();
        sc = new System_Clock( 0, 0, 0, 0, 0, 0);
        top = -1;
        top2 = -1;
    }

    public int[] getDis() {
        dis[0] = 1;
        dis[1] = hour;
        dis[2] = minute;
        dis[3] = sec;
        dis[4] = 0;
        dis[5] = 0;
        dis[6] = 8;
        return dis;
    }
}