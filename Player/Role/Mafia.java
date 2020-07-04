package Player.Role;

import Player.Player;

public class Mafia extends Role
{
    protected final int priorityInResolvingTheIssue = 1;

    public Mafia()
    {
        roleName = "Mafia";
    }

    @Override
    public void Execute(Player player)
    {

    }

    public void TakeAShot()
    {

    }

    @Override
    public Role clone() throws CloneNotSupportedException
    {
        return new Mafia();
    }
}
