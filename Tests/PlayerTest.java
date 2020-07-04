package Tests;

import Player.Events.EventArgs;
import Player.Player;
import org.junit.Assert;

import java.util.List;

class PlayerTest
{

    @org.junit.jupiter.api.Test
    void getCurrentPath()
    {
        String expected = "C:\\Users\\User\\IdeaProjects\\MafiaModel";

        Player player = new Player()
        {
            @Override
            public void ExecuteRole()
            {

            }

            @Override
            public void MakeExcuses()
            {

            }

            @Override
            public void Substitute(List<Player> players)
            {

            }

            @Override
            public Player clone() throws CloneNotSupportedException
            {
                return null;
            }

            @Override
            public void Handle(Object sender, EventArgs e)
            {

            }
        };

        String actual = player.GetCurrentPath();

        Assert.assertEquals(expected, actual);
    }
}