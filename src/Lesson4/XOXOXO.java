package Lesson4;
import java.util.Random;
import java.util.Scanner;
public class XOXOXO {
        public static int SIZE = 5;
        public static int DOTS_TO_WIN = 4;
        public static final char DOT_EMPTY = '•';
        public static final char DOT_X = 'X';
        public static final char DOT_O = 'O';
        public static char[][] map;
        public static Scanner sc = new Scanner(System.in);
        public static Random rand = new Random();
        public static void main(String[] args) {
            initMap();
            printMap();
            while (true) {
                humanTurn();
                printMap();
                if (checkWin(DOT_X)) {
                    System.out.println("Победил человек");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
                aiTurn();
                printMap();
                if (checkWin(DOT_O)) {
                    System.out.println("Победил Искуственный Интеллект");
                    break;
                }
                if (isMapFull()) {
                    System.out.println("Ничья");
                    break;
                }
            }
            System.out.println("Игра закончена");
        }
        public static boolean checkWin(char symb) {
         int horizont;
            for (int i = 0; i <SIZE ; i++) {
                horizont = 0;
                for (int j = 0; j <SIZE; j++) {
                    if (map[i][j] == symb) {
                        horizont ++;
                    if (horizont == DOTS_TO_WIN) {
                        return true;
                    }
                    }else {
                        horizont = 0;
                    }
                }
            }

            int vertikal;
            for (int i = 0; i <SIZE ; i++) {
                vertikal = 0;
                for (int j = 0; j < SIZE; j++) {
                    if (map[j][i] == symb) {
                        vertikal++;
                        if (vertikal == DOTS_TO_WIN) {
                            return true;
                        }
                    } else {
                        vertikal = 0;
                    }
                }
            }

            int diagonal1;
            for (int i = 0; i <SIZE ; i++) {
                diagonal1 = 0;
                for (int j = 0; (j + i) < SIZE; j++) {
                    if (map[j][j + i] == symb) {
                        diagonal1++;
                        if (diagonal1 == DOTS_TO_WIN) {
                            return true;
                        }
                    } else {
                        diagonal1 = 0;
                    }
                }
                diagonal1 = 0;
                for (int j = 0; (j + i) < SIZE; j++) {
                    if (map[j + i][j] == symb) {
                        diagonal1++;
                        if (diagonal1 == DOTS_TO_WIN) {
                            return true;
                        }
                    } else {
                        diagonal1 = 0;
                    }
                }
            }
            int diagonal2;
            for (int i = 0; i <SIZE ; i++) {
                diagonal2 = 0;
                for (int j = SIZE - 1; (SIZE - 1 - j)>=0 && (j - i) >= 0; j--) {
                    if (map[SIZE - 1 - j][j - i] == symb) {
                        diagonal2++;
                        if (diagonal2 == DOTS_TO_WIN) {
                            return true;
                        }
                    } else {
                        diagonal2 = 0;
                    }
                }
                diagonal2 = 0;
                for (int j = SIZE - 1; (SIZE - 1 - j + i) <= (SIZE - 1) && j>=0; j--) {
                    if (map[SIZE - 1 - j + i][j] == symb) {
                        diagonal2++;
                        if (diagonal2 == DOTS_TO_WIN) {
                            return true;
                        }
                    } else {
                        diagonal2 = 0;
                    }
                }
            }

            return false;
        }
        public static boolean isMapFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (map[i][j] == DOT_EMPTY) return false;
                }
            }
            return true;
        }
        public static void aiTurn() {
            int x = 0, y = 0;
            boolean findUser = false;
            boolean findIA = false;
            // проверяем может ли победить игрок
                for (int i = 0; i < SIZE; i++) {
                    for (int j = 0; j < SIZE; j++) {
                        if (isCellValid(j, i)) {
                            map[i][j] = DOT_X;
                            if (checkWin(DOT_X)) {
                                y = i;
                                x = j;
                                findUser = true;
                                break;
                            } else {
                                map[i][j] = DOT_EMPTY;
                            }
                        }
                    }
                    if (findUser) {
                        break;
                    }
                }
                // если игрок не может победить, проверяем может ли победить IA
                if (!findUser) {
                    for (int i = 0; i < SIZE; i++) {
                        for (int j = 0; j < SIZE; j++) {
                            if (isCellValid(j, i)) {
                                map[i][j] = DOT_O;
                                if (checkWin(DOT_O)) {
                                    y = i;
                                    x = j;
                                    findIA = true;
                                    break;
                                } else {
                                    map[i][j] = DOT_EMPTY;
                                }
                            }
                        } if (findIA) {
                            break;
                        }
                    }
                }
                // делаем случайный ход если победы в след.раунде точно не будет
                if (!findUser && !findIA){
                    do {
                        x = rand.nextInt(SIZE);
                        y = rand.nextInt(SIZE);
                    } while (!isCellValid(x, y));
                }

            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
        }
        public static void humanTurn() {
            int x, y;
            do {
                System.out.println("Введите координаты в формате X Y");
                x = sc.nextInt() - 1;
                y = sc.nextInt() - 1;
            } while (!isCellValid(x, y)); 
            map[y][x] = DOT_X;
        }
        public static boolean isCellValid(int x, int y) {
            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
            if (map[y][x] == DOT_EMPTY) return true;
            return false;
        }
        public static void initMap() {
            map = new char[SIZE][SIZE];
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        public static void printMap() {
            for (int i = 0; i <= SIZE; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < SIZE; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
