package UI;

import Player.Characters;
import Player.Decorator.*;
import Player.Person;
import Player.Player;
import Player.Role.*;
import UI.MyControl.PlayerBox;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.LinkedList;


public class CreatePlayers {

    @FXML
    private TextField playerNametxt;

    @FXML
    private TextField playerSextxt;

    @FXML
    private TextField playerAgetxt;

    @FXML
    private TextField playerOratorytxt;

    @FXML
    private TextField playerStressResistencetxt;

    @FXML
    private TextField playerSuspiciontxt;

    @FXML
    private TextField playerLeadershiptxt;

    @FXML
    private TextField playerActingAbilitiestxt;

    @FXML
    private TextField playerIntuitiontxt;

    @FXML
    private TextField playerWillpowertxt;

    @FXML
    private TextField playerOptimismtxt;

    @FXML
    private TextField playerHumortxt;

    @FXML
    private Button AcceptBtn;

    @FXML
    private CheckBox sanguineTemp;

    @FXML
    private CheckBox cholericTemp;

    @FXML
    private CheckBox melancholicTemp;

    @FXML
    private CheckBox phlegmaticTemp;

    @FXML
    private CheckBox boozerFetish;

    @FXML
    private CheckBox buggerFetish;

    @FXML
    private CheckBox freakFetish;

    @FXML
    private CheckBox femenistFetish;

    @FXML
    private CheckBox fanFetish;

    @FXML
    private CheckBox religiousManFetish;

    @FXML
    private CheckBox parasiteFetish;

    @FXML
    private RadioButton higherEdc;

    @FXML
    private ToggleGroup education;

    @FXML
    private RadioButton completeSecondaryEdc;

    @FXML
    private RadioButton incompleteSecondaryEdc;

    @FXML
    private RadioButton twoClassesAndCorridorEdc;

    @FXML
    private RadioButton civilianRole;

    @FXML
    private ToggleGroup role;

    @FXML
    private RadioButton maniacRole;

    @FXML
    private RadioButton mafiaRole;

    @FXML
    private RadioButton mafiaDonRole;

    @FXML
    private RadioButton commissionerRole;

    @FXML
    private RadioButton doctorRole;

    @FXML
    private RadioButton whoreRole;

    @FXML
    private Label playerID;

    @FXML
    private Button createPlayerBtn;

    //
    // Java is fucking language, that's why I am forced to leave this block of code framed in a comment
    //
    private TextField[] textFields;
    public final int MAX_PLAYERS_COUNT = 12;
    public PlayerBox[] players;   // должно быть инициализировано в вызывающем контроллере
    private LinkedList<Player> tempPlayers;
    private int currentCountOfPlayers;
    //
    // end of block. Java is shit
    //

    @FXML
    void CreatePlayerBtn_Click(MouseEvent event)
    {
        if (IsThisFuckingTextFieldsEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("You are moron and Java is a shit");
            alert.setContentText("You must fill all text fields!!!!");
            alert.show();
        }
        else if (tempPlayers.size() >= MAX_PLAYERS_COUNT)
        {
            playerID.setText("You can't create any players! Please, push Accept button");

        }
        else
        {
            Player player = createPlayer();
            if (!setRole(player))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("You are moron and Java is a shit");
                alert.setContentText("You must chose Role!!!!");
                alert.show();
            }
            else
            {
                player = setEducationIfNecessary(player);
                player = setFetishIfNecessary(player);
                player = setTemperamentIfNecessary(player);
                tempPlayers.add(player);
                playerID.setText("Player " + (tempPlayers.size() - 1) + " created!");
            }
        }
    }

    @FXML
    void AcceptBtn_Click(MouseEvent event) {
        for (int i = 0; i < tempPlayers.size(); i++)
        {
            players[i].setPlayer(tempPlayers.get(i));
        }
        ((Stage)(AcceptBtn.getScene().getWindow())).close();
    }

    private boolean setRole(Player player)
    {
        if (civilianRole.isSelected())
        {
            player.SetRole(new Civilian(player));
            return true;
        }
        if (mafiaDonRole.isSelected())
        {
            player.SetRole(new MafiaDon(player));
            return true;
        }
        if (mafiaRole.isSelected())
        {
            player.SetRole(new Mafia(player));
            return true;
        }
        if (commissionerRole.isSelected())
        {
            player.SetRole(new Commissioner(player));
            return true;
        }
        if (doctorRole.isSelected())
        {
            player.SetRole(new Doctor(player));
            return true;
        }
        if (maniacRole.isSelected())
        {
            player.SetRole(new Maniac(player));
            return true;
        }
        if (whoreRole.isSelected())
        {
            player.SetRole(new Whore(player));
            return true;
        }
        return false;
    }

    private Player createPlayer()
    {
        Characters characters = new Characters(playerNametxt.getText(),playerSextxt.getText(),
                Integer.parseInt(playerAgetxt.getText()),Integer.parseInt(playerOratorytxt.getText()),
                Integer.parseInt(playerStressResistencetxt.getText()),Integer.parseInt(playerSuspiciontxt.getText()),
                Integer.parseInt(playerLeadershiptxt.getText()), Integer.parseInt(playerActingAbilitiestxt.getText()),
                Integer.parseInt(playerIntuitiontxt.getText()), Integer.parseInt(playerWillpowertxt.getText()),
                Integer.parseInt(playerOptimismtxt.getText()), Integer.parseInt(playerHumortxt.getText()));
        Player player = new Person(characters);
        return player;
    }

    private Player setTemperamentIfNecessary(Player player)
    {
        Player currentPlayer = player;
        if (sanguineTemp.isSelected())
        {
            currentPlayer = new SanguineDecorator(currentPlayer);
        }
        if (cholericTemp.isSelected())
        {
            currentPlayer = new CholericDecorator(currentPlayer);
        }
        if (melancholicTemp.isSelected())
        {
            currentPlayer = new MelancholicDecorator(currentPlayer);
        }
        if (phlegmaticTemp.isSelected())
        {
            currentPlayer = new PhlegmaticDecorator(currentPlayer);
        }
        return currentPlayer;
    }

    private Player setFetishIfNecessary(Player player)
    {
        Player currentPlayer = player;
        if (boozerFetish.isSelected())
        {
            currentPlayer = new BoozerDecorator(currentPlayer);
        }
        if (buggerFetish.isSelected())
        {
            currentPlayer = new BuggerDecorator(currentPlayer);
        }
        if (freakFetish.isSelected())
        {
            currentPlayer = new FreakDecorator(currentPlayer);
        }
        if (fanFetish.isSelected())
        {
            currentPlayer = new FanDecorator(currentPlayer);
        }
        if (femenistFetish.isSelected())
        {
            currentPlayer = new FeministDecorator(currentPlayer);
        }
        if (parasiteFetish.isSelected())
        {
            currentPlayer = new ParasiteDecorator(currentPlayer);
        }
        if (religiousManFetish.isSelected())
        {
            currentPlayer = new ReligiousManDecorator(currentPlayer);
        }
        return currentPlayer;
    }

    private Player setEducationIfNecessary(Player player)
    {
        Player currentPlayer = player;
        if (higherEdc.isSelected())
        {
            currentPlayer = new HigherEducationDecorator(currentPlayer);
        }
        if (completeSecondaryEdc.isSelected())
        {
            currentPlayer = new CompleteSecondaryEducationDecorator(currentPlayer);
        }
        if (incompleteSecondaryEdc.isSelected())
        {
            currentPlayer = new IncompleteSecondaryEducationDecorator(currentPlayer);
        }
        if (twoClassesAndCorridorEdc.isSelected())
        {
            currentPlayer = new TwoClassesAndCorridorDecorator(currentPlayer);
        }
        return currentPlayer;
    }

    @FXML
    public  void initialize()
    {
        textFields = new TextField[]{
                playerActingAbilitiestxt, playerIntuitiontxt, playerHumortxt, playerLeadershiptxt, playerOptimismtxt,
                playerAgetxt, playerNametxt, playerSextxt, playerSuspiciontxt, playerStressResistencetxt, playerWillpowertxt,
                playerOratorytxt
        };
        tempPlayers = new LinkedList<Player>();
    }


    private boolean IsThisFuckingTextFieldsEmpty()
    {
        for (int i = 0; i < textFields.length; i++)
        {
            if (textFields[i].getText() == null || textFields[i].getText().isEmpty())
            {
                return true;
            }
        }
        return false;
    }

    @FXML
    void OnlyNumbers(KeyEvent event) {
        if (event.getText().matches("[0..9]"))
        {
            event.consume();
        }
    }


    @FXML
    void playerNameKeyPressed(KeyEvent event) {
        if ("0123456789".contains(event.getCharacter()))
        {
            event.consume();
        }
    }


}

