class Solution {

    // 用于承载三种key，通过下面方式可以保证唯一不重复
    // 行："r-"+row 
    // 列："c-"+column 
    // 3*3网格：(row/3)+ "-" + (column/3)
    private Map<String, Set<Character>> map = new HashMap<>();
    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                Character c = board[row][column];
                if (c == '.') {
                    continue;
                }

                if (!checkRow(row, c)) {
                    return false;
                }

                if (!checkColumn(column, c)) {
                    return false;
                }

                if (!checkGrid(row, column, c)) {
                    return false;
                }
            }
        }

        return true;
    }
    private boolean checkRow(int row, Character c) {
        String key = "r-" + row;
        Set<Character> set = map.getOrDefault(key, new HashSet<Character>());
        if (!set.add(c)) {
            return false;
        }
        map.put(key, set);
        return true;
    }
    private boolean checkColumn(int column, Character c) {
        String key = "c-" + column;
        Set<Character> set = map.getOrDefault(key, new HashSet<Character>());
        if (!set.add(c)) {
            return false;
        }
        map.put(key, set);
        return true;
    }
    private boolean checkGrid(int row, int column, Character c) {
        String key = (row / 3) + "-" + (column / 3);
        Set<Character> set = map.getOrDefault(key, new HashSet<Character>());
        if (!set.add(c)) {
            return false;
        }
        map.put(key, set);
        return true;
    }
}