package Player.Role;

import Player.Player;
import Player.Events.*;

public abstract class Role implements IPlayerEventListener
{
    protected Player owner;
    protected String roleName;

    public String GetRoleName()
    {
        return roleName;
    }
    public Role(Player owner)
    {
        this.owner = owner;
    }
    public abstract void Execute();

    protected abstract void ChangeConfidenceLevelOfPlayer(Player player, int persuasiveness);

    @Override
    public void StoryTold(Object sender, EventArgs e)
    {
        ChangeConfidenceLevelOfPlayer((Player) sender,
                ((DefaultEventArgs) e).getReceivedCumulativeSizeOfChangeInConfidenceLevel());
        owner.ScanPlayersAndPutThemInColorList();
    }

    @Override
    public void RolePublished(Object sender, EventArgs e)
    {
        if (((RolePublishedEventArgs)e).getRoleName().equals("Civilian"))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, 70);
        }
        else if (((RolePublishedEventArgs)e).getRoleName().equals("Commissioner"))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, 85);
        }
        else if (((RolePublishedEventArgs)e).getRoleName().equals("Doctor"))
        {
            ChangeConfidenceLevelOfPlayer((Player)sender, 75);
        }
        owner.ScanPlayersAndPutThemInColorList();
    }

    @Override
    public void Substituted(Object sender, EventArgs e)
    {
        int doubtsAboutTheCharge = (int)(owner.GetCharacters().GetIntuition() * 0.7) +
                (int)(owner.GetCharacters().GetSuspicion() * 0.85);
        for (int i = 0; i < ((SubstitutedEventArgs)e).getPlayerWithAccusationsList().size(); i++)
        {
            ((SubstitutedEventArgs)e).getPlayerWithAccusationsList().get(i).setAccusationLevel(
                    ((SubstitutedEventArgs)e).getPlayerWithAccusationsList().get(i).getAccusationLevel() - doubtsAboutTheCharge);
            for (int j = 0; j < owner.playersInGame.size(); j++)
            {
                if (((SubstitutedEventArgs)e).getPlayerWithAccusationsList().get(i).getPlayer() ==
                        owner.playersInGame.get(j).getPlayer())
                {
                    owner.playersInGame.get(i).setConfidenceLevel(owner.playersInGame.get(i).getConfidenceLevel() -
                            ((SubstitutedEventArgs)e).getPlayerWithAccusationsList().get(i).getAccusationLevel());
                    break;
                }
            }
        }
        owner.ScanPlayersAndPutThemInColorList();
    }

    @Override
    public void CandidateWasPutOnDeletion(Object sender, EventArgs e)
    {
        if (((CandidateWasPutOnDeletionEventArgs)e).getPlayerWasPut().equals(owner))
        {
            for (int i = 0; i < owner.playersInGame.size(); i++)
            {
                if (owner.playersInGame.get(i).getPlayer().equals((Player)sender))
                {
                    owner.playersInGame.get(i).setConfidenceLevel(owner.playersInGame.get(i).getConfidenceLevel() -
                            (int)(owner.playersInGame.get(i).getConfidenceLevel() * 0.7));
                    break;
                }
            }
        }
        for (int i = 0; i < owner.playersInGame.size(); i++)
        {
            if (owner.playersInGame.get(i).getPlayer().equals(((CandidateWasPutOnDeletionEventArgs)e).getPlayerWasPut()))
            {
                owner.playersInGame.get(i).setConfidenceLevel(owner.playersInGame.get(i).getConfidenceLevel() -
                        (int)(owner.playersInGame.get(i).getConfidenceLevel() * 0.15));
                break;
            }
        }
        owner.ScanPlayersAndPutThemInColorList();
    }

    @Override
    public void ExcusesMade(Object sender, EventArgs e)
    {
        ChangeConfidenceLevelOfPlayer((Player) sender,
                ((DefaultEventArgs) e).getReceivedCumulativeSizeOfChangeInConfidenceLevel());
        owner.ScanPlayersAndPutThemInColorList();
    }
}
