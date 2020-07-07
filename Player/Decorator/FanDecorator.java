package Player.Decorator;

import Player.Player;

public class FanDecorator extends PersonDecorator
{
    public FanDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetStressResistance((int)(player.GetCharacters().GetStressResistance() * 0.9));
    }

    @Override
    public void ExecuteRole()
    {

    }

}
