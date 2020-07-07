package Player.Events;

import java.util.ArrayList;

public class RolePublishedEvent extends Event
{
    public RolePublishedEvent()
    {
        playerListeners = new ArrayList<IPlayerEventListener>();
    }
    @Override
    public void NotifySubscribers(Object sender, EventArgs e)
    {
        for (int i = 0; i < playerListeners.size(); i++)
        {
            playerListeners.get(i).RolePublished(sender, e);
        }
    }

    @Override
    public Event clone() throws CloneNotSupportedException
    {
        RolePublishedEvent event = new RolePublishedEvent();
        event.playerListeners = (ArrayList<IPlayerEventListener>) this.playerListeners.clone();
        return event;
    }
}
