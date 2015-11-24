package tddmicroexercises.telemetrysystem;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class TelemetryDiagnosticControlsTest
{
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
	
}
