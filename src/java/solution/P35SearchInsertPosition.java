package solution;

/**
 * 35.Search Insert Position
 *
 * @author qinghua.shao
 * @date 2023/6/26
 * @since 1.0.0
 */
public class P35SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {

        int insertIndex1 = searchInsert(new int[]{1, 3, 5, 6}, 5);
        System.out.println(insertIndex1);

        int insertIndex2 = searchInsert(new int[]{1, 3, 5, 6}, 2);
        System.out.println(insertIndex2);

        int insertIndex3 = searchInsert(new int[]{1, 3, 5, 6}, 7);
        System.out.println(insertIndex3);
    }
}
