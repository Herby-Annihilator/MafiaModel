package Player;

import Player.Events.*;
import Player.Role.Role;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Player
{
    //
    // Events
    //
    public CandidateWasPutOnDeletionEvent candidateWasPutOnDeletionEvent;
    public ExcusesMadeEvent excusesMadeEvent;
    public RolePublishedEvent rolePublishedEvent;
    public StoryToldEvent storyToldEvent;
    public SubstitutedEvent substitutedEvent;
    //
    // Lists of players
    //
    protected ArrayList<PlayerWithConfidenceLevel> playersInGame;
    protected ArrayList<Player> blackList;
    protected ArrayList<Player> redList;
    protected ArrayList<Player> grayList;

    protected void ScanPlayersAndPutThemInColorList()
    {
        for (int i = 0; i < playersInGame.size(); i++)
        {
            if (playersInGame.get(i).getConfidenceLevel() <= 30)
            {
                PutPlayerToColorList(playersInGame.get(i).getPlayer(), blackList);
                DeletePlayerFromOtherList(playersInGame.get(i).getPlayer(), redList);
                DeletePlayerFromOtherList(playersInGame.get(i).getPlayer(), grayList);
            }
            else if (playersInGame.get(i).getConfidenceLevel() > 30 && playersInGame.get(i).getConfidenceLevel() <= 80)
            {
                PutPlayerToColorList(playersInGame.get(i).getPlayer(), grayList);
                DeletePlayerFromOtherList(playersInGame.get(i).getPlayer(), redList);
                DeletePlayerFromOtherList(playersInGame.get(i).getPlayer(), blackList);
            }
            else
            {
                PutPlayerToColorList(playersInGame.get(i).getPlayer(), redList);
                DeletePlayerFromOtherList(playersInGame.get(i).getPlayer(), blackList);
                DeletePlayerFromOtherList(playersInGame.get(i).getPlayer(), grayList);
            }
        }
    }
    protected void PutPlayerToColorList(Player player, ArrayList<Player> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (player == list.get(i))
            {
                return;
            }
        }
        list.add(player);
    }
    protected void DeletePlayerFromOtherList(Player playerToDelete, ArrayList<Player> colorList)
    {
        for (int i = 0; i < colorList.size(); i++)
        {
            if (colorList.get(i) == playerToDelete)
            {
                colorList.remove(i);
                break;
            }
        }
    }

    protected Role role;
    public Role GetRole()
    {
        return role;
    }

    protected Characters characters;

    public abstract void ExecuteRole();

    protected String GetCurrentPath()
    {
        File currentDir = new File("");
        String path = currentDir.getAbsolutePath();
        return path;
    }
    protected String GetRandomStringFromFile(String fileName)
    {
        try
        {
            Random random = new Random();
            String currentDirectory = GetCurrentPath();
            Path path = Path.of(currentDirectory + "\\" + fileName);
            List<String> strings = Files.readAllLines(path);
            strings = RemoveEmptyEntries(strings);
            int stringNumber = random.nextInt(strings.size());
            return strings.get(stringNumber);
        }
        catch (IOException e)
        {
            return "File " + fileName + " not found or beaten";
        }

    }
    private List<String> RemoveEmptyEntries(List<String> strings)
    {
        List<String> toReturn = strings;
        for (int i = 0; i < toReturn.size(); i++)
        {
            if (toReturn.get(i).isEmpty() || toReturn.get(i).isBlank())
            {
                toReturn.remove(i);
                i--;
            }
        }
        return toReturn;
    }
    public void TellAStory(Scenario scenario, TextField textField)
    {
        switch (scenario)
        {
            case asylum:
            {
                textField.setText(GetRandomStringFromFile("asylum.txt"));
                storyToldEvent.NotifySubscribers();
                break;
            }
            case camp:
            {
                textField.setText(GetRandomStringFromFile("camp.txt"));
                break;
            }
            case factory:
            {
                textField.setText(GetRandomStringFromFile("factory.txt"));
                break;
            }
            case hospital:
            {
                textField.setText(GetRandomStringFromFile("hospital.txt"));
                break;
            }
            case university:
            {
                textField.setText(GetRandomStringFromFile("university.txt"));
                break;
            }
        }
    }

    // отмазаться
    public abstract void MakeExcuses();

    // очернить других
    public abstract void Substitute(List<Player> players);

    public String PublishRole()
    {
        return role.GetRoleName();
    }

    public Player PutCandidateForDeletion(Player player)
    {
        Player toReturn = null;
        if (!blackList.isEmpty())
        {
            toReturn = FindPlayerWithLessConfidenceLevel(blackList);
        }
        else if (!grayList.isEmpty())
        {
            toReturn = FindPlayerWithLessConfidenceLevel(grayList);
        }
        return toReturn;
    }

    protected Player FindPlayerWithLessConfidenceLevel(ArrayList<Player> list)
    {
        Player toReturn = null;
        int indexOfReturnedPlayer = 0;
        for (int i = 1; i < playersInGame.size(); i++)
        {
            if (playersInGame.get(i).getConfidenceLevel() < playersInGame.get(indexOfReturnedPlayer).getConfidenceLevel())
            {
                indexOfReturnedPlayer = i;
            }
        }
        if (list.contains(playersInGame.get(indexOfReturnedPlayer).getPlayer()))
        {
            toReturn = playersInGame.get(indexOfReturnedPlayer).getPlayer();
        }
        return toReturn;
    }


    @Override
    public abstract Player clone() throws CloneNotSupportedException;

}
