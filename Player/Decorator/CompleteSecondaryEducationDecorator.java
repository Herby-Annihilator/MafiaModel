package Player.Decorator;

import Player.Events.EventArgs;
import Player.Person;
import Player.Player;

import java.util.List;

public class CompleteSecondaryEducationDecorator extends PersonDecorator
{
    public CompleteSecondaryEducationDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetOratory((int)(characters.GetOratory() * 1.15));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() * 1.15));
        characters.SetStressResistance((int)(characters.GetStressResistance() * 1.15));
        characters.SetSuspicion((int)(characters.GetSuspicion() * 1.15));
        characters.SetLeadership((int)(characters.GetLeadership() * 1.15));
        characters.SetIntuition((int)(characters.GetIntuition() * 1.15));
        characters.SetWillPower((int)(characters.GetWillPower() * 1.15));
        characters.SetOptimism((int)(characters.GetOptimism() * 1.15));
        characters.SetHumor((int)(characters.GetHumor() * 1.15));
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
        return new CompleteSecondaryEducationDecorator((Person) player.clone());
    }

    @Override
    public void Handle(Object sender, EventArgs e)
    {

    }
}
