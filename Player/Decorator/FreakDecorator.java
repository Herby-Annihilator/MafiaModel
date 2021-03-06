package Player.Decorator;


import Master.Master;
import Player.Player;

public class FreakDecorator extends PersonDecorator
{
    public FreakDecorator(Player person)
    {
        super(person);
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        player.GetCharacters().SetStressResistance((int)(player.GetCharacters().GetStressResistance() * 0.7));
    }

    @Override
    public void Discuss(Master master)
    {
        player.Discuss(master);
    }

}
