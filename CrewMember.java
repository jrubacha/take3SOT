import java.util.*;

public class CrewMember {
    Random rand = new Random();
    private String name;
    crewMemberHealth health, initialHealth;
    crewMemberOccupation occupation;
    crewMemberInjury injury, initialInjury;
    crewMemberSickness sickness, initialSickness;
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
        daysAtHealthLevel = 0;
        daysWithInjuryType = 0;
        daysWithSicknessType = 0;
    }

    // General Methods
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


    // Update days at
    public void updateDaysAt(){
        if (initialHealth != health) {
            daysAtHealthLevel = 0;
            initialHealth = health;
        } else {
            daysAtHealthLevel++;
        }
        if (initialInjury != injury) {
            daysWithInjuryType = 0;
            initialInjury = injury;
        } else {
            daysWithInjuryType++;
        }
        if (initialSickness != sickness) {
            daysWithSicknessType = 0;
            initialSickness = sickness;
        } else {
            daysWithSicknessType++;
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
            if (daysAtHealthLevel > 60) {
                reduceHealthLevel();
            }
        } else {
            // Currently healthy... I guess i'd need an injury check? and ...
            if (injury != crewMemberInjury.HEALTHY && daysWithInjuryType == 0) {
                reduceHealthLevel();
            } else if (sickness != crewMemberSickness.HEALTHY && daysWithSicknessType == 0) {
                reduceHealthLevel();
            }
        }
    }


    // Methods - Move through health enum
    private void reduceHealthLevel() {
        if (health == crewMemberHealth.GOOD) {
            health = crewMemberHealth.FAIR;
        } else if (health == crewMemberHealth.FAIR) {
            health = crewMemberHealth.POOR;
        } else if (health == crewMemberHealth.POOR) {
            health = crewMemberHealth.DEAD;
        }
    }
    private void increaseHealthLevel() {
        if (health == crewMemberHealth.POOR) {
            health = crewMemberHealth.FAIR;
        } else if (health == crewMemberHealth.FAIR) {
            health = crewMemberHealth.GOOD;
        }
    }
    
}
