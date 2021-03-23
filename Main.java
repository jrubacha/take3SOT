import java.util.*;
class Main {
    public static void main(String[] args) {
        // Setup objects, locations, etc.
        UserInterface ui = new UserInterface();
        Scanner keyboard = new Scanner(System.in);
        currentLocation location = currentLocation.EARTH;
        
        // Welcome

        // Select a Ship

        // Assemble a Crew

        // Buy Initial Supplies

        // Launch

        // Space Dailies (Earth --> Moon)
        location = currentLocation.SPACE;

        // Station Dailies (Moon)
        location = currentLocation.MOON_BASE_1;

        // Space Dailies (Moon --> Mars)
        location = currentLocation.SPACE;

        // Station Dailies (Mars)
        location = currentLocation.MARS_COLONY_7;

        // Space Dailies (Mars --> Inner Belt Transit Station)
        location = currentLocation.SPACE;

        // Station Dailies (Inner Belt Transit Station)
        location = currentLocation.INNER_BELT_TRANSIT_STATION_2;

        // Space Dailies (Inner Belt --> Outer Belt)
        location = currentLocation.SPACE;

        // Station Dailies (Outer Belt Outpost 4)
        location = currentLocation.OUTBELT_OUTPOST_4;

        // Space Dailies (Outer Belt --> Ganymede)
        location = currentLocation.SPACE;

        // Arrival on Ganymede
        location = currentLocation.GANYMEDE_RESEARCH_CENTER;

        // Game Over and Report Score
    }
}