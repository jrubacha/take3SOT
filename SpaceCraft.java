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
        MOON_BASE_1,
        MARS_COLONY_7,
        INNER_BELT_TRANSIT_STATION_2,
        OUTBELT_OUTPOST_4,
        GANYMEDE_RESEARCH_CENTER
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
    String name, descriptiveText;
    craftRange range;
    craftQuality quality;
    craftSpeed speed;
    craftTankSize tankSize;
    craftStatus status;
    craftOrigin origin;
    int cost, capacity, currentFuel;

    public SpaceCraft(String name, craftRange range, craftQuality quality, craftSpeed speed, craftTankSize tankSize, int cost, int capacity, craftOrigin origin, String descriptiveText){
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
        this.descriptiveText = descriptiveText;
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
    public int getCost(){
        return cost;
    }

    // TODO: Create a refueling method
    
    public void burnFuel() {
        int dailyBurn = 0;
        switch (quality) {
            case POOR:
                dailyBurn = 30;
            case FAIR:
                dailyBurn = 20;
            case GOOD:
                dailyBurn = 10;
        }
        currentFuel -= dailyBurn;
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
        ui.pressEnter();
    }

    public void printShortSpecs(){
        ui.println("Name: " + name);
        ui.println("Cost: " + cost);
        ui.println("Crew Capacity: " + capacity);
    }
    public boolean areWeOutOfFuel(){
        if (currentFuel <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void printQuickDescription(){
        ui.println(descriptiveText);
    }

    public int getMaxCapacity(){
        return capacity;
    }
    public craftRange getRange(){
        return range;
    }

    public int getTimetoMoon(){
        if (speed == craftSpeed.FAST) {
            return 2;
        } else if (speed == craftSpeed.AVERAGE) {
            return 3;
        } else {
            return 4;
        }
    }
    public int getTimetoMars(){
        if (speed == craftSpeed.FAST) {
            return 180;
        } else if (speed == craftSpeed.AVERAGE) {
            return 210;
        } else {
            return 240;
        }
    }
    public int getTimetoInnerBelt(){
        if (speed == craftSpeed.FAST) {
            return 200;
        } else if (speed == craftSpeed.AVERAGE) {
            return 300;
        } else {
            return 400;
        }
    }
    public int getTimetoOuterBelt(){
        if (speed == craftSpeed.FAST) {
            return 250;
        } else if (speed == craftSpeed.AVERAGE) {
            return 350;
        } else {
            return 450;
        }
    }
    public int getTimetoGanymede(){
        if (speed == craftSpeed.FAST) {
            return 300;
        } else if (speed == craftSpeed.AVERAGE) {
            return 450;
        } else {
            return 600;
        }
    }

    // Earth Based Space Craft
    public static class SaturnV extends SpaceCraft {
        public SaturnV(){
            super("Saturn V", craftRange.MOON_BASE_1, craftQuality.POOR, craftSpeed.SLOW, craftTankSize.SMALL, 1000, 3, craftOrigin.EARTH, "A flight vehicle straight out of history, this rocket will get you where you need to go. So long as that place is the Moon.\nKeep your initial flight crew small, three passengers maximum, including you Captain.");
        }
    }
    public static class Atlas extends SpaceCraft {
        public Atlas(){
            super("Atlas", craftRange.MOON_BASE_1, craftQuality.FAIR, craftSpeed.SLOW, craftTankSize.SMALL, 5000, 4, craftOrigin.EARTH, "A slightly more modern alternative to the Saturn V, the Atlas Falcon is similarly capable of lifting you and three others into orbit.");
        }
    }
    public static class NewShepard extends SpaceCraft {
        public NewShepard() {
            super("New Shepard XC", craftRange.MARS_COLONY_7, craftQuality.GOOD, craftSpeed.AVERAGE, craftTankSize.MEDIUM, 10000, 6, craftOrigin.EARTH, "It’s not the prettiest spacecraft, but the New Shepard will get you out into the solar system. With an extended range from its earlier counterparts, this ship will take you all the way to Mars, maybe further if you’re careful with your supplies.");
        }
    }
    public static class Artemis extends SpaceCraft {
        public Artemis() {
            super("Artemis N", craftRange.GANYMEDE_RESEARCH_CENTER, craftQuality.GOOD, craftSpeed.FAST, craftTankSize.MEDIUM, 20000, 10, craftOrigin.EARTH, "One of the world’s leaders in solar system travel, Artemis doesn’t disappoint with their ‘N’ series craft. Designed for long journeys in mind, the Artemis N will take you wherever you need to go.");
        }
    }
    public static class NewOrion extends SpaceCraft {
        public NewOrion(){
            super("New Orion", craftRange.GANYMEDE_RESEARCH_CENTER, craftQuality.GOOD, craftSpeed.FAST, craftTankSize.LARGE, 40000, 12, craftOrigin.EARTH, "THE interstellar flight vehicle. Top of the line in speed, luxury, and navigational control, you can’t go wrong with this craft. Travel in style to your destination and never worry about a thing.");
        }
    }

    // Moon Based Space Craft
    public static class Skybird extends SpaceCraft {
        public Skybird() {
            super("Skybird", craftRange.MARS_COLONY_7, craftQuality.FAIR, craftSpeed.SLOW, craftTankSize.MEDIUM, 5000, 5, craftOrigin.MOON, "Skybird's an delapidated Earthcraft left adrift around the moon. We towed her back and cleaned her up. Don't expect to get past Mars with this ol' ship.");
        }
    }
    public static class Helios extends SpaceCraft {
        public Helios() {
            super("Helios 9", craftRange.INNER_BELT_TRANSIT_STATION_2, craftQuality.POOR, craftSpeed.SLOW, craftTankSize.LARGE, 7500, 5, craftOrigin.MOON, "The Helios 9 was built in space, for space. She's an older model though, not quite suited for a trip across the belt. A decent mid system hopper, I'd say.");
        }
    }
    public static class Pegasus extends SpaceCraft {
        public Pegasus() {
            super("Pegasus", craftRange.GANYMEDE_RESEARCH_CENTER, craftQuality.GOOD, craftSpeed.AVERAGE, craftTankSize.MEDIUM, 20000, 10, craftOrigin.MOON, "Looking for luxury? Look no further. The Pegasus was designed for you to travel anywhere in the galaxy in stylish comfort. Just, don't expect to get there in a hurry, okay? Sit back and enjoy the trip.");
        }
    }

    // Mars Based Space Craft (3)
    public static class Avalon extends SpaceCraft {
        public Avalon() {
            super("Avalon", craftRange.GANYMEDE_RESEARCH_CENTER, craftQuality.FAIR, craftSpeed.AVERAGE, craftTankSize.MEDIUM, 12000, 8, craftOrigin.MARS, "Avalon text");
        }
    }
    public static class TX7 extends SpaceCraft {
        public TX7() {
            super("T-X7", craftRange.OUTBELT_OUTPOST_4, craftQuality.GOOD, craftSpeed.AVERAGE, craftTankSize.MEDIUM, 12000, 6, craftOrigin.MARS, "T-X7 text");
        }
    }
    public static class Foxfire extends SpaceCraft {
        public Foxfire() {
            super("Foxfire", craftRange.GANYMEDE_RESEARCH_CENTER, craftQuality.FAIR, craftSpeed.FAST, craftTankSize.SMALL, 17500, 5, craftOrigin.MARS, "Foxfire text");
        }
    }

    // Inner Belt Based Space Craft
    public static class Mayflower extends SpaceCraft {
        public Mayflower() {
            super("Mayflower Legacy", craftRange.OUTBELT_OUTPOST_4, craftQuality.GOOD, craftSpeed.SLOW, craftTankSize.LARGE, 15000, 9, craftOrigin.INNER_BELT, "Mayflower text");
            // I want this ship to be indestructable, don't know what all that means, but essentially, it's made for crossing the asteroid belt
        }
    }
    public static class Cygnus extends SpaceCraft {
        public Cygnus() {
            super("Cygnus Mu", craftRange.GANYMEDE_RESEARCH_CENTER, craftQuality.POOR, craftSpeed.FAST, craftTankSize.MEDIUM, 11000, 7, craftOrigin.INNER_BELT, "Cygnus Mu text");
        }
    }

    // Outer Belt Based Space Craft
    public static class Ankaa extends SpaceCraft {
        public Ankaa() {
            super("Ankaa", craftRange.GANYMEDE_RESEARCH_CENTER, craftQuality.FAIR, craftSpeed.AVERAGE, craftTankSize.MEDIUM, 9000, 6, craftOrigin.OUTER_BELT, "Ankaa text");
        }
    }
    public static class Nikephoros extends SpaceCraft {
        public Nikephoros() {
            super("Nikephoros", craftRange.GANYMEDE_RESEARCH_CENTER, craftQuality.GOOD, craftSpeed.SLOW, craftTankSize.LARGE, 10000, 8, craftOrigin.OUTER_BELT, "Nikephoros text");
        }
    }

}
