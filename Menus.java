import java.util.*;
public class Menus {
    UserInterface ui = new UserInterface();
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
        ui.println("3. Check crew");
        ui.println("4. Attempt to trade");
        ui.println("5. Talk to people");
        ui.println("6. Perform ship maintenance");
        ui.print("\nWhat is your choice? ");
    }

    public void printStationDailyMenu(currentLocation location){
        ui.clear();
        ui.println("You may:");
        ui.println("1. Continue on your journey");
        ui.println("2. Manage supplies");
        ui.println("3. Manage crew");
        ui.println("4. Manage space craft");
        ui.println("5. Talk to people");
        ui.println("6. Stay overnight at " + location);
        ui.print("\nWhat is your choice?");
    }

}
