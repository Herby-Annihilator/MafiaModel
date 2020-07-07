package Player.Events;

import java.util.ArrayList;

public class SubstitutedEvent extends Event
{
    public SubstitutedEvent()
    {
        playerListeners = new ArrayList<IPlayerEventListener>();
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
        event.playerListeners = (ArrayList<IPlayerEventListener>) this.playerListeners.clone();
        return event;
    }
}
