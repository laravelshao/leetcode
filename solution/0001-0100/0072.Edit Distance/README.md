# [72. 编辑距离](https://leetcode.cn/problems/edit-distance)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个单词&nbsp;<code>word1</code> 和&nbsp;<code>word2</code>， <em>请返回将&nbsp;<code>word1</code>&nbsp;转换成&nbsp;<code>word2</code> 所使用的最少操作数</em> &nbsp;。</p>

<p>你可以对一个单词进行如下三种操作：</p>

<ul>
	<li>插入一个字符</li>
	<li>删除一个字符</li>
	<li>替换一个字符</li>
</ul>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>word1 = "horse", word2 = "ros"
<strong>输出：</strong>3
<strong>解释：</strong>
horse -&gt; rorse (将 'h' 替换为 'r')
rorse -&gt; rose (删除 'r')
rose -&gt; ros (删除 'e')
</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>word1 = "intention", word2 = "execution"
<strong>输出：</strong>5
<strong>解释：</strong>
intention -&gt; inention (删除 't')
inention -&gt; enention (将 'i' 替换为 'e')
enention -&gt; exention (将 'n' 替换为 'x')
exention -&gt; exection (将 'n' 替换为 'c')
exection -&gt; execution (插入 'u')
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= word1.length, word2.length &lt;= 500</code></li>
	<li><code>word1</code> 和 <code>word2</code> 由小写英文字母组成</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：动态规划**

参考图解：https://leetcode.cn/problems/edit-distance/solutions/6455/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3

我们定义 `f[i][j]` 表示将 `word1` 的前 `i` 个字符转换成 `word2` 的前 `j` 个字符所使用的最少操作数。初始时 `dp[i][0] = i`, `dp[0][j] = j`。其中 `i ∈ [1, m], j ∈ [0, n]`。

理解替换、删除、插入操作：`dp[i-1][j-1]` 表示替换操作，`dp[i-1][j]` 表示删除操作，`dp[i][j-1]` 表示插入操作

- 替换操作：`word1` 的前 `i-1` 个字符已经变换到 `word2` 的前 `j-1` 个字符的次数，说明 `word1` 的前 `i-1` 个和 `word2` 的前 `j-1` 个字符已经完成操作；
  那么对于 `word1` 的第 `i` 个怎么变成 `word2` 的第 `j` 个呢？这两个字符都存在，那么只能是替换了；所以`dp[i][j] = dp[i-1][j-1] + 1`;
- 插入操作：`word1` 的前 `i` 个字符已经变换到 `word2` 的前 `j-1` 个字符的次数，当前 `word1` 的第 `i` 步字符已经用了， 
  但是 `word2` 还差一个字符（因为当前只是处理了 `word2` 的前 `j-1` 个字符），那么插入一个字符就好了；所以 `dp[i][j] = dp[i][j-1] + 1`;
- 删除操作：`word1` 的前 `i-1` 个字符已经变换到 `word2` 的前 `j` 个字符的次数，当前 `word1` 仅用了前 `i-1` 个字符就完成了到 `word2` 的前 `j` 个字符的操作，
  所以 `word1` 的第 `i` 个字符其实没啥用了，那么删除操作就好了；所以 `dp[i][j] = dp[i-1][j] + 1`;

考虑状态转移方程：

- 当 `word1[i - 1]` 不等于 `word2[j - 1]` 时，需要考虑插入、删除、替换操作，`dp[i, j] = min(dp[i, j - 1], dp[i - 1, j], dp[i - 1, j - 1]) + 1`
- 当 `word1[i - 1]` 等于 `word2[j - 1]`，只需要考虑将 `word1` 的前 `i - 1` 个字符转换成 `word2` 的前 `j - 1` 个字符所使用的最少操作数，则 `dp[i, j] = dp[i - 1, j - 1]`

最后，我们返回 `dp[m][n]` 即可。

时间复杂度 `O(mn)`，空间复杂度 `O(mn)`。其中 `m` 和 `n` 分别是 `word1` 和 `word2` 的长度。

