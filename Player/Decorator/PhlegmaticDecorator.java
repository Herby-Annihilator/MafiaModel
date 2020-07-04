package Player.Decorator;

import Player.Events.EventArgs;
import Player.Person;
import Player.Player;

import java.util.List;

public class PhlegmaticDecorator extends PersonDecorator
{
    public PhlegmaticDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetOptimism((int)(characters.GetOptimism() * 0.85));
        characters.SetHumor((int)(characters.GetHumor() * 0.85));
        characters.SetLeadership((int)(characters.GetLeadership() * 0.85));
        characters.SetOratory((int)(characters.GetOratory() * 0.85));
        characters.SetWillPower((int)(characters.GetWillPower() * 0.8));
        characters.SetIntuition((int)(characters.GetIntuition() * 1.15));
        characters.SetSuspicion((int)(characters.GetSuspicion() * 1.2));
        characters.SetStressResistance((int)(characters.GetStressResistance() * 1.2));
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
        return new PhlegmaticDecorator((Person) player.clone());
    }

    @Override
    public void Handle(Object sender, EventArgs e)
    {

    }
}
