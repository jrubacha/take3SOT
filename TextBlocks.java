public class TextBlocks {
    UserInterface ui = new UserInterface();

    public void printStarLines(){
        for(int i=0; i<35; i++) {
            ui.print("*");
        }
        ui.println("");
    }
    public void printGameIntro() {
        ui.clear();
        printStarLines();
        ui.println("Greetings eager space traveller, and welcome to Star Command.\n\nToday marks your first step in a long journey through the stars. We're glad you chose us to fly with.\n\nYour mission? Successfully navigate the solar system and deliver your crew and equipment safely to the Ganymede Research Center. They are counting on you to get the job done.\n");
        printStarLines();
        ui.pressEnter();
    }

    public void printLaunchPrompt(){
        ui.print("\n1. Launch Today\n2. Postpone launch one day\n\nWhat would you like to do? ");
    }

    public void printMoonWelcome() {
        ui.clear();
        printStarLines();
        ui.println("Wecolme to Moon Base 1! Established in 2154, Moon Base 1 is a thriving hub of near-field research, commerce, and entertainment. You are welcome to stay in your docking station as long as you want, parking here is always free. Check out the vendors if you need a new ship or more supplies. Star Command Regional offices are always open if want to hire/fire any crew members. Interstellar launch rings will be waiting to take you on to Mars when you're ready to leave.\n");
        printStarLines();
        ui.pressEnter();
    }
    public void printSpaceCraftVendorDialogue(){
        ui.clear();
        ui.println("< Welcome to Al's Space Barn >\n\nWe've got all your space craft needs, offered to you at low low prices. No need to worry about pesky launch costs here. I bet you'll find something you like.\n");
        ui.pressEnter();
    }
    public void shipSelectionPrompt(String captainName, int money) {
        ui.clear();
        printStarLines();
        ui.println("Welcome aboard Captain " + captainName + "!\n\nYour first task is to choose a ship.\n\nChoose wisely, some of these flight vehicles are meant for short voyages only and others are suitable for long hauls. You will have the opportunity to purchase a new flight vehicle at each waystation.\n\nYour starting budget is $" + money + ". Ship costs include any fuel needed to get out of Earth's orbit.");
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
        printStarLines();
        ui.println("Congrats! You didn't die on launch."); // TODO: make better success message
        printStarLines();
        ui.pressEnter();
    }
}
