package Player;

import Player.Events.IPlayerEventListener;
import Player.Role.Role;

import java.io.File;
import java.util.List;
import java.util.Random;

public abstract class Player implements IPlayerEventListener
{
    protected Role role;
    public Role GetRole()
    {
        return role;
    }

    protected Characters characters;

    public abstract void ExecuteRole();

    public String getCurrentPath()
    {
        File currentDir = new File("");
        String path = currentDir.getAbsolutePath();
        return path;
    }
    public void TellAStory(Scenario scenario)
    {
        Random random = new Random();
        File currentDir = new File(".");
        String path = currentDir.getAbsolutePath();
        switch (scenario)
        {
            case asylum:
            {

                break;
            }
            case camp:
            {
                break;
            }
            case factory:
            {
                break;
            }
            case hospital:
            {
                break;
            }
            case university:
            {
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

    public void PutCandidateForDeletion(Player player)
    {

    }
    //
    // Реализация подписки и отписки на события
    //


    @Override
    public abstract Player clone() throws CloneNotSupportedException;

}
