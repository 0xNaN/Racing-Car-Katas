package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls
{
    private final String DiagnosticChannelConnectionString = "*111#";
    
    private final TelemetryClient client;
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
    
            int retryLeft = 3;
            while (client.getOnlineStatus() == false && retryLeft > 0)
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
