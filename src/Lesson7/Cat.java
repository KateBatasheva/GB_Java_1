package Lesson7;

public class Cat {
    private String name;
    private int appetit;

    public boolean isHappyCat() {
        return happyCat;
    }

    private boolean happyCat = false;


    public Cat(String name, int appetit) {
        this.name = name;
        this.appetit = appetit;
    }

    public void eat(Plate plate) {
        if (plate.getFood() > appetit) {
            System.out.println("Cat " + name + " with appetit " + appetit + " eat...");
            happyCat = true;
            plate.decreaseFood(appetit);
        } else {
            System.out.println("Cat " + name + " with appetit " + appetit + " don't eat...");
            plate.increaseFood();
            happyCat = false;
        }
    }


    public String getName() {
        return name;
    }

}
