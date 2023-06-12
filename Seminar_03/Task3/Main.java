package Seminar_03.Task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        //divide(5, 0);
        String name = " OUPS";
        try {
            foo();
        } catch (NonExistedFileException e) {
            //System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage() + name);
        }
    }

    private static double divide(int a, int b) {
        double result = 0;
        try {
            result = a / b;
        } catch (RuntimeException e) { // только для исключений java, не измененных
            throw new DivideByZeroException();
        }
        return result;
    }
    private static void foo() throws NonExistedFileException {
        // throw указываем, если знаем об этой ошибке и обработаем в том месте, где оно сработает
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("path")));
        } catch (FileNotFoundException e) {
            throw new NonExistedFileException(); // кидаем наше исключение на
        }
    }
}
