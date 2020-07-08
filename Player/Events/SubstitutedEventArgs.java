package Player.Events;

import Player.PlayerWithAccusations;

import java.util.ArrayList;

public class SubstitutedEventArgs implements EventArgs
{
    private ArrayList<PlayerWithAccusations> playerWithAccusationsList; // серьезность обвинений
    public SubstitutedEventArgs(ArrayList<PlayerWithAccusations> list)
    {
        playerWithAccusationsList = list;
    }

    public ArrayList<PlayerWithAccusations> getPlayerWithAccusationsList()
    {
        return playerWithAccusationsList;
    }
}
