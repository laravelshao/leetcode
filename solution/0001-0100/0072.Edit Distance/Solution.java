class Solution {
    public int minDistance(String word1, String word2) {
        // 状态定义：dp[i, j] 代表将 word1 的前 i 个字符转换为 word2 的前 j 个字符的最少操作步数

        // 针对替换、删除、插入操作说明：
        // 1、替换操作：word1 的前 i-1 个字符已经变换到 word2 的前 j-1 个字符的次数，说明 word1 的前 i-1 个和 word2 的前 j-1 个字符已经完成操作；
        // 那么对于 word1 的第 i 个怎么变成 word2 的第 j 个呢？这两个字符都存在，那么只能是替换了；所以 dp[i][j] = dp[i-1][j-1] + 1;
        // 2、插入操作：word1 的前 i 个字符已经变换到 word2 的前 j-1 个字符的次数，当前 word1 的第 i 步字符已经用了，
        // 但是 word2 还差一个字符（因为当前只是处理了 word2 的前 j-1 个字符），那么插入一个字符就好了；所以 dp[i][j] = dp[i][j-1] + 1;
        // 3、删除操作：word1 的前 i-1 个字符已经变换到 word2 的前 j 个字符的次数，当前 word1 仅用了前 i-1 个字符就完成了到 word2 的前 j 个字符的操作，
        // 所以 word1 的第 i 个字符其实没啥用了，那么删除操作就好了；所以 dp[i][j] = dp[i-1][j] + 1;
        // 转移方程：
        // 1、word1[i] != word2[j]，dp[i, j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1
        // 2、word1[i] == word2[j]，dp[i, j] = dp[i - 1, j - 1]

        // 初始状态：
        // 1、当两个字符串都为空时，dp[0][0] = 0
        // 2、当 word1 字符串为空时，则最少编辑步数等于 word2 的长度，首行为空，dp[0][j] = j
        // 3、当 word2 字符串为空时，则最少编辑步数等于 word1 的长度，首列为空，dp[i][0] = i

        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 初始化首行
        for(int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        // 初始化首列
        for(int j = 1; j <= m; j++) {
            dp[j][0] = j;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }
}