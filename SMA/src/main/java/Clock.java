public class Clock implements Runnable {
    private int sec;

    public Clock(int sec) {
        this.sec=sec;

        new Thread(this).start();
    }
    public void run(){
        while(true){
            this.sec++;
            try{
                Thread.sleep(1000);
            }catch(Exception ex){}

        }
    }

    public int get()
    {
        return this.sec;
    }
}
