public class StopWatch implements Runnable{
    private int min;
    private int sec;
    private int mes;
    private boolean isrun;
    private Clock clk;

    public StopWatch(){
        this.isrun=true;
        }
    public void startSW(){
        new Thread(this).start();
    }
    public void run(){
            this.isrun=true;
            clk = new Clock(this.sec);
            while (isrun) {
                this.sec = clk.get();
                System.out.println(this.sec);
                try {
                    Thread.sleep(1000);
                } catch (Exception ex) {
                }
            }
    }
    public void stopSW(){
        this.clk=null;
        this.isrun=false;
    }
    public void resetSW(){

    }
    public boolean getIsrun(){
        return this.isrun;
    }
}
