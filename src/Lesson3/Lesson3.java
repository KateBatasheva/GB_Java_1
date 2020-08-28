package Lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main (String[] args){

        //1.
        printTask (1,1);
        int userChose;
        do {
            numbersGame(3,9); // всего попыток, разброс значений от нуля
             System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
             userChose = scanner.nextInt();
        } while (userChose==1);
         System.out.println("Спасибо за игру!");
        /*  Подскажите, корректно ли писать циклы в методе main или в нем надо только вызывать методы? */

        //2. вариант 1
        printTask (2,1);
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        System.out.println("Компьютер выбрал одно из следующих слов: \n " + Arrays.toString(words) + "\n Угадай какое.");
        frovGame(words);

        //2. вариант 2 (чрез массив)
        printTask (2, 2);
        System.out.println("Компьютер выбрал одно из следующих слов: \n " + Arrays.toString(words) + "\n Угадай какое.");
        frovGame2(words);

    }

    // 1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
    // При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
    // После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).

    public static void numbersGame (int n, int r) {
        int t = 0; // текущая попытка
        int systemRandom = random.nextInt(r); // загаданное компьютером число
        int userNumb; // вариант пользователя
        System.out.printf("Загадано случайное число от 0 до %d. Количество попыток угадать - %d. Поехали!\n", r, n);
        do {
            userNumb = scanner.nextInt();
            if (userNumb > systemRandom) {
                printHelp(0);
                t++;
            } else if (userNumb < systemRandom) {
                printHelp(1);
                t++;
            } else  {
                printResult(1);
            }
            if ((t==n) ){
                printResult(0);
            }
        } while (!checkWin(userNumb, systemRandom) && t < n);
    }

    public static boolean checkWin (int a, int b){
        return a == b;
    }

    public static void printHelp (int a){
         String result = (a == 1) ? "меньше" : "больше";
         System.out.printf("Указанное вами значение %s, чем загаданное\n", result);
    }

    public static void printResult (int a) {
        String result = (a == 1) ? "выиграли" : "проиграли";
        System.out.printf("Вы %s !\n", result);
    }

    // 2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
    // "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
    // "pear", "pepper", "pineapple", "pumpkin", "potato"};
    //При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    //сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь.
    // Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
    //apple – загаданное
    //apricot - ответ игрока
    //ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    //Для сравнения двух слов посимвольно, можно пользоваться:
    //String str = "apple";
    //str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    //Играем до тех пор, пока игрок не отгадает слово
    //Используем только маленькие буквы

    public static void frovGame (String [] arr) {
        String comp = arr[random.nextInt(arr.length - 1)]; // загадал компьютер
        int l = 15;
        String user;
        StringBuilder strB = new StringBuilder();
        do {
            user = scanner.nextLine();
            strB.setLength(0);
            if (comp.equals(user)) {
                System.out.println("Вы угадали! Поздравляем!");
                break;
            } else {
                int min = Math.min(comp.length(), user.length());
                for (int i = 0; i < min; i++) {
                    if (comp.charAt(i) == user.charAt(i)) {
                        strB.append(user.charAt(i));
                    } else {
                        strB.append('#');
                    }
                }
                    for (int j = min; j < l; j++) {
                        strB.append("#");
                    }
                System.out.println(strB.toString());
            }
        }
            while (true) ;
    }

    public static void frovGame2 (String [] arr) {
        String comp = arr[random.nextInt(arr.length - 1)]; // загадал компьютер
        int l = 15;
        char[] guess = new char[l];
        Arrays.fill(guess, '#'); // создаем массив нужного размера и заполняем его решетками
        String user;
        StringBuilder stringBuild = new StringBuilder();
        do {
            user = scanner.nextLine();
            stringBuild.setLength(0); // обнуляем строку и пробуем наполнить ее по новой
            if (comp.equals(user)) {
                System.out.println("Вы угадали! Поздравляем!");
                break;
            } else {
                int min = Math.min(comp.length(), user.length());
                for (int i = 0; i < min; i++) {
                    if (comp.charAt(i) == user.charAt(i)) {
                        guess[i] = user.charAt(i);
                    }
                }
                for (int i = 0; i < l; i++) {
                    stringBuild.append(guess[i]);
                }
                System.out.println(stringBuild);
            }
        } while (!comp.equals(user));
    }

    // прочее
    public static void printTask (int a, int b){
        System.out.println();
        System.out.printf("%s %d, вариант %d", "Задание №", a, b);
        System.out.println();
    }
}
