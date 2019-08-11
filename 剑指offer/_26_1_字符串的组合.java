package sequential;

import java.util.ArrayList;

/**
 * Created by qqzeng.
 */
public class Combination {

    private static void comb(String str, StringBuilder res, int index, int len, ArrayList<String> result, boolean[] used) {
        if (index == len) {
            System.out.println(res.toString());
            result.add(res.toString());
            return;
        }

        for (int i = index; i < str.length(); i++) {
            if (!used[i]) {
                res.append(str.charAt(i));
                used[i] = true;
                comb(str, res, index + 1, len, result, used);
                res.deleteCharAt(res.length() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> result = new ArrayList<>();
        for (int k = 1; k <= str.length(); k++) {
            System.out.println("---------" + k + "---------");
            boolean[] used = new boolean[str.length()];
            comb(str, new StringBuilder(""), 0, k, result, used);
        }
    }


}
