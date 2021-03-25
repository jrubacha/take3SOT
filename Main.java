import java.util.*;
class Main {
    public static void main(String[] args) {
        // Setup objects, locations, etc.
        UserInterface ui = new UserInterface();
        TextBlocks text = new TextBlocks();
        Scanner keyboard = new Scanner(System.in);
        Menus menu = new Menus();
        Weather weather = new Weather();
        Supplies.Food food = new Supplies.Food();
        Supplies.Water water = new Supplies.Water();
        Crew crew = new Crew();
        SpaceCraft craft = new SpaceCraft.SaturnV();
        int currentDay = 1;
        int targetDay;
        int money = 0;
        boolean readyToLeave = false;
        currentLocation location = currentLocation.EARTH;
        
        
        
        // Welcome
        text.printGameIntro();

        // Add Captain to the Crew
        crew.addCaptain();

        // Select a Ship
        text.shipSelectionPrompt(crew.getCaptainName(), money);
        craft = menu.offerEarthCraft();

        // Assemble a Crew
        // TODO: intro text
        crew.assembleCrew(craft.getMaxCapacity());
        // TODO: print crew list

        // Buy Initial Supplies
        ui.print("buy food prompt");
        int userSelection = keyboard.nextInt();
        food.buySupply(userSelection, money);
        ui.println("buy water prompt");
        userSelection = keyboard.nextInt();
        water.buySupply(userSelection, money);
        text.printSupplies(food, water);

        // Launch
        weather.runLaunchSystem();

        // Space Dailies (Earth --> Moon)
        location = currentLocation.SPACE;
        targetDay = currentDay + craft.getTimetoMoon();
        while (currentDay < targetDay) { // loop needs to run until target reached
            menu.printSpaceDailyHeader(currentDay, location, crew, food, craft);
            ui.pressEnter();
            menu.runDailyMenu(food, crew, water);
            currentDay++;
        }

        // Station Dailies (Moon)
        location = currentLocation.MOON_BASE_1;
        text.printMoonWelcome();
        while (!readyToLeave) { // loop needs to run until user leaves moon
            menu.printSpaceDailyHeader(currentDay, location, crew, food, craft);
            readyToLeave = menu.runDailyStationMenu(location, food, crew);
            currentDay++;
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