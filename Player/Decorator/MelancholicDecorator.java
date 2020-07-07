package Player.Decorator;

import Player.Player;

public class MelancholicDecorator extends PersonDecorator
{
    public MelancholicDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetLeadership((int)(player.GetCharacters().GetLeadership() * 0.85));
        player.GetCharacters().SetOptimism((int)(player.GetCharacters().GetOptimism() * 0.8));
        player.GetCharacters().SetHumor((int)(player.GetCharacters().GetHumor() * 0.8));
        player.GetCharacters().SetOratory((int)(player.GetCharacters().GetOratory() * 0.85));
        player.GetCharacters().SetStressResistance((int)(player.GetCharacters().GetStressResistance() * 0.75));
        player.GetCharacters().SetSuspicion((int)(player.GetCharacters().GetSuspicion() * 1.3));
        player.GetCharacters().SetIntuition((int)(player.GetCharacters().GetIntuition() * 1.2));
        player.GetCharacters().SetWillPower((int)(player.GetCharacters().GetWillPower() * 0.7));
        player.GetCharacters().SetActingAbilities((int)(player.GetCharacters().GetActingAbilities() * 0.9));
    }

    @Override
    public void ExecuteRole()
    {

    }
}
