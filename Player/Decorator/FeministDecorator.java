package Player.Decorator;

import Player.Player;

public class FeministDecorator extends PersonDecorator
{
    public FeministDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetOratory((int)(player.GetCharacters().GetOratory() * 0.73));
        player.GetCharacters().SetActingAbilities((int)(player.GetCharacters().GetActingAbilities() * 0.73));
        player.GetCharacters().SetStressResistance((int)(player.GetCharacters().GetStressResistance() * 0.73));
        player.GetCharacters().SetSuspicion((int)(player.GetCharacters().GetSuspicion() * 0.73));
        player.GetCharacters().SetLeadership((int)(player.GetCharacters().GetLeadership() * 0.73));
        player.GetCharacters().SetIntuition((int)(player.GetCharacters().GetIntuition() * 0.73));
        player.GetCharacters().SetWillPower((int)(player.GetCharacters().GetWillPower() * 0.73));
        player.GetCharacters().SetOptimism((int)(player.GetCharacters().GetOptimism() * 0.73));
        player.GetCharacters().SetHumor((int)(player.GetCharacters().GetHumor() * 0.73));
    }

    @Override
    public void ExecuteRole()
    {

    }

}
