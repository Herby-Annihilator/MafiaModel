package Player;

import Player.Events.EventArgs;
import Player.Role.Civilian;
import Player.Role.Role;

import java.util.List;

public class Person extends Player
{

    public Person()
    {
        role = new Civilian();
        characters = new Characters();
    }
    public Person(Role role, Characters characters)
    {
        this.role = role;
        this.characters = characters;
    }
    @Override
    public void ExecuteRole()
    {
        role.Execute(this);
    }

    @Override
    public void MakeExcuses()
    {

    }

    @Override
    public void Substitute(List<Player> players)
    {

    }

    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new Person(this.role.clone(), this.characters.clone());
    }

    @Override
    public void TellAStory(Scenario scenario)
    {

    }

    @Override
    public void Handle(Object sender, EventArgs e)
    {

    }
}
