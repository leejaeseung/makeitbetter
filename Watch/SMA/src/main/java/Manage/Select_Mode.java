package Manage;

public class Select_Mode {

    private int mode[] = new int[6] ;
    private int now;
    private int count;
    public Select_Mode(){
        now=0;
        count=0;
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
    }

    public void selectMode(){
        if(mode[now]==0)mode[now]=1;
        else mode[now]=0;
    }

    private void nextMode(){
        now=now+1%6;
    }
    private void preMode(){
        now= (now+5)%6;
    }
    public int checkMode(int n){
        return mode[n];
    }
}
