class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            List<String> tmpList = map.getOrDefault(sortedStr, new ArrayList<String>());
            tmpList.add(str);
            map.put(sortedStr, tmpList);
        }

        return new ArrayList(map.values());
    }
}