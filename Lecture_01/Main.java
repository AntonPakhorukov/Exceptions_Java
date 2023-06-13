package Lecture_01;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println(getFileSize(new File("123"))); // вызываем который у нас не существует
        // программа выдала 0, при этом не понятно, это его вес или его не существует?
        // после проверки, выдал -1
        System.out.println(getFileSize(new File("C:\\Users\\pakho\\IdeaProjects\\Seminar_01\\src\\Task_03.java")));
        // int x = 10/ 0; // сработает первое исключение, до остальных не дойдет
        //System.out.println(divide(5, 0)); // сработает ArithmeticException при делении на ноль
        // при добавлении проверки вернется -1
        System.out.println(divide(-10, 10));
        System.out.println(divide2(10, 0));

//        int[] ints = new int[10];
//        System.out.println(ints[1000]); // выдаст ошибку ArrayIndexOutOfBoundsException - вышли за пределы массива

//        a();


    }

    public static int divide(int a1, int a2) {
//        if (a2 == 0){ // добавили проверку
//            return -1;
//        }
        return a1/a2;
    }

    public static int divide2(int a1, int a2){
        if (a2 == 0) {
            throw new RuntimeException("На ноль делить нельзя"); // бросаем исключение при делении на 0
        }
        return a1/a2;
    }
    public static long getFileSize (File file) { // на вход принимаем файл
        if (!file.exists()) { // добавили проверку, если файл не существует
            return -1;
        }
        return file.length(); // у каждого файла есть параметр length

    }
    public static void a() {
        b();
    }
    public static void b() {
        c();
    }

    public static void c() {
        int[] int2 = new int[10];
        System.out.println(int2[1000]);
    }
}
