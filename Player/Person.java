package Player;

import Master.Master;
import Player.Events.*;
import Player.Role.Civilian;
import Player.Role.Role;

import java.util.LinkedList;

public class Person extends Player
{
    protected void InitAllEvents()
    {
        storyToldEvent = new StoryToldEvent();
        candidateWasPutOnDeletionEvent = new CandidateWasPutOnDeletionEvent();
        rolePublishedEvent = new RolePublishedEvent();
        excusesMadeEvent = new ExcusesMadeEvent();
        substitutedEvent = new SubstitutedEvent();
    }
    public Person()
    {
        role = new Civilian(this);
        characters = new Characters();
        InitAllEvents();
        InitAllLists();
    }
    public Person(Role role, Characters characters)
    {
        this.role = role;
        this.characters = characters;
        InitAllEvents();
        InitAllLists();
    }
    public Person(Characters characters)
    {
        this.characters = characters;
        role = new Civilian(this);
        InitAllEvents();
        InitAllLists();
    }
    public void InitAllLists()
    {
        playersInGame = new LinkedList<PlayerWithConfidenceLevel>();
        blackList = new LinkedList<Player>();
        redList = new LinkedList<Player>();
        grayList = new LinkedList<Player>();
    }
    @Override
    public void Discuss(Master master)
    {
        Substitute(blackList);
        Substitute(grayList);
        MakeExcuses();
        if (!blackList.isEmpty())
        {
            PutCandidateForDeletion(master);
        }
        else if (!grayList.isEmpty())
        {
            PutCandidateForDeletion(master);
        }
        else if (!redList.isEmpty())
        {
            if (master.DoesMeReallyNeedToPutPlayerOnDeletion())
            {
                PutCandidateForDeletion(master);
            }
        }
    }


    @Override
    public Player clone() throws CloneNotSupportedException
    {
        Person toReturn = new Person(this.characters.clone());
        toReturn.storyToldEvent = (StoryToldEvent) this.storyToldEvent.clone();
        toReturn.candidateWasPutOnDeletionEvent =
                (CandidateWasPutOnDeletionEvent) this.candidateWasPutOnDeletionEvent.clone();
        toReturn.excusesMadeEvent = (ExcusesMadeEvent) this.excusesMadeEvent.clone();
        toReturn.rolePublishedEvent = (RolePublishedEvent) this.rolePublishedEvent.clone();
        toReturn.substitutedEvent = (SubstitutedEvent) this.substitutedEvent.clone();
        toReturn.blackList = (LinkedList<Player>) this.blackList.clone();
        toReturn.redList = (LinkedList<Player>) this.blackList.clone();
        toReturn.grayList = (LinkedList<Player>) this.blackList.clone();
        toReturn.playersInGame = (LinkedList<PlayerWithConfidenceLevel>) this.playersInGame.clone();
        return toReturn;
    }

}
