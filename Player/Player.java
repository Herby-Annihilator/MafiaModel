package Player;

import Player.Events.IPlayerEventListener;
import Player.Role.Role;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
            int stringNumber = random.nextInt(strings.size());
            return strings.get(stringNumber);
        }
        catch (IOException e)
        {
            return "File " + fileName + " not found or beaten";
        }

    }
    public void TellAStory(Scenario scenario, TextField textField)
    {
        switch (scenario)
        {
            case asylum:
            {
                textField.setText(GetRandomStringFromFile("asylum.txt"));
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

    public void PutCandidateForDeletion(Player player)
    {

    }


    @Override
    public abstract Player clone() throws CloneNotSupportedException;

}
