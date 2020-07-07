package Player.Decorator;

import Player.Player;

public class ReligiousManDecorator extends PersonDecorator
{
    public ReligiousManDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetSuspicion((int)(player.GetCharacters().GetSuspicion() * 1.1));
    }

    @Override
    public void ExecuteRole()
    {

    }
}
