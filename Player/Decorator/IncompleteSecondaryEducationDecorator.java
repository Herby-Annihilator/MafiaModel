package Player.Decorator;

import Player.Player;

public class IncompleteSecondaryEducationDecorator extends PersonDecorator
{
    public IncompleteSecondaryEducationDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetOratory((int)(player.GetCharacters().GetOratory() * 1.13));
        player.GetCharacters().SetActingAbilities((int)(player.GetCharacters().GetActingAbilities() * 1.13));
        player.GetCharacters().SetStressResistance((int)(player.GetCharacters().GetStressResistance() * 1.13));
        player.GetCharacters().SetSuspicion((int)(player.GetCharacters().GetSuspicion() * 1.13));
        player.GetCharacters().SetLeadership((int)(player.GetCharacters().GetLeadership() * 1.13));
        player.GetCharacters().SetIntuition((int)(player.GetCharacters().GetIntuition() * 1.13));
        player.GetCharacters().SetWillPower((int)(player.GetCharacters().GetWillPower() * 1.13));
        player.GetCharacters().SetOptimism((int)(player.GetCharacters().GetOptimism() * 1.13));
        player.GetCharacters().SetHumor((int)(player.GetCharacters().GetHumor() * 1.13));
    }

    @Override
    public void ExecuteRole()
    {

    }
}
