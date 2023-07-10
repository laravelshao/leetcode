package solution.part19;

/**
 * 1991.Find the Middle Index in Array
 *
 * @author qinghua.shao
 * @date 2023/6/25
 * @since 1.0.0
 */
public class P1991FindTheMiddleIndexInArray {

    public static int findMiddleIndex(int[] nums) {

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

        int middleIndex1 = findMiddleIndex(new int[]{2, 3, -1, 8, 4});
        System.out.println(middleIndex1);

        int middleIndex2 = findMiddleIndex(new int[]{1, -1, 4});
        System.out.println(middleIndex2);

        int middleIndex3 = findMiddleIndex(new int[]{2, 5});
        System.out.println(middleIndex3);

        int middleIndex4 = findMiddleIndex(new int[]{1});
        System.out.println(middleIndex4);
    }
}
