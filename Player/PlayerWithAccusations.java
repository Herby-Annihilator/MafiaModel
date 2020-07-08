package Player;

public class PlayerWithAccusations
{
    public PlayerWithAccusations(Player player, int accusation)
    {
        this.player = player;
        accusationLevel = accusation;
    }
    private Player player;
    private int accusationLevel;

    public Player getPlayer()
    {
        return player;
    }

    public int getAccusationLevel()
    {
        return accusationLevel;
    }

    public void setAccusationLevel(int value)
    {
        if (value < 0)
        {
            accusationLevel = 0;
        }
        else if (value > 100)
        {
            accusationLevel = 100;
        }
        else
        {
            accusationLevel = value;
        }
    }
}
