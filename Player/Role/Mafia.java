package Player.Role;

import Player.Events.EventArgs;
import Player.Player;

import java.util.Random;

public class Mafia extends Role
{
    protected final int priorityInResolvingTheIssue = 1;

    public Mafia(Player owner)
    {
        super(owner);
        roleName = "Mafia";
    }

    @Override
    public void StoryTold(Object sender, EventArgs e)
    {
        ChangeConfidenceLevelOfPlayer((Player) sender, 0);
        owner.ScanPlayersAndPutThemInColorList();
    }

    @Override
    protected void ChangeConfidenceLevelOfPlayer(Player player, int persuasiveness)
    {
        for (int i = 0; i < owner.playersInGame.size(); i++)
        {
            if (owner.playersInGame.get(i).getPlayer() == player)
            {
                owner.playersInGame.get(i).setConfidenceLevel(new Random().nextInt(70));
                break;
            }
        }
    }

    @Override
    public void RolePublished(Object sender, EventArgs e)
    {
        super.RolePublished(sender, e);
    }

    @Override
    public void Substituted(Object sender, EventArgs e)
    {
        super.Substituted(sender, e);
    }

    @Override
    public void CandidateWasPutOnDeletion(Object sender, EventArgs e)
    {
        super.CandidateWasPutOnDeletion(sender, e);
    }

    @Override
    public void ExcusesMade(Object sender, EventArgs e)
    {
        super.ExcusesMade(sender, e);
    }


    @Override
    public void Execute()
    {

    }

    public void TakeAShot()
    {

    }
}
