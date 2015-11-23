package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence implements SequenceGenerator
{
    private int _turnNumber = 0;

	public int nextNumber() {
		return _turnNumber++;
	}

	public void reset() {
		this._turnNumber = 0;
	}
}
