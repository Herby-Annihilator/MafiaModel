package Player.Decorator;

import Master.Master;
import Player.Player;

public abstract class PersonDecorator extends Player
{
    protected Player player;
    protected abstract void ChangeCharacters();
    public PersonDecorator(Player person)
    {
        player = person;
        characters = person.GetCharacters();
        this.role = person.GetRole();
        this.storyToldEvent = person.storyToldEvent;
        this.candidateWasPutOnDeletionEvent = person.candidateWasPutOnDeletionEvent;
        this.excusesMadeEvent = person.excusesMadeEvent;
        this.rolePublishedEvent = person.rolePublishedEvent;
        this.substitutedEvent = person.substitutedEvent;
    }

    @Override
    public Player clone() throws CloneNotSupportedException
    {
        return player.clone();
    }

    @Override
    public void Discuss(Master master)
    {
        player.Discuss(master);
    }
}
