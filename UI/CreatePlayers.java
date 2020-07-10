package UI;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


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
    private Button setPlayerTemperamentBtn;

    @FXML
    private Button SetPlayerFetishBtn;

    @FXML
    private Button SetPlayerEducationBtn;

    //
    // Java is fucking language, that's why I am forced to leave this block of code framed in a comment
    //
    private TextField[] textFields;

    //
    // end of block. Java is shit
    //

    @FXML
    void AcceptBtn_Click(MouseEvent event) {
        if (IsThisFuckingTextFieldsEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("You are moron and Java is a shit");
            alert.setContentText("You must fill all text fields!!!!");
            alert.show();
        }
        else
        {
            ((Stage)AcceptBtn.getScene().getWindow()).close();
        }

    }

    @FXML
    public  void initialize()
    {
        textFields = new TextField[]{
                playerActingAbilitiestxt, playerIntuitiontxt, playerHumortxt, playerLeadershiptxt, playerOptimismtxt,
                playerAgetxt, playerNametxt, playerSextxt, playerSuspiciontxt, playerStressResistencetxt, playerWillpowertxt,
                playerOratorytxt
        };
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
    void SetPlayerEducationBtn_Click(MouseEvent event) {

    }

    @FXML
    void SetPlayerFetishBtn_Click(MouseEvent event) {

    }

    @FXML
    void SetPlayerTemperamentBtn_Click(MouseEvent event) {

    }

    @FXML
    void playerNameKeyPressed(KeyEvent event) {
        if ("0123456789".contains(event.getCharacter()))
        {
            event.consume();
        }
    }

}

