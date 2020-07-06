package Player.Events;

public class RolePublishedEventArgs implements EventArgs
{
    private String roleName;
    public RolePublishedEventArgs(String roleName)
    {
        this.roleName = roleName;
    }
}