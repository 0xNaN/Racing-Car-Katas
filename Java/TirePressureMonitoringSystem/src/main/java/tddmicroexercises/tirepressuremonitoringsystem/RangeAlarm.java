package tddmicroexercises.tirepressuremonitoringsystem;

public class RangeAlarm extends Alarm
{
	private final double LOW_PRESSURE_TRESHOLD_DEFAULT  = 17;
    private final double HIGH_PRESSURE_TRESHOLD_DEFAULT = 21;

    private double lowTreshold = LOW_PRESSURE_TRESHOLD_DEFAULT;
    private double highTreshold = HIGH_PRESSURE_TRESHOLD_DEFAULT;

    public RangeAlarm(Sensor sensor, double lowTreshold, double highTreshold) {
		super(sensor);
		this.lowTreshold = lowTreshold;
		this.highTreshold = highTreshold;
	}
    
	@Override
	boolean satisfy(double pressure) {
		return pressure < highTreshold && lowTreshold < pressure;
	}    
}
