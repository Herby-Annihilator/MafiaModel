package UI;

import Master.Master;
import Player.Player;
import UI.MyControl.PlayerBox;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

import static Player.Scenario.factory;

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
    private Button initMasterBtn;

    @FXML
    private Button createPlayerBtn;

    @FXML
    private Button tellAStoryBtn;

    @FXML
    private Button wakeUpMafiaBtn;

    @FXML
    private Button wakeUpMafiaDonBtn;

    @FXML
    private Button wakeUpDoctorBtn;

    @FXML
    private Button wakeUpManiacBtn;

    @FXML
    private Button wakeUpWhoreBtn;

    @FXML
    private Button wakeUpCommissionerBtn;

    @FXML
    private Button startDiscussingBtn;

    @FXML
    private Button removeAllPlayersBtn;

    @FXML
    private Label mafiasWantKillHimLabel;

    @FXML
    private Label maniacWantKillHimLabel;

    @FXML
    private Label doctorWantHealHimLabel;

    @FXML
    private Label whoreWantGiveAnAlibiLabel;

    @FXML
    private Button startAnalisysBtn;

    @FXML
    private Button startNightBtn;

    @FXML
    private Button startDayBtn;

    @FXML
    private Label mafiasKilled;

    @FXML
    private Label maniacKilled;

    @FXML
    private Label residentsKickedOut;

    //
    // Java is fucking language, that's why I am forced to leave this block of code framed in a comment
    //
    private CreatePlayers createPlayersForm;
    private Master master;
    public PlayerBox[] playersInGame;
    private boolean isNight = false;
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
            createPlayersForm.initMasterBtn = initMasterBtn;
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
        tellAStoryBtn.setDisable(false);
        startDayBtn.setDisable(false);
        startNightBtn.setDisable(false);
    }

    @FXML
    public void showFirstPlayerInfo(MouseEvent event)
    {
        try
        {
            for (int i = 0; i < playersInGame.length; i++)
            {
                if (((AnchorPane)event.getSource()).equals(playersInGame[i].getPlayerBoxForImage()))
                {
                    ShowPlayerInfo(playersInGame[i].getPlayer(), informationAboutPlayer);
                }
            }
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Can't cast to anchorPane (method name: showFirstPlayerInfo)");
            alert.show();
        }
    }

    private void ShowPlayerInfo( Player player, TextArea textArea)
    {
        if (master != null)
        {
            master.ShowPlayerInfo(player, textArea);
        }
        else
        {
            textArea.setText("Please, init your master!");
        }
    }

    @FXML
    void removeAllPlayersBtn_Click(MouseEvent event) {
        SetButtonsDisable(true);
        if (master != null)
        {
            master.ResetAllPlayersSettings();
        }
        ResetPlayersInGameParameters();
    }

    private void ResetPlayersInGameParameters()
    {

        for (int i = 0; i < playersInGame.length; i++)
        {
            playersInGame[i].setPlayer(null);
            playersInGame[i].SetDefaultFace();
            playersInGame[i].getPlayerName().setText("");
            playersInGame[i].getPlayerRole().setText("");
        }
    }


    @FXML
    void startDiscussingBtn_Click(MouseEvent event) {
        master.StartDiscussing();
    }

    @FXML
    void tellAStoryBtn_Click(MouseEvent event) {
        for (int i = 0; i < playersInGame.length; i++)
        {
            if (playersInGame[i].getPlayer() != null)
            {
                master.ForcePlayerTellAStory(factory, i, playersInGame[i].getTextArea());
            }
        }
    }

    @FXML
    void wakeUpCommissionerBtn_Click(MouseEvent event) {
        master.WakeUpCommissioner();
    }

    @FXML
    void wakeUpDoctorBtn_Click(MouseEvent event) {
        master.WakeUpDoctor();
        if (master.getPlayerYouWillHeal() != null)
        {
            doctorWantHealHimLabel.setText(master.getPlayerYouWillHeal().GetCharacters().GetName());
        }
        else
        {
            doctorWantHealHimLabel.setText("");
        }
    }

    @FXML
    void wakeUpMafiaBtn_Click(MouseEvent event) {
        master.WakeUpMafia();
        if (master.getMafiaWantKillHim() != null)
        {
            mafiasWantKillHimLabel.setText(master.getMafiaWantKillHim().GetCharacters().GetName());
        }
        else
        {
            mafiasWantKillHimLabel.setText("");
        }
    }

    @FXML
    void wakeUpMafiaDonBtn_Click(MouseEvent event) {
        master.WakeUpMafiaDon();
    }

    @FXML
    void wakeUpManiacBtn_Click(MouseEvent event) {
        master.WakeUpManiac();
        if (master.getManiacWantKillHim() != null)
        {
            maniacWantKillHimLabel.setText(master.getManiacWantKillHim().GetCharacters().GetName());
        }
        else
        {
            maniacWantKillHimLabel.setText("");
        }
    }

    @FXML
    void wakeUpWhoreBtn_Click(MouseEvent event) {
        master.WakeUpWhore();
        if (master.getPlayerWillHasAnAlibi() != null)
        {
            whoreWantGiveAnAlibiLabel.setText(master.getPlayerWillHasAnAlibi().GetCharacters().GetName());
        }
        else
        {
            whoreWantGiveAnAlibiLabel.setText("");
        }
    }

    @FXML
    public void initialize()
    {
        SetButtonsDisable(true);
        initPlayersInGame();
    }

    private void SetButtonsDisable(boolean isDisable)
    {
        initMasterBtn.setDisable(isDisable);
        startNightBtn.setDisable(isDisable);
        startDayBtn.setDisable(isDisable);
        startDiscussingBtn.setDisable(isDisable);
        tellAStoryBtn.setDisable(isDisable);
        wakeUpCommissionerBtn.setDisable(isDisable);
        wakeUpDoctorBtn.setDisable(isDisable);
        wakeUpMafiaBtn.setDisable(isDisable);
        wakeUpMafiaDonBtn.setDisable(isDisable);
        wakeUpManiacBtn.setDisable(isDisable);
        wakeUpWhoreBtn.setDisable(isDisable);
        startAnalisysBtn.setDisable(isDisable);
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


    @FXML
    void startAnalysisBtn_Click(MouseEvent event)
    {
        maniacKilled.setText("");
        mafiasKilled.setText("");
        residentsKickedOut.setText("");
        if (isNight)
        {
            boolean playerShouldBeKilledByMafia = false;
            boolean playerShouldBeKilledByManiac = false;
            if (master.getManiacWantKillHim() != null)
            {
                playerShouldBeKilledByManiac = true;
                if (master.getPlayerYouWillHeal() != null)
                {
                    if (master.getManiacWantKillHim().equals(master.getPlayerYouWillHeal()))
                    {
                        playerShouldBeKilledByManiac = false;
                    }
                }
                if (master.getPlayerWillHasAnAlibi() != null)
                {
                    if (master.getManiacWantKillHim().equals(master.getPlayerWillHasAnAlibi()))
                    {
                        playerShouldBeKilledByManiac = false;
                    }
                }
            }
            if (master.getMafiaWantKillHim() != null)
            {
                playerShouldBeKilledByMafia = true;
                if (master.getPlayerYouWillHeal() != null)
                {
                    if (master.getMafiaWantKillHim().equals(master.getPlayerYouWillHeal()))
                    {
                        playerShouldBeKilledByMafia = false;
                    }
                }
                if (master.getPlayerWillHasAnAlibi() != null)
                {
                    if (master.getMafiaWantKillHim().equals(master.getPlayerWillHasAnAlibi()))
                    {
                        playerShouldBeKilledByMafia = false;
                    }
                }
            }
            if (playerShouldBeKilledByMafia)
            {
                mafiasKilled.setText(master.getMafiaWantKillHim().GetCharacters().GetName());
                master.RemoveChosenPlayer(master.getMafiaWantKillHim());
            }
            if (playerShouldBeKilledByManiac)
            {
                maniacKilled.setText(master.getManiacWantKillHim().GetCharacters().GetName());
                master.RemoveChosenPlayer(master.getManiacWantKillHim());
            }
        }
        else
        {
            if (master.getPlayersWerePutOnDeletion() != null)
            {
                int index = new Random().nextInt(master.getPlayersWerePutOnDeletion().size());
                residentsKickedOut.setText(master.getPlayersWerePutOnDeletion().get(index).GetCharacters().GetName());
                master.RemoveChosenPlayer(master.getPlayersWerePutOnDeletion().get(index));
                master.getPlayersWerePutOnDeletion().clear();
            }

        }
        CheckTheEndOfGame();
    }

    private void CheckTheEndOfGame()
    {
        if (master.getMafiaDon() != null)
        {
            if ((master.getMafias().size() + 1) >= (master.getPlayersRemainingInTheGame().size() - (master.getMafias().size() + 1)))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Game over");
                alert.setContentText("Mafias are winners!\nPlease press 'Remove all players' or 'Init\\Reset master' button");
                alert.show();
                SetButtonsDisable(true);
                initMasterBtn.setDisable(false);
            }
        }
        else if (master.getMafias().size() >= (master.getPlayersRemainingInTheGame().size() - master.getMafias().size()))
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game over");
            alert.setContentText("Mafias are winners!\nPlease press 'Remove all players' or 'Init\\Reset master' button");
            alert.show();
            SetButtonsDisable(true);
            initMasterBtn.setDisable(false);
        }
        else if (master.getMafias().size() == 0 && master.getMafiaDon() == null)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Game over");
            alert.setContentText("Civilians are winners!\nPlease press 'Remove all players' or 'Init\\Reset master' button");
            alert.show();
            SetButtonsDisable(true);
            initMasterBtn.setDisable(false);
        }
    }

    @FXML
    void startNightBtn_Click(MouseEvent event)
    {
        SetButtonsDisable(false);
        if (master.getManiac() == null)
        {
            wakeUpManiacBtn.setDisable(true);
        }
        if (master.getMafiaDon() == null)
        {
            wakeUpMafiaDonBtn.setDisable(true);
        }
        if (master.getMafias() == null)
        {
            wakeUpMafiaBtn.setDisable(true);
        }
        if (master.getDoctor() == null)
        {
            wakeUpDoctorBtn.setDisable(true);
        }
        if (master.getCommissioner() == null)
        {
            wakeUpCommissionerBtn.setDisable(true);
        }
        if (master.getWhore() == null)
        {
            wakeUpWhoreBtn.setDisable(true);
        }
        startDiscussingBtn.setDisable(true);
        startNightBtn.setDisable(true);
        isNight = true;
    }

    @FXML
    void startDayBtn_Click(MouseEvent event)
    {
        SetButtonsDisable(true);
        startNightBtn.setDisable(false);
        startAnalisysBtn.setDisable(false);
        startDiscussingBtn.setDisable(false);
        isNight = false;
    }
}
