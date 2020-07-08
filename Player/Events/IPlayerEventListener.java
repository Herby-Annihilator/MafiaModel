package Player.Events;

public interface IPlayerEventListener
{
    void StoryTold(Object sender, EventArgs e);
    void RolePublished(Object sender, EventArgs e);
    void Substituted(Object sender, EventArgs e);
    void CandidateWasPutOnDeletion(Object sender, EventArgs e);
    void ExcusesMade(Object sender, EventArgs e);
}
