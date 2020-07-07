package Player.Decorator;

import Player.Player;

public class ParasiteDecorator extends PersonDecorator
{
    public ParasiteDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetOratory((int)(player.GetCharacters().GetOratory() * 1.15));
        player.GetCharacters().SetActingAbilities((int)(player.GetCharacters().GetActingAbilities() * 1.15));
    }

    @Override
    public void ExecuteRole()
    {

    }
}
