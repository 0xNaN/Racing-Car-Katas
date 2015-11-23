package tddmicroexercises.turnticketdispenser;

public class TurnNumberSequence
{
    private int _turnNumber = 0;

    public int getNextTurnNumber()
    {
        return _turnNumber++;
    }
}
