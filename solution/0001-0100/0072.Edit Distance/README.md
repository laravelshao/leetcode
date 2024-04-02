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

我们定义 $f[i][j]$ 表示将 $word1$ 的前 $i$ 个字符转换成 $word2$ 的前 $j$ 个字符所使用的最少操作数。初始时 $f[i][0] = i$, $f[0][j] = j$。其中 $i \in [1, m], j \in [0, n]$。

考虑 $f[i][j]$：

-   如果 $word1[i - 1] = word2[j - 1]$，那么我们只需要考虑将 $word1$ 的前 $i - 1$ 个字符转换成 $word2$ 的前 $j - 1$ 个字符所使用的最少操作数，因此 $f[i][j] = f[i - 1][j - 1]$；
-   否则，我们可以考虑插入、删除、替换操作，那么 $f[i][j] = \min(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1]) + 1$。

综上，我们可以得到状态转移方程：

$$
f[i][j] = \begin{cases}
i, & \text{if } j = 0 \\
j, & \text{if } i = 0 \\
f[i - 1][j - 1], & \text{if } word1[i - 1] = word2[j - 1] \\
\min(f[i - 1][j], f[i][j - 1], f[i - 1][j - 1]) + 1, & \text{otherwise}
\end{cases}
$$

最后，我们返回 $f[m][n]$ 即可。

时间复杂度 $O(m \times n)$，空间复杂度 $O(m \times n)$。其中 $m$ 和 $n$ 分别是 $word1$ 和 $word2$ 的长度。

