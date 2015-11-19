package tddmicroexercises.tirepressuremonitoringsystem;

public class Alarm
{
    private final double LOW_PRESSURE_TRESHOLD_DEFAULT  = 17;
    private final double HIGH_PRESSURE_TRESHOLD_DEFAULT = 21;

    private double lowTreshold = LOW_PRESSURE_TRESHOLD_DEFAULT;
    private double highTreshold = HIGH_PRESSURE_TRESHOLD_DEFAULT;
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

        if (psiPressureValue < lowTreshold || highTreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
