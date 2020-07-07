package Player.Role;

import Player.Player;

public class Commissioner extends Civilian
{
    public Commissioner(Player owner)
    {
        super(owner);
        roleName = "Commissioner";
    }
    public boolean IsMafia(Player player)
    {
        return player.GetRole().GetRoleName().equals("Mafia") || player.GetRole().GetRoleName().equals("MafiaDon");
    }

    @Override
    public void Execute()
    {
        super.Execute();
    }
}
