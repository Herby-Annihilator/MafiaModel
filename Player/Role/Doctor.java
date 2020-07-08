package Player.Role;

import Master.Master;
import Player.Events.EventArgs;
import Player.Events.RolePublishedEventArgs;
import Player.Player;

import java.util.Random;

public class Doctor extends Civilian
{
    public Doctor(Player owner)
    {
        super(owner);
        roleName = "Doctor";
    }
    private int countOfHimselfTreats = 1;

    public void Treat(Master master)
    {
        Player playerWillBeHeal = null;
        if (owner.GetCharacters().GetOptimism() < 10)
        {
            if (countOfHimselfTreats > 0)
            {
                playerWillBeHeal = owner;
            }
            else
            {
                playerWillBeHeal = owner.playersInGame.get(new Random().nextInt(owner.playersInGame.size())).getPlayer();

            }
        }
        else
        {
            playerWillBeHeal = owner.playersInGame.get(new Random().nextInt(owner.playersInGame.size())).getPlayer();
        }
        master.TakeThePlayerDoctorWillHeal(playerWillBeHeal);
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
