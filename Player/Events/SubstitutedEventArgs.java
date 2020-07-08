package Player.Events;

import Player.PlayerWithAccusations;

import java.util.LinkedList;

public class SubstitutedEventArgs implements EventArgs
{
    private LinkedList<PlayerWithAccusations> playerWithAccusationsList; // серьезность обвинений
    public SubstitutedEventArgs(LinkedList<PlayerWithAccusations> list)
    {
        playerWithAccusationsList = list;
    }

    public LinkedList<PlayerWithAccusations> getPlayerWithAccusationsList()
    {
        return playerWithAccusationsList;
    }
}
