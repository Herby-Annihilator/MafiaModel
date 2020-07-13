package Player.Role;

import Master.Master;
import Player.Events.DefaultEventArgs;
import Player.Events.EventArgs;
import Player.Events.RolePublishedEventArgs;
import Player.Player;

import java.util.Random;

public class Whore extends Role
{
    private int countOfItselfAlibi;
    private Player playerWasGivenAnAlibiLastMove;
    public Whore(Player owner)
    {
        super(owner);
        countOfItselfAlibi = 1;
        roleName = "Whore";
        playerWasGivenAnAlibiLastMove = null;
    }
    public void GiveAnAlibi(Master master)
    {
        Player playerWillHasAnAlibi = null;
        Random random = new Random();
        if (owner.GetCharacters().GetOptimism() < 10 && countOfItselfAlibi > 0)
        {
            playerWillHasAnAlibi = owner;
            countOfItselfAlibi--;
        }
        else
        {
            boolean playerWasChosen = false;
            while (!playerWasChosen)
            {
                playerWillHasAnAlibi = owner.playersInGame.get(random.nextInt(owner.playersInGame.size())).getPlayer();
                if (playerWasGivenAnAlibiLastMove != null)
                {
                    if (!playerWillHasAnAlibi.equals(playerWasGivenAnAlibiLastMove))
                    {
                        playerWasChosen = true;
                    }
                }
                else
                {
                    playerWasChosen = true;
                }
            }
        }
        master.TakeThePlayerWitchWillHasAnAlibi(playerWillHasAnAlibi);
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
