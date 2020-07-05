package Player.Role;

import Player.Events.EventListenersAdapter;
import Player.Player;

public abstract class Role extends EventListenersAdapter
{
    protected String roleName;

    public String GetRoleName()
    {
        return roleName;
    }
    public abstract void Execute(Player player);

    public abstract Role clone() throws CloneNotSupportedException;
}
