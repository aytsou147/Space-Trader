package fortress.Controllers;

import fortress.Main;
import fortress.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *@author Arvind
 */
public class UniverseControl extends Main implements Initializable{

    public TextField planetName;
    public TextField fuelAmount;
    public TextField playerName;
    public TextField dialogBox;
    public TextField dialogBox1;
    public Button toMarket;
    public Button wonder;
    public Button anthony;
    public Button pokemon;
    public Button zelda;
    public Button jim;
    public Button batman;
    public Button ishaan;
    public Button mario;
    public Button wayne;
    public Button arvind;
    public Button thao;
    public Button luigi;
    public Button michael;
    public Button saveMenu;
    public Button star;

    private AudioClip ac;

    /**
     * Go to market screen
     * @param actionEvent
     * @throws IOException
     */
    public final void goToMarketScreen (ActionEvent actionEvent) throws IOException {
        Parent market = FXMLLoader.load(getClass().getResource("../Views/marketScreen.fxml"));
        stage.setScene(new Scene(market));
        stage.show();
    }

    /**
     * Update on screen values
     */
    public final void update() {
        planetName.setText(NewCharacterControl.player.getSolarSystem().getName());
        fuelAmount.setText("" + NewCharacterControl.player.getShip().getFuel());
        ac.play();
    }

    @Override
    public final void initialize(URL location, ResourceBundle rb) {
       toMarket.setDisable(false);
       saveMenu.setDisable(false);
       ac = new AudioClip(getClass().getResource("../Sounds/warp.mp3").toString());
       update();
       dialogBox.setText("Pick somewhere to travel");
       dialogBox1.setText("");
       playerName.setText("Welcome, " + NewCharacterControl.player.getName());
    }

    /**
     * Go to Wonderworld
     * @param actionEvent
     */
    public final void goToWonder(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[0]));
        randomEvent();
        update();
    }
    /**
     * Go to Batmanworld
     * @param actionEvent
     */
    public final void goToBatman(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[1]));
        randomEvent();
        update();
    }
    /**
     * Go to Arvindworld
     * @param actionEvent
     */
    public final void goToArvind(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[2]));
        randomEvent();
        update();
    }
    /**
     * Go to Anthonyworld
     * @param actionEvent
     */
    public final void goToAnthony(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[3]));
        randomEvent();
        update();
    }
    /**
     * Go to Ishaanworld
     * @param actionEvent
     */
    public final void goToIshaan(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[4]));
        randomEvent();
        update();
    }
    /**
     * Go to Thaoworld
     * @param actionEvent
     */
    public final void goToThao(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[5]));
        randomEvent();
        update();
    }
    /**
     * Go to Pokemonworld
     * @param actionEvent
     */
    public final void goToPokemon(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[6]));
        randomEvent();
        update();
    }
    /**
     * Go to Marioworld
     * @param actionEvent
     */
    public final void goToMario(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[7]));
        randomEvent();
        update();
    }
    /**
     * Go to Luigiworld
     * @param actionEvent
     */
    public final void goToLuigi(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[8]));
        randomEvent();
        update();
    }
    /**
     * Go to Zeldaworld
     * @param actionEvent
     */
    public final void goToZelda(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[9]));
        randomEvent();
        update();
    }
    /**
     * Go to Waynesworld
     * @param actionEvent
     */
    public final void goToWayne(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[10]));
        randomEvent();
        update();
    }
    /**
     * Go to Michaelsworld
     * @param actionEvent
     */
    public final void goToMichael(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[11]));
        randomEvent();
        update();
    }
    /**
     * Go to Jimsworld
     * @param actionEvent
     */
    public final void goToJim(ActionEvent actionEvent) {
        dialogBox.setText(NewCharacterControl.player.setSolarSystem(system[12]));
        randomEvent();
        update();
    }

    /**
        Random Event generator.
        Random Events:
        - Nothing happens
        - Finding fuel
        - Leaking fuel
     */
    public final void randomEvent() {
        int x = (int)(Math.random() * 6);
        //checks that player is not already on a planet and has enough fuel before generating a random event
        if(!dialogBox.getCharacters().toString().equals("Already on planet!") && !dialogBox.getCharacters().toString().equals("Not enough fuel!") ) {
            if (x == 0) {
                dialogBox1.setText("Nothing eventful happened.");
            } else if (x == 1) {
                NewCharacterControl.player.getShip().setFuel(NewCharacterControl.player.getShip().getFuel() + 20);
                fuelAmount.setText("" + (NewCharacterControl.player.getShip().getFuel()));
                dialogBox1.setText("You found some fuel! Fuel+20");
            } else if (x == 2) {
                NewCharacterControl.player.getShip().setFuel(NewCharacterControl.player.getShip().getFuel() - 10);
                fuelAmount.setText("" + (NewCharacterControl.player.getShip().getFuel()));
                dialogBox1.setText("Your fuel leaked. Fuel-10");
            } else if (x == 3) {
                star.setDisable(false);
                star.setVisible(true);
                toMarket.setDisable(true);
                saveMenu.setDisable(true);
                dialogBox1.setText("Star Power!!");
            } else if (x == 4) {
                TradeGoods[] cargo = NewCharacterControl.player.getShip().getCargo();
                boolean illegal = false;
                for (TradeGoods t:cargo) {
                    if (t != null) {
                        if (t.getName().equals("Narcotics") || t.getName().equals("Firearms")) {
                            illegal = true;
                        }
                    }
                }
                if (illegal) {
                    NewCharacterControl.player.setMoney(NewCharacterControl.player.getMoney() - 200);
                    dialogBox1.setText("Police fined you 200 for having illegal goods!");
                } else {
                    NewCharacterControl.player.setMoney(NewCharacterControl.player.getMoney() + 200);
                    dialogBox1.setText("Police gave you 200 for having legal goods!");
                }
            } else if (x == 5) {
                NewCharacterControl.player.setMoney(NewCharacterControl.player.getMoney() - 100);
                dialogBox1.setText("Pirates stole 100 credits!");
            }
        } else {
            dialogBox1.setText("");
        }
    }

    public final void goToStar(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/sparkAnimation.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Go to save menu
     * @param actionEvent
     * @throws IOException
     */
    public final void goToSaveMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/saveMenu.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
}
