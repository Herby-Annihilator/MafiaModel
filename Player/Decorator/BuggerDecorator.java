package Player.Decorator;

import Player.Events.EventArgs;
import Player.Person;
import Player.Player;

import java.util.List;

public class BuggerDecorator extends PersonDecorator
{
    public BuggerDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetOratory((int)(characters.GetOratory() * 0.65));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() * 0.65));
        characters.SetStressResistance((int)(characters.GetStressResistance() * 0.65));
        characters.SetSuspicion((int)(characters.GetSuspicion() * 0.65));
        characters.SetLeadership((int)(characters.GetLeadership() * 0.65));
        characters.SetIntuition((int)(characters.GetIntuition() * 0.65));
        characters.SetWillPower((int)(characters.GetWillPower() * 0.65));
        characters.SetOptimism((int)(characters.GetOptimism() * 0.65));
        characters.SetHumor((int)(characters.GetHumor() * 0.65));
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
        return new BuggerDecorator((Person) player.clone());
    }

    @Override
    public void Handle(Object sender, EventArgs e)
    {

    }
}
