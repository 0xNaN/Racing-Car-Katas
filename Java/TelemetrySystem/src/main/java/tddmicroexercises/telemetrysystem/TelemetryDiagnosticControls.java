package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
	private final String DiagnosticChannelConnectionString = "*111#";
	public static final String DIAGNOSTIC_MESSAGE = "AT#UD";
	
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
    
            client.send(DIAGNOSTIC_MESSAGE);
            diagnosticInfo = client.receive();
        }

        private void connect() {
            client.connect(DiagnosticChannelConnectionString);	
        }
        
  
}
