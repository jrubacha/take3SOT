import java.util.*;

public class CrewMember {
    Random rand = new Random();
    private String name;
    crewMemberHealth health;
    crewMemberOccupation occupation;
    crewMemberInjury injury;
    crewMemberSickness sickness;
    int daysWithInjuryType, daysWithSicknessType, daysAtHealthLevel;

    enum crewMemberHealth {
        DEAD,
        POOR,
        FAIR,
        GOOD
    }
    enum crewMemberOccupation {
        ENGINEER,
        SCIENTIST,
        COMMUNICATIONS_OFFICER,
        PILOT,
        CAPTAIN
    }
    enum crewMemberInjury {
        HEALTHY,
        BROKEN_ARM,
        CONCUSSION,
    }
    enum crewMemberSickness {
        HEALTHY,
        SPACE_DYSENTERY,
        RADIATION_SICKNESS,
        FEVER
    }

    // Constructor
    public CrewMember(String name, crewMemberOccupation occupation) {
        this.name = name;
        this.health = crewMemberHealth.GOOD;
        this.occupation = occupation;
    }

    // Methods
    public String getName(){
        return name;
    }
    public String getHealth(){
        return health.toString();
    }
    public String getOccupation(){
        return occupation.toString();
    }
    public void setOccuptionToCaptain(){
        occupation = crewMemberOccupation.CAPTAIN;
    }
    public boolean isCrewMemberDead(){
        if (health == crewMemberHealth.DEAD) {
            return true;
        } else {
            return false;
        }
    }
    // Methods - Health
    public void assignInjury(){
        int diceRoll = rand.nextInt(100);
        if (injury == crewMemberInjury.HEALTHY) {
            if (diceRoll < 5) {
                injury = crewMemberInjury.BROKEN_ARM;
            } else if (diceRoll < 20) {
                injury = crewMemberInjury.CONCUSSION;
            } else {
                injury = crewMemberInjury.HEALTHY;
            }
        } else if (injury == crewMemberInjury.CONCUSSION) {
            if (diceRoll < 50) {
                injury = crewMemberInjury.CONCUSSION;
            } else {
                injury = crewMemberInjury.HEALTHY;
            }
        } else if (injury == crewMemberInjury.BROKEN_ARM) {
            if (diceRoll < 50) {
                injury = crewMemberInjury.BROKEN_ARM;
            } else {
                injury = crewMemberInjury.HEALTHY;
            }
        }        
    }
    public void updateHealth(){
        if (injury != crewMemberInjury.HEALTHY) {
          // Currently not healthy
        } else {
            // Currently healthy
            if (daysAtHealthLevel > 40 && health == crewMemberHealth.POOR) {
                health = crewMemberHealth.DEAD;
            }
        }
    }
}
