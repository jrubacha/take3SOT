public class Supplies {
    UserInterface ui = new UserInterface();
    double amount;
    String supplyType;
    double unitCost, saleValue;
    static double money;

    public Supplies(String supplyType, int amount, double unitCost, double saleValue){
        this.supplyType= supplyType;
        this.unitCost = unitCost;
        this.saleValue = saleValue;
        this.amount = amount;
        Supplies.money = 65000;
    }

    public double getAmount(){
        return amount;
    }
    public String getType() {
        return supplyType;
    }
    public double getUnitCost(){
        return unitCost;
    }
    public double getSaleValue(){
        return saleValue;
    }
    public double getMoney(){
        return money;
    }
    public void spendMoney(double delta) {
        money -= delta;
    }
    public void earnMoney(double delta) {
        money += delta;
    }
    public void printMoney(){
        ui.println("Money: " + (int) money);
    }
    public void buySupply(int delta){
        increaseQuantity(delta);
        money -= delta * unitCost;
    }
    public void sellSupply(int delta){
        reduceQuantity(delta);
        money += delta * saleValue;
    }
    private void reduceQuantity(double delta) {
        amount -= delta;
    }
    private void increaseQuantity(double delta) {
        amount += delta;
    }
//////////////////////////////////////////////////////////
    public static class Food extends Supplies {
        public Food() {
            super("Food", 0, 0.2, 0.1);
            rationSize = foodRationSize.FILLING;
        }
        foodRationSize rationSize;
        double foodPerDay;
        enum foodRationSize {
            BARE_BONES,
            MEAGER,
            FILLING
        }
        public void printFoodQuantity(){
            ui.println("You have " + amount + " lbs of food.");
        }
        private void calculateFoodPerDay(){
            if (rationSize == foodRationSize.BARE_BONES) {
                foodPerDay = 0.75;
            } else if (rationSize == foodRationSize.MEAGER) {
                foodPerDay = 1.25;
            } else {
                foodPerDay = 2;
            }
        }
        public void eatFood(int crewSize) {
            calculateFoodPerDay();
            amount -= (crewSize * foodPerDay);
        }
        public void setRationSizeToFilling(){
            rationSize = foodRationSize.FILLING;
        }
        public void setRationSizeToMeager(){
            rationSize = foodRationSize.MEAGER;
        }
        public void setRationSizeToBareBones(){
            rationSize = foodRationSize.BARE_BONES;
        }
        public void printChangeRationSizePrompt(){
            ui.clear();
            ui.println("Change food rations\n< Currently " + rationSize +" >");
            ui.print("The amount of food the people in your crew each each day can change. These amounts are:\n1. Filling - meals are large and generous.\n2. Meager - meals are small, but adequate.\n3. Bare bones - meals are very small; everyone stays hungry.\n\nWhat is your choice? ");
        }
        public boolean hasCrewStarved() {
            if (amount <= 0) {
                return true;
            } else {
                return false;
            }
        }
    }
///////////////////////////////////////////////////////////////////////////
    public static class Water extends Supplies {
        public Water() {
            super("Water", 0, 0.25, 0.2);
            rationSize = waterRationSize.HYDRATED;
        }
        waterRationSize rationSize;
        double waterPerDay;
        enum waterRationSize {
            PARCHED,
            THIRSTY,
            HYDRATED
        }
        public void printWaterQuantity(){
            ui.println("You have " + amount + " liters of water.");
        }
        private void calculateWaterPerDay(){
            if (rationSize == waterRationSize.PARCHED) {
                waterPerDay = .5;
            } else if (rationSize == waterRationSize.THIRSTY) {
                waterPerDay = 1.25;
            } else {
                waterPerDay = 2;
            }
        }
        public void drinkWater(int crewSize){
            calculateWaterPerDay();
            amount -= (waterPerDay * crewSize);
        }
        public void setRationSizeToHydrated(){
            rationSize = waterRationSize.HYDRATED;
        }
        public void setRationSizeToThirsty(){
            rationSize = waterRationSize.THIRSTY;
        }
        public void setRationSizeToParched(){
            rationSize = waterRationSize.PARCHED;
        }
    }
/////////////////////////////////////////////////////////////////////////////

    public static class SpareParts extends Supplies {
        public SpareParts() {
            super("Spare Parts", 0, 25, 10);
        }
    }
    public static class SpaceSuits extends Supplies {
        public SpaceSuits() {
            super("Space Suits", 0, 700, 350);
        }
    }

}
