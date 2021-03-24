/*
Writing and running menus
*/

import java.util.*;
public class Menus {
    UserInterface ui = new UserInterface();
    TextBlocks text = new TextBlocks();
    Scanner keyboard = new Scanner(System.in);

    public void printSpaceDailyHeader(int whichDay, currentLocation location, Crew crew, Supplies.Food food, SpaceCraft craft){
        ui.clear();
        ui.println("Day #" + whichDay);
        ui.println("Location: " + location);
        ui.println("Crew health: "); // TODO: fix/create average crew health method
        ui.println("Food: "); // TODO: create remaining food method
        ui.println("Days until next stop: "); // TODO: create days until method
    }

    public void printSpaceDailyMenu(){
        ui.clear();
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

    public void runDailyMenu(Supplies.Food food, Crew crew){
        int userSelection = 0;
        while (userSelection != 1) {
            printSpaceDailyMenu();
            userSelection =    keyboard.nextInt(); // ui.getUserInt(); //
            switch (userSelection) {
                case 1: // continue on journey
                    break;
                case 2: // check supplies
                    ui.placeholder("supplies");
                    break;
                case 3: // change food rations
                    ui.placeholder("rations");
                    break;
                case 4: // check crew
                    ui.placeholder("check crew");
                    break;
                case 5: // attempt to trade
                    ui.placeholder("trade");
                    break;
                case 6: // talk to people
                    ui.placeholder("talk people");
                    break;
                case 7: // perform ship maintenance
                    ui.placeholder("maintenance");
                    break;
                default:
                    userSelection = 0;
                    break;
            }
        }
    }

    public void printStationDailyMenu(currentLocation location){
        ui.clear();
        ui.println("You may:");
        ui.println("1. Depart from " + location);
        ui.println("2. Manage supplies");
        ui.println("3. Manage crew");
        ui.println("4. Manage space craft");
        ui.println("5. Talk to people");
        ui.println("6. Stay overnight at " + location);
        ui.print("\nWhat is your choice?");
    }

    public void runDailyStationMenu(currentLocation location, Supplies.Food food, Crew crew) {
        int userSelection = 1;
        while (userSelection != 0) {
            printStationDailyMenu(location);
            userSelection =  ui.getUserInt(); // keyboard.nextInt(); //
            switch (userSelection) {
                case 1: // depart the current station
                    // verify the user wants to leave
                    ui.placeholder("depart " + location);
                    userSelection = 0;
                    break;
                case 2: // manage supplies
                    printManageSuppliesMenu();
                    runManageSuppliesMenu();
                    break;
                case 3: // manage crew
                    printManageCrewMenu();
                    runManageCrewMenu();
                    break;
                case 4: // manage spact craft
                    printManageCraftMenu();
                    runManageCraftMenu();
                    break;
                case 5: // talk to people
                    ui.placeholder("talk to people");
                    break;
                case 6: // stay overnight
                    ui.placeholder("stay overnight");
                    userSelection = 0;
                    break;
                default:
                    break;
            }
        }
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

    public void runManageSuppliesMenu(){
        int userSelection = keyboard.nextInt();
        do {
            switch (userSelection){
                case 1: // check supplies
                    break;
                case 2: // buy supplies
                    break;
                case 3: // sell supplies
                    break;
                case 4: // change food ration size
                    break;
                case 5: // attempt to trade
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

    public void runManageCrewMenu(){
        int userSelection = keyboard.nextInt();
        do {
            switch (userSelection){
                case 1: // view crew list
                    break;
                case 2: // hire crew members
                    break;
                case 3: // fire crew members
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

    public void runManageCraftMenu(){
        int userSelection = keyboard.nextInt();
        do {
            switch (userSelection){
                case 1: // view current craft's specs
                    break;
                case 2: // buy space craft
                    break;
                case 3: // craft maintenance
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

    public void runStationMaintenanceMenu(){
        int userSelection = keyboard.nextInt();
        do {
            switch (userSelection){
                case 1: // crew engineers
                    break;
                case 2: // station engineers
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
}
