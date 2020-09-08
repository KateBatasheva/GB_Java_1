package Lesson6;

public class Dog extends Animal {
    static int count;
    static int maxRun = 500;
    static int maxSwim = 10;

    public Dog(String name) {
        super(name);
        count++;
    }

    @Override
    protected void swim(int lenght) {
        if (lenght > maxRun) {
            System.out.printf("%s не может проплыть %d метров, он смог проплыть только %d метров.\n", name, lenght, maxSwim);
        } else {
            System.out.printf("%s проплыл %s метров\n", name, lenght);
        }
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
