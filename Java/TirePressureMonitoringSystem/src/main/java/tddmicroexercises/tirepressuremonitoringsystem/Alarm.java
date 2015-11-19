package tddmicroexercises.tirepressuremonitoringsystem;

public abstract class Alarm {
	private Sensor sensor;
	private boolean alarmOn = false;

	public Alarm(Sensor sensor) {
		this.sensor = sensor;
	}

	public void check()
	{
		if (! satisfy(sensor.value())) {
			alarmOn = true;
		}
	}

	abstract boolean satisfy(double value);


	public boolean isAlarmOn()
	{
		return alarmOn; 
	}
}
