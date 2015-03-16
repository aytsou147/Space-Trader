package fortress.Controllers;

import fortress.Models.MarketPlace;
import fortress.Models.Player;
import fortress.Models.TradeGoods;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.media.AudioClip;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the market screen.
 */
public class MarketControl extends fortress.Main implements Initializable{

    public TextField planetName;
    public TextField playerMoney;
    public TextField techLevel;
    public TextField itemP1;
    public TextField itemP2;
    public TextField itemP3;
    public TextField itemP4;
    public TextField itemP5;
    public TextField itemP6;
    public TextField itemP7;
    public TextField itemP8;
    public TextField price1;
    public TextField price2;
    public TextField price3;
    public TextField price4;
    public TextField price5;
    public TextField price6;
    public TextField price7;
    public TextField price8;
    public TextField price9;
    public TextField price10;
    public TextField dialog;
    public TextField merchantItem1;
    public TextField merchantItem2;
    public TextField merchantItem3;
    public TextField merchantItem4;
    public TextField merchantItem5;
    public TextField merchantItem6;
    public TextField merchantItem7;
    public TextField merchantItem8;
    public TextField merchantItem9;
    public TextField merchantItem10;
    public TextField merchantQt1;
    public TextField merchantQt2;
    public TextField merchantQt3;
    public TextField merchantQt4;
    public TextField merchantQt5;
    public TextField merchantQt6;
    public TextField merchantQt7;
    public TextField merchantQt8;
    public TextField merchantQt9;
    public TextField merchantQt10;
    private String noItem = "No item in cargo slot!";
    private String fullCargo = "Cargo is full!";
    private String notEnoughCredits = "Not enough credits!";
    private String outOfStock = "Out of stock!";
    private String successPurch = "Successful Purchase!";
    private String successSale = "Successful Sale!";
    private String water = "Water";
    private String furs = "Furs";
    private String food = "Food";
    private String ore = "Ore";
    private String games = "Games";
    private String firearms = "Firearms";
    private String medicine = "Medicine";
    private String machines = "Machines";
    private String narcotics = "Narcotics";
    private String robots = "Robots";

    private MarketPlace market = new MarketPlace();
    private AudioClip ac;

    /**
     * Goes back to universe screen
     * @param actionEvent
     * @throws IOException
     */
    public final void changePlanet (ActionEvent actionEvent) throws IOException {
        Parent universe = FXMLLoader.load(getClass().getResource("../Views/universe.fxml"));
        stage.setScene(new Scene(universe));
        stage.show();
    }

    /**
     * Goes to shipyard if high enough tech level
     * @param actionEvent
     * @throws IOException
     */
    public final void toShipYard(ActionEvent actionEvent) throws IOException {
        if (NewCharacterControl.player.getSolarSystem().getTech() >= 3) {
            Parent universe = FXMLLoader.load(getClass().getResource("../Views/shipyardScreen.fxml"));
            stage.setScene(new Scene(universe));
            stage.show();
        } else {
            dialog.setText("No shipyard here!");
        }
    }

    //talk to NPC button press initializes merchant inventory
    /*public final void initializeValues (ActionEvent actionEvent) throws IOException {

    }*/

    /**
     * Initializes stuff on screen when opened
     * @param location
     * @param resources
     */
    @Override
    public final void initialize(URL location, ResourceBundle resources) {
        ac = new AudioClip(getClass().getResource("../Sounds/money.mp3").toString());
        updateCargo();
        updateMoney();
        updatePlanet();
        updateMerchant();
    }

    /**
     * Updates the player's cargo on the screen.
     */
    private void updateCargo() {
        Player player = NewCharacterControl.player;
        TradeGoods[] playerCargo = player.getShip().getCargo();
        if (playerCargo[0] != null) {
            itemP1.setText(playerCargo[0].getName());
        }
        else {
            itemP1.setText("");
        }
        if (playerCargo[1] != null) {
            itemP2.setText(playerCargo[1].getName());
        }
        else {
            itemP2.setText("");
        }
        if (playerCargo[2] != null) {
            itemP3.setText(playerCargo[2].getName());
        }
        else {
            itemP3.setText("");
        }
        if (playerCargo[3] != null) {
            itemP4.setText(playerCargo[3].getName());
        }
        else {
            itemP4.setText("");
        }
        if (playerCargo.length > 4 && playerCargo[4] != null) {
            itemP5.setText(playerCargo[4].getName());
        }
        else {
            itemP5.setText("");
        }
        if (playerCargo.length > 5 && playerCargo[5] != null) {
            itemP6.setText(playerCargo[5].getName());
        }
        else {
            itemP6.setText("");
        }
        if (playerCargo.length > 6 && playerCargo[6] != null) {
            itemP7.setText(playerCargo[6].getName());
        }
        else {
            itemP7.setText("");
        }
        if (playerCargo.length > 7 &&playerCargo[7] != null) {
            itemP8.setText(playerCargo[7].getName());
        }
        else if (playerCargo.length > 8) {
            itemP8.setText("");
        }
    }

    /**
     * Updates the player's money on the screen.
     */
    private void updateMoney() {
        Player player = NewCharacterControl.player;
        playerMoney.setText(player.getMoney() + "");
    }

    /**
     * Updates planet data on the screen.
     */
    private void updatePlanet() {
        Player player = NewCharacterControl.player;
        planetName.setText(player.getSolarSystem().getName());
        techLevel.setText("Tech lvl " + player.getSolarSystem().getTech());
    }

    /**
     * Updates merchant quantities and prices.
     */
    private void updateMerchant() {
        int[] quantities = market.getQuantities();
        int[] prices = market.getPrices();
        merchantQt1.setText(quantities[0] + "");
        merchantQt2.setText(quantities[1] + "");
        merchantQt3.setText(quantities[2] + "");
        merchantQt4.setText(quantities[3] + "");
        merchantQt5.setText(quantities[4] + "");
        merchantQt6.setText(quantities[5] + "");
        merchantQt7.setText(quantities[6] + "");
        merchantQt8.setText(quantities[7] + "");
        merchantQt9.setText(quantities[8] + "");
        merchantQt10.setText(quantities[9] + "");
        price1.setText(prices[0] + "");
        price2.setText(prices[1] + "");
        price3.setText(prices[2] + "");
        price4.setText(prices[3] + "");
        price5.setText(prices[4] + "");
        price6.setText(prices[5] + "");
        price7.setText(prices[6] + "");
        price8.setText(prices[7] + "");
        price9.setText(prices[8] + "");
        price10.setText(prices[9] + "");
    }

    /**
     * Sell cargo space 1
     * @param actionEvent
     * @throws IOException
     */
    public final void sellSpace1 (ActionEvent actionEvent) throws IOException {
        String good = itemP1.getCharacters().toString();
        if (good.equals("")) {
            dialog.setText(noItem);
        } else {
            if (good.equals(water)) {
                market.sellItem(TradeGoods.WATER);
            } else if (good.equals(furs)) {
                market.sellItem(TradeGoods.FURS);
            } else if (good.equals(food)) {
                market.sellItem(TradeGoods.FOOD);
            } else if (good.equals(ore)) {
                market.sellItem(TradeGoods.ORE);
            } else if (good.equals(games)) {
                market.sellItem(TradeGoods.GAMES);
            } else if (good.equals(firearms)) {
                market.sellItem(TradeGoods.FIREARMS);
            } else if (good.equals(medicine)) {
                market.sellItem(TradeGoods.MEDICINE);
            } else if (good.equals(machines)) {
                market.sellItem(TradeGoods.MACHINES);
            } else if (good.equals(narcotics)) {
                market.sellItem(TradeGoods.NARCOTICS);
            } else if (good.equals(robots)) {
                market.sellItem(TradeGoods.ROBOTS);
            }
            dialog.setText(successSale);
            ac.play();
        }

        updateCargo();
        updateMoney();
        updateMerchant();
    }

    /**
     * Sell cargo space 2
     * @param actionEvent
     * @throws IOException
     */
    public final void sellSpace2 (ActionEvent actionEvent) throws IOException {
        String good = itemP2.getCharacters().toString();
        if (good.equals("")) {
            dialog.setText(noItem);
        } else {
            if (good.equals(water)) {
                market.sellItem(TradeGoods.WATER);
            } else if (good.equals(furs)) {
                market.sellItem(TradeGoods.FURS);
            } else if (good.equals(food)) {
                market.sellItem(TradeGoods.FOOD);
            } else if (good.equals(ore)) {
                market.sellItem(TradeGoods.ORE);
            } else if (good.equals(games)) {
                market.sellItem(TradeGoods.GAMES);
            } else if (good.equals(firearms)) {
                market.sellItem(TradeGoods.FIREARMS);
            } else if (good.equals(medicine)) {
                market.sellItem(TradeGoods.MEDICINE);
            } else if (good.equals(machines)) {
                market.sellItem(TradeGoods.MACHINES);
            } else if (good.equals(narcotics)) {
                market.sellItem(TradeGoods.NARCOTICS);
            } else if (good.equals(robots)) {
                market.sellItem(TradeGoods.ROBOTS);
            }
            dialog.setText(successSale);
            ac.play();
        }
        updateCargo();
        updateMoney();
        updateMerchant();
    }

    /**
     * Sell cargo space 3
     * @param actionEvent
     * @throws IOException
     */
    public final void sellSpace3 (ActionEvent actionEvent) throws IOException {
        String good = itemP3.getCharacters().toString();
        if (good.equals("")) {
            dialog.setText(noItem);
        } else {
            if (good.equals(water)) {
                market.sellItem(TradeGoods.WATER);
            } else if (good.equals(furs)) {
                market.sellItem(TradeGoods.FURS);
            } else if (good.equals(food)) {
                market.sellItem(TradeGoods.FOOD);
            } else if (good.equals(ore)) {
                market.sellItem(TradeGoods.ORE);
            } else if (good.equals(games)) {
                market.sellItem(TradeGoods.GAMES);
            } else if (good.equals(firearms)) {
                market.sellItem(TradeGoods.FIREARMS);
            } else if (good.equals(medicine)) {
                market.sellItem(TradeGoods.MEDICINE);
            } else if (good.equals(machines)) {
                market.sellItem(TradeGoods.MACHINES);
            } else if (good.equals(narcotics)) {
                market.sellItem(TradeGoods.NARCOTICS);
            } else if (good.equals(robots)) {
                market.sellItem(TradeGoods.ROBOTS);
            }
            dialog.setText(successSale);
            ac.play();
        }
        updateCargo();
        updateMoney();
        updateMerchant();
    }

    /**
     * Sell cargo space 4
     * @param actionEvent
     * @throws IOException
     */
    public final void sellSpace4 (ActionEvent actionEvent) throws IOException {
        String good = itemP4.getCharacters().toString();
        if (good.equals("")) {
            dialog.setText(noItem);
        } else {
            if (good.equals(water)) {
                market.sellItem(TradeGoods.WATER);
            } else if (good.equals(furs)) {
                market.sellItem(TradeGoods.FURS);
            } else if (good.equals(food)) {
                market.sellItem(TradeGoods.FOOD);
            } else if (good.equals(ore)) {
                market.sellItem(TradeGoods.ORE);
            } else if (good.equals(games)) {
                market.sellItem(TradeGoods.GAMES);
            } else if (good.equals(firearms)) {
                market.sellItem(TradeGoods.FIREARMS);
            } else if (good.equals(medicine)) {
                market.sellItem(TradeGoods.MEDICINE);
            } else if (good.equals(machines)) {
                market.sellItem(TradeGoods.MACHINES);
            } else if (good.equals(narcotics)) {
                market.sellItem(TradeGoods.NARCOTICS);
            } else if (good.equals(robots)) {
                market.sellItem(TradeGoods.ROBOTS);
            }
            dialog.setText(successSale);
            ac.play();
        }
        updateCargo();
        updateMoney();
        updateMerchant();
    }

    /**
     * Sell cargo space 5
     * @param actionEvent
     * @throws IOException
     */
    public final void sellSpace5 (ActionEvent actionEvent) throws IOException {
        String good = itemP5.getCharacters().toString();
        if (good.equals("")) {
            dialog.setText(noItem);
        } else {
            if (good.equals(water)) {
                market.sellItem(TradeGoods.WATER);
            } else if (good.equals(furs)) {
                market.sellItem(TradeGoods.FURS);
            } else if (good.equals(food)) {
                market.sellItem(TradeGoods.FOOD);
            } else if (good.equals(ore)) {
                market.sellItem(TradeGoods.ORE);
            } else if (good.equals(games)) {
                market.sellItem(TradeGoods.GAMES);
            } else if (good.equals(firearms)) {
                market.sellItem(TradeGoods.FIREARMS);
            } else if (good.equals(medicine)) {
                market.sellItem(TradeGoods.MEDICINE);
            } else if (good.equals(machines)) {
                market.sellItem(TradeGoods.MACHINES);
            } else if (good.equals(narcotics)) {
                market.sellItem(TradeGoods.NARCOTICS);
            } else if (good.equals(robots)) {
                market.sellItem(TradeGoods.ROBOTS);
            }
            dialog.setText(successSale);
            ac.play();
        }
        updateCargo();
        updateMoney();
        updateMerchant();
    }

    /**
     * Sell cargo space 6
     * @param actionEvent
     * @throws IOException
     */
    public final void sellSpace6 (ActionEvent actionEvent) throws IOException {
        String good = itemP6.getCharacters().toString();
        if (good.equals("")) {
            dialog.setText(noItem);
        } else {
            if (good.equals(water)) {
                market.sellItem(TradeGoods.WATER);
            } else if (good.equals(furs)) {
                market.sellItem(TradeGoods.FURS);
            } else if (good.equals(food)) {
                market.sellItem(TradeGoods.FOOD);
            } else if (good.equals(ore)) {
                market.sellItem(TradeGoods.ORE);
            } else if (good.equals(games)) {
                market.sellItem(TradeGoods.GAMES);
            } else if (good.equals(firearms)) {
                market.sellItem(TradeGoods.FIREARMS);
            } else if (good.equals(medicine)) {
                market.sellItem(TradeGoods.MEDICINE);
            } else if (good.equals(machines)) {
                market.sellItem(TradeGoods.MACHINES);
            } else if (good.equals(narcotics)) {
                market.sellItem(TradeGoods.NARCOTICS);
            } else if (good.equals(robots)) {
                market.sellItem(TradeGoods.ROBOTS);
            }
            dialog.setText(successSale);
            ac.play();
        }
        updateCargo();
        updateMoney();
        updateMerchant();
    }

    /**
     * Sell cargo space 7
     * @param actionEvent
     * @throws IOException
     */
    public final void sellSpace7 (ActionEvent actionEvent) throws IOException {
        String good = itemP7.getCharacters().toString();
        if (good.equals("")) {
            dialog.setText(noItem);
        } else {
            if (good.equals(water)) {
                market.sellItem(TradeGoods.WATER);
            } else if (good.equals(furs)) {
                market.sellItem(TradeGoods.FURS);
            } else if (good.equals(food)) {
                market.sellItem(TradeGoods.FOOD);
            } else if (good.equals(ore)) {
                market.sellItem(TradeGoods.ORE);
            } else if (good.equals(games)) {
                market.sellItem(TradeGoods.GAMES);
            } else if (good.equals(firearms)) {
                market.sellItem(TradeGoods.FIREARMS);
            } else if (good.equals(medicine)) {
                market.sellItem(TradeGoods.MEDICINE);
            } else if (good.equals(machines)) {
                market.sellItem(TradeGoods.MACHINES);
            } else if (good.equals(narcotics)) {
                market.sellItem(TradeGoods.NARCOTICS);
            } else if (good.equals(robots)) {
                market.sellItem(TradeGoods.ROBOTS);
            }
            dialog.setText(successSale);
            ac.play();
        }
        updateCargo();
        updateMoney();
        updateMerchant();
    }

    /**
     * Sell cargo space 8
     * @param actionEvent
     * @throws IOException
     */
    public final void sellSpace8 (ActionEvent actionEvent) throws IOException {
        String good = itemP8.getCharacters().toString();
        if (good.equals("")) {
            dialog.setText(noItem);
        } else {
            if (good.equals(water)) {
                market.sellItem(TradeGoods.WATER);
            } else if (good.equals(furs)) {
                market.sellItem(TradeGoods.FURS);
            } else if (good.equals(food)) {
                market.sellItem(TradeGoods.FOOD);
            } else if (good.equals(ore)) {
                market.sellItem(TradeGoods.ORE);
            } else if (good.equals(games)) {
                market.sellItem(TradeGoods.GAMES);
            } else if (good.equals(firearms)) {
                market.sellItem(TradeGoods.FIREARMS);
            } else if (good.equals(medicine)) {
                market.sellItem(TradeGoods.MEDICINE);
            } else if (good.equals(machines)) {
                market.sellItem(TradeGoods.MACHINES);
            } else if (good.equals(narcotics)) {
                market.sellItem(TradeGoods.NARCOTICS);
            } else if (good.equals(robots)) {
                market.sellItem(TradeGoods.ROBOTS);
            }
            dialog.setText(successSale);
            ac.play();
        }
        updateCargo();
        updateMoney();
        updateMerchant();
    }



    /**
     * Buy water
     * @param actionEvent
     * @throws IOException
     */
    public final void buyProduct1 (ActionEvent actionEvent) throws IOException {
        int buyResult = market.buyItem(TradeGoods.WATER);
        updateCargo();
        updateMoney();
        updateMerchant();
        String dialogString = "";
        switch (buyResult) {
            case 1: dialogString = notEnoughCredits;
                break;
            case 2: dialogString = fullCargo;
                break;
            case 3: dialogString = outOfStock;
                break;
            case 4: dialogString = successPurch;
                ac.play();
                break;
            case 5: dialogString = "Player is level " + NewCharacterControl.player.getLevel() + "!";
                ac.play();
                break;
        }
        dialog.setText(dialogString);
    }

    /**
     * Buy furs
     * @param actionEvent
     * @throws IOException
     */
    public final void buyProduct2 (ActionEvent actionEvent) throws IOException {
        int buyResult = market.buyItem(TradeGoods.FURS);
        updateCargo();
        updateMoney();
        updateMerchant();
        String dialogString = "";
        switch (buyResult) {
            case 1: dialogString = notEnoughCredits;
                break;
            case 2: dialogString = fullCargo;
                break;
            case 3: dialogString = outOfStock;
                break;
            case 4: dialogString = successPurch;
                ac.play();
                break;
            case 5: dialogString = "Player is level " + NewCharacterControl.player.getLevel() + "!";
                ac.play();
                break;
        }
        dialog.setText(dialogString);
    }
    /**
     * Buy food
     * @param actionEvent
     * @throws IOException
     */
    public final void buyProduct3 (ActionEvent actionEvent) throws IOException {
        int buyResult = market.buyItem(TradeGoods.FOOD);
        updateCargo();
        updateMoney();
        updateMerchant();
        String dialogString = "";
        switch (buyResult) {
            case 1: dialogString = notEnoughCredits;
                break;
            case 2: dialogString = fullCargo;
                break;
            case 3: dialogString = outOfStock;
                break;
            case 4: dialogString = successPurch;
                ac.play();
                break;
            case 5: dialogString = "Player is level " + NewCharacterControl.player.getLevel() + "!";
                ac.play();
                break;
        }
        dialog.setText(dialogString);
    }
    /**
     * Buy ore
     * @param actionEvent
     * @throws IOException
     */
    public final void buyProduct4 (ActionEvent actionEvent) throws IOException {
        int buyResult = market.buyItem(TradeGoods.ORE);
        updateCargo();
        updateMoney();
        updateMerchant();
        String dialogString = "";
        switch (buyResult) {
            case 1: dialogString = notEnoughCredits;
                break;
            case 2: dialogString = fullCargo;
                break;
            case 3: dialogString = outOfStock;
                break;
            case 4: dialogString = successPurch;
                ac.play();
                break;
            case 5: dialogString = "Player is level " + NewCharacterControl.player.getLevel() + "!";
                ac.play();
                break;
        }
        dialog.setText(dialogString);
    }
    /**
     * Buy games
     * @param actionEvent
     * @throws IOException
     */
    public final void buyProduct5 (ActionEvent actionEvent) throws IOException {
        int buyResult = market.buyItem(TradeGoods.GAMES);
        updateCargo();
        updateMoney();
        updateMerchant();
        String dialogString = "";
        switch (buyResult) {
            case 1: dialogString = notEnoughCredits;
                break;
            case 2: dialogString = fullCargo;
                break;
            case 3: dialogString = outOfStock;
                break;
            case 4: dialogString = successPurch;
                ac.play();
                break;
            case 5: dialogString = "Player is level " + NewCharacterControl.player.getLevel() + "!";
                ac.play();
                break;
        }
        dialog.setText(dialogString);
    }
    /**
     * Buy firearms
     * @param actionEvent
     * @throws IOException
     */
    public final void buyProduct6 (ActionEvent actionEvent) throws IOException {
        int buyResult = market.buyItem(TradeGoods.FIREARMS);
        updateCargo();
        updateMoney();
        updateMerchant();
        String dialogString = "";
        switch (buyResult) {
            case 1: dialogString = notEnoughCredits;
                break;
            case 2: dialogString = fullCargo;
                break;
            case 3: dialogString = outOfStock;
                break;
            case 4: dialogString = successPurch;
                ac.play();
                break;
            case 5: dialogString = "Player is level " + NewCharacterControl.player.getLevel() + "!";
                ac.play();
                break;
        }
        dialog.setText(dialogString);
    }
    /**
     * Buy medicine
     * @param actionEvent
     * @throws IOException
     */
    public final void buyProduct7 (ActionEvent actionEvent) throws IOException {
        int buyResult = market.buyItem(TradeGoods.MEDICINE);
        updateCargo();
        updateMoney();
        updateMerchant();
        String dialogString = "";
        switch (buyResult) {
            case 1: dialogString = notEnoughCredits;
                break;
            case 2: dialogString = fullCargo;
                break;
            case 3: dialogString = outOfStock;
                break;
            case 4: dialogString = successPurch;
                ac.play();
                break;
            case 5: dialogString = "Player is level " + NewCharacterControl.player.getLevel() + "!";
                ac.play();
                break;
        }
        dialog.setText(dialogString);
    }
    /**
     * Buy machines
     * @param actionEvent
     * @throws IOException
     */
    public final void buyProduct8 (ActionEvent actionEvent) throws IOException {
        int buyResult = market.buyItem(TradeGoods.MACHINES);
        updateCargo();
        updateMoney();
        updateMerchant();
        String dialogString = "";
        switch (buyResult) {
            case 1: dialogString = notEnoughCredits;
                break;
            case 2: dialogString = fullCargo;
                break;
            case 3: dialogString = outOfStock;
                break;
            case 4: dialogString = successPurch;
                ac.play();
                break;
            case 5: dialogString = "Player is level " + NewCharacterControl.player.getLevel() + "!";
                ac.play();
                break;
        }
        dialog.setText(dialogString);
    }
    /**
     * Buy narcotics
     * @param actionEvent
     * @throws IOException
     */
    public final void buyProduct9 (ActionEvent actionEvent) throws IOException {
        int buyResult = market.buyItem(TradeGoods.NARCOTICS);
        updateCargo();
        updateMoney();
        updateMerchant();
        String dialogString = "";
        switch (buyResult) {
            case 1: dialogString = notEnoughCredits;
                break;
            case 2: dialogString = fullCargo;
                break;
            case 3: dialogString = outOfStock;
                break;
            case 4: dialogString = successPurch;
                ac.play();
                break;
            case 5: dialogString = "Player is level " + NewCharacterControl.player.getLevel() + "!";
                ac.play();
                break;
        }
        dialog.setText(dialogString);
    }
    /**
     * Buy robots
     * @param actionEvent
     * @throws IOException
     */
    public final void buyProduct10 (ActionEvent actionEvent) throws IOException {
        int buyResult = market.buyItem(TradeGoods.ROBOTS);
        updateCargo();
        updateMoney();
        updateMerchant();
        String dialogString = "";
        switch (buyResult) {
            case 1: dialogString = notEnoughCredits;
                break;
            case 2: dialogString = fullCargo;
                break;
            case 3: dialogString = outOfStock;
                break;
            case 4: dialogString = successPurch;
                ac.play();
                break;
            case 5: dialogString = "Player is level " + NewCharacterControl.player.getLevel() + "!";
                ac.play();
                break;
        }
        dialog.setText(dialogString);
    }
}
