package fortress.Models;

import java.io.Serializable;

import static java.util.Arrays.copyOf;

/**
 * Represents a ship and its attributes
 *
 * @author Arvind
 */
public class Ship implements Serializable {

    private int hull;
    private TradeGoods[] cargo;
    // Filled cargo spaces
    private int filled;
    private String name;
    private int fuel;

    public int fuelUpgrade;
    public int hullUpgrade;
    public int cargoUpgrade;
    private boolean merc;

    /**
     * Constructs a ship.
     * @param h desired hull level of ship
     * @param capacity max capacity of cargo
     * @param n name of ship
     */
    public Ship(int h, int capacity, String n) {
        hull = h;
        this.cargo = new TradeGoods[capacity];
        name = n;
        filled = 0;
        fuelUpgrade = 2;
        hullUpgrade = 2;
        cargoUpgrade = 2;

    }

    /**
     * Getter for cargo array
     * @return cargo array
     */
    public final TradeGoods[] getCargo() {
        return cargo;
    }

    /**
     * Getter for hull
     * @return hull
     */
    public final int getHull() {
        return hull;
    }

    /**
     * Getter for filled cargo spaces
     * @return filled cargo spaces
     */
    public final int getFilled() {
        return filled;
    }

    /**
     * Getter for fuel
     * @return fuel
     */
    public final int getFuel() { return fuel; }

    /**
     * getter for fuel upgrade
     * @return
     */
    public final int getFuelUpgrade(){ return fuelUpgrade;}

    /**
     * getter for hullUpgrade;
     * @return
     */
    public final int getHullUpgrade(){ return hullUpgrade;}

    /**
     * getter for name;
     * @return
     */
    public final String getName(){ return name;}

    /**
     * Getter for filled cargo spaces
     * @param f fuel
     * @return filled cargo spaces
     */
    public final void setFuel(int f) {
        fuel = f;
    }

    /**
     * setter for hull
     * @param h hull
     */
    public final void setHull(int h){hull = h;}

    /**
     * setter for cargo
     * @param c cargo
     */
    public final void setCargo(TradeGoods[] c) {
        cargo = copyOf(c, c.length);
    }

    /**
     * setter for Fuel Upgrade
     * @param fuelUp fuel upgrade
     */
    public final void setFuelUpgrade(int fuelUp){fuelUpgrade = fuelUp;}

    /**
     * setter for hull upgrade
     * @param hullUp
     */
    public final void setHullUpgrade(int hullUp){ hullUpgrade = hullUp;}

    /**
     * Adds newCargo to cargo array if there is remaining space.
     * If not, returns null.
     * @param newCargo new cargo to be added
     * @return newCargo if successful add, null if not
     */
    public final TradeGoods addCargo(TradeGoods newCargo) {
        // Cargo spaces remaining
        if (filled < cargo.length) {
            cargo[filled] = newCargo;
            filled++;
            justifyCargo();
            return newCargo;
        }
        // Full cargo
        return null;
    }

    /**
     * Removes removeCargo from cargo array.
     * Shifts array values to preserve cargo order.
     * @param removeCargo cargo to be removed
     * @return removeCargo if successful remove, null if not
     */
    public final TradeGoods removeCargo(TradeGoods removeCargo) {
        int index = -1;
        for (int i = 0; i < filled; i++) {
            if (cargo[i] != null && cargo[i].equals(removeCargo)) {
                index = i;
            }
        }
        if (index != -1) {
            cargo[index] = null;
            filled--;
            justifyCargo();
            return removeCargo;
        }
        return null;
    }

    /**
     * Makes the cargo "justified" with respect to the first index
     */
    private void justifyCargo() {
        TradeGoods[] temp = new TradeGoods[cargo.length];
        int current = 0;
        for (TradeGoods t:cargo) {
            if (t != null) {
                temp[current] = t;
                current++;
            }
        }
    }

    public void setMerc(boolean merc) {
        this.merc = merc;
    }

    public boolean getMerc() {
        return merc;
    }
}
