package Player.Decorator;

import Player.Person;
import Player.Player;

public class IncompleteSecondaryEducationDecorator extends PersonDecorator
{
    public IncompleteSecondaryEducationDecorator(Player person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetOratory((int)(characters.GetOratory() * 1.13));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() * 1.13));
        characters.SetStressResistance((int)(characters.GetStressResistance() * 1.13));
        characters.SetSuspicion((int)(characters.GetSuspicion() * 1.13));
        characters.SetLeadership((int)(characters.GetLeadership() * 1.13));
        characters.SetIntuition((int)(characters.GetIntuition() * 1.13));
        characters.SetWillPower((int)(characters.GetWillPower() * 1.13));
        characters.SetOptimism((int)(characters.GetOptimism() * 1.13));
        characters.SetHumor((int)(characters.GetHumor() * 1.13));
    }

    @Override
    public void ExecuteRole()
    {

    }

    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new IncompleteSecondaryEducationDecorator((Person) player.clone());
    }
}
