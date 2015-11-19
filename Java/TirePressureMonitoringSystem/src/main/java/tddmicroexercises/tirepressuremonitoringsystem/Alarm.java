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
    	this.sensor = new FakeSensor();
    }
    
    public Alarm(Sensor sensor, double lowTreshold, double highTreshold) {
    	this.sensor = sensor;
    	this.lowTreshold = lowTreshold;
    	this.highTreshold = highTreshold;
    }

    public void check()
    {
        double psiPressureValue = sensor.value();

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
