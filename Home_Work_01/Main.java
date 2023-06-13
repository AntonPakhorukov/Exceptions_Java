package Home_Work_01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
        */

//        System.out.println(divideByZero(20, 0)); // 1. ошибка при делении на ноль (+ выброс исключения) = ArithmeticException

//        int[] arr = new int[5];
//        setNumber(arr, 10, 5); // 2. ошибка при обращении к индексу массива (+ выброс исключения) = ArrayIndexOutOfBoundsException
//        printArray(arr);

//        int number = getNumber();
//        System.out.println("Вы ввели " + number); // 3. ошибка при вводе не числа (+ выброс исключения) = InputMismatchException

        /*
        Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
        */

        String[][] array = new String[][] {
                {"1", "1", "0", "1", "1"},
                {"1", "0", "1", "1", "0"},
                {"1", "0", "0", "1", "1"},
                {"1", "0", "1" ,"0", "1"},
                {"1", "0", "1", "1", "0"}
        };
        // System.out.println(sum2d(array));
        // ArrayIndexOutOfBoundsException - при не верном определении длинны массива
        // NumberFormatException - при наличии в ячейки не числа

        /*
        Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий
        новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
        Если длины массивов не равны, необходимо как-то оповестить пользователя.
         */

        int[] array1 = new int[] {10, 15, 20, 25, 30, 0};
        int[] array2 = new int[] {5, 15, 25, 35, 10, 0};
        int[] newArray = arrayDifference(array1, array2);
        printArray(newArray);

        /*
        Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
        каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
        Если длины массивов не равны, необходимо как-то оповестить пользователя.
        Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException,
        т.е. ваше.
         */
        int[] arr1 = new int[]{20, 30, 40, 50, 60, 5, 50};
        int[] arr2 = new int[]{5, 6, 4, 25, 3, 5, 5};
        try{
            int[] res = arrayDivide(arr1, arr2);
            printArray(res);
        } catch (RuntimeException e){
            System.err.println("Ошибка вычислений (деление на ноль или разные длины массивов)");
            //System.out.println(e.getMessage());
        }
    }
    public static int[] arrayDivide(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }

    public static int[] arrayDifference(int[] arr1, int[] arr2){
        if (arr1.length > arr2.length) {
            throw new ArrayIndexOutOfBoundsException("Размеры массивов имеют разные значения, первый массив больше второго");
        } else if (arr1.length < arr2.length) {
            throw new ArrayIndexOutOfBoundsException("Размеры массивов имеют разные значения, первый массив меньше второго");
        }
        int[] newArray = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            newArray[i] = arr1[i] - arr2[i];
        }
        return newArray;
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }

    public static int divideByZero (int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("На ноль делить нельзя");
        }
        return a / b;
    }
    public static void setNumber (int[] array, int number, int value) {
        if (number > array.length) {
            throw new ArrayIndexOutOfBoundsException("Вы указали не корректный номер ячейки массива");
        }
        array[number] = value;
    }
    public static void printArray (int[] array){
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public static int getNumber() {
        System.out.print("Введите любое число: ");
        Scanner scan = new Scanner(System.in);
        if (!scan.hasNextInt()) {
            throw new InputMismatchException("Вы ввели не число");
        }
        int number = scan.nextInt();
        scan.close();
        return number;
    }
}
