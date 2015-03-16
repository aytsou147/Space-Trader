package fortress.Controllers;

import fortress.Main;
import fortress.Models.Player;
import fortress.Models.ShipYard;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ishaan Rajan
 */
public class ShipyardControl extends Main implements Initializable {

    public TextField ship1;
    public TextField ship2;
    public TextField ship3;
    public TextField ship4;
    public TextField ship5;
    public TextField shipCargo1;
    public TextField shipCargo2;
    public TextField shipCargo3;
    public TextField shipCargo4;
    public TextField shipCargo5;
    public TextField shipFuel1;
    public TextField shipFuel2;
    public TextField shipFuel3;
    public TextField shipFuel4;
    public TextField shipFuel5;
    public TextField shipHull1;
    public TextField shipHull2;
    public TextField shipHull3;
    public TextField shipHull4;
    public TextField shipHull5;
    public TextField shipPrice1;
    public TextField shipPrice2;
    public TextField shipPrice3;
    public TextField shipPrice4;
    public TextField shipPrice5;
    public TextField playerShip;
    public TextField playerShipCargo;
    public TextField playerShipFuel;
    public TextField playerShipHull;
    public TextField playerShipPrice;
    public TextField playerMoney;
    public TextField dialogBox;
    private String successSale = "Successful sale!";
    private String notEnoughCredits = "Not enough credits!";
    private ShipYard yard = new ShipYard();

    /**
     * Return to market screen
     * @param actionEvent
     * @throws IOException
     */
    public final void backToMarket(ActionEvent actionEvent) throws IOException {
        Parent universe = FXMLLoader.load(getClass().getResource("../Views/marketScreen.fxml"));
        Main.stage.setScene(new Scene(universe));
        Main.stage.show();
    }


    public final void toShipUpgrade(ActionEvent actionEvent) throws IOException {
        Parent universe = FXMLLoader.load(getClass().getResource("../Views/shipUpgradeScreen.fxml"));
        Main.stage.setScene(new Scene(universe));
        Main.stage.show();
    }

    /**
     * Buys bumblebee
     * @param actionEvent
     */
    public final void buyBumblebee(ActionEvent actionEvent) {
        int ret = yard.buyShip("Bumblebee");
        if (ret == 1) {
            dialogBox.setText(successSale);
        } else {
            dialogBox.setText(notEnoughCredits);
        }
        updateVals();
    }
    /**
     * Buys Mosquito
     * @param actionEvent
     */
    public final void buyMosquito(ActionEvent actionEvent) {
        int ret = yard.buyShip("Mosquito");
        if (ret == 1) {
            dialogBox.setText(successSale);
        } else {
            dialogBox.setText(notEnoughCredits);
        }
        updateVals();
    }
    /**
     * Buys Firefly
     * @param actionEvent
     */
    public final void buyFirefly(ActionEvent actionEvent) {
        int ret = yard.buyShip("Firefly");
        if (ret == 1) {
            dialogBox.setText(successSale);
        } else {
            dialogBox.setText(notEnoughCredits);
        }
        updateVals();
    }
    /**
     * Buys Gnat
     * @param actionEvent
     */
    public final void buyGnat(ActionEvent actionEvent) {
        int ret = yard.buyShip("Gnat");
        if (ret == 1) {
            dialogBox.setText(successSale);
        } else {
            dialogBox.setText(notEnoughCredits);
        }
        updateVals();
    }
    /**
     * Buys Flea
     * @param actionEvent
     */
    public final void buyFlea(ActionEvent actionEvent) {
        int ret = yard.buyShip("Flea");
        if (ret == 1) {
            dialogBox.setText(successSale);
        } else {
            dialogBox.setText(notEnoughCredits);
        }
        updateVals();
    }

/*    public final void initialize(ActionEvent actionEvent) {
        updateVals();
    }
*/

    /**
     * Update all on-screen values
     */
    private void updateVals() {
        Player player = NewCharacterControl.player;
        playerShip.setText(player.getShip().getName());
        playerShipCargo.setText(player.getShip().getCargo().length + "");
        playerShipFuel.setText(player.getShip().getFuel() + "");
        playerShipHull.setText(player.getShip().getHull() + "");
        playerShipPrice.setText(yard.sellPrice() + "");
        playerMoney.setText(player.getMoney() + "");
    }


    @Override
    public final void initialize(URL location, ResourceBundle resources) {
        updateVals();
    }
}
