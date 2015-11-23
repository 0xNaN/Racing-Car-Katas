package tddmicroexercises.turnticketdispenser;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketDispenserTest extends TicketDispenser {

	@Test public void
	should_assign_a_ticket_of_zero() {
		TicketDispenser dispenser = new TicketDispenser();
		TurnTicket turnTicket = dispenser.getTurnTicket();
		assertEquals(0, turnTicket.getTurnNumber());
	}
}
