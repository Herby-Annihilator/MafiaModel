package Player.Decorator;

import Player.Person;
import Player.Player;

public class ReligiousManDecorator extends PersonDecorator
{
    public ReligiousManDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetSuspicion((int)(characters.GetSuspicion() * 1.1));
    }

    @Override
    public void ExecuteRole()
    {

    }

    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new ReligiousManDecorator((Person) player.clone());
    }

}
