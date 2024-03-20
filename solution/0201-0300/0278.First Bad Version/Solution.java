/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int i = 1, j = n;
        while (i <= j) {
            // 向下取整除法计算中点 mid
            int mid = i + (j - i) / 2;
            // mid错误，则正确版本在[1, mid - 1]中
            if (isBadVersion(mid)) {
                // 错误
                j = mid - 1;
            } else {
                // mid正确，则第一个错误版本在[mid + 1, j]
                i = mid + 1;
            }
        }

        // i指向第一个错误版本
        return i;
    }
}