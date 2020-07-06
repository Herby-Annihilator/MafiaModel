package Player.Decorator;

import Player.Person;
import Player.Player;

public class ParasiteDecorator extends PersonDecorator
{
    public ParasiteDecorator(Person person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetOratory((int)(characters.GetOratory() * 1.15));
        characters.SetActingAbilities((int)(characters.GetActingAbilities() * 1.15));
    }

    @Override
    public void ExecuteRole()
    {

    }

    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new ParasiteDecorator((Person) player.clone());
    }
}
