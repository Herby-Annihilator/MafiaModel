package Player.Events;

import java.util.ArrayList;

public class ExcusesMadeEvent extends Event
{
    public ExcusesMadeEvent()
    {
        playerListeners = new ArrayList<IPlayerEventListener>();
    }
    @Override
    public void NotifySubscribers(Object sender, EventArgs e)
    {
        for (int i = 0; i < playerListeners.size(); i++)
        {
            playerListeners.get(i).ExcusesMade(sender, e);
        }
    }

    @Override
    public Event clone() throws CloneNotSupportedException
    {
        ExcusesMadeEvent event = new ExcusesMadeEvent();
        event.playerListeners = (ArrayList<IPlayerEventListener>) this.playerListeners.clone();
        return event;
    }
}
