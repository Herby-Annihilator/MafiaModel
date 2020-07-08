package Player.Decorator;

import Master.Master;
import Player.Player;

public class SanguineDecorator extends PersonDecorator
{
    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetLeadership(player.GetCharacters().GetLeadership() / 10 + player.GetCharacters().GetLeadership());
        player.GetCharacters().SetWillPower(player.GetCharacters().GetWillPower() - player.GetCharacters().GetWillPower() / 10);
        player.GetCharacters().SetOptimism(player.GetCharacters().GetOptimism() / 10 + player.GetCharacters().GetOptimism());
        player.GetCharacters().SetHumor(player.GetCharacters().GetHumor() + player.GetCharacters().GetHumor() / 10);
    }

    @Override
    public void Discuss(Master master)
    {
        player.Discuss(master);
    }


    public SanguineDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }
}
