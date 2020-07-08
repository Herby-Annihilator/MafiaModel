package Master;

import Player.Player;

import java.util.ArrayList;

public class Master
{
    private static Master master;
    private ArrayList<Player> allPlayersInGame;
    private ArrayList<Player> mafias;
    private ArrayList<Player> civilians;
    private ArrayList<Player> playersWitchMafiaIsGoingToKill;
    private Player mafiaDon;
    private Player doctor;
    private Player whore;
    private Player maniac;
    private Player commissioner;

    private Master()
    {
        allPlayersInGame = new ArrayList<Player>();
        mafias = new ArrayList<Player>();
        civilians = new ArrayList<Player>();
        playersWitchMafiaIsGoingToKill = new ArrayList<Player>();
    }
    public static Master InitMaster()
    {
        if (master == null)
        {
            master = new Master();
        }
        return master;
    }
    public void setAllPlayersInGame(ArrayList<Player> playersInGame)
    {
        allPlayersInGame = playersInGame;
    }
    public void setMafias(ArrayList<Player> mafias)
    {
        this.mafias = mafias;
    }
    public void setCivilians(ArrayList<Player> civilians)
    {
        this.civilians = civilians;
    }
    public void setMafiaDon(Player mafiaDon)
    {
        this.mafiaDon = mafiaDon;
    }
    public void setDoctor(Player doctor)
    {
        this.doctor = doctor;
    }
    public void setCommissioner(Player commissioner)
    {
        this.commissioner = commissioner;
    }
    public void setWhore(Player whore)
    {
        this.whore = whore;
    }
    public void setManiac(Player maniac)
    {
        this.maniac = maniac;
    }

    public ArrayList<Player> getAllPlayersInGame()
    {
        return allPlayersInGame;
    }

    public ArrayList<Player> getMafias()
    {
        return mafias;
    }

    public ArrayList<Player> getCivilians()
    {
        return civilians;
    }

    public Player getMafiaDon()
    {
        return mafiaDon;
    }

    public Player getDoctor()
    {
        return doctor;
    }

    public Player getWhore()
    {
        return whore;
    }

    public Player getManiac()
    {
        return maniac;
    }

    public Player getCommissioner()
    {
        return commissioner;
    }

    public boolean IsThisPlayerRoleYouNeed(Player sender, Player verifiedPlayer)
    {
        if (sender.GetRole().GetRoleName().equals("Commissioner"))
        {
            if (verifiedPlayer.GetRole().GetRoleName().equals("Mafia") ||
                    verifiedPlayer.GetRole().GetRoleName().equals("MafiaDon"))
            {
                return true;
            }
        }
        else if (sender.GetRole().GetRoleName().equals("MafiaDon"))
        {
            if (verifiedPlayer.GetRole().GetRoleName().equals("Commissioner"))
            {
                return true;
            }
        }
        return false;
    }

    public void TakeThePlayerToBeKilled(Player player)
    {
        if (player != null)
        {
            playersWitchMafiaIsGoingToKill.add(player);
        }
    }
}
