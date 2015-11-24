package tddmicroexercises.telemetrysystem;

public interface TelemetryClient {

	public abstract boolean getOnlineStatus();

	public abstract void connect(String connectionString);
	
	public abstract boolean reconnect();

	public abstract void disconnect();

	public abstract void send(String message);

	public abstract String receive();

}