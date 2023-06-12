import java.util.Arrays;
import java.util.List;

public class Task_03 {
    public static void main(String[] args) {

        int[][] ints = new int[][] {
                {1,0,1,1,1},
                {1,0,1,1,1},
                {1,0,1,1,1},
                {1,0,1,1,1},
                {1,0,1,0,1}
        };

        System.out.println(getElementsSum(ints));

    }
    private static int getElementsSum(int[][] arg) {
        if (isNotSquareArray(arg)) {
            throw new RuntimeException("Массив не квадратный");
        }
        if (isDataNotCorrection(arg)) {
            throw new RuntimeException("Массив должен содержать только 0 или 1");
        }
        return Arrays.stream(arg).mapToInt(ints -> Arrays.stream(ints).sum()).sum();
//        int sum = 0;
//        for (int i = 0; i < arg.length; i++) {
//            for (int j = 0; j < arg.length; j++) {
//                sum += arg[i][j];
//            }
//        }
//        return sum;
    }
    private static boolean isNotSquareArray (int[][] arg) {
        for (int[] ints : arg) {
            if (ints.length != arg.length) return true;
        }
        return false;
    }

    private static boolean isDataNotCorrection (int[][] arg) {
        List<Integer> data = List.of(0, 1);
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg.length; j++) {
                if(!data.contains(arg[i][j])) return true;
            }
        }
        return false;
    }
}
