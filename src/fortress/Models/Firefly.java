package fortress.Models;

/**
 * Created by Anthony on 11/6/14.
 */
public class Firefly extends Ship {
    private static final int DEFAULT_FUEL = 400;
    /**
     * Constructs a ship.
     *
     * @param hull     desired hull level of ship
     * @param capacity max capacity of cargo
     * @param name     name of ship
     */
    public Firefly(int hull, int capacity, String name) {
        super(hull, capacity, name);
        setFuel(DEFAULT_FUEL);
    }
}

