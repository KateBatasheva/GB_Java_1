package Lesson6;

public class Cat extends Animal {
    static int count;
    static int maxRun = 200;

    public Cat(String name) {
        super(name);
        count++;
    }
    @Override
    protected void swim (int lenght) {
        System.out.println(name + " не умеет плавать");
    }

    @Override
    protected void run(int lenght) {
        if (lenght > maxRun) {
            System.out.printf("%s не может пробежать %d метров, он смог пробежать только %d метров.\n", name, lenght, maxRun);
        } else {
            System.out.printf("%s пробежал %s метров\n", name, lenght);
        }
    }
}
