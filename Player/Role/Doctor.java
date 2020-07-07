package Player.Role;

import Player.Player;

public class Doctor extends Civilian
{
    public Doctor(Player owner)
    {
        super(owner);
        roleName = "Doctor";
    }
    private int countOfHimselfTreats = 1;

    public void Treat(Player player)
    {

    }

    public void TreatYourself()
    {
        if (countOfHimselfTreats > 0)
        {
            //Treat();
        }
        countOfHimselfTreats--;
    }

    @Override
    public void Execute()
    {
        super.Execute();
    }
}
