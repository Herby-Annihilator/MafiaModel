package Player;

public class PlayerWithConfidenceLevel
{
    PlayerWithConfidenceLevel(Player player, int confidenceLevel)
    {
        this.player = player;
        setConfidenceLevel(confidenceLevel);
    }
    private Player player;
    private int confidenceLevel;

    public int getConfidenceLevel()
    {
        return confidenceLevel;
    }

    public void setConfidenceLevel(int value)
    {
        if (value < 0)
        {
            confidenceLevel = 0;
        }
        else if (value > 100)
        {
            confidenceLevel = 100;
        }
        else
        {
            confidenceLevel = value;
        }
    }
    public Player getPlayer()
    {
        return player;
    }
}
