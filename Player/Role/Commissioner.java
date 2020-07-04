package Player.Role;

import Player.Player;

public class Commissioner extends Civilian
{
    public Commissioner()
    {
        roleName = "Commissioner";
    }
    public boolean IsMafia(Player player)
    {
        return player.GetRole().GetRoleName().equals("Mafia") || player.GetRole().GetRoleName().equals("MafiaDon");
    }

    @Override
    public void Execute(Player player)
    {
        super.Execute(player);
    }

    @Override
    public Role clone() throws CloneNotSupportedException
    {
        return new Commissioner();
    }
}
