/*
A place for things that happen daily.
These may include
    - calculating consumables
        - eg. food, water, fuel
    - determining whether someone gets sick/hurt
    - determining whether someone who's health is poor die
*/


public class SpaceDailies {
    UserInterface ui = new UserInterface();


    public void consumeConsumables(Crew crew, Supplies.Food food, SpaceCraft craft, Supplies.Water water, int increment) {
        for (int i=0; i<increment; i++) {
            food.eatFood(crew.sumTotalOfCrew());
            craft.burnFuel(crew);
            water.drinkWater(crew.sumTotalOfCrew());
            crew.randomDead();
        }
    }

    
    public boolean areWeAlive(Crew crew, Supplies.Food food, Supplies.Water water, SpaceCraft craft) {
        if (food.hasCrewStarved()) {
            ui.clear();
            ui.placeholder("death by starvation");
            ui.endOfGame(crew, food, water, craft);
            return false;
        } else if (water.hasCrewSufferedTerminalDehydration()) {
            ui.clear();
            ui.placeholder("death by lack of water");
            ui.endOfGame(crew, food, water, craft);
            return false;
        } else if (craft.areWeOutOfFuel()) {
            ui.clear();
            ui.placeholder("ran out of fuel");
            ui.endOfGame(crew, food, water, craft);
            return false;
        } else if (crew.sumTotalOfCrew() == 0) {
            ui.clear();
            ui.placeholder("everyone died");
            ui.endOfGame(crew, food, water, craft);
            return false;
        } else {
            return true;
        }

    }

    public void diceRollCrewHealth(Crew crew, Supplies.Food food, Supplies.Water water) {
        
    }


}

