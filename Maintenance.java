/*
Maintenance Mini Game
*/
import java.util.*;

public class Maintenance {
    Scanner k = new Scanner(System.in);
    Random r = new Random();
    UserInterface ui = new UserInterface();
    String sequence = "";
    String userSequence;
    int currentDay = 0;

    String prompt = "Hello Engineer!\nThere are a couple of faulty systems around the ship. The console will tell you the sequence you will need to input in order to fix them. As you go, the sequence will grow longer and get more difficult to remember.\nGood luck!";

    public void runMantenanceGame(int day){
        boolean gameOn = true;
        ui.println(prompt);
        ui.pressEnter();
        if (day != currentDay) {
            do {
                sequence = sequence + r.nextInt(4);
                ui.clear();
                ui.println("Remember the sequence:\n");
                ui.println(sequence);
                ui.sleep(1100);
                ui.clear();
                ui.println("Type the sequence:\n");
                userSequence = k.next();
                if (!sequence.equals(userSequence)) {
                    gameOn = false;
                }  
            } while (gameOn);
            ui.println("\nYou got " + (sequence.length()-1) + " matches correct.");
            ui.placeholder("\ngood thing that happens because of score");
            //ui.pressEnter(); // extra not needed because placeholder contains one
            currentDay = day;
        } else {
            ui.println("You can do maintenance again tomorrow.");
            ui.pressEnter();
        }
    }
    
}