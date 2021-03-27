public class TextBlocks {
    UserInterface ui = new UserInterface();
    Art art = new Art();

    public void printStarLines(){
        for(int i=0; i<35; i++) {
            ui.print("*");
        }
        ui.println("");
    }
    public void printGameIntro() {
        ui.clear();
        printStarLines();
        ui.println("Greetings eager space traveller, and welcome to Star Command.\n\nToday marks your first step in a long journey through the stars. We're glad you chose us to fly with.\n\nYour mission? Successfully navigate the solar system and deliver your crew and equipment safely to the Ganymede Research Center. They are counting on you to get the job done.");
        art.printNightScene();
        ui.pressEnter();
    }

    public void printBuyFuelPrompt(Crew crew){
        ui.clear();
        ui.print("< Buying Fuel >\n\nYour craft can hold " + crew.getSpaceCraft().getMaxFuel() + " gallons of fuel.\n\nHow much would you like to purchase? ");
    }

    public void printLaunchPrompt(){
        ui.print("\n1. Launch Today\n2. Postpone launch one day\n\nWhat would you like to do? ");
    }

    public void printMoonWelcome() {
        ui.clear();
        printStarLines();
        ui.println("Wecolme to Moon Base 1! Established in 2154, Moon Base 1 is a thriving hub of near-field research, commerce, and entertainment. You are welcome to stay in your docking station as long as you want, parking here is always free. Check out the vendors if you need a new ship or more supplies. Star Command Regional offices are always open if want to hire/fire any crew members. Interstellar launch rings will be waiting to take you on to Mars when you're ready to leave.");
        printStarLines();
        ui.pressEnter();
    }

    public void printMarsWelcome() {
        ui.clear();
        printStarLines();
        ui.println("Welcome to Mars Colony 7!\n\nNestled on the edge of Solis Lacus, or \"The Eye of Mars\" if you will, Colony 7 is small outpost dedicated to maintaining services for outbound travellers such as yourself. You'll find our shops, crew quarters, and maintenance bays up to the task of preparing you to get where you need to go.");
        printStarLines();
        ui.pressEnter();
    }

    public void printInnerBeltWelcome(){
        ui.clear();
        printStarLines();
        ui.println("Greetings traveller! Transit Station 2 welcomes you to her docking bays. As your last stop before crossing into the asteroid belt, we encourage you to stock up on anything you might need before departing.");
        printStarLines();
        ui.pressEnter();
    }

    public void printOuterBeltWelcome(){
        ui.clear();
        printStarLines();
        ui.println("Welcome to the middle of nowhere. This is Outpost 4, first post-asteroid belt relief station. You already know what kind of amenities we offer, so I'll let you get to it. This is the last rest point before the Ganymede Research Center, so think twice before leaving, it's a long trip out there.");
        printStarLines();
        ui.pressEnter();
    }
    public void printGanymedeWelcome(){
        ui.clear();
        printStarLines();
        ui.println("You've done it! You've arrived at the Ganymede Research Center!\n\nWe're so glad you're here. The equipment you've brought will be instrumental to our success, we need it more than ever. You wouldn't believe the logistical challenges in having to order things years in advance.\n\nThank you and welcome.");
        printStarLines();
        ui.pressEnter();
    }
    public void printSpaceCraftVendorDialogue(){
        ui.clear();
        ui.println("< Welcome to Al's Space Barn >\n\nWe've got all your space craft needs, offered to you at low low prices. No need to worry about pesky launch costs here. I bet you'll find something you like.\n");
        ui.pressEnter();
    }
    public void shipSelectionPrompt(String captainName, double money) {
        ui.clear();
        printStarLines();
        ui.println("Welcome aboard Captain " + captainName + "!\n\nYour first task is to choose a ship.\n\nChoose wisely, some of these flight vehicles are meant for short voyages only and others are suitable for long hauls. You will have the opportunity to purchase a new flight vehicle at each waystation.\n\nYour starting budget is $" + (int) money + ". Ship costs include any fuel needed to get out of Earth's orbit.");
        printStarLines();
        ui.pressEnter();
    }

    public void printPurchaseShipOptions(){
        ui.print("\n1. See next ship\n2. Purchase this ship\n\nWhat would you like to do? ");
    }

    public void printSpacePurchaseShipOptions(){
        ui.print("\n1. See next ship\n2. Purchase this ship\n3. Leave\n\nWhat would you like to do? ");
    }

    public void printMissedLaunchWindow(){
        ui.clear();
        printStarLines();
        ui.println("Oh no! You waited too long!"); // TODO: make better message
        printStarLines();
        System.exit(0);
    }

    public void printBadWeatherLaunchMessage(){
        ui.clear();
        printStarLines();
        ui.println("\nWeather conditions proved unfavorable for the launch.\n\nStart Command is sorry to report that all hands were lost.");
        printStarLines();
        System.exit(0);
    }

    public void printSuccessfulLaunchMessage() {
        ui.clear();
        art.printShip1();
        printStarLines();
        ui.println("Congrats! You didn't die on launch."); // TODO: make better success message
        printStarLines();
        ui.pressEnter();
    }

    public void printSupplies(Supplies.Food food, Supplies.Water water, Crew crew){
        ui.clear();
        printStarLines();
        food.printFoodQuantity();
        water.printWaterQuantity();
        crew.getSpaceCraft().printRelativeFuelLevel();
        ui.println("current fuel: " + crew.getSpaceCraft().getCurrentFuel()); // TODO: remove later
        food.printMoney();
        printStarLines();
        ui.pressEnter();
    }

    public void printBuyFoodPrompt(){
        ui.clear();
        ui.print("< Buying Food >\n\nThe average person eats 2 lbs of food a day.\n\nHow many pounds of food would you like to buy? ");
    }

    public void printBuyWaterPrompt(){
        ui.clear();
        ui.print("< Buying Water >\n\nThe average person needs 1 liter of water a day.\n\nHow many liters of water would you like to buy? ");
    }
}
