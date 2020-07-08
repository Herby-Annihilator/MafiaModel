package Player.Role;

import Player.Events.DefaultEventArgs;
import Player.Events.EventArgs;
import Player.Events.RolePublishedEventArgs;
import Player.Player;

public class Whore extends Role
{
    private int countOfItselfAlibi;
    public Whore(Player owner)
    {
        super(owner);
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
    public void Execute()
    {

    }

    @Override
    public void StoryTold(Object sender, EventArgs e)
    {
        ChangeConfidenceLevelOfPlayer((Player) sender,
                ((DefaultEventArgs) e).getReceivedCumulativeSizeOfChangeInConfidenceLevel());
        owner.ScanPlayersAndPutThemInColorList();
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
        else if (((RolePublishedEventArgs)e).getRoleName().equals("Whore"))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, -100);
        }
        owner.ScanPlayersAndPutThemInColorList();
    }


    @Override
    protected void ChangeConfidenceLevelOfPlayer(Player player, int persuasiveness)
    {
        for (int i = 0; i < owner.playersInGame.size(); i++)
        {
            if (owner.playersInGame.get(i).getPlayer() == player)
            {
                owner.playersInGame.get(i).setConfidenceLevel(persuasiveness -
                        owner.GetCharacters().GetSuspicion());
                break;
            }
        }
    }
}
