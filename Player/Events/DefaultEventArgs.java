package Player.Events;

public class DefaultEventArgs implements EventArgs
{
    //
    // полученный совокупный размер изменения уровня доверия
    //
    protected int receivedCumulativeSizeOfChangeInConfidenceLevel;

    public void setReceivedCumulativeSizeOfChangeInConfidenceLevel(int value)
    {
        if (value < 0)
        {
            receivedCumulativeSizeOfChangeInConfidenceLevel = 0;
        }
        else if (value > 0)
        {
            receivedCumulativeSizeOfChangeInConfidenceLevel = 100;
        }
        else
        {
            receivedCumulativeSizeOfChangeInConfidenceLevel = value;
        }
    }
    public int getReceivedCumulativeSizeOfChangeInConfidenceLevel()
    {
        return receivedCumulativeSizeOfChangeInConfidenceLevel;
    }

    public DefaultEventArgs(int receivedCumulativeSizeOfChangeInConfidenceLevel)
    {
        setReceivedCumulativeSizeOfChangeInConfidenceLevel(receivedCumulativeSizeOfChangeInConfidenceLevel);
    }
}
