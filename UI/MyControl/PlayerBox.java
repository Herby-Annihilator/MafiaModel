package UI.MyControl;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class PlayerBox
{
    private Label playerName;
    private Label playerRole;
    private AnchorPane playerBoxForImage;
    private Image playerFace;

    public PlayerBox(Label playerName, Label playerRole, AnchorPane playerBoxForImage)
    {
        this.playerName = playerName;
        this.playerRole = playerRole;
        this.playerBoxForImage = playerBoxForImage;
        playerFace = null;
    }

    public Label getPlayerName()
    {
        return playerName;
    }

    public void setPlayerName(Label playerName)
    {
        this.playerName = playerName;
    }

    public Label getPlayerRole()
    {
        return playerRole;
    }

    public void setPlayerRole(Label playerRole)
    {
        this.playerRole = playerRole;
    }

    public AnchorPane getPlayerBoxForImage()
    {
        return playerBoxForImage;
    }

    public void setPlayerBoxForImage(AnchorPane playerBoxForImage)
    {
        this.playerBoxForImage = playerBoxForImage;
    }

    public Image getPlayerFace()
    {
        return playerFace;
    }

    public void setPlayerFace(Image playerFace)
    {
        this.playerFace = playerFace;
    }
}
