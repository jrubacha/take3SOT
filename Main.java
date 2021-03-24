import java.util.*;
class Main {
    public static void main(String[] args) {
        // Setup objects, locations, etc.
        UserInterface ui = new UserInterface();
        TextBlocks text = new TextBlocks();
        Scanner keyboard = new Scanner(System.in);
        Menus menu = new Menus();
        Supplies.Food food = new Supplies.Food();
        Crew crew = new Crew();
        SpaceCraft craft = new SpaceCraft.SaturnV();
        int currentDay = 0;
        int money = 0;
        currentLocation location = currentLocation.EARTH;
        
        SpaceCraft[] moonCraft = {new SpaceCraft.Skybird(), new SpaceCraft.Helios(), new SpaceCraft.Pegasus()};
        
        // Welcome
        text.printGameIntro();

        // Add Captain to the Crew
        crew.addCaptain();

        // Select a Ship
        text.shipSelectionPrompt(crew.getCaptainName(), money);
        craft = menu.offerEarthCraft();

        // Assemble a Crew
        ui.placeholder("make crew");

        // Buy Initial Supplies
        ui.placeholder("buy supplies");

        // Launch
        ui.placeholder("launch");

        // Space Dailies (Earth --> Moon)
        location = currentLocation.SPACE;
        while (currentDay < 3) { // loop needs to run until target reached
            menu.printSpaceDailyHeader(currentDay, location, crew, food, craft);
            ui.pressEnter();
            menu.runDailyMenu(food, crew);
            currentDay++;
        }

        // Station Dailies (Moon)
        location = currentLocation.MOON_BASE_1;
        while (currentDay < 6) { // loop needs to run until user leaves moon
            menu.printSpaceDailyHeader(currentDay, location, crew, food, craft);
            menu.runDailyStationMenu(location, food, crew);
            currentDay++;
        }

        // Space Dailies (Moon --> Mars)
        location = currentLocation.SPACE;

        // Station Dailies (Mars)
        location = currentLocation.MARS_COLONY_7;

        // Space Dailies (Mars --> Inner Belt Transit Station)
        location = currentLocation.SPACE;

        // Station Dailies (Inner Belt Transit Station)
        location = currentLocation.INNER_BELT_TRANSIT_STATION_2;

        // Space Dailies (Inner Belt --> Outer Belt)
        location = currentLocation.SPACE;

        // Station Dailies (Outer Belt Outpost 4)
        location = currentLocation.OUTBELT_OUTPOST_4;

        // Space Dailies (Outer Belt --> Ganymede)
        location = currentLocation.SPACE;

        // Arrival on Ganymede
        location = currentLocation.GANYMEDE_RESEARCH_CENTER;

        // Game Over and Report Score
    }
}