package Player.Decorator;

import Player.Person;
import Player.Player;

public class TwoClassesAndCorridorDecorator extends PersonDecorator
{
    public TwoClassesAndCorridorDecorator(Player person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetOratory((int)(characters.GetOratory() * 1.07));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() * 1.07));
        characters.SetStressResistance((int)(characters.GetStressResistance() * 1.07));
        characters.SetSuspicion((int)(characters.GetSuspicion() * 1.07));
        characters.SetLeadership((int)(characters.GetLeadership() * 1.07));
        characters.SetIntuition((int)(characters.GetIntuition() * 1.07));
        characters.SetWillPower((int)(characters.GetWillPower() * 1.07));
        characters.SetOptimism((int)(characters.GetOptimism() * 1.07));
        characters.SetHumor((int)(characters.GetHumor() * 1.07));
    }

    @Override
    public void ExecuteRole()
    {

    }

    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new TwoClassesAndCorridorDecorator((Person) player.clone());
    }
}
