package fortress.Models;

import java.io.Serializable;

/**
 * Solar System class that generates a single planet with a name, position, tech level, and resource level
 * Created by Anthony on 9/19/14.
 */
public class SolarSystem implements Serializable {
    private String name;
    private int x;
    private int y;
    private int tech;
    private int resource;

    /*
    Tech Level:
    0 Pre-Agriculture
    1 Agriculture
    2 Medieval
    3 Renaissance
    4 Early Industrial
    5 Industrial
    6 Post-Industrial
    7 Hi-Tech

    Resource Level:
    0 NO SPECIAL RESOURCES (the most common)
    1 MINERAL RICH
    2 MINERAL POOR
    3 DESERT
    4 LOTS OF WATER
    5 RICH SOIL
    6 POOR SOIL
    7 RICH FAUNA
    8 LIFELESS
    9 WEIRD MUSHROOMS
    10 LOTS OF HERBS
    11 ARTISTIC
    12 WARLIKE
     */

    /**
     * Generates the solar system
     * @param n name of the planet
     * @param xPos x position
     * @param yPos y position
     * @param t technology value
     * @param r resource value
     */
    public SolarSystem(String n, int xPos, int yPos, int t, int r) {
        name = n;
        x = xPos;
        y = yPos;
        tech = t;
        resource = r;
    }

    /**
     * Getter for name of planet
     * @return name
     */
    public final String getName() {
        return name;
    }

    /**
     * Getter for x-coordinate of planet
     * @return x
     */
    public final int getX() {
        return x;
    }

    /**
     * Getter for y-coordinate of planet
     * @return y
     */
    public final int getY() {
        return y;
    }

    /**
     * Getter for tech level of planet
     * @return tech
     */
    public final int getTech() {
        return tech;
    }

    /**
     * Getter for resource level of planet
     * @return resource
     */
    public final int getResource() {
        return resource;
    }

    /**
     * Setter for name of planet
     * @param n name
     */
    public final void setName(String n) {
        name = n;
    }

    /**
     * Setter for x-coordinate of planet
     * @param xPos x-position
     */
    public final void setX(int xPos) {
        x = xPos;
    }

    /**
     * Setter for y-coordinate of planet
     * @param yPos y-position
     */
    public final void setY(int yPos) {
        y = yPos;
    }

    /**
     * Setter for tech level of planet
     * @param t tech
     */
    public final void setTech(int t) {
        tech = t;
    }

    /**
     * Setter for resource level of planet
     * @param r resource
     */
    public final void setResource(int r) {
        resource = r;
    }

    /**
     * To-string of class that will show planet has been created
     * @return
     */
    @Override
    public final String toString() {
        return "Solar system " + name + " has been created at (" + x + ", " + y
                + ") and with a tech level of " + tech + " and a resource level of " + resource + ".";
    }
}
