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
    public int sumTotalOfCrew() {
        return (crewList.size());
    }
    public void hireCrewPrompt(){
        ui.clear();
        ui.print("\nYou can hire several people for your journey. There are many qualified candidates from the following categories:\n1. Engineer\n2. Scientist\n3. Communications Officer\n4. Pilot\n5. No more hires\n\nWho would you like to hire? ");
    }
    public void assembleCrew(int maxCapacity) {
        int userSelc = 0;
        while ((sumTotalOfCrew() < maxCapacity) && (userSelc != 5)) {
            CrewMember.crewMemberOccupation currentJob = CrewMember.crewMemberOccupation.ENGINEER; // default to engr
            hireCrewPrompt();
            int remainingCapacity = maxCapacity - sumTotalOfCrew();
            userSelc = keyboard.nextInt();
            switch (userSelc) {
                case 1:
                    currentJob = CrewMember.crewMemberOccupation.ENGINEER;
                    ui.print("How many engineers would you like to hire? ");
                    break;
                case 2:
                    currentJob = CrewMember.crewMemberOccupation.SCIENTIST;    
                    ui.print("How many scientists would you like to hire? ");
                    break;
                case 3:
                    currentJob = CrewMember.crewMemberOccupation.COMMUNICATIONS_OFFICER;
                    ui.print("How many communications officers would you like to hire? ");
                    break;
                case 4:
                    currentJob = CrewMember.crewMemberOccupation.PILOT;
                    ui.print("How many pilots would you like to hire? ");
                    break;
                case 5:
                    if (sumTotalOfCrew() == 1){
                        ui.print("You haven't hired anyone.\n\n1. Yes\n2. No\n\nAre you sure? ");
                        userSelc = keyboard.nextInt();
                        if (userSelc == 1) {
                            userSelc = 5;
                        } else {
                            userSelc = 0;
                        }
                    } else {
                        ui.println("No more hires, got it.");
                    }
                    break;
                default:
                    ui.println("Don't do that");
                    break;
            }
            
            if (userSelc !=5) {
                int numberOfCrewToAdd = keyboard.nextInt();
                if (numberOfCrewToAdd < 0 || numberOfCrewToAdd > remainingCapacity) {
                    ui.clear();
                    ui.println("I'm sorry, you can't hire that number. No hires were made.");
                } else {
                    for (int i=0; i<numberOfCrewToAdd; i++) {
                        ui.print("What's this crew member's name? ");
                        String newCrewName = keyboard.next();
                        crewList.add(new CrewMember(newCrewName, currentJob));
                    }
                }
            }
        }
    }
    public void printCrewList(){
        ui.clear();
        ui.println("The following people are in your crew.\n");
        for (CrewMember i : crewList) {
            ui.println("Name: " + i.getName() + "  Occupation: " + i.getOccupation() + "   Health: " + i.getHealth());
        }
        ui.pressEnter();
    }
    public boolean doesCrewHaveCommOfficer(){
        boolean foundCommOfficer = false;
        for (CrewMember i : crewList) {
            if (i.occupation == CrewMember.crewMemberOccupation.COMMUNICATIONS_OFFICER) {
                foundCommOfficer = true;
            }
        }
        return foundCommOfficer;
    }
    public boolean doesCrewHaveEngineer(){
        boolean foundEngineer = false;
        for (CrewMember i : crewList) {
            if (i.occupation == CrewMember.crewMemberOccupation.ENGINEER) {
                foundEngineer = true;
            }
        }
        return foundEngineer;
    }
    public void fireCrewMember(){
        if (crewList.size() == 1) {
            ui.println("You don't have anyone you can fire.");
        } else {
            ui.clear();
            ui.println("Here's your current crew:");
            int j = 1;
            for (int i=1; i<crewList.size(); i++) {
                ui.println(i + ".  " + crewList.get(i).getName() + "   Occupation: " + crewList.get(i).getOccupation());
            }
            ui.print("Who would you like to fire? ");
            int firedMember = keyboard.nextInt();
            crewList.remove(firedMember);
        }
    }


}
