package Player.Decorator;

import Player.*;

public abstract class PersonDecorator extends Player
{
    protected Player player;
    protected abstract void ChangeCharacters();
}
