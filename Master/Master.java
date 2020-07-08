package Master;

import Player.Player;
import Player.Role.*;


import java.util.ArrayList;

public class Master
{
    private static Master master;
    private ArrayList<Player> allPlayersInGame;
    private ArrayList<Player> playersRemainingInTheGame;   // оставшиеся в игре игроки
    private ArrayList<Player> mafias;
    private ArrayList<Player> civilians;
    private ArrayList<Player> playersWitchMafiaIsGoingToKill;
    private Player mafiaDon;
    private Player doctor;
    private Player whore;
    private Player maniac;
    private Player commissioner;

    private Player playerYouWillHeal;
    private Player playerWillHasAnAlibi;
    private Player mafiaWantKillHim;
    private Player maniacWantKillHim;

    private Master()
    {
        allPlayersInGame = new ArrayList<Player>();
        playersRemainingInTheGame = new ArrayList<Player>();
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

    public void TakeThePlayerDoctorWillHeal(Player player)
    {
        if (player != null)
        {
            playerYouWillHeal = player;
        }
    }

    public void TakeThePlayerWitchWillHasAnAlibi(Player player)
    {
        if (player != null)
        {
            playerWillHasAnAlibi = player;
        }
    }

    //
    // Будим игроков по ролям
    //
    public void WakeUpMafia()
    {
        for (int i = 0; i < mafias.size(); i++)
        {
            ((Mafia)mafias.get(i).GetRole()).TakeAShot(this);
        }
        ((MafiaDon)mafiaDon.GetRole()).TakeAShot(this);
        mafiaWantKillHim = FindOutPlayerToKill();
        playersWitchMafiaIsGoingToKill.clear();
    }
    private Player FindOutPlayerToKill()
    {
        int[] countOfMafiasWitchWantToKillPlayerWithSpecificIndex = new int[playersWitchMafiaIsGoingToKill.size()];
        for (int i = 0; i < countOfMafiasWitchWantToKillPlayerWithSpecificIndex.length; i++)
        {
            countOfMafiasWitchWantToKillPlayerWithSpecificIndex[i] = 0;
        }
        for (int i = 0; i < playersWitchMafiaIsGoingToKill.size(); i++)
        {
            Player currentPlayer = playersWitchMafiaIsGoingToKill.get(i);
            for (int j = 0; j < playersWitchMafiaIsGoingToKill.size(); j++)
            {
                if (currentPlayer.equals(playersWitchMafiaIsGoingToKill.get(j)))
                {
                    countOfMafiasWitchWantToKillPlayerWithSpecificIndex[j]++;
                }
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < countOfMafiasWitchWantToKillPlayerWithSpecificIndex.length; i++)
        {
            if (countOfMafiasWitchWantToKillPlayerWithSpecificIndex[maxIndex] <
                    countOfMafiasWitchWantToKillPlayerWithSpecificIndex[i])
            {
                maxIndex = i;
            }
        }
        for (int i = 0; i < countOfMafiasWitchWantToKillPlayerWithSpecificIndex.length; i++)
        {
            if (i != maxIndex)
            {
                if (countOfMafiasWitchWantToKillPlayerWithSpecificIndex[i] ==
                        countOfMafiasWitchWantToKillPlayerWithSpecificIndex[maxIndex])
                {
                    playersWitchMafiaIsGoingToKill.clear();
                    ((MafiaDon)mafiaDon.GetRole()).TakeAShot(this);
                    return playersWitchMafiaIsGoingToKill.get(0);
                }
            }
        }
        return playersWitchMafiaIsGoingToKill.get(maxIndex);
    }

    public void WakeUpMafiaDon()
    {
        if (mafiaDon != null)
        {
            ((MafiaDon)(mafiaDon.GetRole())).ExecuteSpecialFunctions(this);
        }
    }

    public void WakeUpDoctor()
    {
        if (doctor != null)
        {
            ((Doctor)(doctor.GetRole())).Treat(this);
        }
    }

    public void WakeUpManiac()
    {
        if (maniac != null)
        {
            ((Maniac)(maniac.GetRole())).TakeAShot(this);
            maniacWantKillHim = playersWitchMafiaIsGoingToKill.get(0);
            playersWitchMafiaIsGoingToKill.clear();
        }
    }

    public void WakeUpWhore()
    {
        if (whore != null)
        {
            ((Whore)(whore.GetRole())).GiveAnAlibi(this);
        }
    }

    public void WakeUpCommissioner()
    {
        if (commissioner != null)
        {
            ((Commissioner)(commissioner.GetRole())).ExecuteSpecialFunctions(this);
        }
    }

}
