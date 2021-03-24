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
    String name;
    craftRange range;
    craftQuality quality;
    craftSpeed speed;
    craftTankSize tankSize;
    craftStatus status;
    int cost, capacity;
    int currentFuel; 

    public SpaceCraft(String name, craftRange range, craftQuality quality, craftSpeed speed, craftTankSize tankSize, int cost, int capacity){
        this.name = name;
        this.range = range;
        this.quality = quality;
        this.speed = speed;
        this.tankSize = tankSize;
        this.cost = cost;
        this.capacity = capacity;
        this.currentFuel = getMaxFuel();
        this.status = craftStatus.GOOD;
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

    public class SaturnV extends SpaceCraft {
        public SaturnV(){
            super("Saturn V", craftRange.MOON, craftQuality.POOR, craftSpeed.SLOW, craftTankSize.SMALL, 1000, 3);
        }
    }
}
