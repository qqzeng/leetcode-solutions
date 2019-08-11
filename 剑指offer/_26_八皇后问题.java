package sequential;

/**
 * Created by qqzeng.
 */
public class EigthQueen {

    private static boolean isValid(int[] chess, int index) {
        for (int i = 0; i < index; i++) {
            if (chess[index] == chess[i]) return false;
            if (Math.abs(index - i) == Math.abs(chess[index] - chess[i])) return false;
        }
        return true;
    }

    static int count = 0;

    public static void eightQueue(int n, int index, int[] chess) {
        if (index == n) {
            count++;
            for (int i = 0; i < n; i++) System.out.print(chess[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            chess[index] = i;
            boolean valid = isValid(chess, index);
            if (valid) {
                eightQueue(n, index + 1, chess);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        eightQueue(n, 0, new int[n]);
        System.out.println(count);
    }
}