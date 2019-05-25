package Function;

public class Alarm_Manager {
    private Alarm alarm[] = new Alarm[5];
    public Alarm_Manager(){
        for(int i=0;i<5;i++) {
            alarm[i] = new Alarm();
        }
    }
}
