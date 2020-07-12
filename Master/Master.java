package Master;

import Player.*;
import Player.Role.*;
import UI.MyControl.PlayerBox;
import javafx.scene.control.TextArea;

import java.util.LinkedList;

public class Master
{
    private static Master master;
    private PlayerBox[] playerBoxes;
    private LinkedList<Player> allPlayersInGame;
    private LinkedList<Player> playersRemainingInTheGame;   // оставшиеся в игре игроки
    private LinkedList<Player> mafias;
    private LinkedList<Player> civilians;
    private LinkedList<Player> playersWitchMafiaIsGoingToKill;
    private LinkedList<Player> playersWerePutOnDeletion;
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
        allPlayersInGame = new LinkedList<Player>();
        playersRemainingInTheGame = new LinkedList<Player>();
        mafias = new LinkedList<Player>();
        civilians = new LinkedList<Player>();
        playersWitchMafiaIsGoingToKill = new LinkedList<Player>();
        playersWerePutOnDeletion = new LinkedList<Player>();
    }
    public static Master InitMaster()
    {
        if (master == null)
        {
            master = new Master();
        }
        return master;
    }

    public void Reset()
    {
        allPlayersInGame.clear();
        playersRemainingInTheGame.clear();
        mafias.clear();
        civilians.clear();
        playersWitchMafiaIsGoingToKill.clear();
        playersWerePutOnDeletion.clear();
        playerBoxes = null;
        mafiaDon = null;
        doctor = null;
        maniac = null;
        commissioner = null;
        whore = null;
    }

    public void UnsubscribePlayer(Player player)
    {
        for (int i = 0; i < allPlayersInGame.size(); i++)
        {
            if (!allPlayersInGame.get(i).equals(player))
            {
                allPlayersInGame.get(i).storyToldEvent.RemoveListener(player.GetRole());
                allPlayersInGame.get(i).candidateWasPutOnDeletionEvent.RemoveListener(player.GetRole());
                allPlayersInGame.get(i).substitutedEvent.RemoveListener(player.GetRole());
                allPlayersInGame.get(i).excusesMadeEvent.RemoveListener(player.GetRole());
                allPlayersInGame.get(i).rolePublishedEvent.RemoveListener(player.GetRole());
            }
        }
    }

    public void SetAllPlayersParameters()
    {
        if (playerBoxes != null)
        {
            for (int i = 0; i < playerBoxes.length; i++)
            {
                if (playerBoxes[i].getPlayer() != null)
                {
                    allPlayersInGame.add(playerBoxes[i].getPlayer());
                    playersRemainingInTheGame.add(playerBoxes[i].getPlayer());
                    SubscribeThisPlayerOnOtherPlayersEvents(playerBoxes[i].getPlayer());
                    InformPlayerAboutOtherPlayers(playerBoxes[i].getPlayer());
                    if (playerBoxes[i].getPlayer().GetRole().GetRoleName().equals("Civilian"))
                    {
                        civilians.add(playerBoxes[i].getPlayer());
                    }
                    else if (playerBoxes[i].getPlayer().GetRole().GetRoleName().equals("Mafia"))
                    {
                        mafias.add(playerBoxes[i].getPlayer());
                    }
                    else if (playerBoxes[i].getPlayer().GetRole().GetRoleName().equals("MafiaDon"))
                    {
                        mafiaDon = playerBoxes[i].getPlayer();
                    }
                    else if (playerBoxes[i].getPlayer().GetRole().GetRoleName().equals("Commissioner"))
                    {
                        commissioner = playerBoxes[i].getPlayer();
                    }
                    else if (playerBoxes[i].getPlayer().GetRole().GetRoleName().equals("Doctor"))
                    {
                        doctor = playerBoxes[i].getPlayer();
                    }
                    else if (playerBoxes[i].getPlayer().GetRole().GetRoleName().equals("Maniac"))
                    {
                        maniac = playerBoxes[i].getPlayer();
                    }
                    else if (playerBoxes[i].getPlayer().GetRole().GetRoleName().equals("Whore"))
                    {
                        whore = playerBoxes[i].getPlayer();
                    }
                }
            }
            IntroduceMafias();
        }
    }

    private void IntroduceMafias()
    {
        for (int i = 0; i < mafias.size(); i++)
        {
            for (int j = 0; j < mafias.size(); j++)
            {
                if (!mafias.get(i).equals(mafias.get(j)))
                {
                    ((Mafia)mafias.get(i).GetRole()).AddMafiaToMafiasList(mafias.get(j));
                }
            }
            if (mafiaDon != null)
            {
                ((Mafia)mafias.get(i).GetRole()).AddMafiaToMafiasList(mafiaDon);
                ((MafiaDon)mafiaDon.GetRole()).AddMafiaToMafiasList(mafias.get(i));
            }
        }
    }

    private void SubscribeThisPlayerOnOtherPlayersEvents(Player player)
    {
        for (int i = 0; i < playerBoxes.length; i++)
        {
            if (playerBoxes[i].getPlayer() != null)
            {
                if (!playerBoxes[i].getPlayer().equals(player))
                {
                    playerBoxes[i].getPlayer().substitutedEvent.AddListener(player.GetRole());
                    playerBoxes[i].getPlayer().candidateWasPutOnDeletionEvent.AddListener(player.GetRole());
                    playerBoxes[i].getPlayer().excusesMadeEvent.AddListener(player.GetRole());
                    playerBoxes[i].getPlayer().rolePublishedEvent.AddListener(player.GetRole());
                    playerBoxes[i].getPlayer().storyToldEvent.AddListener(player.GetRole());
                }
            }
        }
    }

    private void InformPlayerAboutOtherPlayers(Player playerToInform)
    {
        for (int i = 0; i < playerBoxes.length; i++)
        {
            if (playerBoxes[i].getPlayer() != null)
            {
                if (!playerBoxes[i].getPlayer().equals(playerToInform))
                {
                    playerToInform.playersInGame.add(new PlayerWithConfidenceLevel(playerBoxes[i].getPlayer(), 0));
                }
            }
        }
    }

    public void setAllPlayersInGame(LinkedList<Player> playersInGame)
    {
        allPlayersInGame = playersInGame;
    }
    public void setMafias(LinkedList<Player> mafias)
    {
        this.mafias = mafias;
    }
    public void setCivilians(LinkedList<Player> civilians)
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

    public LinkedList<Player> getAllPlayersInGame()
    {
        return allPlayersInGame;
    }

    public LinkedList<Player> getMafias()
    {
        return mafias;
    }

    public LinkedList<Player> getCivilians()
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
    public PlayerBox[] getPlayerBoxes()
    {
        return playerBoxes;
    }

    public void setPlayerBoxes(PlayerBox[] playerBoxes)
    {
        this.playerBoxes = playerBoxes;
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

    public void TakePlayerWasPutOnDeletion(Player player)
    {
        if (player != null)
        {
            playersWerePutOnDeletion.addLast(player);
        }
    }

    public boolean DoesMeReallyNeedToPutPlayerOnDeletion()
    {
        return playersWerePutOnDeletion.isEmpty();
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
        if (mafiaDon != null)
        {
            ((MafiaDon)mafiaDon.GetRole()).TakeAShot(this);
        }
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
                    countOfMafiasWitchWantToKillPlayerWithSpecificIndex[i]++;
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
            if (!playersWitchMafiaIsGoingToKill.isEmpty())
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

    public void StartDiscussing()
    {
        for (int i = 0; i < playersRemainingInTheGame.size(); i++)
        {
            playersRemainingInTheGame.get(i).Discuss(this);
        }
        playersRemainingInTheGame.addLast(playersRemainingInTheGame.getFirst());
        playersRemainingInTheGame.removeFirst();
    }

    public void ForcePlayerTellAStory(Scenario scenario, int playerIndexInPlayerBoxes, TextArea textArea)
    {
        playerBoxes[playerIndexInPlayerBoxes].getPlayer().TellAStory(scenario, textArea);
    }

    public void ResetAllPlayersSettings()
    {
        if (allPlayersInGame != null)
        {
            for (int i = 0; i < allPlayersInGame.size(); i++)
            {
                allPlayersInGame.get(i).playersInGame = new LinkedList<PlayerWithConfidenceLevel>();
                allPlayersInGame.get(i).blackList = new LinkedList<Player>();
                allPlayersInGame.get(i).redList = new LinkedList<Player>();
                allPlayersInGame.get(i).grayList = new LinkedList<Player>();
                UnsubscribePlayer(allPlayersInGame.get(i));
            }
            allPlayersInGame = new LinkedList<Player>();
        }
    }
}
