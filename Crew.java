import java.util.*;

public class Crew {
    UserInterface ui = new UserInterface();
    Menus menu = new Menus();
    Art art = new Art();
    Scanner keyboard = new Scanner(System.in);
    ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
    ArrayList<CrewMember> deadList = new ArrayList<CrewMember>();
    SpaceCraft craft = new SpaceCraft.SaturnV();


    public void addCaptain(){
        ui.clear();
        art.printSpaceMan();
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

    public void assignNewCaptain() {
        CrewMember temp;
        if (crewList.size() == 1) {
            ui.println("You don't have anyone you can promote to captain.");
        } else {
            ui.clear();
            ui.println("Here's your current crew:");
            int i;
            for (i=1; i<crewList.size(); i++) {
                ui.println(i + ".  " + crewList.get(i).getName() + "   Occupation: " + crewList.get(i).getOccupation());
            }
            ui.print(i + ". Do nothing\n\nWho would you like to make Captain? ");
            int newCaptain = keyboard.nextInt();
            if (newCaptain == i) {
                // Do nothing
            } else if (isCaptainAlive()) {
                temp = crewList.get(newCaptain);
                temp.setOccuptionToCaptain();
                crewList.set(newCaptain, crewList.get(0));
                crewList.set(0, temp);
            } else {
                // If captain is dead
                crewList.set(0, crewList.get(newCaptain));
                crewList.remove(newCaptain);
            }
        }
    }
    public boolean isCaptainAlive(){
        if (crewList.get(0).health != CrewMember.crewMemberHealth.DEAD) {
            return true;
        } else {
            return false;
        }
    }
    public int sumTotalOfCrew() {
        return (crewList.size());
    }
    public void hireCrewPrompt(){
        ui.clear();
        ui.print("\nYou can hire several people for your journey. There are many qualified candidates from the following categories:\n\t1. Engineer\n\t2. Scientist\n\t3. Communications Officer\n\t4. Pilot\n\t5. No more hires\n\t6. Describe crew roles\n\nWho would you like to hire? ");
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
                case 6:
                    keyboard.nextLine();
                    ui.clear();
                    ui.println("Engineer: A skilled technician who can take care of your ship. Engineers allow you to make repairs to your spacecraft while in space.\n\nScientist: Well educated experts whose job it is to make advancements in the field of space travel. Scientists will allow you to perform research while in space, potentially leading to discoveries that will improve the lives of your crew members.\n\nCommunications Officer: Well trained individuals capable of navigating the comm. ports on your space craft. Without them, you won't be able to contact other space craft while in space, limiting your ability to trade.\n\nPilot: Experienced individuals who will improve your space travel experience. With a pilot onboard, you'll make better time to your destinations, have better odds of avoiding space debris, and use less fuel.");
                    ui.pressEnter();
                    break;
                default:
                    ui.println("Don't do that");
                    break;
            }
            
            if (userSelc !=5 && userSelc != 6) {
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

    public void printEndGameCrewList(){
        ui.println("The following people in your crew:\n");
        for (CrewMember i : crewList) {
            ui.println("\tName: " + i.getName() + "  Occupation: " + i.getOccupation() + "   Health: " + i.getHealth());
        }
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
    public boolean doesCrewHaveScientist(){
        boolean foundScientist = false;
        for (CrewMember i : crewList) {
            if (i.occupation == CrewMember.crewMemberOccupation.SCIENTIST) {
                foundScientist = true;
            }
        }
        return foundScientist;
    }
    public boolean doesCrewHavePilot(){
        boolean foundPilot = false;
        for (CrewMember i : crewList) {
            if (i.occupation == CrewMember.crewMemberOccupation.PILOT) {
                foundPilot = true;
            }
        }
        return foundPilot;
    }
    public void fireCrewMember(){
        if (crewList.size() == 1) {
            ui.println("You don't have anyone you can fire.");
        } else {
            ui.clear();
            ui.println("Here's your current crew:");
            int j = 1;
            int i;
            for (i=1; i<crewList.size(); i++) {
                ui.println(i + ".  " + crewList.get(i).getName() + "   Occupation: " + crewList.get(i).getOccupation());
            }
            ui.print(i + ". Do nothing\n\nWho would you like to fire? ");
            int firedMember = keyboard.nextInt();
            if (firedMember == i) {
            } else {
                crewList.remove(firedMember);
            }
        }
    }
    public String getOverallCrewHealth(){
        int count=0;
        for (CrewMember i : crewList) {
            if ("Good".equalsIgnoreCase(i.getHealth())) {
                count++;
            } else if ("Poor".equalsIgnoreCase(i.getHealth())) {
                count--;
            }
        }
        if (count > (2 * crewList.size() / 3)) {
            return "Good";
        } else if (count > (2 * crewList.size() / 5)) {
            return "Fair";
        } else {
            return "Poor";
        }
    }

	public void randomDead() {
        Random r = new Random();
        ArrayList<CrewMember> theDead = new ArrayList<CrewMember>();
        for (CrewMember i : crewList) {
            if (r.nextInt(10) == 1) {
                i.killCrewMember();
                ui.println(i.getName() + " has died.");
                theDead.add(i);
            }
        }
        purgeTheDead(theDead);
    }
    
    public void purgeTheDead(ArrayList<CrewMember> deadBodies) {
        deadList.addAll(deadBodies);
        crewList.removeAll(deadBodies);
    }

    public void breakAnArm(){
        
    }


////////////////////////////////////////////////////////////////////////////////////

    public SpaceCraft getSpaceCraft(){
        return craft;
    }
    public void modifyCraft(SpaceCraft newCraft) {
        craft = newCraft;
    }



}
