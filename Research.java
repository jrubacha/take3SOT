import java.util.*;
public class Research {
    // Controls the Scientist CrewMember Special Tasks
    UserInterface ui = new UserInterface();

    String researchPanel = "=================================\n\n"
        + "Welcome Science Officer.\nWould you like instructions on how to use the portal?\n\n\t1. Yes\n\t2. No"
        + "=================================";

    String researchPanelInstructions = "Each day, you may conduct space research. Gaining this knowledge will make it easier for you to assist in tasks around the ship. Correctly answering questions will improve your score and help your crew consume less resources.";


    // QUESTION 1
    String passage1 = "The sun has enough mass to control a large distant planet like Jupiter. The sun is a star and all stars progress through a life cycle. Stars which are 1.5 to 3 times larger than the sun are called giant stars. It’s easy to conclude that giant stars have a greater gravitational pull than our sun because they have a greater mass. When a giant star dies at the end of its life cycle, only the core (solid center) of the star is left. If this core collapses into itself, nothing visible is left.";

    String question1 = "What do we call a star that is 1.5 to 3 times larger than our sun?";

    String correctAnswer1 = "giant star";

    // QUESTION 2
    String passage2 = "Besides planets and their moons there are several other types of celestial bodies in our solar system. These include asteroids, comets and meteors."
    + "Asteroids are also called planetoids or minor planets because they are in a fixed orbit around the sun. Many asteroids are quite small compared to the planets. For example, a probe launched into space by NASA sent back a picture of an asteroid that was merely 30 miles in diameter. An asteroid is like a large boulder orbiting around the sun. Astronomers have identified 26 asteroids larger than 125 miles in diameter and thousands between 50 and 125 miles in diameter. Space probes have taken a closer look at some large asteroids."
    + "Meanwhile scientists have estimated that there are millions of asteroids too small to be visible from earth even with the most powerful telescopes. There is a large group of asteroids that orbit the sun between the planets Mars and Jupiter that is called the main belt of asteroids. Scientists don’t yet know why so many asteroids exist in this part of the solar system."
    + "Comets also revolve around the sun. While planets have elliptical orbits that are close to being circular, comets have highly elliptical orbits that are long and narrow. This means that at some points in their orbit comets are much closer to the sun than other times. Comets are balls of ice and rocky dust particles that look like giant dirty snowballs. The ice is a mixture of water, ammonia, carbon dioxide, carbon monoxide and methane. As it travels through space a comet has a trailing tail made of gas and particles. The tail of a comet always faces away from the sun due to the solar wind and solar radiation. Because comets have a different shape of orbit, sometimes they collide with a planet, causing an impact crater on the planet. NASA space probes are providing new information about comets."
    + "A meteor is often called a shooting star, falling star or even fireball because it appears as a brief bright light traveling in the night sky. A meteor is caused by a small chunk of space material that enters the earth’s atmosphere. Millions of tiny chunks of space rocks, called meteoroids, enter the earth’s atmosphere daily and simply burn up. When a meteoroid does survive its trip through the atmosphere and lands on earth, it is called a meteorite.";

    String question2 = "Find in the blank: The tail of a comet always faces ____ from the sun.";

    String correctAnswer2 = "away";

    // QUESTION 3
    String passage3 = passage2;
    String quesiton3 = "What is a meteoroid that lands on earth called?";
    String correctAnswer3 = "meteorite";


    // QUESTION 4


    // QUESTION 5


    // Array housing all of the questions, their passages, and their correct answers
    String[][] questionArray = {{passage1, question1, correctAnswer1}, {passage2, question 2, correctAnswer2}, {passage3, question3, correctAnswer3}};

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