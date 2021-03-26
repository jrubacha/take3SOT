import java.util.*;
class Main {
    public static void main(String[] args) {
        // Setup objects, locations, etc.
        UserInterface ui = new UserInterface();
        TextBlocks text = new TextBlocks();
        SpaceDailies daily = new SpaceDailies();
        Scanner keyboard = new Scanner(System.in);
        Menus menu = new Menus();
        Weather weather = new Weather();
        Supplies.Food food = new Supplies.Food();
        Supplies.Water water = new Supplies.Water();
        Crew crew = new Crew();
        SpaceCraft craft = new SpaceCraft.SaturnV();
        int currentDay = 1;
        int increment = 1;
        int targetDay;
        boolean readyToLeave = false;
        currentLocation location = currentLocation.EARTH;
              
        
        
        // Welcome
        text.printGameIntro();

        // Add Captain to the Crew
        crew.addCaptain();

        // Select a Ship
        text.shipSelectionPrompt(crew.getCaptainName(), food.getMoney());
        craft = menu.offerEarthCraft();
        food.spendMoney(craft.getCost());

        // Assemble a Crew
        // TODO: intro text
        crew.assembleCrew(craft.getMaxCapacity());
        crew.printCrewList();

        // Buy Initial Supplies
        ui.println("Now that you have a crew, you'll need to take care of them.\n\nYou'll need to make initial purchases of food and water to last at least until you can get to the moon.\n");
        text.printStarLines();
        text.printBuyFoodPrompt();
        int userSelection = ui.getUserInt();
        food.buySupply(userSelection);
        text.printBuyWaterPrompt();
        userSelection = ui.getUserInt();
        water.buySupply(userSelection);
        text.printSupplies(food, water);

        // Launch
        weather.runLaunchSystem();

        // Space Dailies (Earth --> Moon)
        location = currentLocation.SPACE;
        targetDay = currentDay + craft.getTimetoMoon();
        while (currentDay < targetDay) { // loop needs to run until target reached
            daily.consumeConsumables(crew, food, craft, water, increment);
            if (!daily.areWeAlive(crew, food, water, craft)) {
                System.exit(0);
            }
            menu.printSpaceDailyHeader(targetDay, currentDay, location, crew, food, craft);
            // ui.pressEnter();
            menu.runDailyMenu(food, crew, water, currentDay);
            currentDay += increment;
        }

        // Station Dailies (Moon)
        location = currentLocation.MOON_BASE_1;
        text.printMoonWelcome();
        while (!readyToLeave) { // loop needs to run until user leaves moon
            // daily.consumeConsumables(crew, food, craft, water, increment);
            menu.printSpaceDailyHeader(0, currentDay, location, crew, food, craft);
            readyToLeave = menu.runDailyStationMenu(location, food, water, crew, craft, currentDay);
            currentDay += increment;
        }

        // Space Dailies (Moon --> Mars)
        location = currentLocation.SPACE;
        targetDay = currentDay + craft.getTimetoMoon();

        // Station Dailies (Mars)
        location = currentLocation.MARS_COLONY_7;
        text.printMarsWelcome();

        // Space Dailies (Mars --> Inner Belt Transit Station)
        location = currentLocation.SPACE;

        // Station Dailies (Inner Belt Transit Station)
        location = currentLocation.INNER_BELT_TRANSIT_STATION_2;
        text.printInnerBeltWelcome();

        // Space Dailies (Inner Belt --> Outer Belt)
        location = currentLocation.SPACE;

        // Station Dailies (Outer Belt Outpost 4)
        location = currentLocation.OUTBELT_OUTPOST_4;
        text.printOuterBeltWelcome();

        // Space Dailies (Outer Belt --> Ganymede)
        location = currentLocation.SPACE;

        // Arrival on Ganymede
        location = currentLocation.GANYMEDE_RESEARCH_CENTER;
        text.printGanymedeWelcome();

        // Game Over and Report Score
    }
}