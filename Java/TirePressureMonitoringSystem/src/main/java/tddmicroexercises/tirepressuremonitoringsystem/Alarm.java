package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LowPressureTreshold = 17;
    private final double HighPressureTreshold = 21;

    private Sensor sensor;

    boolean alarmOn = false;
    
    public Alarm() {
    	this.sensor = new Sensor();
    }
    
    public Alarm(Sensor sensor) {
    	this.sensor = sensor;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureTreshold || HighPressureTreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
