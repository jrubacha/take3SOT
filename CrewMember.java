import java.util.*;

public class CrewMember {
    Random rand = new Random();
    private String name;
    crewMemberHealth health, initialHealth;
    crewMemberOccupation occupation;
    crewMemberInjury injury, initialInjury;
    crewMemberSickness sickness, initialSickness;
    int daysWithInjuryType, daysWithSicknessType, daysAtHealthLevel, daysAtFoodRation, daysAtWaterRation;

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
        daysAtWaterRation = 0;
        daysAtFoodRation = 0;
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
    public void rollForHealthUpdate(){
        assignInjury();
        updateHealthByInjuryType();
        updateDaysAt();
    }


    // Update days at
    private void updateDaysAt(){
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

    private void daysAtFoodLevel(Supplies.Food food, Supplies.Water water) {
        
    }

    // Methods - Health
    private void assignInjury(){
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
    private void updateHealthByInjuryType(){
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
    private void updateHealthBySickness(){
        if (daysWithSicknessType == 0) {
            if (sickness == crewMemberSickness.FEVER || sickness == crewMemberSickness.RADIATION_SICKNESS || sickness == crewMemberSickness.SPACE_DYSENTERY) {
                reduceHealthLevel();
            }
        }
    }
    // TODO: fix the significant problem wherein these health types all reduce health level and if you have poor nutrition, injury, and sickness, you're gonna die

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
    
    // Methods
    public void killCrewMember() {
        health = crewMemberHealth.DEAD;
    }
}
