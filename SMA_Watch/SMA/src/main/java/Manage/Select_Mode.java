package Manage;

public class Select_Mode {

    private int mode[] = new int[6] ;
    private int now;
    private int count;
    private int [] dis;
    public Select_Mode(){
        dis=new int[7];
    }

    public int run(int input){
        if(input == 1) nextMode(); // 다음
        else if(input ==2) preMode(); // 전
        else if(input==3) selectMode(); // 활성화 변경
        if(count==4)return 1; // 4개 활성화 되었다.
        return 0;
    }

    public void setMode(){
        for(int i=0;i<6;i++){
            mode[i] =0;
        }
        count=0;
        now=0;
    }

    public void selectMode(){
        if(mode[now]==0){
            mode[now]=1;
            count++;
        }
        else {
            mode[now]=0;
            count--;
        }
    }

    private void nextMode(){
        now=(now+1)%6;
    }
    private void preMode(){
        now= (now+5)%6;
    }
    public int checkMode(int n){
        return mode[n];
    }
    public int[] getDis() {
        dis[0] = now;
        dis[1] = 0;
        dis[2] = 0;
        dis[3] = count;
        dis[4] = 0;
        dis[5] = 0;
        if(mode[now]==0)dis[6] = 10; //off
        else if(mode[now]==1)dis[6] = 9; //on
        return dis;
    }
}
