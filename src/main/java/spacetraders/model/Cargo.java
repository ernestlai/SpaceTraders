package spacetraders.model;

import java.io.Serializable;

/**
*This class implements the Cargo Class
*to set up and create the methods of cargo
* @author Team 6, CS 2340 - Fall 2014 M5
*
*/

public class Cargo implements Serializable {

    private Resources resources;
    private int baseSize;
    private int extraSpace;  // Calculated from gadgets on ships

    /**
     * This constructor sets up a Cargo
     * @param int maxSize
     *
     */
    public Cargo(int baseSize) {
        this.baseSize = baseSize;
        resources = new Resources();
    }

    /**
     * Returns the resources
     * @return The resources that the cargo holds
     *
     */
    public Resources getResources() {
        return resources;
    }
    /**
     * Set the resources
     * @param resources
     *
     */
    public void setResources(Resources resources) {
        this.resources = resources;
    }

    /**
     * Returns the total number of units of resources
     * @return The total amount of resources that the cargo has
     *
     */
    public int calculateTotalResources() {
        int waterAmount = resources.getResourceAmount(ResourceType.WATER);
        int foodAmount = resources.getResourceAmount(ResourceType.FOOD);
        int oilAmount = resources.getResourceAmount(ResourceType.OIL);
        int goldAmount = resources.getResourceAmount(ResourceType.GOLD);
        int cocaineAmount = resources.getResourceAmount(ResourceType.COCAINE);
        int totalAmount = waterAmount + foodAmount
                + oilAmount + goldAmount + cocaineAmount;
        return totalAmount;
    }

    /**
     * Returns the empty space that the cargo can still hold
     * @return The empty space
     *
     */
    public int calculateEmptySpace() {
        return getMaxSize() - calculateTotalResources();
    }

    /**
     * Checks if cargo has room for amount of resources
     * @param amount The amount of resources
     * @return True if amount of resources fit. False otherwise.
     */
    public boolean validateCargoSpace(int amount) {
        boolean ret = false;
        if (calculateEmptySpace() >= amount) {
            ret = true;
        }
        return ret;
    }

    /**
     * Returns the max size that the cargo can hold
     * @return The max size
     */
    public int getMaxSize() {
        return baseSize + extraSpace;
    }
    /**
     * Add extra space to the cargo
     * @param int represents space
     */
    public void addExtraSpace(int space) {
        extraSpace += space;
    }
}