package fortress.Controllers;

import fortress.Models.Persistence;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Controller class for the Title Screen
 */
public class Controller extends fortress.Main{

    private Persistence p = new Persistence();

    /**
     * When "New Game" button on Title Screen clicked, changes scene to new character creation screen
     * @param actionEvent
     * @throws IOException
     */
    public final void goToCharacterCreationScreen (ActionEvent actionEvent) throws IOException {
           Parent root = FXMLLoader.load(getClass().getResource("../Views/newCharacterScreen.fxml"));
           stage.setScene(new Scene(root));
           stage.show();
    }

    /**
     * Exits the game.
     * @param actionEvent
     */
    public final void exitGame(ActionEvent actionEvent) {
        stage.close();
    }

    /**
     * Loads the game
     * @param actionEvent
     * @throws IOException
     */
    public final void loadGame(ActionEvent actionEvent) throws IOException {
        p.loadGame();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/universe.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
