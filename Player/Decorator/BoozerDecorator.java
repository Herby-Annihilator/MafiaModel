package Player.Decorator;

import Master.Master;
import Player.Player;

public class BoozerDecorator extends PersonDecorator
{
    public BoozerDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetLeadership((int)(player.GetCharacters().GetLeadership() * 1.1));
        player.GetCharacters().SetOratory((int)(player.GetCharacters().GetOratory() * 1.1));
        player.GetCharacters().SetActingAbilities((int)(player.GetCharacters().GetActingAbilities() * 1.1));
    }

    @Override
    public void Discuss(Master master)
    {
        player.Discuss(master);
    }
}
