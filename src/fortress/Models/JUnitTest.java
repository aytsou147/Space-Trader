package fortress.Models;

import fortress.Controllers.NewCharacterControl;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * JUnits Tests
 *
 * Arvind: addCargo();
 * Anthony: setSolarSystem(SolarSystem system);
 * Thao: buyShip(String shipName);
 * Ishaan:
 */
public class JUnitTest extends fortress.Main {

    private static final String DEFAULT_NAME = "TestName";
    private static final int INITIAL_MONEY = 1000;
    private static final int DEFAULT_TIMEOUT = 200;
    private static final String LUIGI = "Luigiworld";
    private static final String ZELDA = "Zeldaworld";
    private static final String FLEA = "Flea";

    /**
     * Initializes objects for testing
     */
    @BeforeClass
    public static void setUp() {
        Player player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        SolarSystem[] system = new SolarSystem[NUM_PLANETS];
        system[8] = new SolarSystem(LUIGI, 10, 10, 7, 7);
        system[9] = new SolarSystem(ZELDA, 12, 12, 5, 8);
        player.currentPlanet = system[8];
    }

    /**
     * Tests add cargo
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testAddCargo1() {
        Ship testShip = new Ship(5, 5, DEFAULT_NAME);
        testShip.addCargo(TradeGoods.FIREARMS);
        TradeGoods[] cargo = testShip.getCargo();

        assertTrue(cargo[0].getName().equals("Firearms"));
        for (int i = 1; i < cargo.length; i++) {
            assertTrue(cargo[i] == null);
        }
    }

    /**
     * Tests add cargo
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testAddCargo2() {
        Ship testShip = new Ship(5, 5, DEFAULT_NAME);
        for (int i = 0; i < testShip.getCargo().length; i++) {
			testShip.addCargo(TradeGoods.WATER);
        }
        TradeGoods[] cargo = testShip.getCargo();
        for (int i = 0; i < cargo.length; i++) {
            assertTrue(cargo[i].getName().equals("Water"));
        }
    }

    /**
     * Tests add cargo
     */
	@Test (timeout = DEFAULT_TIMEOUT)
    public final void testAddCargo3() {
        Ship testShip = new Ship(5, 5, DEFAULT_NAME);
        for (int i = 0; i < testShip.getCargo().length; i++) {
			testShip.addCargo(TradeGoods.WATER);
        }
		testShip.addCargo(TradeGoods.FIREARMS);
        TradeGoods[] cargo = testShip.getCargo();
        for (int i = 0; i < cargo.length; i++) {
            assertTrue(cargo[i].getName().equals("Water"));
        }
    }

    /**
     * Tests add cargo
     */
	@Test (timeout = DEFAULT_TIMEOUT)
    public final void testAddCargo4() {
        Ship testShip = new Ship(5, 5, DEFAULT_NAME);
		TradeGoods good = null;
        for (int i = 0; i < testShip.getCargo().length; i++) {
			good = testShip.addCargo(TradeGoods.WATER);
        }
        assertTrue(good.getName().equals("Water"));
    }

    /**
     * Tests add cargo
     */
	@Test (timeout = DEFAULT_TIMEOUT)
	public final void testAddCargo5() {
        Ship testShip = new Ship(5, 5, DEFAULT_NAME);
		TradeGoods good;
        for (int i = 0; i < testShip.getCargo().length; i++) {
			testShip.addCargo(TradeGoods.WATER);
        }
		good = testShip.addCargo(TradeGoods.FIREARMS);
        assertTrue(good == null);
    }

    /**
     * Tests add cargo
     */
	@Test (timeout = DEFAULT_TIMEOUT)
    public final void testAddCargo6() {
        Ship testShip = new Ship(5, 5, DEFAULT_NAME);
		TradeGoods[] goods = testShip.getCargo();
		for (int i = 0; i < testShip.getCargo().length; i++) {
			assertTrue(goods[i] == null);
        }
    }

    /**
     * Tests if currentPlanet is null
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testSetSolarSystem1() {
        Player player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);

        SolarSystem[] system = new SolarSystem[NUM_PLANETS];
        system[8] = new SolarSystem(LUIGI, 10, 10, 7, 7);
        player.currentPlanet = null;

        String result = player.setSolarSystem(system[8]);

        assertEquals("", result);
        assertEquals(system[8], player.currentPlanet);
    }

    /**
     * Tests if currentPlanet is passed in as parameter,
     * thus going to the same planet
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testSetSolarSystem2() {
        Player player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);

        SolarSystem[] system = new SolarSystem[NUM_PLANETS];
        system[8] = new SolarSystem(LUIGI, 10, 10, 7, 7);
        system[9] = new SolarSystem(ZELDA, 12, 12, 5, 8);
        player.currentPlanet = system[8];

        Ship ship = new Ship(5, 5, DEFAULT_NAME);
        ship.setFuel(100);

        String result = player.setSolarSystem(player.currentPlanet);

        assertEquals(system[8], player.currentPlanet);
        assertEquals("Already on planet!", result);
        assertTrue(ship.getFuel() == 100);
    }

    /**
     * Tests if planet is too far away compared to fuel
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testSetSolarSystem3() {
        Player player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);

        SolarSystem[] system = new SolarSystem[NUM_PLANETS];
        system[8] = new SolarSystem(LUIGI, 10, 10, 7, 7);
        system[9] = new SolarSystem(ZELDA, 12, 12, 5, 8);
        player.currentPlanet = system[8];

        Ship ship = new Ship(5, 5, DEFAULT_NAME);
        ship.setFuel(0);
        player.setShip(ship);

        String result = player.setSolarSystem(system[9]);

        assertEquals("Not enough fuel!", result);
        assertTrue(ship.getFuel() == 0);
        assertEquals(system[8], player.currentPlanet);
    }

    /**
     * Tests when planet in range compared to fuel
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testSetSolarSystem4() {
        Player player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);

        SolarSystem[] system = new SolarSystem[NUM_PLANETS];
        system[8] = new SolarSystem(LUIGI, 10, 10, 7, 7);
        system[9] = new SolarSystem(ZELDA, 12, 12, 5, 8);
        player.currentPlanet = system[8];

        Ship ship = new Ship(5, 5, DEFAULT_NAME);
        ship.setFuel(DEFAULT_TIMEOUT);
        player.setShip(ship);

        String result = player.setSolarSystem(system[9]);

        assertEquals("Successful transport!", result);
        assertTrue(player.getShip().getFuel() == (DEFAULT_TIMEOUT - (int) Math.sqrt(8)));
        assertEquals(system[9], player.currentPlanet);
    }

    /**
     * buying FLEA ship with enough money
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testBuyShipFleaSuccess(){
        NewCharacterControl.player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        Ship testShip = new Ship(5,8,FLEA);
        NewCharacterControl.player.setShip(testShip);
        NewCharacterControl.player.setMoney(INITIAL_MONEY);
        ShipYard yard = new ShipYard();

        int buyShipReturn = yard.buyShip(FLEA);

        assertTrue(buyShipReturn == 1);
        assertEquals(FLEA,NewCharacterControl.player.getShip().getName());
        assertTrue(NewCharacterControl.player.getShip().getHull() == 5);
        assertTrue(NewCharacterControl.player.getShip().getFuel() == DEFAULT_TIMEOUT);
        assertTrue(NewCharacterControl.player.getMoney() == (850 + yard.sellPrice()));
    }

    /**
     * failing to buy FLEA ship because not enough money
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testBuyShipFleaFail(){
        NewCharacterControl.player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        Ship testShip = new Ship(5,8,FLEA);
        NewCharacterControl.player.setShip(testShip);
        NewCharacterControl.player.setMoney(0);
        ShipYard yard = new ShipYard();

        int buyShipReturn = yard.buyShip(FLEA);

        assertTrue(buyShipReturn == 2);
    }

    /**
     * buying "Gnat" ship with enough money
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testBuyShipGnatSuccess(){
        NewCharacterControl.player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        Ship testShip = new Ship(5,8,FLEA);
        NewCharacterControl.player.setShip(testShip);
        NewCharacterControl.player.setMoney(INITIAL_MONEY);
        ShipYard yard = new ShipYard();

        int buyShipReturn = yard.buyShip("Gnat");

        assertTrue(buyShipReturn == 1);
        assertEquals("Gnat",NewCharacterControl.player.getShip().getName());
        assertTrue(NewCharacterControl.player.getShip().getHull() == 3);
        assertTrue(NewCharacterControl.player.getShip().getFuel() == 500);
        assertTrue(NewCharacterControl.player.getMoney() == (850 + yard.sellPrice()));
    }

    /**
     * failing to buy "Gnat" ship because not enough money
     */
    @Test
    public final void testBuyShipGnatFail(){
        NewCharacterControl.player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        Ship testShip = new Ship(5,8,FLEA);
        NewCharacterControl.player.setShip(testShip);
        NewCharacterControl.player.setMoney(0);
        ShipYard yard = new ShipYard();

        int buyShipReturn = yard.buyShip("Gnat");

        assertTrue(buyShipReturn == 2);
        assertEquals(FLEA,NewCharacterControl.player.getShip().getName());
    }

    /**
     * buying "Firefly" ship with enough money
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testBuyShipFireflySuccess(){
        NewCharacterControl.player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        Ship testShip = new Ship(5,8,FLEA);
        NewCharacterControl.player.setShip(testShip);
        NewCharacterControl.player.setMoney(INITIAL_MONEY);
        ShipYard yard = new ShipYard();

        int buyShipReturn = yard.buyShip("Firefly");

        assertTrue(buyShipReturn == 1);
        assertEquals("Firefly",NewCharacterControl.player.getShip().getName());
        assertTrue(NewCharacterControl.player.getShip().getHull() == 8);
        assertTrue(NewCharacterControl.player.getShip().getFuel() == 400);
        assertTrue(NewCharacterControl.player.getMoney() == (800 + yard.sellPrice()));
    }

    /**
     * failing to buy "Firefly" ship because not enough money
     */
    @Test
    public final void testBuyShipFireflyFail(){
        NewCharacterControl.player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        Ship testShip = new Ship(5,8,FLEA);
        NewCharacterControl.player.setShip(testShip);
        NewCharacterControl.player.setMoney(0);
        ShipYard yard = new ShipYard();

        int buyShipReturn = yard.buyShip("Firefly");

        assertTrue(buyShipReturn == 2);
        assertEquals(FLEA,NewCharacterControl.player.getShip().getName());
    }

    /**
     * buying "Mosquito" ship with enough money
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testBuyShipMosquitoSuccess(){
        NewCharacterControl.player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        Ship testShip = new Ship(5,8,FLEA);
        NewCharacterControl.player.setShip(testShip);
        NewCharacterControl.player.setMoney(INITIAL_MONEY);
        ShipYard yard = new ShipYard();

        int buyShipReturn = yard.buyShip("Mosquito");

        assertTrue(buyShipReturn == 1);
        assertEquals("Mosquito",NewCharacterControl.player.getShip().getName());
        assertTrue(NewCharacterControl.player.getShip().getHull() == 3);
        assertTrue(NewCharacterControl.player.getShip().getFuel() == 600);
        assertTrue(NewCharacterControl.player.getMoney() == (900 + yard.sellPrice()));
    }

    /**
     * failing to buy "Mosquito" ship because not enough money
     */
    @Test
    public final void testBuyShipMosquitoFail(){
        NewCharacterControl.player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        Ship testShip = new Ship(5,8,FLEA);
        NewCharacterControl.player.setShip(testShip);
        NewCharacterControl.player.setMoney(0);
        ShipYard yard = new ShipYard();

        int buyShipReturn = yard.buyShip("Mosquito");

        assertTrue(buyShipReturn == 2);
        assertEquals(FLEA,NewCharacterControl.player.getShip().getName());
    }

    /**
     * buying "Bumblebee" ship with enough money
     */
    @Test (timeout = DEFAULT_TIMEOUT)
    public final void testBuyShipBumblebeeSuccess(){
        NewCharacterControl.player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        Ship testShip = new Ship(5,8,FLEA);
        NewCharacterControl.player.setShip(testShip);
        NewCharacterControl.player.setMoney(INITIAL_MONEY);
        ShipYard yard = new ShipYard();

        int buyShipReturn = yard.buyShip("Bumblebee");

        assertTrue(buyShipReturn == 1);
        assertEquals("Bumblebee",NewCharacterControl.player.getShip().getName());
        assertTrue(NewCharacterControl.player.getShip().getHull() == 4);
        assertTrue(NewCharacterControl.player.getShip().getFuel() == 300);
        assertTrue(NewCharacterControl.player.getMoney() == (800 + yard.sellPrice()));
    }

    /**
     * failing to buy "Bumblebee" ship because not enough money
     */
    @Test
    public final void testBuyShipBumblebeeFail(){
        NewCharacterControl.player = Player.getInstance(0,0,0,0,0,DEFAULT_NAME);
        Ship testShip = new Ship(5,8,FLEA);
        NewCharacterControl.player.setShip(testShip);
        NewCharacterControl.player.setMoney(0);
        ShipYard yard = new ShipYard();

        int buyShipReturn = yard.buyShip("Bumblebee");

        assertTrue(buyShipReturn == 2);
        assertEquals(FLEA,NewCharacterControl.player.getShip().getName());
    }
}