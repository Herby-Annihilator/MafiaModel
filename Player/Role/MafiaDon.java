package Player.Role;

import Master.Master;
import Player.Player;

import java.util.LinkedList;

public class MafiaDon extends Mafia
{
    public MafiaDon(Player owner)
    {
        super(owner);
        roleName = "MafiaDon";
        checkedPlayers = new LinkedList<Player>();
    }
    private Player commissioner;
    private LinkedList<Player> checkedPlayers;


    public boolean IsCommissioner(Player player)
    {
        return player.GetRole().GetRoleName().equals("Commissioner");
    }

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
                        commissioner = playerToVerify;
                        break;
                    }
                }
            }
            else
            {
                checkedPlayers.add(playerToVerify);
            }
            owner.ScanPlayersAndPutThemInColorList();
        }
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
    public void TakeAShot(Master master)
    {
        if (commissioner != null)
        {
            nextPlayerToKill = commissioner;
        }
        master.TakeThePlayerToBeKilled(nextPlayerToKill);
    }

    public void NullifyCommissioner()
    {
        commissioner = null;
    }
}
