package Lesson5;

import java.util.Random;

public class OOP {
    private static Random random = new Random();

public static void main (String[] args){

// Создаем массив из 5 сотрудников
    Employer [] employers = new Employer[5];
    employers[0] = new Employer ("Иванов Иван Иваныч", "Инженер", "ivan@ya.ru");
    employers[1] = new Employer ("Петров Петр Петрович", "Бухгалтер", "petr@ya.ru");
    employers[2] = new Employer ("Васильев Василий Васильевич", "Менеджер", "vasilii@ya.ru");
    employers[3] = new Employer ("Иванов Петр Васильевич", "Программист", "petr.vas@ya.ru");
    employers[4] = new Employer ("Петров Василий Иваныч", "Секретарь", "vasilii.iva@ya.ru");

    for (int i = 0; i < employers.length; i++) {
        employers[i].setAge(random.nextInt(40)+18);
        employers[i].setSalary((random.nextInt(100)+50)*1000);
        employers[i].setTel(String.format("8 9%d-%d-%d-%d ", random.nextInt(99),random.nextInt(999),random.nextInt(99),random.nextInt(99)));
    }

// Выводим инфу о сотрудниках
    All(employers);
    check(employers);

}
// С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
static void check (Employer [] arr){
     System.out.println("Сотрудники старше 40 лет");
    for (int i = 0; i <arr.length; i++) {
        if (arr[i].age > 40){
            arr[i].info();
        }
    }
}

static void All (Employer [] arr){
     System.out.println("Все сотрудники:");
    for (int i = 0; i <arr.length ; i++) {
        arr[i].info();
    }
     System.out.println();
}
}
// ПКМ - Generate - Constructor
// ctrl + нажать на поле - покажет где оно в классе animal.name - нажимаем на name