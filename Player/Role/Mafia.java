package Player.Role;

import Master.Master;
import Player.Events.CandidateWasPutOnDeletionEventArgs;
import Player.Events.EventArgs;
import Player.Player;

import java.util.ArrayList;
import java.util.Random;

public class Mafia extends Role
{
    protected final int priorityInResolvingTheIssue = 1;
    protected static Player nextPlayerToKill;
    protected ArrayList<Player> mafias;

    public Mafia(Player owner)
    {
        super(owner);
        roleName = "Mafia";
        mafias = new ArrayList<Player>();
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
        if (!mafias.contains(((CandidateWasPutOnDeletionEventArgs)e).getPlayerWasPut()))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, -70);
        }
    }

    @Override
    public void Substituted(Object sender, EventArgs e)
    {

    }

    @Override
    public void CandidateWasPutOnDeletion(Object sender, EventArgs e)
    {
        if (((CandidateWasPutOnDeletionEventArgs)e).getPlayerWasPut().equals(owner) ||
        mafias.contains(((CandidateWasPutOnDeletionEventArgs)e).getPlayerWasPut()))
        {
            nextPlayerToKill = (Player)sender;
        }
    }

    @Override
    public void ExcusesMade(Object sender, EventArgs e)
    {
        if (!mafias.contains(((CandidateWasPutOnDeletionEventArgs)e).getPlayerWasPut()))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, -70);
        }
    }


    @Override
    public void Execute()
    {

    }

    public void TakeAShot(Master master)
    {
        master.TakeThePlayerToBeKilled(nextPlayerToKill);
    }
}
