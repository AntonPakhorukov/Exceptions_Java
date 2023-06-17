package Home_Work_02;

import javax.crypto.spec.PSource;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
        и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
        вместо этого, необходимо повторно запросить у пользователя ввод данных.
        */
//        try {
//            System.out.print("Введите дробное число: ");
//            getNumber();
//        } catch (InputMismatchException e) {
//            System.out.println("Ура, получилось!");
//        }

        /*
        2. Если необходимо, исправьте данный код
        (задание 2 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)
        */

//        try {
//            int d = 0;
//            int[] intArray = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
//            double catchedRes1 = intArray[8] / d;
//            System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//            System.err.println("Catching exception: " + e);
//        }

        /*
        3. Дан следующий код, исправьте его там, где требуется
        (задание 3 https://docs.google.com/document/d/17EaA1lDxzD5YigQ5OAal60fOFKVoCbEJqooB9XfhT7w/edit)

        Выполнено в папке Home_Work_02, в файле Task_03.

        */

        /*
        4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
        */

        try {
            String name = getName();
            System.out.println("Вас зовут: " + name);
        } catch (Exception e) {
            System.err.println("Пустые строки вводить нельзя");
        } /*catch (NullPointerException | NumberFormatException e) {
            System.err.println("Не корректный ввод");
        }*/

    }

    public static float getNumber() {
        float result = 0;
        Scanner scan = new Scanner(System.in);
        if (!scan.hasNextFloat()) {
            System.err.print("Вы ввели не дробное число, повторите попытку: ");
            getNumber();
        }
        result = scan.nextFloat();
        System.out.println("Вы ввели: " + result);
        scan.close();
        return result;
    }

    public static String getName() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите свое имя: ");
        String name = scan.nextLine();
        scan.close();
//        if (name.isEmpty()) {
//            throw new NullPointerException();
//        } else {
//            for (Character c : name.toCharArray())
//                if (Character.isDigit(c)) {
//                    throw new NumberFormatException();
//                }
//        }
        if (name.isEmpty()) {
            throw new Exception();
        }
        return name;
    }
}
