# [1143. 最长公共子序列](https://leetcode.cn/problems/longest-common-subsequence)

## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个字符串 <code>text1</code> 和 <code>text2</code>，返回这两个字符串的最长 <strong>公共子序列</strong> 的长度。如果不存在 <strong>公共子序列</strong> ，返回 <code>0</code> 。</p>

<p>一个字符串的 <strong>子序列</strong><em> </em>是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。</p>

<ul>
	<li>例如，<code>"ace"</code> 是 <code>"abcde"</code> 的子序列，但 <code>"aec"</code> 不是 <code>"abcde"</code> 的子序列。</li>
</ul>

<p>两个字符串的 <strong>公共子序列</strong> 是这两个字符串所共同拥有的子序列。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>text1 = "abcde", text2 = "ace" 
<strong>输出：</strong>3  
<strong>解释：</strong>最长公共子序列是 "ace" ，它的长度为 3 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>text1 = "abc", text2 = "abc"
<strong>输出：</strong>3
<strong>解释：</strong>最长公共子序列是 "abc" ，它的长度为 3 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>text1 = "abc", text2 = "def"
<strong>输出：</strong>0
<strong>解释：</strong>两个字符串没有公共子序列，返回 0 。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= text1.length, text2.length <= 1000</code></li>
	<li><code>text1</code> 和 <code>text2</code> 仅由小写英文字符组成。</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：动态规划**

我们定义 $f[i][j]$ 表示 $text1$ 的前 $i$ 个字符和 $text2$ 的前 $j$ 个字符的最长公共子序列的长度。那么答案为 $f[m][n]$，其中 $m$ 和 $n$ 分别为 $text1$ 和 $text2$ 的长度。

如果 $text1$ 的第 $i$ 个字符和 $text2$ 的第 $j$ 个字符相同，则 $f[i][j] = f[i - 1][j - 1] + 1$；如果 $text1$ 的第 $i$ 个字符和 $text2$ 的第 $j$ 个字符不同，则 $f[i][j] = max(f[i - 1][j], f[i][j - 1])$。即状态转移方程为：

$$
f[i][j] =
\begin{cases}
f[i - 1][j - 1] + 1, & text1[i - 1] = text2[j - 1] \\
\max(f[i - 1][j], f[i][j - 1]), & text1[i - 1] \neq text2[j - 1]
\end{cases}
$$

时间复杂度 $O(m \times n)$，空间复杂度 $O(m \times n)$。其中 $m$ 和 $n$ 分别为 $text1$ 和 $text2$ 的长度。

参考官方题解：https://leetcode.cn/problems/longest-common-subsequence/solutions/696763/zui-chang-gong-gong-zi-xu-lie-by-leetcod-y7u0/
