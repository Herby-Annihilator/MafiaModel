package Player.Decorator;

import Master.Master;
import Player.Player;

public class CompleteSecondaryEducationDecorator extends PersonDecorator
{
    public CompleteSecondaryEducationDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetOratory((int)(player.GetCharacters().GetOratory() * 1.15));
        player.GetCharacters().SetActingAbilities((int)(player.GetCharacters().GetActingAbilities() * 1.15));
        player.GetCharacters().SetStressResistance((int)(player.GetCharacters().GetStressResistance() * 1.15));
        player.GetCharacters().SetSuspicion((int)(player.GetCharacters().GetSuspicion() * 1.15));
        player.GetCharacters().SetLeadership((int)(player.GetCharacters().GetLeadership() * 1.15));
        player.GetCharacters().SetIntuition((int)(player.GetCharacters().GetIntuition() * 1.15));
        player.GetCharacters().SetOptimism((int)(player.GetCharacters().GetOptimism() * 1.15));
        player.GetCharacters().SetHumor((int)(player.GetCharacters().GetHumor() * 1.15));
    }

    @Override
    public void Discuss(Master master)
    {
        player.Discuss(master);
    }

}
