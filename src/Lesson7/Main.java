package Lesson7;
/*1. Расширить задачу про котов и тарелки с едой
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды, а кот пытается покушать 15-20)
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true
4. Считаем, что если коту мало еды в тарелке, то он ее просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы)
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку*/

import Lesson6.Animal;
import Lesson6.Dog;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int cat = random.nextInt(10) + 10;
         System.out.println("Создаем "+ cat + " котов");
        Cat[] cats = new Cat[cat];

        for (int i = 0, a = 1; i < cats.length; i++, a++) {
            cats[i] = new Cat("Koshak № " + a, random.nextInt(30) + 10);
        }
        Plate bigPlate = new Plate(0);
        bigPlate.increaseFood();


        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bigPlate);
             System.out.println(bigPlate.toString());
        }
         System.out.println();
        for (int i = 0; i < cats.length; i++) {
            if (!cats[i].isHappyCat()) {
                System.out.println("Cat " + cats[i].getName() + " остался голодным :(");
            } else {
                System.out.println("Cat " + cats[i].getName() + " покушал. Доволен :)");
            }
        }
    }
}

