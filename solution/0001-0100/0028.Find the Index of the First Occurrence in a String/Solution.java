class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }

        int len1 = haystack.length(), len2 = needle.length();
        // p为haystack索引位置，q为needle索引位置
        int p = 0, q = 0;
        while (p < len1) {
            // 样例说明：haystack = "mississippi"，needle = "issip"
            // 第1次循环：p = 0, q = 0, 下标元素元素不相同
            // 第2次循环：p = 1, q = 0, 下标位置元素相同 p = 2, q = 1
            // 第3次循环：p = 2, q = 1, 下标位置元素相同 p = 3, q = 2
            // 第4次循环：p = 3, q = 2, 下标位置元素相同 p = 4, q = 3
            // 第5次循环：p = 4, q = 3, 下标位置元素相同 p = 5, q = 4
            // 第6次循环：p = 5, q = 4, 下标位置元素不相同，p 需要回到相同长度前的位置的下一位置，p = p - q + 1, q则置为0
            if (haystack.charAt(p) == needle.charAt(q)) {
                if (len2 == 1) {
                    return p;
                }
                p++;
                q++;
            } else {
                // 当不匹配时，p需要从p-q的下一个元素开始尝试
                p = p - q + 1;
                // q置为0
                q = 0;
            }

            // 当q到needle末尾，p-q就是索引下标
            if (q == len2) {
                return p - q;
            }
        }

        return -1;
    }
}