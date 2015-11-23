package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicketDispenserTest {
	SequenceGenerator turnNumberSequence;
	TicketDispenser dispenser;
	
	TurnTicket TICKET_ZERO = new TurnTicket(0);
	TurnTicket TICKET_ONE  = new TurnTicket(1);
	
	TurnTicket firstTicket;
	TurnTicket secondTicket;
	
	@Before
	public void setUp() {
		turnNumberSequence = new TurnNumberSequence();
		dispenser = new TicketDispenser(turnNumberSequence);
	}
	
	@Test public void
	the_first_ticket_is_zero() {
		assertEquals(TICKET_ZERO, dispenser.getTurnTicket());
	}
	
	@Test public void
	the_tickets_value_increments() {	
		firstTicket = dispenser.getTurnTicket();
		secondTicket = dispenser.getTurnTicket();
		assertEquals(TICKET_ONE, secondTicket);
	}
	
	@Test public void
	two_dispenser_doesnt_assign_the_same_ticket() {
		TicketDispenser secondDispenser = new TicketDispenser(turnNumberSequence);
		
		firstTicket = dispenser.getTurnTicket();
		secondTicket = secondDispenser.getTurnTicket();
		
		assertEquals(TICKET_ZERO, firstTicket);
		assertEquals(TICKET_ONE, secondTicket);
	}
}
