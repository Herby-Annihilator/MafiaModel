package Player.Role;

import Player.Player;

public class MafiaDon extends Mafia
{
    public MafiaDon(Player owner)
    {
        super(owner);
        roleName = "MafiaDon";
    }

    @Override
    public void Execute()
    {
        super.Execute();
    }

    public boolean IsCommissioner(Player player)
    {
        return player.GetRole().GetRoleName().equals("Commissioner");
    }

}
