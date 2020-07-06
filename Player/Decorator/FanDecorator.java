package Player.Decorator;

import Player.Person;
import Player.Player;

public class FanDecorator extends PersonDecorator
{
    public FanDecorator(Player person)
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
    public Player clone() throws CloneNotSupportedException
    {
        return new FanDecorator((Person) player.clone());
    }
}
