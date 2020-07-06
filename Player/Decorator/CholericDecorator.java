package Player.Decorator;

import Player.Person;
import Player.Player;

public class CholericDecorator extends PersonDecorator
{
    public CholericDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetLeadership(characters.GetLeadership() / 10 + characters.GetLeadership());
        characters.SetWillPower((int)(characters.GetWillPower() * 1.1));
        characters.SetOptimism((int)(characters.GetOptimism() * 1.1));
        characters.SetOratory((int)(characters.GetOratory() * 1.1));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() + 0.85));
        characters.SetHumor((int)(characters.GetHumor() * 1.1));
    }

    @Override
    public void ExecuteRole()
    {

    }

    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new CholericDecorator((Person) player.clone());
    }

}
