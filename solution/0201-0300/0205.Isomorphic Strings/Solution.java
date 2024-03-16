class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>(), t2s = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if ((s2t.containsKey(sc) && s2t.get(sc) != tc)
                    || (t2s.containsKey(tc) && t2s.get(tc) != sc)) {
                return false;
            }
            s2t.put(sc, tc);
            t2s.put(tc, sc);
        }

        return true;
    }
}