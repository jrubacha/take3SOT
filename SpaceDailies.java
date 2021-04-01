/*
A place for things that happen daily.
These may include
    - calculating consumables
        - eg. food, water, fuel
    - determining whether someone gets sick/hurt
    - determining whether someone who's health is poor die
    - checking to see if we're still alive
        - TODO: write this
*/


public class SpaceDailies {
    UserInterface ui = new UserInterface();
    public void consumeConsumables(Crew crew, Supplies.Food food, SpaceCraft craft, Supplies.Water water, int increment) {
        food.eatFood(crew.sumTotalOfCrew());
        craft.burnFuel();
        water.drinkWater(crew.sumTotalOfCrew());
    }
    public boolean areWeAlive(Crew crew, Supplies.Food food, Supplies.Water water, SpaceCraft craft) {
        if (food.hasCrewStarved()) {
            ui.clear();
            ui.placeholder("death by starvation");
            return false;
        } else if (water.hasCrewSufferedTerminalDehydration()) {
            ui.clear();
            ui.placeholder("death by lack of water");
            return false;
        } else if (craft.areWeOutOfFuel()) {
            ui.clear();
            ui.placeholder("ran out of fuel");
            return false;
        } else {
            return true;
        }
    }

    public void diceRollCrewHealth(Crew crew, Supplies.Food food, Supplies.Water water) {
        
    }


}

