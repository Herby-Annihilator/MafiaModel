package Player.Decorator;

import Player.Person;
import Player.Player;

public class MelancholicDecorator extends PersonDecorator
{
    public MelancholicDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetLeadership((int)(characters.GetLeadership() * 0.85));
        characters.SetOptimism((int)(characters.GetOptimism() * 0.8));
        characters.SetHumor((int)(characters.GetHumor() * 0.8));
        characters.SetOratory((int)(characters.GetOratory() * 0.85));
        characters.SetStressResistance((int)(characters.GetStressResistance() * 0.75));
        characters.SetSuspicion((int)(characters.GetSuspicion() * 1.3));
        characters.SetIntuition((int)(characters.GetIntuition() * 1.2));
        characters.SetWillPower((int)(characters.GetWillPower() * 0.7));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() * 0.9));
    }

    @Override
    public void ExecuteRole()
    {

    }

    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new MelancholicDecorator((Person) player.clone());
    }
}
