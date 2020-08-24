package Lesson2;

import java.util.Arrays;
import java.util.Random;

public class Lesson2 {
    public static void main (String[] args){

// 1.
        printTask ((byte) 1);
        Random random = new Random();
        int b = random.nextInt(20 ) + 10;
        int [] userArr = new int [b];
        CreateArr (userArr, 2, 0);
        PrintArr (userArr, (byte) 1);
        ArrChange (userArr);
        PrintArr (userArr, (byte) 2);

// 2.
        printTask ((byte) 2);
        int [] userArr2 = new int[8];
        FillArr (userArr2);
        PrintArr (userArr2, (byte) 3);

// 3.
        printTask ((byte) 3);
        int [] userArr3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        PrintArr (userArr3, (byte) 1);
        Less6 (userArr3);
        PrintArr (userArr3, (byte) 2);

// 4.
        printTask ((byte) 4);
        byte a = 5;
        int [][] userArr4 = new int [a][a];
        Diagonals (userArr4);
        PrintBigArr (userArr4);

// 5.
        printTask ((byte) 5);
        int [] userArr5 = new int[b]; // из первого задания
        CreateArr (userArr5, 20, 0); // из первого задания
        PrintArr (userArr5, (byte) 3); // из первого задания
         System.out.println("Максимальное значение: " + FindMax(userArr5));
         System.out.println("Минимальное значение: " + FindMin(userArr5));

// 6.
        printTask ((byte) 6);
        int [] userArr6 = new int[b]; // из первого задания
        CreateArr (userArr6, 10, 0); // из первого задания
        PrintArr (userArr6, (byte) 3); // из первого задания
        System.out.println("Результат: " + checkBalance (userArr6));

// 7.
        printTask ((byte) 7);
        int b2 = random.nextInt(5 ) + 5;
        int [] userArr7 = new int [b2];
        CreateArr (userArr7, 10, -5); // из первого задания
        PrintArr (userArr7, (byte) 1); // из первого задания
        arrMove (userArr7, -1);
        PrintArr (userArr7, (byte) 2); // из первого задания
    }


// 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
// С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static int [] CreateArr (int [] arr, int a, int b){
        Random random = new Random();
        for (int i = 0; i<arr.length; i++){
            arr [i] = random.nextInt(a) +b;
        }
        return arr;
    }
    public static void ArrChange (int [] arr){
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
    }
    public static void PrintArr (int [] arr, byte a){
        String type;
        if (a == 1) {
            type = "Первоначальный";
        } else if ( a==2){
            type = "Измененный";
        } else {
            type = "Просто";
        }
        System.out.printf("%15s %s %s\n", type, " массив: ", Arrays.toString(arr));
    }

// 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

    public static void FillArr (int [] arr) {
        for (int i = 1; i<arr.length; i++) {
            arr[i] = arr[i-1] +3;
        }
    }
// 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

    public static int [] Less6 (int [] arr){
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            } else {
                continue;
            }
        }
        return arr;
    }
// 4.  Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        public static void Diagonals (int [][] arr){
            for (int i = 0; i<arr.length; i++) {
                for (int j = 0; j<arr.length; j++){
                    if ((i == j) || (i + j  == arr.length-1)) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }
        }

        public static void PrintBigArr (int [][] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.printf("%-3d", arr[i][j]);
                }
                System.out.println();
            }
        }

// 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        public static int FindMax (int [] arr) {
        int max = arr [0];
        for (int i = 0; i < arr.length; i++) {
            if (arr [i] > max){
                max = arr [i];
            } else {
                continue;
            }
        }
        return max;
        }

    public static int FindMin (int [] arr) {
        int min = arr [0];
        for (int i = 0; i < arr.length; i++) {
            if (arr [i] < min){
                min = arr [i];
            } else {
                continue;
            }
        }
        return min;
    }

// 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
// метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
// Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
// граница показана символами ||, эти символы в массив не входят.

    public static boolean checkBalance (int [] arr) {
        int sum = 0;
        boolean b = false;
        for (int value : arr) {
            sum += value;
        }
            int half = arr[0];
            for (int i = 1; i < arr.length; i++) {
                    if (arr[i] + half == sum / 2) {
                        b = true;
                        break;
                    } else {
                        half += arr[i];
                        b = false;
                    }
                }
            return b;
            }

// 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
// при этом метод должен сместить все элементымассива на n позиций.
// Для усложнения задачи нельзя пользоваться вспомогательными массивами.

    public static void arrMove (int [] arr, int n) {
        for (int b = 0; b < Math.abs(n); b++) {
            if (n < 0) {
                for (int i = 0; i < arr.length - 1; i++) {
                    int a = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = a;
                }
            } else {
                for (int j = arr.length - 1; j > 0; j--) {
                    int c = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = c;
                }
            }
        }
    }


    // прочее
    public static void printTask (byte a){
         System.out.println();
         System.out.printf("%s %d", "Задание №", a);
         System.out.println();
    }
}
