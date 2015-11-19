package tddmicroexercises.tirepressuremonitoringsystem;


import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.*;

import static org.junit.Assert.*;

public class TestAlarm {
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	final Sensor sensor = context.mock(Sensor.class);
	
	private Alarm alarm;
	
	@Before
	public void setUp() {
		this.alarm = new Alarm(sensor, 1, 2);
	}
	
    @Test
    public void
    should_starts_off() {
        assertEquals(false, alarm.isAlarmOn());
    }
    
    @Test
    public void
    should_turn_on_when_tire_is_low() {
    	context.checking(new Expectations(){{
    		oneOf(sensor).value(); will(returnValue(0.0));
    	}});
    	alarm.check();
    	
    	assertTrue(alarm.isAlarmOn());
    }
    
    @Test
    public void
    should_turn_on_when_tire_is_high() {
    	context.checking(new Expectations(){{
    		oneOf(sensor).value(); will(returnValue(3.0));
    	}});
    	alarm.check();
    	
    	assertTrue(alarm.isAlarmOn());
    }
    
    @Test
    public void
    should_remain_off_when_tire_is_between_range() {
    	context.checking(new Expectations(){{
    		oneOf(sensor).value(); will(returnValue(1.5));
    	}});
    	alarm.check();
    	
    	assertFalse(alarm.isAlarmOn());
    }
}
