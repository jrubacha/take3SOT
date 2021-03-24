public class TextBlocks {
    UserInterface ui = new UserInterface();

    private void printStarLines(){
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
    public void printSaturnVText(){
        ui.println("\nOption 1: Saturn V Rocket\n\nA flight vehicle straight out of history, this rocket will get you where you need to go. So long as that place is the Moon.\nKeep your initial flight crew small, three passengers maximum, including you Captain.\n\nCost: 1000\nCapacity: 3\nRange: Moon Base");
    }
    public void printFalconText(){
        ui.println("\nOption 2: Atlas Falcon\n\nA slightly more modern alternative to the Saturn V, the Atlas Falcon is similarly capable of lifting you and three others into orbit.\n\nCost: 5000\nCapacity: 4\nRange: Moon Base");
    }
    public void printNewShepardText(){
        ui.println("\nOption 3: New Shepard XC\n\nIt’s not the prettiest spacecraft, but the New Shepard will get you out into the solar system. With an extended range from its earlier counterparts, this ship will take you all the way to Mars, maybe further if you’re careful with your supplies.\n\nCost: 10000\nCapacity: 6\nRange: Inner Ring Station");
    }
    public void printArtemisText(){
        ui.println("\nOption 4: Artemis N\n\nOne of the world’s leaders in solar system travel, Artemis doesn’t disappoint with their ‘N’ series craft. Designed for long journeys in mind, the Artemis N will take you wherever you need to go.\n\nCost: 20000\nCapacity: 10\nRange: Kuiper Belt");
    }
    public void printNewOrionText(){
        ui.println("\nOption 5: New Orion\n\nTHE interstellar flight vehicle. Top of the line in speed, luxury, and navigational control, you can’t go wrong with this craft. Travel in style to your destination and never worry about a thing.\n\nCost: 40000\nCapacity: 12\nRange: Proxima b");
    }
    public void printLaunchPrompt(){
        ui.print("\n1. Launch Today\n2. Postpone launch one day\n\nWhat would you like to do? ");
    }
    public void printLaunchSuccess() {
        ui.print("Congrats on making it to space. You're on your way to the Moon now. ");
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
    public void printSkybirdText(){
        ui.println("Skybird's an delapidated Earthcraft left adrift around the moon. We towed her back and cleaned her up. Don't expect to get past Mars with this ol' ship.");
    }
    public void printHelios9Text(){
        ui.println("The Helios 9 was built in space, for space. She's an older model though, not quite suited for a trip across the belt. A decent mid system hopper, I'd say.");
    }
    public void printPegasusText(){
        ui.println("Looking for luxury? Look no further. The Pegasus was designed for you to travel anywhere in the galaxy in stylish comfort. Just, don't expect to get there in a hurry, okay? Sit back and enjoy the trip.");
    }

}
