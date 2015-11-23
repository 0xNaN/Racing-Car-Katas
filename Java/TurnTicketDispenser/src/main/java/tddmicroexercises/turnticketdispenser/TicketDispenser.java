package tddmicroexercises.turnticketdispenser;

public class TicketDispenser
{
	private SequenceGenerator turnNumberSequence;
	
	public TicketDispenser() {
		this(TicketGeneratorFactory.staticTurnTicketGenerator());
	}
	
	public TicketDispenser(SequenceGenerator turnNumberSequence) {
		this.turnNumberSequence = turnNumberSequence; 
	}
	
    public TurnTicket getTurnTicket()
    {
        int newTurnNumber = turnNumberSequence.nextNumber();
        TurnTicket newTurnTicket = new TurnTicket(newTurnNumber);

        return newTurnTicket;
    }
}
