public class SpaceCraft {
    UserInterface ui = new UserInterface();
    enum craftQuality {
        POOR,
        FAIR,
        GOOD
    }
    enum craftSpeed {
        SLOW,
        AVERAGE,
        FAST
    }
    enum craftTankSize {
        SMALL,
        MEDIUM,
        LARGE
    }
    enum craftRange {
        MOON,
        MARS,
        INNER_BELT,
        OUTER_BELT,
        EVERYWHERE
    }
    enum craftStatus {
        DEAD,
        FAILING,
        DETERIORATING,
        AVERAGE,
        GOOD,
        OUTSTANDING
    }
    enum craftOrigin {
        EARTH,
        MOON,
        MARS,
        INNER_BELT,
        OUTER_BELT
    }
    String name;
    craftRange range;
    craftQuality quality;
    craftSpeed speed;
    craftTankSize tankSize;
    craftStatus status;
    craftOrigin origin;
    int cost, capacity, currentFuel;

    public SpaceCraft(String name, craftRange range, craftQuality quality, craftSpeed speed, craftTankSize tankSize, int cost, int capacity, craftOrigin origin){
        this.name = name;
        this.range = range;
        this.quality = quality;
        this.speed = speed;
        this.tankSize = tankSize;
        this.cost = cost;
        this.capacity = capacity;
        this.currentFuel = getMaxFuel();
        this.status = craftStatus.GOOD;
        this.origin = origin;
    }

    public int getMaxFuel() {
        if (tankSize == craftTankSize.LARGE) {
            return 1000;
        } else if (tankSize == craftTankSize.MEDIUM) {
            return 750;
        } else {
            return 500;
        }
    }

    public void printFullCraftSpecs(){
        ui.clear();
        ui.println("Name: " + name);
        ui.println("Cost: " + cost);
        ui.println("Crew Capacity: " + capacity);
        ui.println("Range: " + range);
        ui.println("Quality: " + quality);
        ui.println("Speed: " + speed);
        ui.println("Tank Size: " + tankSize);
        ui.println("Current Fuel: " + currentFuel);
        ui.println("Status: " + status);
    }

    public void printShortSpecs(){
        ui.println("Name: " + name);
        ui.println("Cost: " + cost);
        ui.println("Crew Capacity: " + capacity);
    }

    // Earth-based Space Craft
    public class SaturnV extends SpaceCraft {
        public SaturnV(){
            super("Saturn V", craftRange.MOON, craftQuality.POOR, craftSpeed.SLOW, craftTankSize.SMALL, 1000, 3, craftOrigin.EARTH);
        }
    }
    public class Atlas extends SpaceCraft {
        public Atlas(){
            super("Atlas", craftRange.MOON, craftQuality.FAIR, craftSpeed.SLOW, craftTankSize.SMALL, 5000, 4, craftOrigin.EARTH);
        }
    }
    public class NewShepard extends SpaceCraft {
        public NewShepard() {
            super("New Shepard XC", craftRange.MARS, craftQuality.GOOD, craftSpeed.AVERAGE, craftTankSize.MEDIUM, 10000, 6, craftOrigin.EARTH);
        }
    }
    public class Artemis extends SpaceCraft {
        public Artemis() {
            super("Artemis N", craftRange.EVERYWHERE, craftQuality.GOOD, craftSpeed.FAST, craftTankSize.MEDIUM, 20000, 10, craftOrigin.EARTH);
        }
    }
    public class NewOrion extends SpaceCraft {
        public NewOrion(){
            super("New Orion", craftRange.EVERYWHERE, craftQuality.GOOD, craftSpeed.FAST, craftTankSize.LARGE, 40000, 12, craftOrigin.EARTH);
        }
    }

    // Moon Based Space Craft
    public class Skybird extends SpaceCraft {
        public Skybird() {
            super("Skybird", craftRange.MARS, craftQuality.FAIR, craftSpeed.SLOW, craftTankSize.MEDIUM, 5000, 5, craftOrigin.MOON);
        }
    }
    public class Helios extends SpaceCraft {
        public Helios() {
            super("Helios 9", craftRange.INNER_BELT, craftQuality.POOR, craftSpeed.SLOW, craftTankSize.LARGE, 7500, 5, craftOrigin.MOON);
        }
    }
    public class Pegasus extends SpaceCraft {
        public Pegasus() {
            super("Pegasus", craftRange.EVERYWHERE, craftQuality.GOOD, craftSpeed.AVERAGE, craftTankSize.MEDIUM, 20000, 10, craftOrigin.MOON);
        }
    }

    // Mars Based Space Craft (3)

    // Inner Belt Based Space Craft (2)

    // Outer Belt Based Space Craft (2)
    
}
