package Player.Decorator;

import Player.Person;
import Player.Player;

public class HigherEducationDecorator extends PersonDecorator
{
    public HigherEducationDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetOratory((int)(characters.GetOratory() * 1.3));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() * 1.3));
        characters.SetStressResistance((int)(characters.GetStressResistance() * 1.3));
        characters.SetSuspicion((int)(characters.GetSuspicion() * 1.3));
        characters.SetLeadership((int)(characters.GetLeadership() * 1.3));
        characters.SetIntuition((int)(characters.GetIntuition() * 1.3));
        characters.SetWillPower((int)(characters.GetWillPower() * 1.3));
        characters.SetOptimism((int)(characters.GetOptimism() * 1.3));
        characters.SetHumor((int)(characters.GetHumor() * 1.3));
    }

    @Override
    public void ExecuteRole()
    {

    }


    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new HigherEducationDecorator((Person) player.clone());
    }
}
