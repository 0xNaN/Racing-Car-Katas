package tddmicroexercises.telemetrysystem;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class TelemetryDiagnosticControlsTest
{
	@Rule public JUnitRuleMockery context = new JUnitRuleMockery();
	private final TelemetryClient client = context.mock(TelemetryClient.class);
	
	@Test(expected = Exception.class)
    public void 
    should_try_three_time_to_connect_if_client_is_offline() throws Exception {
		TelemetryDiagnosticControls diagnosticControl = new TelemetryDiagnosticControls(client);
		context.checking(new Expectations(){{
			oneOf(client).disconnect();
			exactly(4).of(client).getOnlineStatus(); will(returnValue(false));
			exactly(3).of(client).connect(with(any(String.class)));
		}});
		diagnosticControl.checkTransmission();
    }

}
