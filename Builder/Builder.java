package Builder;

import Player.Decorator.*;
import Player.Person;
import Player.Player;

import java.util.Random;

public class Builder
{
    private Player lastBuiltPlayer;

    public Player BuiltLastBuiltPlayer()
    {
        return lastBuiltPlayer = ClonePlayer(lastBuiltPlayer);
    }

    public Player BuiltRandomPlayer()
    {
        Random random = new Random();
        int countOfTemperaments = random.nextInt(Temperament.values().length);
        int countOfFetishes = random.nextInt(Fetish.values().length);
        int educationRank = random.nextInt(Education.values().length);
        Player player;
    }

    public Player SetPlayerTemperament(Player player, Temperament temperament)
    {
        switch (temperament)
        {
            case Choleric:
            {
                player = new CholericDecorator(player);
                break;
            }
            case Sanguine:
            {
                player = new SanguineDecorator(player);
                break;
            }
            case Melanholic:
            {
                player = new MelancholicDecorator(player);
                break;
            }
            case Phlegmatic:
            {
                player = new PhlegmaticDecorator(player);
                break;
            }
        }
        lastBuiltPlayer = ClonePlayer(player);
        return player;
    }
    public Player SetPlayerFetish(Player player, Fetish fetish)
    {
        switch (fetish)
        {
            case Fan:
            {
                player = new FanDecorator(player);
                break;
            }
            case Freak:
            {
                player = new FreakDecorator(player);
                break;
            }
            case Boozer:
            {
                player = new BoozerDecorator(player);
                break;
            }
            case Bugger:
            {
                player = new BuggerDecorator(player);
                break;
            }
            case Feminist:
            {
                player = new FeministDecorator(player);
                break;
            }
            case ReligiousMan:
            {
                player = new ReligiousManDecorator(player);
            }
        }
        lastBuiltPlayer = ClonePlayer(player);
        return player;
    }

    public Player SetPlayerEducation(Player player, Education education)
    {
        switch (education)
        {
            case Higher:
            {
                player = new HigherEducationDecorator(player);
                break;
            }
            case CompleteSecondary:
            {
                player = new CompleteSecondaryEducationDecorator(player);
                break;
            }
            case IncompleteSecondary:
            {
                player = new IncompleteSecondaryEducationDecorator(player);
                break;
            }
            case TwoClassesAndCorridor:
            {
                player = new TwoClassesAndCorridorDecorator(player);
                break;
            }
        }
        lastBuiltPlayer = ClonePlayer(player);
        return player;
    }

    public Player BuiltCustomPlayer()
    {
        Player player = new HigherEducationDecorator(new SanguineDecorator(new CholericDecorator
                (new Person())));
        lastBuiltPlayer = ClonePlayer(player);
        return player;
    }
    private Player ClonePlayer(Player player)
    {
        try
        {
            return player.clone();
        }
        catch (CloneNotSupportedException e)
        {
            return null;
        }
    }
}
