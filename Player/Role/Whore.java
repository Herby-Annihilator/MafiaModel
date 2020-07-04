package Player.Role;

import Player.Player;

public class Whore extends Role
{
    private int countOfItselfAlibi;
    public Whore()
    {
        countOfItselfAlibi = 1;
        roleName = "Whore";
    }
    public void GiveAnAlibi()
    {

    }
    public void GiveAnAlibiToYourself()
    {
        if (countOfItselfAlibi > 0)
        {
            GiveAnAlibi();
        }
        countOfItselfAlibi--;
    }

    @Override
    public void Execute(Player player)
    {

    }

    @Override
    public Role clone() throws CloneNotSupportedException
    {
        return new Whore();
    }
}
