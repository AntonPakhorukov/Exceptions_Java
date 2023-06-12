package Seminar_03.Task4;

/**
 Напишите метод, на вход которого подаётся двумерный строковый массив размером 3х3.
 При подаче массива другого размера необходимо бросить исключение MyArraySizeException.

 1. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 Если в каком-то элементе массива преобразование не удалось
 (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
 с детализацией, в какой именно ячейке лежат неверные данные.

 2. В методе main() вызвать полученный метод, обработать возможные исключения
 MyArraySizeException и MyArrayDataException и вывести результат расчета
 (сумму элементов, при условии, что подали на вход корректный массив).
 */
public class Task4 {
    public static void main(String[] args) {
        try {
            System.out.println(sum2d(arr, 3));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    static String[][] arr = new String[][] {
            {"1", "1.5", "1.5"},
            {"1", "1.5", "1.5"},
            {"1", "1.5", "1.5"}
    };

    public static double sum2d(String[][] arr, int size) throws MyArraySizeException, MyArrayDataException{
        if (isNotSquare(arr, 3)) {
            throw new MyArraySizeException();
        }
        double summ = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                try {
                    summ += Double.parseDouble(arr[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException();
                }
            }
        }
        return 0;
    }
    public static boolean isNotSquare(String[][] array, int size) {
        if (array.length != size) return true;
        for (String[] st: array) {
            if (st.length != size) {
                return true;
            }
        }
        return false;
    }
}
