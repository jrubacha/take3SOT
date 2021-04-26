import java.util.*;
public class UserInterface {
    Scanner keyboard = new Scanner(System.in);
    //TextBlocks text = new TextBlocks();

    public void print(String word) {
        System.out.print(word);
    }
    public void println(String word) {
        System.out.println(word);
    }
    public void clear(){
        // Temp. removal because school computer is booty
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // really bad temp fix
        // for (int i=0; i<50;i++){
        //     println("");
        // }
    }
    public void pressEnter(){
        print("\n< Press ENTER to continue >");
        keyboard.nextLine();
    }

    // public int getUserInt(){
    //     int a = 0;
    //     while (a == 0) {
    //         try {
    //             a = keyboard.nextInt();
    //         } catch (InputMismatchException e) {
    //             keyboard.next();
    //         }
    //     }
    //     return a;
    // }

    public void placeholder(String word){
        println(word + " placeholder");
        pressEnter();
    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            // no-op
        }
    }
    public void endOfGame(Crew crew, Supplies.Food food, Supplies.Water water, SpaceCraft craft) {
        clear();
        println("**************************************");
        println("You ended the game with:\n");
        crew.printEndGameCrewList();
        println("\nTravelling aboard the " + craft.name + "\n");

        if (food.getAmount() <0){
            println("0 pounds of food");
        } else {
            println(food.getAmount()+ " pounds of food");
        }
        if (water.getAmount()<0) {
            println("0 liters of water");
        } else {
            println(water.getAmount()+ " liters of water");
        }
        

        println("\n\nScore calculation not yet available in this version.");

        println("\n\nThank you for playing.\n\n\nTo play again, press the run button.");
        println("**************************************");
        System.exit(0);
    }
}
