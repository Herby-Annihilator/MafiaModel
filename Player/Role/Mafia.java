package Player.Role;

import Master.Master;
import Player.Events.CandidateWasPutOnDeletionEventArgs;
import Player.Events.EventArgs;
import Player.Player;

import java.util.LinkedList;
import java.util.Random;

public class Mafia extends Role
{
    protected final int priorityInResolvingTheIssue = 1;
    protected Player nextPlayerToKill;
    protected LinkedList<Player> mafias;

    public Mafia(Player owner)
    {
        super(owner);
        roleName = "Mafia";
        mafias = new LinkedList<Player>();
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
            if (owner.playersInGame.get(i).getPlayer().equals(player))
            {
                if (mafias.contains(player))
                {
                    owner.playersInGame.get(i).setConfidenceLevel(90);
                }
                else
                {
                    owner.playersInGame.get(i).setConfidenceLevel(new Random().nextInt(70));
                }
                break;
            }
        }
    }

    @Override
    public void RolePublished(Object sender, EventArgs e)
    {
        ChangeConfidenceLevelOfPlayer((Player)sender, -70);
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
        ChangeConfidenceLevelOfPlayer((Player)sender, -70);
    }


    @Override
    public void Execute()
    {

    }

    public void TakeAShot(Master master)
    {
        if (owner.playersInGame.size() > 5)
        {
            Random random = new Random();
            int index;
            boolean playerChosen;
            do
            {
                playerChosen = true;
                index = random.nextInt(owner.playersInGame.size());
                for (int i = 0; i < mafias.size(); i++)
                {
                    if (owner.playersInGame.get(index).getPlayer().equals(mafias.get(i)))
                    {
                        playerChosen = false;
                    }
                }
            } while (!playerChosen);
            nextPlayerToKill = owner.playersInGame.get(index).getPlayer();
        }
        else
        {
            nextPlayerToKill = owner.playersInGame.get(0).getPlayer();
        }
        master.TakeThePlayerToBeKilled(nextPlayerToKill);
        nextPlayerToKill = null;
    }

    public void AddMafiaToMafiasList(Player player)
    {
        mafias.add(player);
    }

    public void RemovePlayerFromSpecialLists(Player player)
    {
        if (mafias.contains(player))
        {
            mafias.remove(player);
        }
    }
}
