package fortress.Controllers;

import fortress.Models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for upgrading ship
 * @author Ishaan Rajan
 */
public class ShipUpgradeControl extends fortress.Main implements Initializable {

    public TextField fuelCapacity;
    public TextField descriptFuelCapacity;
    public TextField priceFuelCapacity;
    public TextField hullStrength;
    public TextField descriptHullStrength;
    public TextField priceHullStrength;
    public TextField playerShip;
    public TextField playerShipCargo;
    public TextField playerShipFuel;
    public TextField playerShipHull;
    public TextField playerShipMerc;
    public TextField fuelUpgradeSlot;
    public TextField hullUpgradeSlot;
    public TextField mercUpgradeSlot;
    public TextField playerMoney;
    public TextField dialogBox;
    public TextField mercQuarters;
    public TextField descriptMercQuarters;
    public TextField priceMercQuarters;
    public Button buyHullStrength;
    public Button buyMercQuarters;

    /**
     * Goes back to shipyard screen
     * @param actionEvent
     * @throws IOException
     */
    public final void backToShipyard(ActionEvent actionEvent) throws IOException {
        Parent universe = FXMLLoader.load(getClass().getResource("../Views/shipyardScreen.fxml"));
        fortress.Main.stage.setScene(new Scene(universe));
        fortress.Main.stage.show();

    }


    /**
     * Displays ship upgrades available
     */
    public final void shipUpgrades() {

        fuelCapacity.setText("Fuel Overload");
        descriptFuelCapacity.setText("Increases Fuel by 100");
        priceFuelCapacity.setText("200");

        mercQuarters.setText("Merc Quarters");
        descriptMercQuarters.setText("Allows player to buy a mercenary");
        priceMercQuarters.setText("300");

        if (NewCharacterControl.player.getSolarSystem().getTech() == 7) {
            hullStrength.setText("Hull Strength");
            descriptHullStrength.setText("Increases Hull Strength by 20");
            priceHullStrength.setText("300");
        } else {
            hullStrength.setDisable(true);
            descriptHullStrength.setDisable(true);
            priceHullStrength.setDisable(true);
            buyHullStrength.setDisable(true);
        }
    }

    /**
     * Buy fuel capacity upgrade (+200)
     * @param actionEvent
     */
    public final void buyFuelCapacity(ActionEvent actionEvent) {
        int price = 200;
        if (NewCharacterControl.player.getMoney() >= price && NewCharacterControl.player.getShip().getFuelUpgrade() != 0) {
            NewCharacterControl.player.getShip().setFuel(NewCharacterControl.player.getShip().getFuel() + 100);
            NewCharacterControl.player.setMoney(NewCharacterControl.player.getMoney() - price);
            NewCharacterControl.player.getShip().setFuelUpgrade((NewCharacterControl.player.getShip().getFuelUpgrade() - 1));
            updateVals();

        }else{
            if (NewCharacterControl.player.getShip().getFuelUpgrade() == 0) {
                dialogBox.setText("Cannot upgrade fuel anymore");
            }else{
                dialogBox.setText("Not enough credits!");
            }

        }
    }


    /**
     * Buy hull strength upgrade (+20)
     * @param actionEvent
     */
    public final void buyHullStrength(ActionEvent actionEvent){
        int price = 300;
        if(NewCharacterControl.player.getMoney() >= price && NewCharacterControl.player.getShip().getHullUpgrade() != 0) {
            NewCharacterControl.player.getShip().setHull(NewCharacterControl.player.getShip().getHull() + 20);
            NewCharacterControl.player.setMoney(NewCharacterControl.player.getMoney() - price);
            NewCharacterControl.player.getShip().setHullUpgrade((NewCharacterControl.player.getShip().getHullUpgrade() - 1));
            updateVals();
        }else{
            if (NewCharacterControl.player.getShip().getHullUpgrade() == 0){
                dialogBox.setText("Cannot upgrade hull anymore");
            }else {
                dialogBox.setText("Not enough credits!");
            }
        }
    }

    /**
     * Buy mercenary (augments skills)
     * @param actionEvent
     */
    public final void buyMercQuarters(ActionEvent actionEvent){
        int price = 300;
        if(NewCharacterControl.player.getMoney() >= price && !NewCharacterControl.player.getShip().getMerc()) {
            for (int i:NewCharacterControl.player.getSkills()) {
                i += 5;
            }
            NewCharacterControl.player.getShip().setMerc(true);
            NewCharacterControl.player.setMoney(NewCharacterControl.player.getMoney() - price);
            updateVals();
        }else{
            if (NewCharacterControl.player.getShip().getMerc()){
                dialogBox.setText("Already hired mercenary");
            }else {
                dialogBox.setText("Not enough credits!");
            }
        }
    }

    /**
     * Updates values of text boxes on the screen
     */
    private void updateVals() {
        Player player = NewCharacterControl.player;
        playerShip.setText(player.getShip().getName());
        playerShipCargo.setText(player.getShip().getCargo().length + "");
        playerShipFuel.setText(player.getShip().getFuel() + "");
        playerShipHull.setText(player.getShip().getHull() + "");
        if (player.getShip().getMerc()) {
            playerShipMerc.setText("1");
        } else {
            mercUpgradeSlot.setText("0");
        }
        playerMoney.setText(player.getMoney() + "");
        fuelUpgradeSlot.setText(player.getShip().getFuelUpgrade() + "");
        hullUpgradeSlot.setText(player.getShip().getHullUpgrade() + "");
        if (player.getShip().getMerc()) {
            mercUpgradeSlot.setText("0");
        } else {
            mercUpgradeSlot.setText("1");
        }
        shipUpgrades();
    }

    /**
     * Initializes the thing on the screen when it is opened
     * @param location
     * @param resources
     */
    @Override
    public final void initialize(URL location, ResourceBundle resources) {

        updateVals();

    }
}


