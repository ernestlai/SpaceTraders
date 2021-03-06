package spacetraders.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
* The universe class. It is responsible for creating the Universe as well
* as the planets that are in the universe.
* @author Team Astrosnails (6) - CS 2340 Fall 2014
*/
public class Universe implements Serializable {
    private static Universe universe;
    private List<Planet> planets;
    private int width;
    private int height;

    /**
    *  Creates the Universe as well as planets in the universe.
    */
    private Universe() {
        width = 15;
        height = 10;

        Resources r1 = new Resources();
        r1.addResource(ResourceType.WATER, 1000)
            .addResource(ResourceType.FOOD, 200)
            .addResource(ResourceType.GOLD, 20)
            .addResource(ResourceType.OIL, 100)
            .addResource(ResourceType.COCAINE, 1);

        Planet p1 = new Planet("Flinstones", new Coordinates(1, 2),
            TechnologyLevel.AGRICULTURE,
            ResourceLevel.LOTSOFWATER, r1, PlanetEvent.DROUGHT,
            new HashSet<>());

        Resources r2 = new Resources();
        r2.addResource(ResourceType.WATER, 50)
            .addResource(ResourceType.FOOD, 300)
            .addResource(ResourceType.GOLD, 80)
            .addResource(ResourceType.OIL, 500)
            .addResource(ResourceType.COCAINE, 2);

        Set<ShipType> shipyard2 = new HashSet<>();
        shipyard2.add(ShipType.XWING);
        shipyard2.add(ShipType.SAMUS);
        shipyard2.add(ShipType.PROTOSS);

        Set<GadgetType> gadgets2 = new HashSet<>();
        gadgets2.add(GadgetType.CRYSTAL_RING_SHIELD);
        gadgets2.add(GadgetType.GIANT_MONSTER);
        gadgets2.add(GadgetType.BAZOOKA);

        Planet p2 = new Planet("United States of America",
            new Coordinates(4, 5),
            TechnologyLevel.POST_INDUSTRIAL,
            ResourceLevel.DESERT, r2, PlanetEvent.NOTHING, shipyard2);
        p2.setGadgets(gadgets2);
        
        Resources r3 = new Resources();
        r3.addResource(ResourceType.WATER, 500)
            .addResource(ResourceType.FOOD, 500)
            .addResource(ResourceType.GOLD, 400)
            .addResource(ResourceType.OIL, 50)
            .addResource(ResourceType.COCAINE, 5);

        Set<ShipType> shipyard3 = new HashSet<>();
        shipyard3.add(ShipType.USGISHIMURA);
        shipyard3.add(ShipType.VICVIPER);
        shipyard3.add(ShipType.PROTOSS);

        Planet p3 = new Planet("King Arthur", new Coordinates(2, 3),
            TechnologyLevel.MEDIEVAL,
            ResourceLevel.MINERALRICH, r3, PlanetEvent.NOTHING,
            shipyard3);

        Resources r4 = new Resources();
        r4.addResource(ResourceType.WATER, 200)
            .addResource(ResourceType.FOOD, 1000)
            .addResource(ResourceType.GOLD, 100)
            .addResource(ResourceType.OIL, 100)
            .addResource(ResourceType.COCAINE, 0);

        Set<ShipType> shipyard4 = new HashSet<>();
        shipyard4.add(ShipType.LUNARWHALE);
        shipyard4.add(ShipType.NORMANDY);

        Planet p4 = new Planet("Leonardo Da Vinci", new Coordinates(9, 8),
            TechnologyLevel.RENAISSANCE,
            ResourceLevel.RICHSOIL, r4, PlanetEvent.NOTHING,
            shipyard4);

        Resources r5 = new Resources();
        r5.addResource(ResourceType.WATER, 100)
            .addResource(ResourceType.FOOD, 250)
            .addResource(ResourceType.GOLD, 500)
            .addResource(ResourceType.OIL, 1000)
            .addResource(ResourceType.COCAINE, 3);

        Set<ShipType> shipyard5 = new HashSet<>();
        shipyard5.add(ShipType.XWING);
        shipyard5.add(ShipType.LUNARWHALE);

        Set<GadgetType> gadgets5 = new HashSet<>();
        gadgets5.add(GadgetType.BLACK_KNIGHT_SHIELD);
        gadgets5.add(GadgetType.MISSILE);
        gadgets5.add(GadgetType.INFINITY_SPACE);
        gadgets5.add(GadgetType.LIGHTNING_SPEED);

        Planet p5 = new Planet("Terminator", new Coordinates(8, 5),
            TechnologyLevel.HI_TECH,
            ResourceLevel.MINERALRICH, r5,
            PlanetEvent.WAR, shipyard5);
        p5.setGadgets(gadgets5);

        planets = new ArrayList<Planet>();
        planets.add(p1);
        planets.add(p2);
        planets.add(p3);
        planets.add(p4);
        planets.add(p5);
    }

    /**
    *  Returns an instance of the universe. Ensures that Universe follows
    *  the Singleton pattern.
    *  @return The universe
    */
    public static Universe getInstance() {
        if (universe == null) {
            universe = new Universe();
        }

        return universe;
    }

    /**
    * CAUTION: ONLY USE FOR LOADING GAME
    * Sets the global universe object to otherUniverse
    * @param otherUniverse The universe
    */
    public static void setInstance(Universe otherUniverse) {
        universe = otherUniverse;
    }

    /**
    * Returns the planet in the universe
    * @return The planets
    */
    public List<Planet> getPlanets() {
        return planets;
    }

    /**
    * Returns the width of the universe
    * @return The width
    */
    public int getWidth() {
        return width;
    }

    /**
    * Returns the height of the universe
    * @return The height
    */
    public int getHeight() {
        return height;
    }
}
