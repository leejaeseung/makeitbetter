public class Time{
    private int m;
    private int d;
    private int h;
    private int min;
    private int sec;
    public Time(){

        this.m=0;
        this.d=0;
        this.h=0;
        this.min=0;
        this.sec=0;

        Clock dis=new Clock(sec);

        while(true)
        {
            this.sec = dis.get();
            System.out.println(this.sec);
            try{
                Thread.sleep(1000);
            }catch(Exception ex){}
        }
    }
    //public void display(){
       // lbl.setText(this.m+"-"+this.d+"   "+this.h+":"+this.min+":"+this.sec);
   // }
}
