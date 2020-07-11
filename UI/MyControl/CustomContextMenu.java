package UI.MyControl;

import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

public class CustomContextMenu
{
    public ContextMenu menu;
    public MenuItem createNewPlayer;
    public MenuItem changePlayer;
    public MenuItem showPlayerCharacters;
    public CustomContextMenu()
    {
        menu = new ContextMenu();
        createNewPlayer = new MenuItem("Create new player");
        changePlayer = new Menu("Change player");
        showPlayerCharacters = new MenuItem("Show player's characters");
        menu.getItems().addAll(createNewPlayer, changePlayer, showPlayerCharacters);
    }

    public void SubscribeOnActions()
    {
        createNewPlayer.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

    private EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>()
    {
        @Override
        public void handle(MouseEvent mouseEvent)
        {
            if (mouseEvent.isPrimaryButtonDown())
            {

            }
        }
    };
}
