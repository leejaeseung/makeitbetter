public class StopWatch implements Runnable{
    private int min;
    private int sec;
    private int m;

    public StopWatch(){

    }
    public void startSW(){
        new Thread(this).start();
    }
    public void run(){
        Clock clk=new Clock(this.sec);
        while(true){
            this.sec = clk.get();
            System.out.println(this.sec);
            try{
                Thread.sleep(1000);
            }catch(Exception ex){}
        }
    }
    public void stopSW(){

    }
    public void resetSW(){

    }
}
