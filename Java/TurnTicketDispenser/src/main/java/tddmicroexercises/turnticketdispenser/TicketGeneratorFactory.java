package tddmicroexercises.turnticketdispenser;

public class TicketGeneratorFactory {
	private static TurnNumberSequence turnNumberSequence = new TurnNumberSequence();
	
	public static 
	SequenceGenerator staticTurnTicketGenerator() {
		return turnNumberSequence;
	}
}
