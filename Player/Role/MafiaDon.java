package Player.Role;

import Player.Player;

public class MafiaDon extends Mafia
{
    public MafiaDon()
    {
        roleName = "MafiaDon";
    }

    @Override
    public void Execute(Player player)
    {
        super.Execute(player);
    }

    public boolean IsCommissioner(Player player)
    {
        return player.GetRole().GetRoleName().equals("Commissioner");
    }

    @Override
    public Role clone() throws CloneNotSupportedException
    {
        return new MafiaDon();
    }
}
