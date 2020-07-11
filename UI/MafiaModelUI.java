package UI;

import Builder.Builder;
import Master.Master;
import UI.MyControl.PlayerBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MafiaModelUI {

    @FXML
    private AnchorPane root;

    @FXML
    private Label firstPlayerName;

    @FXML
    private Label firstPlayerRole;

    @FXML
    private AnchorPane firstPlayerPane;

    @FXML
    private TextArea firstPlayerText;

    @FXML
    private Label secondPlayerName;

    @FXML
    private Label secondPlayerRole;

    @FXML
    private AnchorPane secondPlayerPane;

    @FXML
    private TextArea secondPlayerText;

    @FXML
    private Label thirdPlayerName;

    @FXML
    private Label thirdPlayerRole;

    @FXML
    private AnchorPane thirdPlayerPane;

    @FXML
    private TextArea thirdPlayerText;

    @FXML
    private Label fourthPlayerName;

    @FXML
    private Label fourthPlayerRole;

    @FXML
    private AnchorPane fourthPlayerPane;

    @FXML
    private TextArea fourthPlayerText;

    @FXML
    private Label fifthPlayerName;

    @FXML
    private Label fifthPlayerRole;

    @FXML
    private AnchorPane fifthPlayerPane;

    @FXML
    private TextArea fifthPlayerText;

    @FXML
    private Label sixthPlayerName;

    @FXML
    private Label sixthPlayerRole;

    @FXML
    private AnchorPane sixthPlayerPane;

    @FXML
    private TextArea sixthPlayerText;

    @FXML
    private Label seventhPlayerName;

    @FXML
    private Label seventhPlayerRole;

    @FXML
    private AnchorPane seventhPlayerPane;

    @FXML
    private TextArea sevenPlayerText;

    @FXML
    private Label eighthPlayerName;

    @FXML
    private Label eighthPlayerRole;

    @FXML
    private AnchorPane eighthPlayerPane;

    @FXML
    private TextArea eighthPlayerText;

    @FXML
    private Label ninthPlayerName;

    @FXML
    private Label ninthPlayerRole;

    @FXML
    private AnchorPane ninthPlayerPane;

    @FXML
    private TextArea ninthPlayerText;

    @FXML
    private Label tenthPlayerName;

    @FXML
    private Label tenthPlayerRole;

    @FXML
    private AnchorPane tenthPlayerPane;

    @FXML
    private TextArea tenthPlayerText;

    @FXML
    private Label eleventhPlayerName;

    @FXML
    private Label eleventhPlayerRole;

    @FXML
    private AnchorPane eleventhPlayerPane;

    @FXML
    private TextArea elevenPlayerText;

    @FXML
    private Label twelfthPlayerName;

    @FXML
    private Label twelfthPlayerRole;

    @FXML
    private AnchorPane twelfthPlayerPane;

    @FXML
    private TextArea twelfthPlayerText;

    @FXML
    private TextArea informationAboutPlayer;

    @FXML
    private Button startGameBtn;

    @FXML
    private Button endGameBtn;

    @FXML
    private Button createPlayerBtn;

    @FXML
    private Button initMasterBtn;

    //
    // Java is fucking language, that's why I am forced to leave this block of code framed in a comment
    //
    private CreatePlayers createPlayersForm;
    private Master master;
    public PlayerBox[] playersInGame;
    public Builder builder;
    //
    // end of block. Java is shit
    //

    @FXML
    void createPlayerBtn_Click(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreatePlayers.fxml"));
        try
        {
            Parent root = loader.load();
            createPlayersForm = loader.getController();
            createPlayersForm.players = playersInGame;
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();

        }
        catch (IOException e)
        {
            System.out.println("Fuck you");
        }


    }

    @FXML
    public void initMasterBtn_Click(MouseEvent event)
    {
        if (master == null)
        {
            master = master.InitMaster();
        }
        else
        {
            master.Reset();
        }
        master.setPlayerBoxes(playersInGame);
        master.SetAllPlayersParameters();
    }

    @FXML
    public void initialize()
    {
        initPlayersInGame();
    }

    private void initPlayersInGame()
    {
        playersInGame = new PlayerBox[12];
        playersInGame[0] = new PlayerBox(firstPlayerName,firstPlayerRole,firstPlayerPane, firstPlayerText);
        playersInGame[1] = new PlayerBox(secondPlayerName,secondPlayerRole,secondPlayerPane, secondPlayerText);
        playersInGame[2] = new PlayerBox(thirdPlayerName,thirdPlayerRole,thirdPlayerPane, thirdPlayerText);
        playersInGame[3] = new PlayerBox(fourthPlayerName,fourthPlayerRole,fourthPlayerPane, fourthPlayerText);
        playersInGame[4] = new PlayerBox(fifthPlayerName,fifthPlayerRole,fifthPlayerPane, fifthPlayerText);
        playersInGame[5] = new PlayerBox(sixthPlayerName,sixthPlayerRole,sixthPlayerPane, sixthPlayerText);
        playersInGame[6] = new PlayerBox(seventhPlayerName,seventhPlayerRole,seventhPlayerPane, sevenPlayerText);
        playersInGame[7] = new PlayerBox(eighthPlayerName,eighthPlayerRole,eighthPlayerPane, eighthPlayerText);
        playersInGame[8] = new PlayerBox(ninthPlayerName,ninthPlayerRole,ninthPlayerPane, ninthPlayerText);
        playersInGame[9] = new PlayerBox(tenthPlayerName,tenthPlayerRole,tenthPlayerPane, tenthPlayerText);
        playersInGame[10] = new PlayerBox(eleventhPlayerName,eleventhPlayerRole,eleventhPlayerPane, elevenPlayerText);
        playersInGame[11] = new PlayerBox(twelfthPlayerName,twelfthPlayerRole,twelfthPlayerPane, twelfthPlayerText);
    }

}
