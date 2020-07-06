package Player.Events;

import java.util.ArrayList;

public class ExcusesMadeEvent extends Event
{
    public ExcusesMadeEvent()
    {
        playerListeners = new ArrayList<IPlayerEventListener>();
    }
    @Override
    public void NotifySubscribers(Object sender, DefaultEventArgs e)
    {
        for (int i = 0; i < playerListeners.size(); i++)
        {
            playerListeners.get(i).ExcusesMade(sender, e);
        }
    }
}
