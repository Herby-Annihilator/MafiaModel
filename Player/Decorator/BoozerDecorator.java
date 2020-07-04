package Player.Decorator;

import Player.Events.EventArgs;
import Player.Person;
import Player.Player;

import java.util.List;

public class BoozerDecorator extends PersonDecorator
{
    public BoozerDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetLeadership((int)(characters.GetLeadership() * 1.1));
        characters.SetOratory((int)(characters.GetOratory() * 1.1));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() * 1.1));
    }

    @Override
    public void ExecuteRole()
    {

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
        return new BoozerDecorator((Person) player.clone());
    }

    @Override
    public void Handle(Object sender, EventArgs e)
    {

    }
}
