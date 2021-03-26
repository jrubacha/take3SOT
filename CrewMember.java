public class CrewMember {
    private String name;
    crewMemberHealth health;
    crewMemberOccupation occupation;
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
}
