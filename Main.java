import java.util.*;
class Main {
    public static void main(String[] args) {
        // Setup objects, locations, etc.
        UserInterface ui = new UserInterface();
        Scanner keyboard = new Scanner(System.in);
        Menus menu = new Menus();
        Supplies.Food food = new Supplies.Food();
        Crew crew = new Crew();
        SpaceCraft craft = new SpaceCraft();
        int currentDay = 0;
        currentLocation location = currentLocation.EARTH;
        
        // Welcome
        ui.placeholder("welcome");

        // Select a Ship
        ui.placeholder("select ship");

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