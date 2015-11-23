package tddmicroexercises.turnticketdispenser;

public class TurnTicket
{
    private final int turnNumber;

    public TurnTicket(int turnNumber)
    {
        this.turnNumber = turnNumber;
    }

    public int getTurnNumber()
    {
        return turnNumber;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + turnNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TurnTicket other = (TurnTicket) obj;
		if (turnNumber != other.turnNumber)
			return false;
		return true;
	}

}
