package Player.Decorator;


import Player.Person;
import Player.Player;

public class FreakDecorator extends PersonDecorator
{
    public FreakDecorator(Player person)
    {
        player = person;
        ChangeCharacters();
    }

    @Override
    protected void ChangeCharacters()
    {
        characters.SetStressResistance((int)(characters.GetStressResistance() * 0.7));
    }

    @Override
    public void ExecuteRole()
    {

    }

    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return new FreakDecorator((Person) player.clone());
    }
}
