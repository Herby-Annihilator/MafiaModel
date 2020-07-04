package Player;

public class Characters
{
    public Characters()
    {
        age = 35;
        sex = "man";
        name = "Player";
        oratory = 10;
        stressResistance = 10;
        suspicion = 10;
        leadership = 10;
        actingAbilities = 10;
        intuition = 10;
        willPower = 10;
        optimism = 10;
        humor = 10;
    }
    public Characters(String name, String sex, int age)
    {
        this();
        SetAge(age);
        SetSex(sex);
        SetName(name);
    }
    public Characters(String name, String sex, int age, int oratory, int stressResistance, int suspicion,
                      int leadership, int actingAbilities, int intuition, int willPower, int optimism, int humor)
    {
        this(name, sex, age);
        SetOratory(oratory);
        SetStressResistance(stressResistance);
        SetSuspicion(suspicion);
        SetLeadership(leadership);
        SetActingAbilities(actingAbilities);
        SetIntuition(intuition);
        SetWillPower(willPower);
        SetOptimism(optimism);
        SetHumor(humor);
    }
    private String sex;
    public String GetSex()
    {
        return sex;
    }
    public void SetSex(String value)
    {
        this.sex = value;
    }

    private int age;
    public int GetAge()
    {
        return age;
    }
    public void SetAge(int value)
    {
        if (value < 5)
        {
            age = 5;
        }
        else if (value > 150)
        {
            age = 150;
        }
        else
        {
            age = value;
        }
    }

    private String name;
    public String GetName()
    {
        return name;
    }
    public void SetName(String value)
    {
        name = value;
    }

    private int oratory;
    public int GetOratory()
    {
        return oratory;
    }
    public void SetOratory(int value)
    {
        if (value < 0)
        {
            oratory = 0;
        }
        else if (value > 100)
        {
            oratory = 100;
        }
        else
        {
            oratory = value;
        }
    }

    private int stressResistance;
    public int GetStressResistance()
    {
        return stressResistance;
    }
    public void SetStressResistance(int value)
    {
        if (value < 0)
        {
            stressResistance = 0;
        }
        else if (value > 100)
        {
            stressResistance = 100;
        }
        else
        {
            stressResistance = value;
        }
    }
    // Подозрительность
    private int suspicion;
    public int GetSuspicion()
    {
        return suspicion;
    }
    public void SetSuspicion(int value)
    {
        if (value < 0)
        {
            suspicion = 0;
        }
        else if (value > 100)
        {
            suspicion = 100;
        }
        else
        {
            suspicion = value;
        }
    }

    private int leadership;
    public int GetLeadership()
    {
        return leadership;
    }
    public void SetLeadership(int value)
    {
        if (value < 0)
        {
            leadership = 0;
        }
        else if (value > 100)
        {
            leadership = 100;
        }
        else
        {
            leadership = value;
        }
    }

    private int actingAbilities;
    public int GetActingAbilities()
    {
        return actingAbilities;
    }
    public void SetActingAbilities(int value)
    {
        if (value < 0)
        {
            actingAbilities = 0;
        }
        else if (value > 100)
        {
            actingAbilities = 100;
        }
        else
        {
            actingAbilities = value;
        }
    }

    private int intuition;
    public int GetIntuition()
    {
        return intuition;
    }
    public void SetIntuition(int value)
    {
        if (value < 0)
        {
            intuition = 0;
        }
        else if (value > 100)
        {
            intuition = 100;
        }
        else
        {
            intuition = value;
        }
    }

    private int willPower;
    public int GetWillPower()
    {
        return willPower;
    }
    public void SetWillPower(int value)
    {
        if (value < 0)
        {
            willPower = 0;
        }
        else if (value > 100)
        {
            willPower = 100;
        }
        else
        {
            willPower = value;
        }
    }

    private int optimism;
    public int GetOptimism()
    {
        return optimism;
    }
    public void SetOptimism(int value)
    {
        if (value < 0)
        {
            optimism = 0;
        }
        else if (value > 100)
        {
            optimism = 100;
        }
        else
        {
            optimism = value;
        }
    }

    private int humor;
    public int GetHumor()
    {
        return humor;
    }
    public void SetHumor(int value)
    {
        if (value < 0)
        {
            humor = 0;
        }
        else if (value > 100)
        {
            humor = 100;
        }
        else
        {
            humor = value;
        }
    }

    @Override
    protected Characters clone() throws CloneNotSupportedException
    {
        Characters characters = new Characters(new String(name), new String(sex), age, oratory, stressResistance,
                suspicion, leadership, actingAbilities, intuition, willPower, optimism, humor);
        return characters;
    }
}
