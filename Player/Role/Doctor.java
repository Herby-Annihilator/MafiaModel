package Player.Role;

import Player.Events.EventArgs;
import Player.Events.RolePublishedEventArgs;
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

    @Override
    public void RolePublished(Object sender, EventArgs e)
    {
        if (((RolePublishedEventArgs)e).getRoleName().equals("Civilian"))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, 70);
        }
        else if (((RolePublishedEventArgs)e).getRoleName().equals("Commissioner"))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, 85);
        }
        else if (((RolePublishedEventArgs)e).getRoleName().equals("Doctor"))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, -100);
        }
        owner.ScanPlayersAndPutThemInColorList();
    }
}
