package Player.Decorator;

import Master.Master;
import Player.Player;

public class BuggerDecorator extends PersonDecorator
{
    public BuggerDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetOratory((int)(player.GetCharacters().GetOratory() * 0.65));
        player.GetCharacters().SetActingAbilities((int)(player.GetCharacters().GetActingAbilities() * 0.65));
        player.GetCharacters().SetStressResistance((int)(player.GetCharacters().GetStressResistance() * 0.65));
        player.GetCharacters().SetSuspicion((int)(player.GetCharacters().GetSuspicion() * 0.65));
        player.GetCharacters().SetLeadership((int)(player.GetCharacters().GetLeadership() * 0.65));
        player.GetCharacters().SetIntuition((int)(player.GetCharacters().GetIntuition() * 0.65));
        player.GetCharacters().SetWillPower((int)(player.GetCharacters().GetWillPower() * 0.65));
        player.GetCharacters().SetOptimism((int)(player.GetCharacters().GetOptimism() * 0.65));
        player.GetCharacters().SetHumor((int)(player.GetCharacters().GetHumor() * 0.65));
    }

    @Override
    public void Discuss(Master master)
    {
        player.Discuss(master);
    }
}
