package Player.Role;

import Player.Events.DefaultEventArgs;
import Player.Events.EventArgs;
import Player.Player;

public class Whore extends Role
{
    private int countOfItselfAlibi;
    public Whore(Player owner)
    {
        super(owner);
        countOfItselfAlibi = 1;
        roleName = "Whore";
    }
    public void GiveAnAlibi()
    {

    }
    public void GiveAnAlibiToYourself()
    {
        if (countOfItselfAlibi > 0)
        {
            GiveAnAlibi();
        }
        countOfItselfAlibi--;
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

    @Override
    protected void ChangeConfidenceLevelOfPlayer(Player player, int persuasiveness)
    {
        for (int i = 0; i < owner.playersInGame.size(); i++)
        {
            if (owner.playersInGame.get(i).getPlayer() == player)
            {
                owner.playersInGame.get(i).setConfidenceLevel(persuasiveness -
                        owner.GetCharacters().GetSuspicion());
                break;
            }
        }
    }
}
