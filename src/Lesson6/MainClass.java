package Lesson6;

/*1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль.
(Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4.* Добавить подсчет созданных котов, собак и животных.*/

import java.util.Random;

public class MainClass {

    public static void main (String[] args){
        Random random = new Random();
        Animal [] animals = new Animal[random.nextInt(10)+10];

        for (int i = 0, j = animals.length-1, a = 0; i <= j; i++, j--, a++) {
            if (i == j) {
                animals[i] = new Cat("Koshak №" + (a + 1));
            } else {
                animals[i] = new Cat("Koshak №" + (a + 1));
                animals[j] = new Dog("Sobaken №" + (animals.length/2 -i));
            }
        }

        for (Animal animal : animals) {
            animal.run(random.nextInt(200) + 50);
            animal.swim(random.nextInt(5) + 5);
        }
 System.out.printf("\nВсего создано %d животных, из них %d кошек и %d собак.\n", Animal.count, Cat.count, Dog.count);
    }
}
