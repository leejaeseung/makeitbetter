package Manage;
import GUI.*;

public class Select_Menu extends GUI {
   private Change_Mode change_mode;

   private Select_Menu(){
        change_mode = new Change_Mode();
   }

   public static void main(String[] args) {
       Select_Menu watch = new Select_Menu();
       watch.checkMenu(0); // 메뉴 4개를 고른다
   }

    private void checkMenu(int n) {
        int check,count=0;
        change_mode.changeSet();
        for(;count<4;) {
            check=GUI_btn();
            display(n,0,0,0,0,0,0);
            if (check == 3) {
                change_mode.startMenu(n);
                count++;
            }
            if (check == 2) n = preMenu(n); //down버튼을 누르면 이전모드 확인
            if (check == 1) n = nextMenu(n);  //up버튼을 누르면 다음모드 확인
            try {
                Thread.sleep(100);
            }catch(InterruptedException e){}
        }

        change_mode.changeMode();
    }
    private int nextMenu(int n){
       return n+1%6;
    }
    private int preMenu(int n){
       
       return (n+5)%6;
    }
}
