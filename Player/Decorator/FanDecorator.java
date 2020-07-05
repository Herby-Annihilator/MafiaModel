package Player.Decorator;

import Player.Person;
import Player.Player;

import java.util.List;

public class FanDecorator extends PersonDecorator
{
    public FanDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetStressResistance((int)(characters.GetStressResistance() * 0.9));
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
        return new FanDecorator((Person) player.clone());
    }
}
