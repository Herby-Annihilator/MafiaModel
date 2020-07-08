package Player;

import Master.Master;
import Player.Events.*;
import Player.Role.Civilian;
import Player.Role.Role;

import java.util.Random;

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
    }
    public Person(Role role, Characters characters)
    {
        this.role = role;
        this.characters = characters;
    }
    public Person(Characters characters)
    {
        this.characters = characters;
        role = new Civilian(this);
    }
    @Override
    public void Discuss(Master master)
    {
        Player playerToDelete = null;
        Substitute(blackList);
        Substitute(grayList);
        MakeExcuses();
        if (!blackList.isEmpty())
        {
            playerToDelete = blackList.get(new Random().nextInt(blackList.size()));
            PutCandidateForDeletion(playerToDelete);
        }
        else if (!grayList.isEmpty())
        {
            playerToDelete = grayList.get(new Random().nextInt(grayList.size()));
            PutCandidateForDeletion(playerToDelete);
        }
        else if (!redList.isEmpty())
        {
            if (master.DoesMeReallyNeedToPutPlayerOnDeletion())
            {
                playerToDelete = grayList.get(new Random().nextInt(grayList.size()));
            }
            PutCandidateForDeletion(playerToDelete);
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
        return toReturn;
    }

}
