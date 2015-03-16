package fortress.Models;

import fortress.Controllers.NewCharacterControl;

/**
 * Represents the shipyard
 * @author Arvind
 */
public class ShipYard {

    /**
     * Buys a ship.
     * @param shipName name of ship
     * @return
     * 1 if successful sale
     * 2 if not enough cash
     */
    public final int buyShip(String shipName) {
        Player player = NewCharacterControl.player;
        int ret = 1;
        if (shipName.equalsIgnoreCase("Flea") && player.getMoney() + sellPrice() > 150) {
            player.setShip(new Flea(5, 8, "Flea"));
            player.setMoney(player.getMoney() - 150);
            player.getShip().setFuel(200);
            player.setMoney(player.getMoney() + sellPrice());
        } else if (shipName.equalsIgnoreCase("Gnat") && player.getMoney() + sellPrice() > 150) {
            player.setShip(new Gnat(3, 5, "Gnat"));
            player.setMoney(player.getMoney() - 150);
            player.getShip().setFuel(500);
            player.setMoney(player.getMoney() + sellPrice());
        }else if (shipName.equalsIgnoreCase("Firefly") && player.getMoney() + sellPrice() > 200) {
            player.setShip(new Firefly(8, 6, "Firefly"));
            player.setMoney(player.getMoney() - 200);
            player.getShip().setFuel(400);
            player.setMoney(player.getMoney() + sellPrice());
        }else if (shipName.equalsIgnoreCase("Mosquito") && player.getMoney() + sellPrice() > 100) {
            player.setShip(new Mosquito(3, 4, "Mosquito"));
            player.setMoney(player.getMoney() - 100);
            player.getShip().setFuel(600);
            player.setMoney(player.getMoney() + sellPrice());
        }else if (shipName.equalsIgnoreCase("Bumblebee") && player.getMoney() + sellPrice() > 200) {
            player.setShip(new Bumblebee(4, 7, "Bumblebee"));
            player.setMoney(player.getMoney() - 200);
            player.getShip().setFuel(300);
            player.setMoney(player.getMoney() + sellPrice());
        } else {
            ret = 2;
        }
        return ret;
    }

    /**
     * Calculates the sell price of a ship
     * @return the sell price of a ship
     */
    public final int sellPrice() {
        Player player = NewCharacterControl.player;
        int sellPrice = 0;
        sellPrice += (player.getShip().getFuel() / 15);
        sellPrice += player.getShip().getHull() * 5;
        return sellPrice;
    }
}
