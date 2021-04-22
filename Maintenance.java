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

    String prompt = "Hello Engineer!\nThere are a couple of faulty systems around the ship. The console will tell you the sequence you will need to input in order to fix them. As you go, the sequence will grow longer and get more difficult to remember.\nGood luck!";

    public void runMantenanceGame(){
        boolean gameOn = true;
        do {
            Integer newVal = r.nextInt(4);
            String addon = newVal.toString();
            sequence.concat(addon);
            ui.println(sequence);
            ui.pressEnter();
            userSequence = k.next();
            if (!sequence.equals(userSequence)) {
                gameOn = false;
            }  
        } while (gameOn);
        ui.println("You got " + sequence.length() + " matches correct.");
    }

    


    
}