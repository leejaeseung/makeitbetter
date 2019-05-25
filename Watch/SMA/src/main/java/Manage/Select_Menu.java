package Manage;
import GUI.*;

public class Select_Menu extends GUI {
    private Change_Mode change_mode;


    public static void main(String[] args) {
        //Select_Menu watch = new Select_Menu();
        //watch.checkMenu(0); // 메뉴 4개를 고른다

        new GUI();
    }
    /*private Select_Menu(){
        change_mode = new Change_Mode();
    }
    private void checkMenu(int n) {
        int check,count=0;
        change_mode.changeSet();
        for(;count<4;) {
            check = GUI_selectMenu(n);
            if (check == 0) {
                change_mode.startMenu(n);
                count++;
            }
            if (check == 1) n = preMenu(n);
            if (check == 2) n = nextMenu(n);
        }
        change_mode.changeMode();
    }
    private int nextMenu(int n){
        return n+1%6;
    }
    private int preMenu(int n){
        return (n+5)%6;
    }*/
}
