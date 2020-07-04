package Player.Role;

import Player.Player;

public class Maniac extends Role
{
    private int countOfShots;
    public Maniac()
    {
        countOfShots = 3;
        roleName = "Maniac";
    }

    public void TakeAShot()
    {

    }

    @Override
    public void Execute(Player player)
    {

    }

    @Override
    public Role clone() throws CloneNotSupportedException
    {
        return new Maniac();
    }
}
