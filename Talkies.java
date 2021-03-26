import java.util.*;
public class Talkies {
    UserInterface ui = new UserInterface();
    Random rand = new Random();
    int currentDay = 0;

    public void pickATalky(int day){
        if (day != currentDay) {
            switch(rand.nextInt(20)) {
                case 1:
                    printTalky1();
                    break;
                case 2:
                    printTalky2();
                    break;
                case 3:
                    printTalky3();
                    break;
                case 4:
                    printTalky4();
                    break;
                case 5:
                    printTalky5();
                    break;
                case 6:
                    printTalky6();
                    break;
                case 7:
                    printTalky7();
                    break;
                case 8:
                    printTalky8();
                    break;
                case 9:
                    printTalky9();
                    break;
                default:
                    printTalky10();
                    break;
            }
            currentDay = day;
        } else {
            ui.println("You can talk again tomorrow.");
        }
        ui.pressEnter();
    }

    private void printTalky1() {
        ui.println("Random space fact 1");
    }
    private void printTalky2() {
        ui.println("Random space fact 2");
    }
    private void printTalky3() {
        ui.println("Random space fact 3");
    }
    private void printTalky4() {
        ui.println("Random space fact 4");
    }
    private void printTalky5() {
        ui.println("Random space fact 5");
    }
    private void printTalky6() {
        ui.println("Random space fact 6");
    }
    private void printTalky7() {
        ui.println("Random space fact 7");
    }
    private void printTalky8() {
        ui.println("Random space fact 8");
    }
    private void printTalky9() {
        ui.println("Random space fact 9");
    }
    private void printTalky10() {
        ui.println("No one wants to talk to you today.");
    }
}