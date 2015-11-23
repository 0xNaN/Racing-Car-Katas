package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketDispenserTest extends TicketDispenser {

	@Test public void
	the_first_ticket_is_zero() {
		TicketDispenser dispenser = new TicketDispenser();
		assertEquals(new TurnTicket(0), dispenser.getTurnTicket());
	}
}
