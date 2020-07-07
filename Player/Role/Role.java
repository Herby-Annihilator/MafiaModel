package Player.Role;

import Player.Events.EventListenersAdapter;
import Player.Player;

public abstract class Role extends EventListenersAdapter
{
    protected Player owner;
    protected String roleName;

    public String GetRoleName()
    {
        return roleName;
    }
    public Role(Player owner)
    {
        this.owner = owner;
    }
    public abstract void Execute();

    protected abstract void ChangeConfidenceLevelOfPlayer(Player player, int persuasiveness);
}
