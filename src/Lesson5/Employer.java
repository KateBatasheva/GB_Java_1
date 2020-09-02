package Lesson5;

// Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст
public class Employer {
    String name;
    String position;
    String email;
    String tel;
    int salary;
    int age;

    public Employer(String name, String position, String email) {
        this.name = name;
        this.position = position;
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
    public void info (){
         System.out.printf("ФИО: %s, возраст - %d, работает на позиции %s за %d рублей. Связаться можно по телефону %s или по почте %s.\n", name, age, position, salary, tel, email);
    }
}
