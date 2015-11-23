package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketDispenserTest {
	@Test public void
	the_first_ticket_is_zero() {
		TurnNumberSequence turnNumberSequence = new TurnNumberSequence();
		TicketDispenser dispenser = new TicketDispenser(turnNumberSequence);
		assertEquals(new TurnTicket(0), dispenser.getTurnTicket());
	}
	
}
