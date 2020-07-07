package Player.Decorator;

import Player.Player;

public class CholericDecorator extends PersonDecorator
{
    public CholericDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetLeadership(player.GetCharacters().GetLeadership() / 10 + player.GetCharacters().GetLeadership());
        player.GetCharacters().SetWillPower((int)(player.GetCharacters().GetWillPower() * 1.1));
        player.GetCharacters().SetOptimism((int)(player.GetCharacters().GetOptimism() * 1.1));
        player.GetCharacters().SetOratory((int)(player.GetCharacters().GetOratory() * 1.1));
        player.GetCharacters().SetActingAbilities((int)(player.GetCharacters().GetActingAbilities() + 0.85));
        player.GetCharacters().SetHumor((int)(player.GetCharacters().GetHumor() * 1.1));
    }

    @Override
    public void ExecuteRole()
    {

    }

}
