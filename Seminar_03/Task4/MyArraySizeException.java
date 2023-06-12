package Seminar_03.Task4;

public class MyArraySizeException extends Exception{
    MyArraySizeException() {
        super("Двумерный массив должен быть размером 3х3");
    }
}
