import java.util.*;
public class UserInterface {
    Scanner keyboard = new Scanner(System.in);
    public void print(String word) {
        System.out.print(word);
    }
    public void println(String word) {
        System.out.println(word);
    }
    public void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void pressEnter(){
        print("\n< Press ENTER to continue >");
        keyboard.nextLine();
    }

    public int getUserInt(){
        int a = 0;
        while (a == 0) {
            try {
                a = keyboard.nextInt();
            } catch (InputMismatchException e) {
                a = 0;
            }
        }
        return a;
    }

    public void placeholder(String word){
        println(word + " placeholder");
        pressEnter();
    }
}
