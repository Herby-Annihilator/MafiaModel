package Player.Events;

import java.util.ArrayList;

public class StoryToldEvent extends Event
{

    public StoryToldEvent()
    {
        this.playerListeners = new ArrayList<IPlayerEventListener>();
    }

    @Override
    public void NotifySubscribers(Object sender, DefaultEventArgs e)
    {
         for (int i = 0; i < playerListeners.size(); i++)
         {
             playerListeners.get(i).StoryTold(sender, e);
         }
    }
}
