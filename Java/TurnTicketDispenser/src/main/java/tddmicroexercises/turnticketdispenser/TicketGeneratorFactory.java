package tddmicroexercises.turnticketdispenser;

public class TicketGeneratorFactory {
	private static SequenceGenerator turnNumberSequence = new TurnNumberSequence();
	
	public static 
	SequenceGenerator staticTurnTicketGenerator() {
		return turnNumberSequence;
	}
}
