package Seminar_03.Task4;

public class MyArrayDataException extends Exception{
    public  MyArrayDataException() {
        super("В массиве должны быть только числа");
    }
    public  MyArrayDataException(String message) {
        super(message);
    }
    public MyArrayDataException (int i, int j){
        super(String.format("В ячейке [%d][%d]не число", i, j));
    }
}
