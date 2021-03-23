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

}
