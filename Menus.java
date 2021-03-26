/*
Writing and running menus
*/

import java.util.*;


public class Menus {
    UserInterface ui = new UserInterface();
    TextBlocks text = new TextBlocks();
    Talkies talk = new Talkies();
    Scanner keyboard = new Scanner(System.in);

    public void printSpaceDailyHeader(int targetDay, int currentDay, currentLocation location, Crew crew, Supplies.Food food, SpaceCraft craft){
        ui.clear();
        ui.println("Day #" + currentDay);
        ui.println("Location: " + location);
        ui.println("Crew health: "); // TODO: fix/create average crew health method
        ui.println("Food: " + food.getAmount());
        ui.println("Days until next stop: " + (targetDay - currentDay));
        text.printStarLines();
    }

    public void printSpaceDailyMenu(){
        //ui.clear();
        ui.println("You may:");
        ui.println("1. Continue on your journey");
        ui.println("2. Check supplies");
        ui.println("3. Change food rations");
        ui.println("4. Check crew");
        ui.println("5. Attempt to trade");
        ui.println("6. Talk to people");
        ui.println("7. Perform ship maintenance");
        ui.print("\nWhat is your choice? ");
    }

    public void runDailyMenu(Supplies.Food food, Crew crew, Supplies.Water water, int day){
        int userSelection = 0;
        while (userSelection != 1) {
            printSpaceDailyMenu();
            userSelection = keyboard.nextInt();
            switch (userSelection) {
                case 1: // continue on journey
                    break;
                case 2: // check supplies
                    text.printSupplies(food, water);
                    ui.clear();
                    break;
                case 3: // change food rations
                    food.printChangeRationSizePrompt();
                    runChangeFoodRation(food);
                    ui.clear();
                    break;
                case 4: // check crew
                    crew.printCrewList();
                    ui.clear();
                    break;
                case 5: // attempt to trade
                    if (crew.doesCrewHaveCommOfficer()) {
                        ui.placeholder("trade"); // TODO: Figure out how trading works...
                    } else {
                        ui.println("\nYou do not have a communications officer. You cannot contact anyone to trade.");
                        ui.pressEnter();
                    }
                    ui.clear();
                    break;
                case 6: // talk to people
                    if (crew.doesCrewHaveCommOfficer()) {
                        talk.pickATalky(day);
                    } else {
                        ui.println("\nYou do not have a communications officer. You cannot contact anyone to talk.");
                        ui.pressEnter();
                    }
                    ui.clear();
                    break;
                case 7: // perform ship maintenance
                    if (crew.doesCrewHaveCommOfficer()) {
                        ui.placeholder("repair"); // TODO: Make repair minigame?
                    } else {
                        ui.println("\nYou do not have an engineer. You cannot repair the ship in space.");
                        ui.pressEnter();
                    }
                    ui.clear();
                    break;
                default:
                    userSelection = 0;
                    break;
            }
        }
    }

    public void printStationDailyMenu(currentLocation location, int day, Crew crew){
        ui.clear();
        ui.println("Day #" + day);
        ui.println("Location: " + location);
        ui.println("Crew Health: "); // TODO: finish once avg crew health made
        text.printStarLines();
        ui.println("You may:");
        ui.println("1. Depart from " + location);
        ui.println("2. Manage supplies");
        ui.println("3. Manage crew");
        ui.println("4. Manage space craft");
        ui.println("5. Talk to people");
        ui.println("6. Stay overnight at " + location);
        ui.print("\nWhat is your choice? ");
    }

    public boolean runDailyStationMenu(currentLocation location, Supplies.Food food, Supplies.Water water, Crew crew, SpaceCraft craft, int currentDay) {
        int userSelection = 1;
        boolean readyToLeave = false;
        while (userSelection != 0) {
            printStationDailyMenu(location, currentDay, crew);
            userSelection =  ui.getUserInt(); // keyboard.nextInt(); //
            switch (userSelection) {
                case 1: // depart the current station
                    // verify the user wants to leave
                    ui.placeholder("depart " + location);
                    readyToLeave = true;
                    userSelection = 0;
                    break;
                case 2: // manage supplies
                    printManageSuppliesMenu();
                    runManageSuppliesMenu(food, water);
                    break;
                case 3: // manage crew
                    printManageCrewMenu();
                    runManageCrewMenu(crew, craft);
                    break;
                case 4: // manage spact craft
                    printManageCraftMenu();
                    runManageCraftMenu(craft, location, crew);
                    break;
                case 5: // talk to people
                    talk.pickATalky(currentDay);
                    break;
                case 6: // stay overnight
                    ui.placeholder("stay overnight");
                    userSelection = 0;
                    break;
                default:
                    break;
            }
        }
        return readyToLeave;
    }

    public void printManageSuppliesMenu(){
        ui.clear();
        ui.println("< Managing Supplies >\n");
        ui.println("You may:");
        ui.println("1. Check supplies");
        ui.println("2. Buy supplies");
        ui.println("3. Sell supplies");
        ui.println("4. Change food ration size");
        ui.println("5. Attempt to trade");
        ui.println("6. Do nothing"); // exits out of current menu with no changes
        ui.print("\nWhat is your choice? ");
    }

    public void runManageSuppliesMenu(Supplies.Food food, Supplies.Water water){
        int userSelection = 0;
        do {
            userSelection = keyboard.nextInt();
            switch (userSelection){
                case 1: // check supplies
                    text.printSupplies(food, water);
                    break;
                case 2: // buy supplies
                    ui.clear();
                    ui.print("You may buy:\n1. Food\n2. Water\n3. Fuel.\n4. Spare parts\n5. Space suits\n6. Do nothing\n\nWhat is your choice? ");
                    runBuySuppliesMenu(food, water);
                    break;
                case 3: // sell supplies
                    ui.clear();
                    ui.print("You may sell:\n1. Food\n2. Water\n3. Fuel.\n4. Spare parts\n5. Space suits\n6. Do nothing\n\nWhat is your choice? ");
                    runSellSuppliesMenu(food, water);
                    break;
                case 4: // change food ration size
                    food.printChangeRationSizePrompt();
                    runChangeFoodRation(food);
                    break;
                case 5: // attempt to trade
                    ui.placeholder("trade dialogue");
                    ui.placeholder("trade dialogue");
                    break;
                case 6: // do nothing
                    break;
                default:
                    userSelection = 0;
                    printManageSuppliesMenu();
                    break;
            } 
        } while (userSelection == 0);
    }

    public void runBuySuppliesMenu(Supplies.Food food, Supplies.Water water){
        int userSelection = 0;
        do {
            userSelection = keyboard.nextInt();
            switch(userSelection) {
                case 1: // buy food
                    text.printBuyFoodPrompt();
                    food.buySupply(keyboard.nextInt());
                    break;
                case 2: // buy water
                    text.printBuyWaterPrompt();
                    water.buySupply(keyboard.nextInt());
                    break;
                case 3: // buy fuel
                    ui.placeholder("buy fuel");
                    break;
                case 4: // buy spare parts
                    ui.placeholder("buy spare parts");
                    break;
                case 5: // buy space suits
                    ui.placeholder("buy space suits");
                    break;
                case 6: // do nothing and leave
                    break;
                default: // loop menu until valid choice
                    userSelection = 0;
                    break;
            }
        } while (userSelection == 0);
    }
    public void runSellSuppliesMenu(Supplies.Food food, Supplies.Water water){
        int userSelection = 0;
        do {
            userSelection = keyboard.nextInt();
            switch(userSelection) {
                case 1: // sell food
                    ui.print("How many pounds of food would you like to sell? ");
                    food.sellSupply(keyboard.nextInt());
                    break;
                case 2: // sell water
                    ui.print("How many liters of water would you like to sell? ");
                    water.sellSupply(keyboard.nextInt());
                    break;
                case 3: // sell fuel
                    ui.placeholder("sell fuel");
                    break;
                case 4: // buy spare parts
                    ui.placeholder("sell spare parts");
                    break;
                case 5: // buy space suits
                    ui.placeholder("sell space suits");
                    break;
                case 6: // do nothing and leave
                    break;
                default: // loop menu until valid choice
                    userSelection = 0;
                    break;
            }
        } while (userSelection == 0);
    }
    public void printManageCrewMenu(){
        ui.clear();
        ui.println("< Managing Crew >\n");
        ui.println("You may:");
        ui.println("1. View crew list");
        ui.println("2. Hire crew members");
        ui.println("3. Fire crew members");
        ui.println("4. Do nothing");
        ui.print("\nWhat is your choice? ");
    }

    public void runManageCrewMenu(Crew crew, SpaceCraft craft){
        int userSelection = 0;
        do {
            userSelection = keyboard.nextInt();
            switch (userSelection){
                case 1: // view crew list
                    crew.printCrewList();
                    break;
                case 2: // hire crew members
                    crew.assembleCrew(craft.getMaxCapacity());
                    break;
                case 3: // fire crew members
                    crew.fireCrewMember();
                    break;
                case 4: // do nothing
                    break;
                default:
                    userSelection = 0;
                    printManageCrewMenu();
                    break;
            } 
        } while (userSelection == 0);
    }

    public void printManageCraftMenu(){
        ui.clear();
        ui.println("< Managing Space Craft >\n");
        ui.println("You may:");
        ui.println("1. View current craft's specs");
        ui.println("2. Buy space craft");
        ui.println("3. Craft maintenance");
        ui.println("4. Do nothing");
        ui.println("\nWhat is your choice? ");
    }

    public void runManageCraftMenu(SpaceCraft craft, currentLocation Location, Crew crew){
        int userSelection = 0;
        do {
            userSelection = keyboard.nextInt();
            switch (userSelection){
                case 1: // view current craft's specs
                    craft.printFullCraftSpecs();
                    break;
                case 2: // buy space craft
                    offerMoonCraft();
                    break;
                case 3: // craft maintenance
                    printStationMaintenanceMenu();
                    runStationMaintenanceMenu(craft, crew);
                    break;
                case 4: // do nothing
                    break;
                default:
                    userSelection = 0;
                    printManageCraftMenu();
                    break;
            } 
        } while (userSelection == 0);
    }

    public void printStationMaintenanceMenu(){
        ui.clear();
        ui.println("< Space Craft Maintenance >\n");
        ui.println("You may:");
        ui.println("1. Have crew engineers perform maintenance - Free, minimal repair gain");
        ui.println("2. Have station repairmen perform maintenance = $1000, Excellent repair gain");
        ui.println("3. Do nothing");
        ui.print("\nWhat would you like to do? ");
    }

    public void runStationMaintenanceMenu(SpaceCraft craft,Crew crew){
        int userSelection = 0;
        do {
            userSelection = keyboard.nextInt();
            switch (userSelection){
                case 1: // crew engineers
                    ui.placeholder("crew engineers do maintenance");
                    break;
                case 2: // station engineers
                    ui.placeholder("station engineers do maintenance");
                    break;
                case 3: // do nothing
                    break;
                default:
                    userSelection = 0;
                    printStationMaintenanceMenu();
                    break;
            } 
        } while (userSelection == 0);
    }
   
    public SpaceCraft offerEarthCraft(){
        SpaceCraft[] earthCraft = {new SpaceCraft.SaturnV(), new SpaceCraft.Atlas(), new SpaceCraft.NewShepard(), new SpaceCraft.Artemis(), new SpaceCraft.NewOrion()};
        boolean needAShip = true;
        int userSelection, i = 0;
        while (needAShip) {
            for (i=0; i<earthCraft.length; i++) {
                printEarthSpaceCraftShopFormat(earthCraft[i]);
                userSelection = keyboard.nextInt();
                if (userSelection == 2) {
                    needAShip = false;
                    break;
                }
            }
        }
        return earthCraft[i];
    }

    public SpaceCraft offerMoonCraft(){
        SpaceCraft[] moonCraft = {new SpaceCraft.Skybird(), new SpaceCraft.Helios(), new SpaceCraft.Pegasus()};
        boolean needAShip = true;
        int userSelection, i = 0;
        while (needAShip) {
            for (i=0; i<moonCraft.length; i++) {
                printSpaceCraftShopFormat(moonCraft[i]);
                userSelection = keyboard.nextInt();
                if (userSelection == 2 || userSelection == 3) {
                    needAShip = false;
                    break;
                }
            }
        }
        return moonCraft[i];
    }

    public SpaceCraft offerMarsCraft(){
        SpaceCraft[] marsCraft = {new SpaceCraft.Avalon(), new SpaceCraft.Mayflower(), new SpaceCraft.Foxfire()};
        boolean needAShip = true;
        int userSelection, i = 0;
        while (needAShip) {
            for (i=0; i<marsCraft.length; i++) {
                printSpaceCraftShopFormat(marsCraft[i]);
                userSelection = keyboard.nextInt();
                if (userSelection == 2 || userSelection == 3) {
                    needAShip = false;
                    break;
                }
            }
        }
        return marsCraft[i];
    }

    public SpaceCraft offerIBCraft(){
        SpaceCraft[] ibCraft = {new SpaceCraft.Skybird(), new SpaceCraft.Helios(), new SpaceCraft.Pegasus()}; // TODO: Fix this
        boolean needAShip = true;
        int userSelection, i = 0;
        while (needAShip) {
            for (i=0; i<ibCraft.length; i++) {
                printSpaceCraftShopFormat(ibCraft[i]);
                userSelection = keyboard.nextInt();
                if (userSelection == 2 || userSelection == 3) {
                    needAShip = false;
                    break;
                }
            }
        }
        return ibCraft[i];
    }

    public SpaceCraft offerOBCraft(){
        SpaceCraft[] obCraft = {new SpaceCraft.Skybird(), new SpaceCraft.Helios(), new SpaceCraft.Pegasus()}; // TODO: fix this
        boolean needAShip = true;
        int userSelection, i = 0;
        while (needAShip) {
            for (i=0; i<obCraft.length; i++) {
                printSpaceCraftShopFormat(obCraft[i]);
                userSelection = keyboard.nextInt();
                if (userSelection == 2 || userSelection == 3) {
                    needAShip = false;
                    break;
                }
            }
        }
        return obCraft[i];
    }

    public void printEarthSpaceCraftShopFormat(SpaceCraft craft){
        ui.clear();
        text.printStarLines();
        craft.printQuickDescription();
        craft.printShortSpecs();
        text.printStarLines();
        text.printPurchaseShipOptions();
    }

    public void printSpaceCraftShopFormat(SpaceCraft craft){
        ui.clear();
        text.printStarLines();
        craft.printQuickDescription();
        craft.printShortSpecs();
        text.printStarLines();
        text.printSpacePurchaseShipOptions();
    }

    public void runChangeFoodRation(Supplies.Food food){
        switch (keyboard.nextInt()) {
            case 1:
                food.setRationSizeToFilling();
                break;
            case 2:
                food.setRationSizeToMeager();
                break;
            case 3:
                food.setRationSizeToBareBones();
                break;
            default:
                food.setRationSizeToFilling();
                break;
        }
    }
}
