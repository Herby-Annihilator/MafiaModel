package Player.Decorator;

import Player.Player;

public class TwoClassesAndCorridorDecorator extends PersonDecorator
{
    public TwoClassesAndCorridorDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetOratory((int)(player.GetCharacters().GetOratory() * 1.07));
        player.GetCharacters().SetActingAbilities((int)(player.GetCharacters().GetActingAbilities() * 1.07));
        player.GetCharacters().SetStressResistance((int)(player.GetCharacters().GetStressResistance() * 1.07));
        player.GetCharacters().SetSuspicion((int)(player.GetCharacters().GetSuspicion() * 1.07));
        player.GetCharacters().SetLeadership((int)(player.GetCharacters().GetLeadership() * 1.07));
        player.GetCharacters().SetIntuition((int)(player.GetCharacters().GetIntuition() * 1.07));
        player.GetCharacters().SetWillPower((int)(player.GetCharacters().GetWillPower() * 1.07));
        player.GetCharacters().SetOptimism((int)(player.GetCharacters().GetOptimism() * 1.07));
        player.GetCharacters().SetHumor((int)(player.GetCharacters().GetHumor() * 1.07));
    }

    @Override
    public void ExecuteRole()
    {

    }
}
