package Player.Decorator;

import Player.Person;
import Player.Player;

import java.util.List;

public class SanguineDecorator extends PersonDecorator
{
    @Override
    protected void ChangeCharacters()
    {
        characters.SetLeadership(characters.GetLeadership() / 10 + characters.GetLeadership());
        characters.SetWillPower(characters.GetWillPower() - characters.GetWillPower() / 10);
        characters.SetOptimism(characters.GetOptimism() / 10 + characters.GetOptimism());
        characters.SetHumor(characters.GetHumor() + characters.GetHumor() / 10);
    }

    @Override
    public void ExecuteRole()
    {
        role.Execute(this);
    }

    @Override
    public void MakeExcuses()
    {

    }

    @Override
    public void Substitute(List<Player> players)
    {

    }

    public SanguineDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new SanguineDecorator((Person) player.clone());
    }

}
