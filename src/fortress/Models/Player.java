package fortress.Models;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

import static java.util.Arrays.copyOf;

/**
 * Represents a character with skeellez.
 * @author Arvind
 */
public final class Player implements Serializable {


    private static Player instance = null;
    // 0 = pilot
    // 1 = fighter
    // 2 = trader
    // 3 = engineer
    // 4 = investor
	private int[] skills;
    private int exp;
	private String name;
    public static final int INITIAL_MONEY = 50000;
    private Ship ship;
    protected SolarSystem currentPlanet;
    private int money;
    private int level;
	/**
	 * Creates a new character.
	 *
	 * @param pilot
	 * @param fighter
	 * @param trader
	 * @param engineer
	 * @param investor
	 * @param playerName
	 */
	private Player(int pilot, int fighter, int trader, int engineer, int investor, String playerName) {
		skills = new int[]{pilot, fighter, trader, engineer, investor};
		name = playerName;
        money = INITIAL_MONEY;
        exp = 0;
        level = 1;
	}

    /**
     * Creates new instance of player if null; if not, returns current instance
     * @return current instance of player
     */
    public static Player getInstance(int pilot, int fighter, int trader, int engineer, int investor, String name) {
        if (instance == null) {
            instance = new Player(pilot, fighter, trader, engineer, investor, name);
            return instance;
        }
        return instance;
    }

	/**
	 * @return current value of skills
	 */
	public int[] getSkills() {
		return skills;
	}

	/**
	 * @return current value of name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Resets value of skills, returns OLD VALUE of skills
	 * @param pSkills
	 * @return
	 */
	public void setSkills(int[] pSkills) {
		skills = copyOf(pSkills, pSkills.length);
	}

	/**
	 * Resets value of name, returns OLD VALUE of name
	 * @param playerName
	 * @return
	 */
	public String setName(String playerName) {
		String temp = name;
		name = playerName;
		return temp;
	}

    /**
     * Sets the player's ship to a given ship
     * @param s The ship to set to
     * @return new Ship
     */
    public Ship setShip(Ship s) {
        ship = s;
        return ship;
    }

    /**
     * Getter for ship
     * @return the Ship
     */
    public Ship getShip() {
        return ship;
    }


    /**
     * Sets the player's current system
     * Updates ship fuel appropriately
     * @param system system to set
     * @return Dialog box display
     */
    public String setSolarSystem(SolarSystem system) {
        if (currentPlanet != null) {
            int x1 = currentPlanet.getX();
            int y1 = currentPlanet.getY();
            int x2 = system.getX();
            int y2 = system.getY();
            int distance = (int) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
            distance -= (skills[0] / 3);
            if (distance == 0) {
                return "Already on planet!";
            }
            if (ship.getFuel() < distance) {
                return "Not enough fuel!";
            }
            ship.setFuel(ship.getFuel() - distance);
            currentPlanet = system;
            if(addExp(3)) {
                return "Player is level " + level + "!";
            }
            return "Successful transport!";
        }
        currentPlanet = system;
        return "";
    }

    /**
     * Getter for current planet
     * @return current planet
     */
    public SolarSystem getSolarSystem() {
        return currentPlanet;
    }

    /**
     * Getter for money
     * @return current money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Adds experience points
     * @param x number of experience points to add
     * @return true if level up, false otherwise
     */
    public boolean addExp(int x) {
        exp += x;
        if (exp >= 30 && x == 3) { // Add to pilot and engineer if level up by flying
            skills[0]++;
            skills[3]++;
            level++;
            exp = 0;
            return true;
        }
        if (exp >= 30 && x == 5) { // Add to trader if level up by trading
            skills[2] += 2;
            level++;
            exp = 0;
            return true;
        }
        return false;
    }

    /**
     * Getter for level
     * @return level
     */
    public int getLevel() {
        return level;
    }
    /**
     * Setter for money
     * @param m new money value
     */
    public void setMoney(int m) {
        money = m;
    }

    @Override
    public String toString() {
        return "You created " + name + " with " + INITIAL_MONEY + " credits.";
    }
}