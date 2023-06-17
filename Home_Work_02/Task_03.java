package Home_Work_02;

import java.lang.reflect.Array;

public class Task_03 {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(34, 234);
            int[] abc = { 1, 2 };
            abc[1] = 3;
        } catch (ArithmeticException ex) {
            System.out.println("Делить на ноль нельзя!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

}
