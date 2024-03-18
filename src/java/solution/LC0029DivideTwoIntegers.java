package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinghua.shao
 * @date 2024/1/28
 * @since 1.0.0
 */
public class LC0029DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        }

        // Integer的范围时[-2^31, 2^31-1]，如果 Integer.MIN_VALUE 除以 -1，则会超过边界需要特殊处理
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 除数为最小值
        if (divisor == Integer.MIN_VALUE) {
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }

        // 获取商的符号
        boolean sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);
        // 所有数字都转换为负数进行处理，防止商溢出
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        List<Integer> candidates = new ArrayList<>();
        candidates.add(divisor);
        int index = 0;
        // 注意溢出
        while (candidates.get(index) >= dividend - candidates.get(index)) {
            candidates.add(candidates.get(index) + candidates.get(index));
            ++index;
        }

        int ans = 0;
        for (int i = candidates.size() - 1; i >= 0; --i) {
            if (candidates.get(i) >= dividend) {
                ans += 1 << i;
                dividend -= candidates.get(i);
            }
        }

        return sign ? ans : -ans;
    }

    public static void main(String[] args) {

        divide(100, 3);
    }
}
