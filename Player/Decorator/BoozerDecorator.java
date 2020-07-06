package Player.Decorator;

import Player.Person;
import Player.Player;

public class BoozerDecorator extends PersonDecorator
{
    public BoozerDecorator(Player person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetLeadership((int)(characters.GetLeadership() * 1.1));
        characters.SetOratory((int)(characters.GetOratory() * 1.1));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() * 1.1));
    }

    @Override
    public void ExecuteRole()
    {
        player.ExecuteRole();
    }


    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new BoozerDecorator((Person) player.clone());
    }

}
