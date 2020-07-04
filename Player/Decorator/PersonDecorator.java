package Player.Decorator;

import Player.Player;
import Player.Person;

public abstract class PersonDecorator extends Player
{
    protected Person player;
    protected abstract void ChangeCharacters();
}
