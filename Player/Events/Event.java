package Player.Events;

import java.util.ArrayList;

public abstract class Event
{
    public Event(Object objectOnEventHappened, EventArgs eventArgs)
    {
        this.objectOnEventHappened = objectOnEventHappened;
        this.eventArgs = eventArgs;
    }
    protected EventArgs eventArgs;
    protected Object objectOnEventHappened;
    protected ArrayList<IPlayerEventListener> playerListeners = new ArrayList<IPlayerEventListener>();
    public void AddListener(IPlayerEventListener listener)
    {
        playerListeners.add(listener);
    }

    public void RemoveListener(IPlayerEventListener listener)
    {
        playerListeners.remove(listener);
    }

    public IPlayerEventListener[] GetListeners()
    {
        return playerListeners.toArray(new IPlayerEventListener[playerListeners.size()]);
    }

    protected void NotifySubscribers()
    {
        for (int i = 0; i < playerListeners.size(); i++)
        {
            playerListeners.get(i).Handle(objectOnEventHappened, eventArgs);
        }
    }
}
