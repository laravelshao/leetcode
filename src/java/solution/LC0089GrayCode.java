package solution;

import java.util.ArrayList;
import java.util.List;


/**
 * 89. Gray Code
 *
 * @author qinghua.shao
 * @date 2024/3/27
 * @since 1.0.0
 */
public class LC0089GrayCode {

    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
            //
            head <<= 1;
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(grayCode(4));
    }
}
