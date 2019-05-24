public class Clock implements Runnable{
    private int sec;
    private boolean clk_state;

    public Clock(int sec) {
        this.sec=sec;

        new Thread(this).start();
    }
    public void run(){
        clk_state=true;
        while(clk_state){
            this.sec++;
            try{
                Thread.sleep(1000);
            }catch(Exception ex){}
        }
    }
    public void stop(){
        clk_state=false;
    }

    public int get()
    {
        return this.sec;
    }
}
