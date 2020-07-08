package Player.Events;

import java.util.LinkedList;

public class CandidateWasPutOnDeletionEvent extends Event
{
    public CandidateWasPutOnDeletionEvent()
    {
        playerListeners = new LinkedList<IPlayerEventListener>();
    }
    @Override
    public void NotifySubscribers(Object sender, EventArgs e)
    {
        for (int i = 0; i < playerListeners.size(); i++)
        {
            playerListeners.get(i).CandidateWasPutOnDeletion(sender, e);
        }
    }

    @Override
    public Event clone() throws CloneNotSupportedException
    {
        CandidateWasPutOnDeletionEvent event = new CandidateWasPutOnDeletionEvent();
        event.playerListeners = (LinkedList<IPlayerEventListener>) this.playerListeners.clone();
        return event;
    }
}
