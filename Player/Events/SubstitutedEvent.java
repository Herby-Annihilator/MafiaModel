package Player.Events;

import java.util.LinkedList;

public class SubstitutedEvent extends Event
{
    public SubstitutedEvent()
    {
        playerListeners = new LinkedList<IPlayerEventListener>();
    }
    @Override
    public void NotifySubscribers(Object sender, EventArgs e)
    {
        for (int i = 0; i < playerListeners.size(); i++)
        {
            playerListeners.get(i).Substituted(sender, e);
        }
    }

    @Override
    public Event clone() throws CloneNotSupportedException
    {
        SubstitutedEvent event = new SubstitutedEvent();
        event.playerListeners = (LinkedList<IPlayerEventListener>) this.playerListeners.clone();
        return event;
    }
}
