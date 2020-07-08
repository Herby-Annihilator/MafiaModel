package Player.Decorator;

import Master.Master;
import Player.Player;

public class FanDecorator extends PersonDecorator
{
    public FanDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetStressResistance((int)(player.GetCharacters().GetStressResistance() * 0.9));
    }

    @Override
    public void Discuss(Master master)
    {
        player.Discuss(master);
    }

}
