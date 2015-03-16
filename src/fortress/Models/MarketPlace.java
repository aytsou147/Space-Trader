package fortress.Models;
import fortress.Controllers.NewCharacterControl;

import java.util.Random;

/**
 * Represents a marketplace.
 * @author Arvind
 */
public class MarketPlace{
    private Random rand = new Random();
    /*
    0 - water
    1 - furs
    2 - food
    3 - ore
    4 - games
    5 - firearms
    6 - medicine
    7 - machines
    8 - narcotics
    9 - robots
     */
    private TradeGoods[] goods;
    private int[] prices;
    private int[] quantities;
    private static final int NUM_GOODS = 10;

    /**
     * Creates the MarketPlace model.
     * Generates all goods and prices depending on tech level.
     */
    public MarketPlace() {
        goods = new TradeGoods[NUM_GOODS];
        goods[0] = TradeGoods.WATER;
        goods[1] = TradeGoods.FURS;
        goods[2] = TradeGoods.FOOD;
        goods[3] = TradeGoods.ORE;
        goods[4] = TradeGoods.GAMES;
        goods[5] = TradeGoods.FIREARMS;
        goods[6] = TradeGoods.MEDICINE;
        goods[7] = TradeGoods.MACHINES;
        goods[8] = TradeGoods.NARCOTICS;
        goods[9] = TradeGoods.ROBOTS;
        prices = new int[goods.length];
        quantities = new int[goods.length];
        SolarSystem system = NewCharacterControl.player.getSolarSystem();
        if(system.getTech() == 0 )
        {
            loadWater();
            loadFurs();
        }

        else if(system.getTech() == 1 )
        {
            loadWater();
            loadFurs();
            loadFood();
        }

        else if(system.getTech() == 2 )
        {
            loadWater();
            loadFurs();
            loadFood();
            loadOre();
        }

        else if(system.getTech() == 3 )
        {
            loadOre();
            loadFirearm();
            loadGames();
        }

        else if(system.getTech() == 4 )
        {
            loadMachines();
            loadMedicine();
        }

        else if(system.getTech() == 5 )
        {
            //possible resources: everything except ROBOTS
            loadWater();
            loadFurs();
            loadFood();
            loadOre();
            loadGames();
            loadFirearm();
            loadMedicine();
            loadMachines();
            loadNarcotics();
        }

        else if(system.getTech() == 6 || system.getTech() == 7)
        {
            //possible resources: everything
            loadWater();
            loadFurs();
            loadFood();
            loadOre();
            loadGames();
            loadFirearm();
            loadMedicine();
            loadMachines();
            loadNarcotics();
            loadRobots();
        }
    }

    /**
     * The player buys a good from the marketplace.
     * @param good Good to buy
     * @return
     * -1 if null input
     * 1 if player doesn't have enough credits
     * 2 if player has full cargo
     * 3 if merchant out of stock
     * 4 if successful purchase
     * 5 if successful purchase and level up
     */
    public final int buyItem(TradeGoods good) {
        Player player = NewCharacterControl.player;
        Ship ship = player.getShip();
        TradeGoods[] cargo = ship.getCargo();
        if (good == null) {
            return -1;
        }
        int index = 0;
        for (int i = 0; i < prices.length; i++) {
            if (good.getName().equals(goods[i].getName())) {
                index = i;
            }
        }
        // Player doesn't have enough money
        if (player.getMoney() < prices[index]) {
            return 1;
        }
        // Full cargo
        boolean full = true;
        for (TradeGoods t:cargo) {
            if (t == null) {
                full = false;
            }
        }
        if (full) {
            return 2;
        }
        // Merchant out of stock
        if (quantities[index] == 0) {
            return 3;
        }
        quantities[index]--;
        player.setMoney(player.getMoney() - prices[index]);
        ship.addCargo(good);
        if (player.addExp(5)) {
            return 5;
        }
        return 4;
    }

    /**
     * The player sells a given good to the market
     * @param good The good to be sold
     */
    public final void sellItem(TradeGoods good) {
        int index = 0;
        for (int i = 0; i < prices.length; i++) {
            if (good.getName().equals(goods[i].getName())) {
                index = i;
            }
        }
        Ship ship = NewCharacterControl.player.getShip();
        TradeGoods removed = ship.removeCargo(good);
        if (removed == null) {
            return;
        }
        quantities[index]++;
        NewCharacterControl.player.setMoney(NewCharacterControl.player.getMoney() + prices[index]);
    }

    /**
     * Load water information
     */
    public final void loadWater() {
        prices[0] = TradeGoods.WATER.calcMarketPrice();
        prices[0] -= (NewCharacterControl.player.getSkills()[2]*10);
        quantities[0] = rand.nextInt(3) + 1;
    }
    /**
     * Load furs information
     */
    public final void loadFurs() {
        prices[1] = TradeGoods.FURS.calcMarketPrice();
        prices[1] -= (NewCharacterControl.player.getSkills()[2]*10);
        quantities[1] = rand.nextInt(5) + 5;
    }
    /**
     * Load food information
     */
    public final void loadFood() {
        prices[2] = TradeGoods.FOOD.calcMarketPrice();
        prices[2] -= (NewCharacterControl.player.getSkills()[2]*10);
        quantities[2] = rand.nextInt(5) + 5;
    }
    /**
     * Load ore information
     */
    public final void loadOre() {
        prices[3] = TradeGoods.ORE.calcMarketPrice();
        prices[3] -= (NewCharacterControl.player.getSkills()[2]*10);
        quantities[3] = rand.nextInt(5) + 5;
    }
    /**
     * Load games information
     */
    public final void loadGames() {
        prices[4] = TradeGoods.GAMES.calcMarketPrice();
        prices[4] -= (NewCharacterControl.player.getSkills()[2]*10);
        quantities[4] = rand.nextInt(5) + 5;
    }
    /**
     * Load firearm information
     */
    public final void loadFirearm() {
        prices[5] = TradeGoods.FIREARMS.calcMarketPrice();
        prices[5] -= (NewCharacterControl.player.getSkills()[2]*10);
        quantities[5] = rand.nextInt(5) + 5;
        prices[5] -= (NewCharacterControl.player.getSkills()[1]*30);
    }
    /**
     * Load medicine information
     */
    public final void loadMedicine() {
        prices[6] = TradeGoods.MEDICINE.calcMarketPrice();
        prices[6] -= (NewCharacterControl.player.getSkills()[2]*10);
        quantities[6] = rand.nextInt(5) + 5;
    }
    /**
     * Load machines information
     */
    public final void loadMachines() {
        prices[7] = TradeGoods.MACHINES.calcMarketPrice();
        prices[7] -= (NewCharacterControl.player.getSkills()[2]*10);
        prices[7] -= (NewCharacterControl.player.getSkills()[3]*30);
        quantities[7] = rand.nextInt(5) + 5;
    }
    /**
     * Load narcotics information
     */
    public final void loadNarcotics() {
        prices[8] = TradeGoods.NARCOTICS.calcMarketPrice();
        prices[8] -= (NewCharacterControl.player.getSkills()[2]*10);
        quantities[8] = rand.nextInt(5) + 5;
    }
    /**
     * Load robots information
     */
    public final void loadRobots() {
        prices[9] = TradeGoods.ROBOTS.calcMarketPrice();
        prices[9] -= (NewCharacterControl.player.getSkills()[2]*10);
        prices[9] -= (NewCharacterControl.player.getSkills()[3]*30);
        quantities[9] = rand.nextInt(5) + 5;

    }

    /**
     * Getter for goods
     * @return goods
     */
    public final TradeGoods[] getGoods() {
        return goods;
    }

    /**
     * Getter for prices
     * @return prices
     */
    public final int[] getPrices() {
        return prices;
    }

    /**
     * Getter for quantities
     * @return quantities
     */
    public final int[] getQuantities() {
        return quantities;
    }
}
