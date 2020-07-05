package Player.Role;

import Player.Player;

public class Civilian extends Role
{
    public Civilian()
    {
        roleName = "Civilian";
    }
    @Override
    public void Execute(Player player)
    {

    }

    @Override
    public Role clone() throws CloneNotSupportedException
    {
        Civilian civilian = new Civilian();
        return civilian;
    }

}
