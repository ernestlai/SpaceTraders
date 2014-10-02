package spacetraders.model;

/**
*This class implements the Planet Class
*to set up and create the methods of creating coordinates
* @author Team 6, CS 2340 - Fall 2014 M5
* 
*/
public class Planet {
    
    private String name;
    private Coordinates coordinates;
    private TechnologyLevel technologyLevel;
    private ResourceLevel resourceLevel;
    private Resources resources;

    /**
	 * This constructor sets up a planet
	 * @param String name, Coordinates coordinates, TechnologyLevel technologyLevel,
     *   ResourceLevel resourceLevel, Resources resources
	 * 
	 */
    public Planet(String name, Coordinates coordinates, TechnologyLevel technologyLevel,
        ResourceLevel resourceLevel, Resources resources) {
        this.name = name;
        this.coordinates = coordinates;
        this.technologyLevel = technologyLevel;
        this.resourceLevel = resourceLevel;
        this.resources = resources;
    }
    
    /**
    * sets planet name
    * @param String name
    * @return none
    */
    public void setName(String name) {
        this.name = name;
    }

    /**
    * gets name of planet
    * @param none
    * @return String name
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * this method gets resource price
    * @param ResourceType type
    * @return price as int
    */
    public int getResourcePrice(ResourceType type) {
        //get the instance of this singleton class
        ResourcesInfo a = ResourcesInfo.getInstance();
        double randomness = -1.0 * a.getVariance(type) / 100 + 
        Math.random()*2*a.getVariance(type) / 100;
        int value = a.getBasePrice(type) * (int) (1 + randomness); 
        value += (a.getPriceIncreasePerTechLevel(type) * 
            (technologyLevel.ordinal() - a.getMinTechLevelToProduce(type).ordinal()));
        if (getResourceLevel() == a.getConditionForCheap(type)) {
            value /= 2;
        } else if (getResourceLevel() == a.getConditionForExpensive(type)) {
            value *= 1.5;
        }

        return value; 
    }

    /**
    * this method sets cooridnates of planet
    * @param Coordinates coordinates
    * @return none
    */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    
    /**
    * this method gets planet coordinates
    * @param none
    * @return Coordinate coordinates
    */
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    
    /**
    * this method sets technology level of the planet
    * @param TechnologyLevel technologyLevel
    * @return none
    */
    public void setTechnologyLevel(TechnologyLevel technologyLevel) {
        this.technologyLevel = technologyLevel;
    }
   
    /**
    * this method gets the technology level of planet
    * @param none 
    * @return TechnologyLevel technologyLevel
    */
    public TechnologyLevel getTechnologyLevel() {
        return this.technologyLevel;
    }
   
    /**
    * this method sets Resource level
    * @param ResourceLevel resourceLevel
    * @return none
    */
    public void setResourceLevel(ResourceLevel resourceLevel) {
        this.resourceLevel = resourceLevel;
    }

    /**
    * this method gets Resource level
    * @param none
    * @return ResourceLevel
    */
    public ResourceLevel getResourceLevel() {
        return this.resourceLevel;
    }
   
    /**
    * this method sets Resources
    * @param Resources resources
    * @return none
    */
    public void setResources(Resources resources) {
        this.resources = resources;
    }
   
    /**
    * this method gets Resources
    * @param none
    * @return Resources
    */
    public Resources getResources() {
        return this.resources;
    }
}
