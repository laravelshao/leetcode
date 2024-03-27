class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) { 
                // 二进制前面添加1
                res.add(head + res.get(j));
            }
            // 每次左移1位，依次是 1,2(10),4(100),8(1000)
            head <<= 1;
        }

        return res;
    }
}