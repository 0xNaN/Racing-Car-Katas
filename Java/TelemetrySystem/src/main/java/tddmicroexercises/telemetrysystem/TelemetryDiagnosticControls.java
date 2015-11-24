package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private static final int RETRY_ATTEMPT = 3;

	private final String DiagnosticChannelConnectionString = "*111#";
    
    private TelemetryClient client;
    private String diagnosticInfo = "";

        public TelemetryDiagnosticControls(TelemetryClient client)
        {
            this.client = client;
        }
        
        public String getDiagnosticInfo(){
            return diagnosticInfo;
        }
        
        public void setDiagnosticInfo(String diagnosticInfo){
            this.diagnosticInfo = diagnosticInfo;
        }
 
        public void checkTransmission() throws Exception
        {
            diagnosticInfo = "";

            client.disconnect();
    
            int retryLeft = RETRY_ATTEMPT;
            while (retryLeft > 0 && !client.getOnlineStatus())
            {
                client.connect(DiagnosticChannelConnectionString);
                retryLeft -= 1;
            }
             
            if(client.getOnlineStatus() == false)
            {
                throw new Exception("Unable to connect.");
            }
    
            client.send(FakeTelemetryClient.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = client.receive();
    }
}
