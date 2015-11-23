package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicketDispenserTest {
	TurnNumberSequence turnNumberSequence;
	TicketDispenser dispenser;
	
	@Before
	public void setUp() {
		turnNumberSequence = new TurnNumberSequence();
		dispenser = new TicketDispenser(turnNumberSequence);
	}
	
	@Test public void
	the_first_ticket_is_zero() {
		assertEquals(new TurnTicket(0), dispenser.getTurnTicket());
	}
	
	@Test public void
	the_tickets_value_increments() {	
		TurnTicket firstTicket = dispenser.getTurnTicket();
		TurnTicket secondTicket = dispenser.getTurnTicket();
		assertEquals(new TurnTicket(1), secondTicket);
	}
	
	@Test public void
	two_dispenser_doesnt_assign_the_same_ticket() {
		TicketDispenser secondDispenser = new TicketDispenser(turnNumberSequence);
		
		TurnTicket firstTicket = dispenser.getTurnTicket();
		TurnTicket secondTicket = secondDispenser.getTurnTicket();
		
		assertEquals(new TurnTicket(0), firstTicket);
		assertEquals(new TurnTicket(1), secondTicket);
	}
}
