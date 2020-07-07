package Player.Decorator;

import Player.Player;

public class PhlegmaticDecorator extends PersonDecorator
{
    public PhlegmaticDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetOptimism((int)(player.GetCharacters().GetOptimism() * 0.85));
        player.GetCharacters().SetHumor((int)(player.GetCharacters().GetHumor() * 0.85));
        player.GetCharacters().SetLeadership((int)(player.GetCharacters().GetLeadership() * 0.85));
        player.GetCharacters().SetOratory((int)(player.GetCharacters().GetOratory() * 0.85));
        player.GetCharacters().SetWillPower((int)(player.GetCharacters().GetWillPower() * 0.8));
        player.GetCharacters().SetIntuition((int)(player.GetCharacters().GetIntuition() * 1.15));
        player.GetCharacters().SetSuspicion((int)(player.GetCharacters().GetSuspicion() * 1.2));
        player.GetCharacters().SetStressResistance((int)(player.GetCharacters().GetStressResistance() * 1.2));
    }

    @Override
    public void ExecuteRole()
    {

    }
}
