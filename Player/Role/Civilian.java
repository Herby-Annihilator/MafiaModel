package Player.Role;

import Player.Events.DefaultEventArgs;
import Player.Events.EventArgs;
import Player.Player;

public class Civilian extends Role
{
    public Civilian(Player owner)
    {
        super(owner);
        roleName = "Civilian";
    }
    @Override
    public void Execute()
    {

    }


    @Override
    public void StoryTold(Object sender, EventArgs e)
    {
        ChangeConfidenceLevelOfPlayer((Player) sender,
                ((DefaultEventArgs) e).getReceivedCumulativeSizeOfChangeInConfidenceLevel());
        owner.ScanPlayersAndPutThemInColorList();
    }

    @Override
    protected void ChangeConfidenceLevelOfPlayer(Player player, int persuasiveness) // persuasiveness - убедительность
    {
        for (int i = 0; i < owner.playersInGame.size(); i++)
        {
            if (owner.playersInGame.get(i).getPlayer() == player)
            {
                owner.playersInGame.get(i).setConfidenceLevel(persuasiveness -
                        (int)(owner.GetCharacters().GetSuspicion() * 1.3));
                break;
            }
        }
    }

    @Override
    public void RolePublished(Object sender, EventArgs e)
    {
        super.RolePublished(sender, e);
    }

    @Override
    public void Substituted(Object sender, EventArgs e)
    {
        super.Substituted(sender, e);
    }

    @Override
    public void CandidateWasPutOnDeletion(Object sender, EventArgs e)
    {
        super.CandidateWasPutOnDeletion(sender, e);
    }

    @Override
    public void ExcusesMade(Object sender, EventArgs e)
    {
        super.ExcusesMade(sender, e);
    }
}
