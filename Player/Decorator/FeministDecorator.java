package Player.Decorator;

import Player.Person;
import Player.Player;

import java.util.List;

public class FeministDecorator extends PersonDecorator
{
    public FeministDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetOratory((int)(characters.GetOratory() * 0.73));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() * 0.73));
        characters.SetStressResistance((int)(characters.GetStressResistance() * 0.73));
        characters.SetSuspicion((int)(characters.GetSuspicion() * 0.73));
        characters.SetLeadership((int)(characters.GetLeadership() * 0.73));
        characters.SetIntuition((int)(characters.GetIntuition() * 0.73));
        characters.SetWillPower((int)(characters.GetWillPower() * 0.73));
        characters.SetOptimism((int)(characters.GetOptimism() * 0.73));
        characters.SetHumor((int)(characters.GetHumor() * 0.73));
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
        return new FeministDecorator((Person) player.clone());
    }
}
