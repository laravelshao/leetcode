class Solution {
    public boolean isHappy(int n) {

        Set<Integer> hashSet = new HashSet<>();
        while (hashSet.add(n)) {
            int next = 0;
            while (n > 0) {
                int lastFigure = n % 10;
                next += lastFigure * lastFigure;
                n = n / 10;
            }
            if (next == 1) {
                return true;
            }
            n = next;
        }
        return false;
    }
}