import java.util.*;

public class Crew {
    UserInterface ui = new UserInterface();
    Scanner keyboard = new Scanner(System.in);
    ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();


    public void addCaptain(){
        ui.clear();
        ui.print("Let's get started. First, what is your name? ");
        String captainName = keyboard.next();
        captainName = captainName.substring(0,1).toUpperCase() + captainName.substring(1).toLowerCase();
        crewList.add(new CrewMember(captainName, CrewMember.crewMemberOccupation.CAPTAIN));
    }

    public String getCaptainName() {
        String captainName = "";
        for (CrewMember i : crewList) {
            if (i.occupation == CrewMember.crewMemberOccupation.CAPTAIN) {
                captainName = i.getName();
            }
        }
        return captainName;
    }
}
