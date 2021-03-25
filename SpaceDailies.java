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
    public void consumeConsumables(Crew crew, Supplies.Food food, SpaceCraft craft, Supplies.Water water, int increment) {
        food.eatFood(crew.sumTotalOfCrew());
        craft.burnFuel();
        water.drinkWater(crew.sumTotalOfCrew());
    }
}
