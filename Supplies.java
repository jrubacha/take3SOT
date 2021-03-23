public class Supplies {
    public static class Food extends Supplies {
        FoodRationSize rationSize;
        double foodCost = 0.20;
        double foodSale = 0.10;
        enum FoodRationSize {
            BARE_BONES,
            MEAGER,
            FILLING
        }
    }
}
