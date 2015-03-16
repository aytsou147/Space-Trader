package fortress;

import fortress.Models.SolarSystem;
import fortress.Models.SparkAnimation;
import javafx.animation.Animation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;

/**
 * Starts the application and displays Title Screen
 */
public class Main extends Application {
    public static final int NUM_PLANETS = 13;
    public static Stage stage;
    public static SolarSystem[] system;
    public static MediaPlayer mediaPlayer;
    /*
    private final Image IMAGE = new Image("http://media.creativebloq.futurecdn.net/sites/creativebloq.com/files/images/2011/11/vox.jpg");

    private static final int COLUMNS  =   4;
    private static final int COUNT    =  16;
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  0;
    private static final int WIDTH    = 148;
    private static final int HEIGHT   = 148;
    */
    @Override
    /**
     * Loads the initial screen.
     */
    public final void start(Stage primaryStage) {
        try {
            /*
            ImageView imageView = new ImageView(IMAGE);
            imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

            final Animation animation = new SparkAnimation(
                    imageView,
                    Duration.millis(1000),
                    COUNT, COLUMNS,
                    OFFSET_X, OFFSET_Y,
                    WIDTH, HEIGHT
            );
            animation.setCycleCount(20);
            animation.play();

            primaryStage.setScene(new Scene(new Group(imageView)));
            primaryStage.show();
            */
            Parent root = FXMLLoader.load(Main.class.getResource("Views/SpaceTrader.fxml"));
            primaryStage.setTitle("Space Trader");

            stage = primaryStage;
            stage.setScene(new Scene(root));
            stage.show();

            URL bgmResource = getClass().getResource("Sounds/music.mp3");
            Media bgm = new Media(bgmResource.toString());
            mediaPlayer = new MediaPlayer(bgm);
            mediaPlayer.play();

            system = new SolarSystem[NUM_PLANETS];
            system[0] = new SolarSystem("Wonderworld", 10, 20, 0, 0);
            system[1] = new SolarSystem("Batmanworld", 19, 39, 7, 12);
            system[2] = new SolarSystem("Arvindworld", 2, 6, 1, 1);
            system[3] = new SolarSystem("Anthonyworld", 4, 12, 2, 2);
            system[4] = new SolarSystem("Ishaanworld", 14, 1, 3, 3);
            system[5] = new SolarSystem("Thaoworld", 25, 20, 4, 4);
            system[6] = new SolarSystem("Pokemonworld", 4, 27, 5, 5);
            system[7] = new SolarSystem("Marioworld", 12, 14, 6, 6);
            system[8] = new SolarSystem("Luigiworld", 11, 13, 7, 7);
            system[9] = new SolarSystem("Zeldaworld", 10, 12, 5, 8);
            system[10] = new SolarSystem("Waynesworld", 16, 13, 1, 9);
            system[11] = new SolarSystem("Michaelsworld", 13, 8, 2, 10);
            system[12] = new SolarSystem("Jimsworld", 2, 22, 3, 11);
        } catch (Exception e) {
        }
    }

    /**
     * Launches the game.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
