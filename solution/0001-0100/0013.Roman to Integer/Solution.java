class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symbolValueMap = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int value = symbolValueMap.get(s.charAt(i));
            // 如果当前位置值小于后一位，需要减去，需要考虑边界
            if (i < s.length() - 1 && value < symbolValueMap.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}