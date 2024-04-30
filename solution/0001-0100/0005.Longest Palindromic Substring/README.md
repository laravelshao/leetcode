# [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。</p>

<p>如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "babad"
<strong>输出：</strong>"bab"
<strong>解释：</strong>"aba" 同样是符合题意的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "cbbd"
<strong>输出：</strong>"bb"
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> 仅由数字和英文字母组成</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：动态规划**

我们定义 `dp[i][j]` 表示字符串 `s[i..j]` 是否为回文串，初始时 `dp[i][j] = true`。

接下来，我们定义变量 `start` 和 `maxLen`，其中 `start` 表示最长回文串的起始位置，`maxLen` 表示最长回文串的长度。初始时 `start = 0`, `maxLen = 1`。

考虑 `dp[i][j]`，如果 `s[i] = s[j]`，那么 `dp[i][j] = dp[i + 1][j - 1]`；否则 `dp[i][j] = false`。如果 `dp[i][j] = true` 且 `j - i + 1 > mx`，那么我们更新 `mx = j - i + 1`, `k = i`。

由于 `dp[i][j]` 依赖于 `dp[i + 1][j - 1]`，因此我们需要保证 `i + 1` 在 `j - 1` 之前，因此我们需要从大到小地枚举 `i`，从小到大地枚举 `j`。

时间复杂度 `O(n^2)`，空间复杂度 `O(n^2)`。其中 `n` 是字符串 `s` 的长度。


**方法二：枚举回文中间点**

我们可以枚举回文中间点，向两边扩散，找到最长的回文串。

时间复杂度 `O(n^2)`，空间复杂度 `O(1)`。其中 `n` 是字符串 `s` 的长度。



