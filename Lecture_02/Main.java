package Lecture_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Objects;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // === NullPointerException ===

        /*
        String name = null;
        System.out.println(name.length()); // выдаст NullPointerException
        */

        // === ClassCastException ===

        /*
        Object object = new String("123"); // создали класс object и положили в него строку
        File file = (File) object; // создали класс File и сделали преобразование в него object
        System.out.println(file); // выдаст ClassCastException
        */

        // === NumberFormatException ===

        /*
        String number = "123qw";
        int i = Integer.parseInt(number);
        System.out.println(i); // выдаст NumberFormatException
        */

        // === UnsupportedOperationException ===

        /*
        List<Object> emptyList = Collections.emptyList(); // возвращает пустой лист, не изменяемый лист
        emptyList.add(new Object()); // выдаст UnsupportedOperationException, так как метод add для emptyList не поддерживается
        */

        // === Блок try / catch ===
        // Ver.1 =================================================================================================
        try {
            int result = 10/0;
        } catch (ArithmeticException e) {
            System.err.println("Operation divide by zero not supported1");
        }
        System.out.println();
        int number = 1;
        try{
            number = 10/0;
        } catch (ArithmeticException e) {
            System.err.println("Operation divide by zero not supported"); // перехватили исключение
        }
        System.out.println(number); // при этом код продолжется выполнятся, если блок catch
         //не сработает, то number обновится
        System.out.println();
        // Ver.2 =================================================================================================
//        int number2 = 1;
//        try{
//            number2 = 10/1;
//            String str = null;
//            System.out.println(str.length()); // NullPointerException
//        } catch (Exception e) { // ArithmeticException e
//            System.err.println("Operation not supported"); // перехватили исключение
//        }
//        System.out.println(number2);
        // программа упадет, так как NullPointerException не обработается, нет в блоке catch
        // можно поднять catch до уровня Exception, тогда приложение падать не будет
//        System.out.println();
        // Ver.3 =================================================================================================
//        int number3 = 1;
//        try{
//            number3 = 10/0;
//            String str = null;
//            System.out.println(str.length()); // NullPointerException
//        } catch (ArithmeticException e) { // сработает только первое исключение
//            System.err.println("Operation divide by zero not supported"); // перехватили исключение
//        } catch (NullPointerException e) { // второе исключение
//            System.err.println("Operation not supported");
//        }
//        System.out.println(number3);
//        System.out.println();
        // Ver.4 ================================================================================================
//        int number4 = 1;
//        try{
//            number4 = 10/1;
//            String str = null;
//            //System.out.println(str.length()); // NullPointerException
//            Collections.emptyList().add(new Object());
//        } catch (ArithmeticException e) { // сработает только первое исключение
//            System.err.println("Operation divide by zero not supported"); // перехватили исключение
//        } catch (NullPointerException e) { // второе исключение
//            System.err.println("Operation not supported");
//        } catch (Exception e){
//            System.err.println("Exception"); // поймает родитель исключений, первым его ставить нельзя, так как
//            // он соберет все возможные исключения и остальные наследники работать не будут
//        }
//        System.out.println(number4);
//        System.out.println();
        // ======================================================================================================
        //FileReader reader = new FileReader("test"); // сразу будет подчеркнут FileReader, так как будет
        // исключение FileNotFoundException - checked исключения, обязаны обработать
//        try {
//            FileReader reader = new FileReader("test");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        // ======================================================================================================
        // можно сделать обработку нескольких исключений в рамках одного блока try / catch
//        try {
//            FileReader reader = new FileReader("test");
//        } catch (RuntimeException | FileNotFoundException e) {
//            System.err.println("catch exception");
//        }
        // ======================================================================================================
        // так же, можно добавить выполнение определенных операций не зависимо от выполнения блока try / catch
//        FileReader reader = null;
//        try {
//            reader = new FileReader("C:\\Users\\pakho\\IdeaProjects\\Seminar_01\\src\\Lecture_02\\test.md");
//            reader.read();
//        } catch (RuntimeException | IOException e) {
//            System.err.println("catch exception: " + e.getClass().getSimpleName());
//        } finally { // блок, который в любом случае будет выполнен
//            System.out.println("finaly start");
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    System.err.println("Exception while close");
//                }
//            }
//            System.out.println("finaly end");
//        }

    }
}
