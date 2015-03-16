package fortress.Models;

import fortress.Controllers.NewCharacterControl;

import java.util.Random;


/**
 * @author Ishaan
 */

//enum for all the Trade Goods in the game
public enum TradeGoods {

    WATER(0,0,2,30,3,4,4,3,30,50, "Water"),
    FURS(0,0,0,250,10,10,7,8,230,280, "Furs"),
    FOOD(1,0,1,100,5,5,5,6,90,160, "Food"),
    ORE(2,2,3,350,20,10,1,2,350,420, "Ore"),
    GAMES(3,1,6,250,-10,5,11,0,160,270, "Games"),
    FIREARMS(3,1,5,1250,-75,100,12,0,600,1100, "Firearms"),
    MEDICINE(4,1,6,650,-20,10,10,0,400,700, "Medicine"),
    MACHINES(4,3,5,900,-30,5,0,0,600,800, "Machines"),
    NARCOTICS(5,0,5,3500,-125,150,9,0,2000,3000, "Narcotics"),
    ROBOTS(6,4,7,5000,-150,100,0,0,3500,5000, "Robots");

    /*
     * @param mtlp - Minimum Tech Level to Produce this resource (can't buy on planets below this lvl)
     * @param mtlu - Minimum Tech Level to Use this resource (can't sell on planets blow this lvl)
     * @param ttp - Tech Level that produces most of this item
     * @param bp - Base Price of the product
     * @param ipl - Price increase per tech level
     * @param var - Variance is the max percentage the price can vary above or below the base
     * @param mtl - Minimum price offered in a trade with random trader
     * @param mth - Maximum price offered in a trade with random trader
     * @param cr - When this condition is present, the price of this resource is unusually low
     * @param er - When this condition is present, the resource is expensive
     */
    private final int mtlp;
    private final int mtlu;
    private final int ttp;
    private final int bp;
    private final int ipl;
    private final int var;
    private final String name;

    /*
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
    private final int cr;
    private final int er;

    //space trades is extra credit, might not be implemented for this milestone
    private final int mtl;
    private final int mth;


    private TradeGoods(int minTechLvlProd, int minTechLvlUse, int techToProd, int basePrice, int priceInc, int variance,
                        int cheapResource, int expensiveResource, int minTraderPrice, int maxTraderPrice, String goodName)
    {
        mtlp = minTechLvlProd;
        mtlu = minTechLvlUse;
        ttp = techToProd;
        bp = basePrice;
        ipl = priceInc;
        var = variance;
        cr = cheapResource;
        er = expensiveResource;
        mtl = minTraderPrice;
        mth = maxTraderPrice;
        name = goodName;
    }

    /**
     * Getter for name
     * @return good name
     */
    public String getName() {
        return name;
    }

    /**
     * Calculate market prices for goods
     * @return
     */
    public int calcMarketPrice()
    {
        SolarSystem system = NewCharacterControl.player.getSolarSystem();
        int price;
        Random r = new Random();

        //if no special resource level
        if(system.getResource() == 0)
        {
            //if "heads" price increases
            if (Math.random() < 0.5) {
                price = bp + (ipl * (system.getTech() - mtlp)) + (bp * (r.nextInt(var + 1)) / 10);
            }

            //"tails" no price increase
            else {
                price = bp + (ipl * (system.getTech() - mtlp));
            }
        }

        //if expensive resource is present
        else if (system.getResource() == 2 ||system.getResource() == 3 ||system.getResource() == 6 ||system.getResource() == 8 )
        {
            //if "heads" price increases
            if (Math.random() < 0.5) {
                price = bp + (ipl * (system.getTech() - mtlp)) + (bp * (r.nextInt(var + 1)) / 10) + 10;
            }

            //"tails" no price increase
            else {
                price = bp + (ipl * (system.getTech() - mtlp)) + 10;
            }


        }

        //cheap resource
        else
        {
            //if "heads" price increases
            if (Math.random() < 0.5) {
                price = bp + (ipl * (system.getTech() - mtlp)) + (bp * (r.nextInt(var + 1)) / 10) - 10;
            }

            //"tails" no price increase
            else {
                price = bp + (ipl * (system.getTech() - mtlp)) - 10;
            }

        }
        return price;
    }


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
    */





}


