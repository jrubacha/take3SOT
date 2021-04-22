import java.util.*;
public class Research {
    // Controls the Scientist CrewMember Special Tasks
    UserInterface ui = new UserInterface();

    String researchPanel = "=================================\n\n"
        + "Welcome Science Officer.\nWould you like instructions on how to use the portal?\n\n\t1. Yes\n\t2. No"
        + "=================================";

    String researchPanelInstructions = "Each day, you may conduct space research. Gaining this knowledge will make it easier for you to assist in tasks around the ship. Correctly answering questions will improve your score and help your crew consume less resources.";

    String passage1 = "The sun has enough mass to control a large distant planet like Jupiter. The sun is a star and all stars progress through a life cycle. Stars which are 1.5 to 3 times larger than the sun are called giant stars. It’s easy to conclude that giant stars have a greater gravitational pull than our sun because they have a greater mass. When a giant star dies at the end of its life cycle, only the core (solid center) of the star is left. If this core collapses into itself, nothing visible is left.";

    String question1 = "What do we call a star that is 1.5 to 3 times larger than our sun?";

    String correctAnswer1 = "giant star";

    String[][] questionArray = {{passage1, question1, correctAnswer1}};

    public void runResearchActivity(){
        Random r = new Random();
        if (canCrewRunResearch()) {
            int randomQ = r.nextInt(questionArray.length);
            printQuestion(randomQ);
            checkAnswer(randomQ);
        } else {
            ui.println("The research panel seems to be malfunctioning. Try again later.");
        }
       

    }
    private void printQuestion(int whichQ) {
        ui.println("Read the following question and then answering the question.");
        ui.println(questionArray[whichQ][0]);
        ui.println(questionArray[whichQ][1]);
    }
    private void checkAnswer(int whichQ){
        Scanner k = new Scanner(System.in);
        String userGuess = k.nextLine();
        if (questionArray[whichQ][2].equalsIgnoreCase(userGuess)) {
            ui.println("That's correct. Good reading.");
        } else {
            ui.println("That's not it. Read more carefully next time.");
        }
    }
    private boolean canCrewRunResearch(){
        Random r = new Random();
        if (r.nextInt(20) < 2) {
            return false;
        } else {
            return true;
        }
    }
}