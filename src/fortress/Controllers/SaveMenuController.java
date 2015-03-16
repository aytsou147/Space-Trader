package fortress.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by ThaoMVo on 10/27/2014.
 */
public class SaveMenuController extends fortress.Models.Persistence {

    public TextField display;

    /**
     * Go back to universe screen
     * @param actionEvent
     * @throws IOException
     */
    public final void cancelScreen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/universe.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Save current state
     * @param actionEvent
     */
    public final void saveGame(ActionEvent actionEvent) {
        saveGame();
        display.setText("Game saved successfully!");
    }

    /**
     * Load last saved state
     * @param actionEvent
     */
    public final void loadGame(ActionEvent actionEvent) {
        loadGame();
        display.setText("Game loaded successfully!");
    }
}
