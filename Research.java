import java.util.*;
public class Research {
    // Controls the Scientist CrewMember Special Tasks
    UserInterface ui = new UserInterface();

    String researchPanel = "=================================\n\n"
        + "Welcome Science Officer.\nWould you like instructions on how to use the portal?\n\n\t1. Yes\n\t2. No"
        + "=================================";

    String researchPanelInstructions = "Each day, you may conduct space research. Gaining this knowledge will make it easier for you to assist in tasks around the ship. Correctly answering questions will improve your score and help your crew consume less resources.";


    // QUESTION 1
    String passage1 = "There are basic principles of physics that influence our lives and the laws of gravity are part of these scientific principles. The pull of the earth’s gravity keeps your feet on the ground and pulls the apple toward the ground when it falls from the tree. Astronauts in space can float freely inside the International Space Station because they have escaped the pull of earth’s gravity on their bodies because they are so far from earth. The moon’s gravitational pull on the earth creates ocean tides. Plus, the sun’s gravitational pull keeps the planets in our solar system revolving in their orbits around the sun. This tells you that gravity exists in the universe and not just on earth."
    +"\nIn fact, launch rockets must escape the pull of earth’s gravity in order to send probes into space like the Voyager that explored Jupiter. The speed rockets need to reach in order to overcome earth’s gravity and travel into space is called escape velocity. Physicists have mathematical equations that calculate the escape velocity of lots of bodies in space, like planets and stars. The gravitational pull and escape velocity of a body in space depends on its mass. Mass is how scientists measure the amount of matter in something. The more mass a body in space has, the greater its gravitational force is."
    +"\nThe sun has enough mass to control a large distant planet like Jupiter. The sun is a star and all stars progress through a life cycle. Stars which are 1.5 to 3 times larger than the sun are called giant stars. It’s easy to conclude that giant stars have a greater gravitational pull than our sun because they have a greater mass. When a giant star dies at the end of its life cycle, only the core (solid center) of the star is left. If this core collapses into itself, nothing visible is left."
    +"\nWhat happened to the mass of the star? The matter in the star’s core had to go somewhere and physicists define this missing matter as a black hole. A black hole has so much matter concentrated in a place that is so small that it is invisible to even powerful telescopes. All that concentrated mass still exerts a gravitational pull on anything that gets near it. That pull of gravity is so strong that once something “falls” into a black hole, it can never create enough escape velocity to get out. Even light, the thing in the universe that travels the fastest, cannot escape from a black hole.";

    String question1 = "What do we call a star that is 1.5 to 3 times larger than our sun?";

    String correctAnswer1 = "giant star";

    // QUESTION 2
    String passage2 = "Besides planets and their moons there are several other types of celestial bodies in our solar system. These include asteroids, comets and meteors."
    + "\nAsteroids are also called planetoids or minor planets because they are in a fixed orbit around the sun. Many asteroids are quite small compared to the planets. For example, a probe launched into space by NASA sent back a picture of an asteroid that was merely 30 miles in diameter. An asteroid is like a large boulder orbiting around the sun. Astronomers have identified 26 asteroids larger than 125 miles in diameter and thousands between 50 and 125 miles in diameter. Space probes have taken a closer look at some large asteroids."
    + "\nMeanwhile scientists have estimated that there are millions of asteroids too small to be visible from earth even with the most powerful telescopes. There is a large group of asteroids that orbit the sun between the planets Mars and Jupiter that is called the main belt of asteroids. Scientists don’t yet know why so many asteroids exist in this part of the solar system."
    + "\nComets also revolve around the sun. While planets have elliptical orbits that are close to being circular, comets have highly elliptical orbits that are long and narrow. This means that at some points in their orbit comets are much closer to the sun than other times. Comets are balls of ice and rocky dust particles that look like giant dirty snowballs. The ice is a mixture of water, ammonia, carbon dioxide, carbon monoxide and methane. As it travels through space a comet has a trailing tail made of gas and particles. The tail of a comet always faces away from the sun due to the solar wind and solar radiation. Because comets have a different shape of orbit, sometimes they collide with a planet, causing an impact crater on the planet. NASA space probes are providing new information about comets."
    + "\nA meteor is often called a shooting star, falling star or even fireball because it appears as a brief bright light traveling in the night sky. A meteor is caused by a small chunk of space material that enters the earth’s atmosphere. Millions of tiny chunks of space rocks, called meteoroids, enter the earth’s atmosphere daily and simply burn up. When a meteoroid does survive its trip through the atmosphere and lands on earth, it is called a meteorite.";

    String question2 = "Find in the blank: The tail of a comet always faces ____ from the sun.";
    String correctAnswer2 = "away";

    // QUESTION 3
    String passage3 = passage2;
    String question3 = "What is a meteoroid that lands on earth called?";
    String correctAnswer3 = "meteorite";


    // QUESTION 4
    String passage4 = passage1;
    String question4 = "The gravitational pull and escape velocity of a body in space depends on its ________.";
    String correctAnswer4 = "mass";

    // QUESTION 5
    String passage5 = passage1;
    String question5 = "What is another name for an asteroid?";
    String correctAnswer5 = "planetoid";

    // Array housing all of the questions, their passages, and their correct answers
    String[][] questionArray = {{passage1, question1, correctAnswer1}, {passage2, question2, correctAnswer2}, {passage3, question3, correctAnswer3}, {passage4, question4, correctAnswer4}, {passage5, question5, correctAnswer5}};

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
        ui.println("Read the following passage and then answer the question.");
        ui.pressEnter();
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