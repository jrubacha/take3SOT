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
        Art art = new Art();
        int currentDay = 1;
        int increment = 1;
        int targetDay;
        boolean readyToLeave = false;
        currentLocation location = currentLocation.EARTH;
              
        
        
        // Welcome
        text.printTitleScreen();
        text.printGameIntro();


        // Add Captain to the Crew
        crew.addCaptain();


        // Select a Ship
        text.shipSelectionPrompt(crew.getCaptainName(), food.getMoney());
        menu.offerEarthCraft(crew);
        SpaceCraft craft = crew.getSpaceCraft();
        food.spendMoney(craft.getCost());


        // Assemble a Crew
        crew.assembleCrew(craft.getMaxCapacity());
        crew.printCrewList();


        // Buy Initial Supplies
        ui.clear();
        text.printStarLines();
        text.printIntialPurchaseExplanation();
        text.printStarLines();
        ui.pressEnter();
        text.printBuyFoodPrompt(crew.sumTotalOfCrew());
        int userSelection = keyboard.nextInt();
        food.buySupply(userSelection);
        text.printBuyWaterPrompt(crew.sumTotalOfCrew());
        userSelection = keyboard.nextInt();
        water.buySupply(userSelection);
        text.printSupplies(food, water, crew);


        // Launch
        text.explainLaunchSystem();
        weather.runLaunchSystem();


        // Space Dailies (Earth --> Moon)
        location = currentLocation.SPACE;
        targetDay = currentDay + craft.getTimetoMoon();
        while (currentDay < targetDay) {
            daily.consumeConsumables(crew, food, crew.getSpaceCraft(), water, increment);
            if (!daily.areWeAlive(crew, food, water, crew.getSpaceCraft())) {
                ui.endOfGame(crew, food, water, craft);
            }
            menu.runDailyMenu(targetDay, currentDay, location, crew, food, crew.getSpaceCraft(), water);
            currentDay += increment;
        }


        // Station Dailies (Moon)
        location = currentLocation.MOON_BASE_1;
        text.printMoonWelcome();
        while (!readyToLeave) {
            readyToLeave = menu.runDailyStationMenu(location, food, water, crew, crew.getSpaceCraft(), currentDay);
            currentDay += increment;
        }
        

        // Space Dailies (Moon --> Mars)
        location = currentLocation.SPACE;
        targetDay = currentDay + craft.getTimetoMars();
        increment = 10;
        while (currentDay < targetDay) {
            daily.consumeConsumables(crew, food, crew.getSpaceCraft(), water, increment);
            if (!daily.areWeAlive(crew, food, water, crew.getSpaceCraft())) {
                ui.endOfGame(crew, food, water, craft);
            }
            menu.runDailyMenu(targetDay, currentDay, location, crew, food, crew.getSpaceCraft(), water);
            currentDay += increment;
        }


        // Station Dailies (Mars)
        location = currentLocation.MARS_COLONY_7;
        readyToLeave = false;
        increment = 1;
        text.printMarsWelcome();
        while (!readyToLeave) {
            readyToLeave = menu.runDailyStationMenu(location, food, water, crew, crew.getSpaceCraft(), currentDay);
            currentDay += increment;
        }


        // Space Dailies (Mars --> Inner Belt Transit Station)
        location = currentLocation.SPACE;
        targetDay = currentDay + craft.getTimetoInnerBelt();
        increment = 10;
        while (currentDay < targetDay) {
            daily.consumeConsumables(crew, food, crew.getSpaceCraft(), water, increment);
            if (!daily.areWeAlive(crew, food, water, crew.getSpaceCraft())) {
                ui.endOfGame(crew, food, water, craft);
            }
            menu.runDailyMenu(targetDay, currentDay, location, crew, food, crew.getSpaceCraft(), water);
            currentDay += increment;
        }


        // Station Dailies (Inner Belt Transit Station)
        location = currentLocation.INNER_BELT_TRANSIT_STATION_2;
        readyToLeave = false;
        text.printInnerBeltWelcome();
        increment = 1;
        while (!readyToLeave) {
            readyToLeave = menu.runDailyStationMenu(location, food, water, crew, crew.getSpaceCraft(), currentDay);
            currentDay += increment;
        }


        // Space Dailies (Inner Belt --> Outer Belt)
        location = currentLocation.SPACE;
        targetDay = currentDay + craft.getTimetoOuterBelt();
        increment = 10;
        while (currentDay < targetDay) {
            daily.consumeConsumables(crew, food, crew.getSpaceCraft(), water, increment);
            if (!daily.areWeAlive(crew, food, water, crew.getSpaceCraft())) {
                ui.endOfGame(crew, food, water, craft);
            }
            menu.runDailyMenu(targetDay, currentDay, location, crew, food, crew.getSpaceCraft(), water);
            currentDay += increment;
        }


        // Station Dailies (Outer Belt Outpost 4)
        location = currentLocation.OUTBELT_OUTPOST_4;
        readyToLeave = false;
        text.printOuterBeltWelcome();
        increment = 1;
        while (!readyToLeave) {
            readyToLeave = menu.runDailyStationMenu(location, food, water, crew, crew.getSpaceCraft(), currentDay);
            currentDay += increment;
        }


        // Space Dailies (Outer Belt --> Ganymede)
        location = currentLocation.SPACE;
        targetDay = currentDay + craft.getTimetoGanymede();
        increment = 20;
        while (currentDay < targetDay) {
            daily.consumeConsumables(crew, food, crew.getSpaceCraft(), water, increment);
            if (!daily.areWeAlive(crew, food, water, crew.getSpaceCraft())) {
                ui.endOfGame(crew, food, water, craft);
            }
            menu.runDailyMenu(targetDay, currentDay, location, crew, food, crew.getSpaceCraft(), water);
            currentDay += increment;
        }


        // Arrival on Ganymede
        location = currentLocation.GANYMEDE_RESEARCH_CENTER;
        text.printGanymedeWelcome();


        // Game Over and Report "Score"
        ui.endOfGame(crew, food, water, craft);
    }
}