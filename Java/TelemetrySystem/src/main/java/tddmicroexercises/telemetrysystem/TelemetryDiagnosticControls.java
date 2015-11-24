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
        	connect();
            if(client.getOnlineStatus() == false)
            	client.reconnect();
    
            client.send(FakeTelemetryClient.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = client.receive();
        }

        private void connect() {
            client.connect(DiagnosticChannelConnectionString);	
        }
        
  
}
