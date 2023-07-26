package solution;

/**
 * 724.Find Pivot Index
 *
 * @author qinghua.shao
 * @date 2023/6/26
 * @since 1.0.0
 */
public class P0724FindPivotIndex {

    public static int pivotIndex(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum * 2 + nums[i] == sum) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int pivotIndex1 = pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(pivotIndex1);

        int pivotIndex2 = pivotIndex(new int[]{1, 2, 3});
        System.out.println(pivotIndex2);

        int pivotIndex3 = pivotIndex(new int[]{2, 1, -1});
        System.out.println(pivotIndex3);
    }
}
