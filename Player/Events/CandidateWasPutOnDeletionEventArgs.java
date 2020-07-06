package Player.Events;

import Player.Player;

public class CandidateWasPutOnDeletionEventArgs implements EventArgs
{
    private Player playerWasPut;
    public CandidateWasPutOnDeletionEventArgs(Player player)
    {
        playerWasPut = player;
    }
}
