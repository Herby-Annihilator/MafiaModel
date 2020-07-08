package Player.Role;

import Player.Events.EventArgs;
import Player.Events.RolePublishedEventArgs;
import Player.Player;

public class Maniac extends Role
{
    private int countOfShots;
    public Maniac(Player owner)
    {
        super(owner);
        countOfShots = 3;
        roleName = "Maniac";
    }

    public void TakeAShot()
    {

    }

    @Override
    public void Execute()
    {

    }

    @Override
    protected void ChangeConfidenceLevelOfPlayer(Player player, int persuasiveness)
    {
        for (int i = 0; i < owner.playersInGame.size(); i++)
        {
            if (owner.playersInGame.get(i).getPlayer() == player)
            {
                owner.playersInGame.get(i).setConfidenceLevel(persuasiveness -
                        (int)(owner.GetCharacters().GetSuspicion() * 1.1));
                break;
            }
        }
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
            ChangeConfidenceLevelOfPlayer((Player)sender, 75);
        }
        else if (((RolePublishedEventArgs)e).getRoleName().equals("Maniac"))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, -100);
        }
        owner.ScanPlayersAndPutThemInColorList();

    }
}
