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
}
