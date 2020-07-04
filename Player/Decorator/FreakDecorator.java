package Player.Decorator;


import Player.Events.EventArgs;
import Player.Person;
import Player.Player;

import java.util.List;

public class FreakDecorator extends PersonDecorator
{
    public FreakDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetStressResistance((int)(characters.GetStressResistance() * 0.7));
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
        return new FreakDecorator((Person) player.clone());
    }

    @Override
    public void Handle(Object sender, EventArgs e)
    {

    }
}
