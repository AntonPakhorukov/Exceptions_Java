package Seminar_02;

/**
 * Обработайте возможные исключительные ситуации. "Битые" значения
 * в исходном массиве считайте нулями. Можно внести в код правки,
 * которые считаете необходимыми
 */
public class Task2 {
    public static void main(String[] args) {
        String[][] arr0 = new String[][] {
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "1", "1", "1", "1"}
        };

        String[][] arr = new String[][] {
                {"1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "2"},
                {"3", "3"},
                {"2", "6"}
        };

        String[][] arr1 = new String[][] {
                {"1", "1"},
                {"1", "1", "1", "1", "1"},
                {"1", "2"},
                {"3", "a"},
                {"2", "6"}
        };

        System.out.println(sum2d(arr1));
    }


//    private static int sum2d(String[][] arr) {
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) { // было 5 длинна
//                int val = Integer.parseInt(arr[i][j]);
//                sum += val;
//            }
//        }
//        return sum;
//    }

    private static int sum2d(String[][] arr) {
        int sum = 0;
        if (arr != null) {
            try {
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) { // было 5 длинна
                        int val = Integer.parseInt(arr[i][j]);
                        sum += val;
                    }
                }
            } catch (NumberFormatException e) {
                System.err.println("Не корректный ввод");
            }
            return sum; // потому что нет throw
        } else {
            throw new NullPointerException("Массив не может быть пустым");
        }
    }
}