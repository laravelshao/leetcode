class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> visitedSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            if (map.containsKey(sc) && map.get(sc) != tc) {
                return false;
            }
            if (!map.containsKey(sc) && visitedSet.contains(tc)) {
                return false;
            }
            map.put(sc, tc);
            visitedSet.add(tc);
        }
        return true;
    }
}