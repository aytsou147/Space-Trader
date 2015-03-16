package fortress.Models;

import fortress.Controllers.NewCharacterControl;

import java.io.*;

/**
 * Created by Anthony Tsou
 */
public class Persistence extends fortress.Main {
    /**
     * Save the game
     */
    public final void saveGame() {
        savePlayer();
        saveShip();
    }

    /**
     * Save the player
     */
    private void savePlayer() {
        try {
            FileOutputStream fileOut = new FileOutputStream("player.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(NewCharacterControl.player);
            out.close();
            fileOut.close();
        } catch(IOException i) {
        }
    }

    /**
     * Save the ship
     */
    private void saveShip() {
        try {
            FileOutputStream fileOut = new FileOutputStream("ship.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(NewCharacterControl.ship);
            out.close();
            fileOut.close();
        } catch(IOException i) {
        }
    }

    /**
     * Load the game
     */
    public final void loadGame() {
        loadPlayer();
        loadShip();
    }

    /**
     * Load the player
     */
    private void loadPlayer() {
        try {
            FileInputStream fileIn = new FileInputStream("player.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            NewCharacterControl.player = (Player) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            return;
        } catch(ClassNotFoundException c) {
            return;
        }
    }

    /**
     * Load the ship
     */
    private void loadShip() {
        try {
            FileInputStream fileIn = new FileInputStream("ship.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            NewCharacterControl.ship = (Ship) in.readObject();
            in.close();
            fileIn.close();
        } catch(IOException i) {
            return;
        } catch(ClassNotFoundException c) {
            return;
        }
    }
}
