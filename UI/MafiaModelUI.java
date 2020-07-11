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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

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
    private Label secondPlayerName;

    @FXML
    private Label secondPlayerRole;

    @FXML
    private AnchorPane secondPlayerPane;

    @FXML
    private Label thirdPlayerName;

    @FXML
    private Label thirdPlayerRole;

    @FXML
    private AnchorPane thirdPlayerPane;

    @FXML
    private Label fourthPlayerName;

    @FXML
    private Label fourthPlayerRole;

    @FXML
    private AnchorPane fourthPlayerPane;

    @FXML
    private Label fifthPlayerName;

    @FXML
    private Label fifthPlayerRole;

    @FXML
    private AnchorPane fifthPlayerPane;

    @FXML
    private Label sixthPlayerName;

    @FXML
    private Label sixthPlayerRole;

    @FXML
    private AnchorPane sixthPlayerPane;

    @FXML
    private Label seventhPlayerName;

    @FXML
    private Label seventhPlayerRole;

    @FXML
    private AnchorPane seventhPlayerPane;

    @FXML
    private Label eighthPlayerName;

    @FXML
    private Label eighthPlayerRole;

    @FXML
    private AnchorPane eighthPlayerPane;

    @FXML
    private Label ninthPlayerName;

    @FXML
    private Label ninthPlayerRole;

    @FXML
    private AnchorPane ninthPlayerPane;

    @FXML
    private Label tenthPlayerName;

    @FXML
    private Label tenthPlayerRole;

    @FXML
    private AnchorPane tenthPlayerPane;

    @FXML
    private Label eleventhPlayerName;

    @FXML
    private Label eleventhPlayerRole;

    @FXML
    private AnchorPane eleventhPlayerPane;

    @FXML
    private Label twelfthPlayerName;

    @FXML
    private Label twelfthPlayerRole;

    @FXML
    private AnchorPane twelfthPlayerPane;

    @FXML
    private Button startGameBtn;

    @FXML
    private Button endGameBtn;

    @FXML
    private Button createPlayerBtn;

    //
    // Java is fucking language, that's why I am forced to leave this block of code framed in a comment
    //
    private CreatePlayers createPlayersForm;
    private Master master;
    public LinkedList<PlayerBox> playersInGame;
    public Builder builder;
    //
    // end of block. Java is shit
    //

    @FXML
    void createPlayerBtn_Click(MouseEvent event) {
        FXMLLoader loader = new FXMLLoader();
        try
        {
            Parent root = loader.load(getClass().getResource("CreatePlayers.fxml"));
            createPlayersForm = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }
        catch (IOException e)
        {
            System.out.println("Fuck you");
        }


    }

    @FXML
    public void initialize()
    {
        initPlayersInGame();
        master = Master.InitMaster();
        builder = new Builder();
    }

    private void initPlayersInGame()
    {
        playersInGame = new LinkedList<PlayerBox>();
        playersInGame.add(new PlayerBox(firstPlayerName,firstPlayerRole,firstPlayerPane));
        playersInGame.add(new PlayerBox(secondPlayerName,secondPlayerRole,secondPlayerPane));
        playersInGame.add(new PlayerBox(thirdPlayerName,thirdPlayerRole,thirdPlayerPane));
        playersInGame.add(new PlayerBox(fourthPlayerName,fourthPlayerRole,fourthPlayerPane));
        playersInGame.add(new PlayerBox(fifthPlayerName,fifthPlayerRole,fifthPlayerPane));
        playersInGame.add(new PlayerBox(sixthPlayerName,sixthPlayerRole,sixthPlayerPane));
        playersInGame.add(new PlayerBox(seventhPlayerName,seventhPlayerRole,seventhPlayerPane));
        playersInGame.add(new PlayerBox(eighthPlayerName,eighthPlayerRole,eighthPlayerPane));
        playersInGame.add(new PlayerBox(ninthPlayerName,ninthPlayerRole,ninthPlayerPane));
        playersInGame.add(new PlayerBox(tenthPlayerName,tenthPlayerRole,tenthPlayerPane));
        playersInGame.add(new PlayerBox(eleventhPlayerName,eleventhPlayerRole,eleventhPlayerPane));
        playersInGame.add(new PlayerBox(twelfthPlayerName,twelfthPlayerRole,twelfthPlayerPane));
    }

}
