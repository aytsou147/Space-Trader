package fortress.Controllers;

import fortress.Main;
import fortress.Models.SparkAnimation;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.Initializable;
import javafx.scene.media.AudioClip;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Anthony on 12/4/14.
 */
public class SparkAnimationControl implements Initializable {
    private static final int COLUMNS  =   4;
    private static final int COUNT    =  16;
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  0;
    private static final int WIDTH    = 148;
    private static final int HEIGHT   = 148;

    private AudioClip ac = new AudioClip(getClass().getResource("../Sounds/money.mp3").toString());

    @FXML
    private ImageView spark;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final Animation animation = new SparkAnimation (
                spark,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
        );
        animation.setCycleCount(animation.INDEFINITE);
        animation.play();
    }

    public void collectMoney(ActionEvent actionEvent) throws IOException {
        ac.play();
        NewCharacterControl.player.setMoney(NewCharacterControl.player.getMoney() + 500);
        Parent root = FXMLLoader.load(getClass().getResource("../Views/universe.fxml"));
        Main.stage.setScene(new Scene(root));
    }
}
