package tddmicroexercises.tirepressuremonitoringsystem;


import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import static org.junit.Assert.*;

public class TestAlarm {
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	final Sensor sensor = context.mock(Sensor.class);
	
    @Test
    public void
    should_starts_off() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }
    
    @Test
    public void
    should_turn_on_when_tire_is_low() {
    	Alarm alarm = new Alarm(sensor, 1, 2);
    	context.checking(new Expectations(){{
    		oneOf(sensor).value(); will(returnValue(0.0));
    	}});
    	alarm.check();
    	
    	assertTrue(alarm.isAlarmOn());
    }
}
