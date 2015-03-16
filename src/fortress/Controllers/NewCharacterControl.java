package fortress.Controllers;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import fortress.Models.Flea;
import fortress.Models.Player;
import fortress.Models.Ship;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Controller class for the "New Player" screen.
 */
public class NewCharacterControl extends fortress.Main {
    public Button acceptBtn;
    public Button exitBtn;
    public TextField playerName;
    public TextField pilotPointsInput;
    public TextField fighterPointsInput;
    public TextField traderPointsInput;
    public TextField engineeringPointsInput;
    public TextField investorPointsInput;
    public TextField remainingSkillPoints;

    private static final int MAX_SKILLS = 15;
    public static Player player;
    public static Ship ship;

    /**
     * Parses the player input and generates an appropriate character.
     * Generates the universe.
     * @param actionEvent
     */
    public final void acceptPlayerInputAction(ActionEvent actionEvent) throws IOException {
        String name = playerName.getCharacters().toString();
        int pilot = Integer.parseInt(pilotPointsInput.getCharacters().toString());
        int fighter = Integer.parseInt(fighterPointsInput.getCharacters().toString());
        int trader = Integer.parseInt(traderPointsInput.getCharacters().toString());
        int engineering = Integer.parseInt(engineeringPointsInput.getCharacters().toString());
        int investor = Integer.parseInt(investorPointsInput.getCharacters().toString());


        player = Player.getInstance(pilot, fighter, trader, engineering, investor, name);
        ship = new Flea(5, 8, "Flea");
        player.setShip(ship);

        player.setSolarSystem(system[0]);

        Parent universe = FXMLLoader.load(getClass().getResource("../Views/universe.fxml"));
        stage.setScene(new Scene(universe));
        stage.show();
    }

    /**
     * When Cancel button is clicked, creates universe and closes screen.
     * @param actionEvent
     */
    public final void cancelScreen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/SpaceTrader.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }

    /**
     * Adds to pilot skill and decrements from remaining skill points.
     * @param actionEvent
     */
    public final void addToPilot(ActionEvent actionEvent) {
        if (Integer.parseInt(remainingSkillPoints.getCharacters().toString()) > 0) {
            pilotPointsInput.setText(Integer.parseInt(pilotPointsInput.getCharacters().toString()) + 1 + "");
            int current = Integer.parseInt(remainingSkillPoints.getCharacters().toString());
            current--;
            remainingSkillPoints.setText(Integer.valueOf(current).toString());
        }
    }

    /**
     * Adds to fighter skill and decrements from remaining skill points.
     * @param actionEvent
     */
    public final void addToFighter(ActionEvent actionEvent) {
        if (Integer.parseInt(remainingSkillPoints.getCharacters().toString()) > 0) {
            fighterPointsInput.setText(Integer.parseInt(fighterPointsInput.getCharacters().toString()) + 1 + "");
            int current = Integer.parseInt(remainingSkillPoints.getCharacters().toString());
            current--;
            remainingSkillPoints.setText(Integer.valueOf(current).toString());
        }
    }

    /**
     * Adds to trader skill and decrements from remaining skill points.
     * @param actionEvent
     */
    public final void addToTrader(ActionEvent actionEvent) {
        if (Integer.parseInt(remainingSkillPoints.getCharacters().toString()) > 0) {
            traderPointsInput.setText(Integer.parseInt(traderPointsInput.getCharacters().toString()) + 1 + "");
            int current = Integer.parseInt(remainingSkillPoints.getCharacters().toString());
            current--;
            remainingSkillPoints.setText(Integer.valueOf(current).toString());
        }
    }

    /**
     * Adds to engineering skill and decrements from remaining skill points.
     * @param actionEvent
     */
    public final void addToEngineer(ActionEvent actionEvent) {
        if (Integer.parseInt(remainingSkillPoints.getCharacters().toString()) > 0) {
            engineeringPointsInput.setText(Integer.parseInt(engineeringPointsInput.getCharacters().toString()) + 1 + "");
            int current = Integer.parseInt(remainingSkillPoints.getCharacters().toString());
            current--;
            remainingSkillPoints.setText(Integer.valueOf(current).toString());
        }
    }

    /**
     * Adds to investor skill and decrements from remaining skill points.
     * @param actionEvent
     */
    public final void addToInvestor(ActionEvent actionEvent) {
        if (Integer.parseInt(remainingSkillPoints.getCharacters().toString()) > 0) {
            investorPointsInput.setText(Integer.parseInt(investorPointsInput.getCharacters().toString()) + 1 + "");
            int current = Integer.parseInt(remainingSkillPoints.getCharacters().toString());
            current--;
            remainingSkillPoints.setText(Integer.valueOf(current).toString());
        }
    }

    /**
     * Subtracts pilot skill and increments remaining skill points.
     * @param actionEvent
     */
    public final void subtractFromPilot(ActionEvent actionEvent) {
        if (Integer.parseInt(remainingSkillPoints.getCharacters().toString()) < MAX_SKILLS &&
            Integer.parseInt(pilotPointsInput.getCharacters().toString()) != 0) {
            pilotPointsInput.setText(Integer.parseInt(pilotPointsInput.getCharacters().toString()) - 1 + "");
            int current = Integer.parseInt(remainingSkillPoints.getCharacters().toString());
            current++;
            remainingSkillPoints.setText(Integer.valueOf(current).toString());
        }
    }

    /**
     * Subtracts fighter skill and increments remaining skill points.
     * @param actionEvent
     */
    public final void subtractFromFighter(ActionEvent actionEvent) {
        if (Integer.parseInt(remainingSkillPoints.getCharacters().toString()) < MAX_SKILLS &&
            Integer.parseInt(fighterPointsInput.getCharacters().toString()) != 0) {
            fighterPointsInput.setText(Integer.parseInt(fighterPointsInput.getCharacters().toString()) - 1 + "");
            int current = Integer.parseInt(remainingSkillPoints.getCharacters().toString());
            current++;
            remainingSkillPoints.setText(Integer.valueOf(current).toString());
        }
    }


    /**
     * Subtracts trader skill and increments remaining skill points.
     * @param actionEvent
     */
    public final void subtractFromTrader(ActionEvent actionEvent) {
        if (Integer.parseInt(remainingSkillPoints.getCharacters().toString()) < MAX_SKILLS &&
            Integer.parseInt(traderPointsInput.getCharacters().toString()) != 0) {
            traderPointsInput.setText(Integer.parseInt(traderPointsInput.getCharacters().toString()) - 1 + "");
            int current = Integer.parseInt(remainingSkillPoints.getCharacters().toString());
            current++;
            remainingSkillPoints.setText(Integer.valueOf(current).toString());
        }
    }

    /**
     * Subtracts engineer skill and increments remaining skill points.
     * @param actionEvent
     */
    public final void subtractFromEngineer(ActionEvent actionEvent) {
        if ((Integer.parseInt(remainingSkillPoints.getCharacters().toString()) < MAX_SKILLS) &&
            (Integer.parseInt(engineeringPointsInput.getCharacters().toString()) != 0)) {
            engineeringPointsInput.setText(Integer.parseInt(engineeringPointsInput.getCharacters().toString()) - 1 + "");
            int current = Integer.parseInt(remainingSkillPoints.getCharacters().toString());
            current++;
            remainingSkillPoints.setText(Integer.valueOf(current).toString());
        }
    }

    /**
     * Subtracts investor skill and increments remaining skill points.
     * @param actionEvent
     */
    public final void subtractFromInvestor(ActionEvent actionEvent) {
        if (Integer.parseInt(remainingSkillPoints.getCharacters().toString()) < MAX_SKILLS &&
            Integer.parseInt(investorPointsInput.getCharacters().toString()) != 0) {
            investorPointsInput.setText(Integer.parseInt(investorPointsInput.getCharacters().toString()) - 1 + "");
            int current = Integer.parseInt(remainingSkillPoints.getCharacters().toString());
            current++;
            remainingSkillPoints.setText(Integer.valueOf(current).toString());
        }
    }


}
