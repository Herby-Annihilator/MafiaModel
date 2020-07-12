package UI.MyControl;

import Player.Player;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class PlayerBox
{
    private Label playerName;
    private Label playerRole;
    private AnchorPane playerBoxForImage;
    private Image playerFace;
    private Player player;
    private TextArea textArea;

    public PlayerBox(Label playerName, Label playerRole, AnchorPane playerBoxForImage, TextArea textArea)
    {
        this.textArea = textArea;
        this.playerName = playerName;
        this.playerRole = playerRole;
        this.playerBoxForImage = playerBoxForImage;
        playerFace = null;
        player = null;
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
        playerBoxForImage.setBackground(new Background(new BackgroundImage(playerFace, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer(Player player)
    {
        this.player = player;
        playerName.setText(player.GetCharacters().GetName());
        playerRole.setText(player.GetRole().GetRoleName());
    }

    public TextArea getTextArea()
    {
        return textArea;
    }

    public void setTextArea(TextArea textArea)
    {
        this.textArea = textArea;
    }
}
