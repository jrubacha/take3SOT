import java.util.*;
public class Talkies {
    UserInterface ui = new UserInterface();
    Random rand = new Random();
    int currentDay = 0;

    private String lonely = "No one wants to talk to you today.";
    private String fact1 = "Random space fact 1";
    private String fact2 = "random space fact 2";
    private String fact3 = "random space fact 3";
    private String fact4 = "random space fact 4";
    private String fact5 = "random space fact 5";
    private String fact6 = "random space fact 6";
    private String fact7 = "random space fact 7";
    private String fact8 = "random space fact 8";
    private String fact9 = "random space fact 9";
    private String moonFact1 = "random moon fact 1";
    private String moonFact2 = "random moon fact 2";
    private String moonFact3 = "random moon fact 3";
    private String moonFact4 = "random moon fact 4";
    private String moonFact5 = "random moon fact 5";
    
    
    public void pickATalky(int day){
        if (day != currentDay) {
            switch(rand.nextInt(20)) {
                case 1:
                    ui.println(fact1);
                    break;
                case 2:
                    ui.println(fact2);
                    break;
                case 3:
                    ui.println(fact3);
                    break;
                case 4:
                    ui.println(fact4);
                    break;
                case 5:
                    ui.println(fact5);
                    break;
                case 6:
                    ui.println(fact6);
                    break;
                case 7:
                    ui.println(fact7);
                    break;
                case 8:
                    ui.println(fact8);
                    break;
                case 9:
                    ui.println(fact9);
                    break;
                default:
                    ui.println(lonely);
                    break;
            }
            currentDay = day;
        } else {
            ui.println("You can talk again tomorrow.");
        }
        ui.pressEnter();
    }

    public void pickAMoonTalky(int day){
        if (day != currentDay) {
            switch(rand.nextInt(20)) {
                case 1:
                    ui.println(moonFact1);
                    break;
                case 2:
                    ui.println(moonFact2);
                    break;
                case 3:
                    ui.println(moonFact3);
                    break;
                case 4:
                    ui.println(moonFact4);
                    break;
                case 5:
                    ui.println(moonFact5);
                    break;
                case 6:
                    ui.println(fact8);
                    break;
                case 7:
                    ui.println(fact8);
                    break;
                case 8:
                    ui.println(fact8);
                    break;
                case 9:
                    ui.println(fact8);
                    break;
                default:
                    ui.println(lonely);
                    break;
            }
            currentDay = day;
        } else {
            ui.println("You can talk again tomorrow.");
        }
        ui.pressEnter();
    }
}