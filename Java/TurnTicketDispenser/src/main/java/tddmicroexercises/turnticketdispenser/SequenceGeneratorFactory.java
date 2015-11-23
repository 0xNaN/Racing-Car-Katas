package tddmicroexercises.turnticketdispenser;

public class SequenceGeneratorFactory {
	private static TurnNumberSequence turnNumberSequence = new TurnNumberSequence();
	
	public static 
	SequenceGenerator staticTurnTicketGenerator() {
		return turnNumberSequence;
	}
}
