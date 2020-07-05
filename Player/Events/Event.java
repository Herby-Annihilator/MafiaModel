package Player.Events;

import java.util.ArrayList;

public abstract class Event
{
    protected ArrayList<IPlayerEventListener> playerListeners;
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

    public abstract void NotifySubscribers(Object sender, EventArgs e);
}
