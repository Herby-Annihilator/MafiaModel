package Player.Role;

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
}
