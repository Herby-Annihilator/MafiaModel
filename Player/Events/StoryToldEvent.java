package Player.Events;

import java.util.LinkedList;

public class StoryToldEvent extends Event
{

    public StoryToldEvent()
    {
        this.playerListeners = new LinkedList<IPlayerEventListener>();
    }

    @Override
    public void NotifySubscribers(Object sender, EventArgs e)
    {
         for (int i = 0; i < playerListeners.size(); i++)
         {
             playerListeners.get(i).StoryTold(sender, e);
         }
    }

    @Override
    public Event clone() throws CloneNotSupportedException
    {
        StoryToldEvent event = new StoryToldEvent();
        event.playerListeners = (LinkedList<IPlayerEventListener>) this.playerListeners.clone();
        return event;
    }
}
