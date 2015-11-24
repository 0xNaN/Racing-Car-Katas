package tddmicroexercises.telemetrysystem;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TelemetryDiagnosticControlsTest
{
	final String DIAGNOSTIC_MESSAGE = "AT#UD";
	
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private final TelemetryClient client = context.mock(TelemetryClient.class);
	TelemetryDiagnosticControls diagnosticControl;
	
	@Before
	public void setUp() {
		diagnosticControl = new TelemetryDiagnosticControls(client);		
	}
	
	@Test (expected = Exception.class)
    public void
    should_throw_an_exception_if_failed_to_reconnect() throws Exception {
		context.checking(new Expectations(){{
			exactly(1).of(client).connect(with(any(String.class)));
			exactly(1).of(client).getOnlineStatus(); will(returnValue(false));
			exactly(1).of(client).reconnect(); will(throwException(new Exception()));
		}});
		diagnosticControl.checkTransmission();
    }
	
	@Test
	public void
    should_set_the_message_received() throws Exception {
		
		context.checking(new Expectations(){{
			exactly(1).of(client).connect(with(any(String.class)));
			exactly(1).of(client).getOnlineStatus(); will(returnValue(true));
			exactly(1).of(client).send(with(DIAGNOSTIC_MESSAGE));
			exactly(1).of(client).receive(); will(returnValue("msg"));
		}});
		
		diagnosticControl.checkTransmission();
		assertEquals("msg", diagnosticControl.getDiagnosticInfo());
    }
	
}
