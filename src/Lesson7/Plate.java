package Lesson7;

public class Plate {
    private int food;
    private int maxFood = 150;


    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
            this.food -= amount;
        }


    public void increaseFood (){
        System.out.printf("Тарелка наполнена на %d единиц, теперь там %d единиц.\n", maxFood - getFood(), maxFood);
        this.food = maxFood;
    }



    @Override
    public String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }
}
