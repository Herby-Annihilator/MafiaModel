package Player.Role;

import Master.Master;
import Player.Events.EventArgs;
import Player.Events.RolePublishedEventArgs;
import Player.Player;

import java.util.LinkedList;

public class Commissioner extends Civilian
{
    public Commissioner(Player owner)
    {
        super(owner);
        roleName = "Commissioner";
        mafias = new LinkedList<Player>();
        checkedPlayers = new LinkedList<Player>();
    }
    public boolean IsMafia(Player player)
    {
        if (player.GetRole().GetRoleName().equals("Mafia") || player.GetRole().GetRoleName().equals("MafiaDon"))
        {
            mafias.add(player);
            return true;
        }
        return false;
    }
    private LinkedList<Player> mafias;
    private LinkedList<Player> checkedPlayers;

    public void ExecuteSpecialFunctions(Master master)
    {
        Player playerToVerify = ChooseNotCheckedPlayer();
        if (playerToVerify != null)
        {
            if (master.IsThisPlayerRoleYouNeed(owner, playerToVerify))
            {
                for (int i = 0; i < owner.playersInGame.size(); i++)
                {
                    if (playerToVerify == owner.playersInGame.get(i).getPlayer())
                    {
                        owner.playersInGame.get(i).setConfidenceLevel(0);
                        mafias.add(playerToVerify);
                        break;
                    }
                }
            }
            else
            {
                checkedPlayers.add(playerToVerify);
            }
            NullifyMafia();
        }
    }

    private void NullifyMafia()
    {
        for (int i = 0; i < mafias.size(); i++)
        {
            owner.playersInGame.get(owner.playersInGame.indexOf(mafias.get(i))).setConfidenceLevel(0);
        }
        owner.ScanPlayersAndPutThemInColorList();
    }

    private Player ChooseNotCheckedPlayer()
    {
        for (int i = 0; i < owner.playersInGame.size(); i++)
        {
            if (!mafias.contains(owner.playersInGame.get(i).getPlayer()) &&
                    !checkedPlayers.contains(owner.playersInGame.get(i).getPlayer()))
            {
                return owner.playersInGame.get(i).getPlayer();
            }
        }
        return null;
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
            ChangeConfidenceLevelOfPlayer((Player)sender, -100);
        }
        else if (((RolePublishedEventArgs)e).getRoleName().equals("Doctor"))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, 75);
        }
        NullifyMafia();
    }

    @Override
    public void ExcusesMade(Object sender, EventArgs e)
    {
        super.ExcusesMade(sender, e);
        NullifyMafia();
    }

    @Override
    public void Substituted(Object sender, EventArgs e)
    {
        super.Substituted(sender, e);
        NullifyMafia();
    }

    @Override
    public void CandidateWasPutOnDeletion(Object sender, EventArgs e)
    {
        super.CandidateWasPutOnDeletion(sender, e);
        NullifyMafia();
    }
}
