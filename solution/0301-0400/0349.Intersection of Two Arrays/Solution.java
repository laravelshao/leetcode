class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> intersectSet = new HashSet<>();

        for (int num : nums1) {
            nums1Set.add(num);
        }

        for (int num : nums2) {
            if (nums1Set.contains(num)) {
                intersectSet.add(num);
            }
        }

        int[] res = new int[intersectSet.size()];
        int i = 0;
        for (int num : intersectSet) {
            res[i++] = num;
        }

        return res;
    }
}