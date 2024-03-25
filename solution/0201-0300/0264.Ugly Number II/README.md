# [264. 丑数 II](https://leetcode.cn/problems/ugly-number-ii)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数 <code>n</code> ，请你找出并返回第 <code>n</code> 个 <strong>丑数</strong> 。</p>

<p><strong>丑数 </strong>就是质因子只包含&nbsp;<code>2</code>、<code>3</code> 和&nbsp;<code>5</code>&nbsp;的正整数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>n = 10
<strong>输出：</strong>12
<strong>解释：</strong>[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>n = 1
<strong>输出：</strong>1
<strong>解释：</strong>1 通常被视为丑数。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1690</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->


**方法一：动态规划**

定义数组 `dp`，其中 `dp[i-1]` 表示第 `i` 个丑数，那么第 `n` 个丑数就是 `dp[n - 1]`。最小的丑数是 `1`，所以 `dp[0]=1`。

定义 `3` 个指针 `a`、`b` 和 `c`，表示下一个丑数是当前指针指向的丑数乘以对应的质因数。初始时，三个指针的值都指向 `0`。

- `a` 指向 `dp` 中的第一个丑数，即 `dp[0]`，`next2 = dp[a] * 2` 表示下一个 `2`倍的丑数
- `b` 指向 `dp` 中的第一个丑数，即 `dp[0]`，`next3 = dp[b] * 3` 表示下一个 `3`倍的丑数；
- `c` 指向 `dp` 中的第一个丑数，即 `dp[0]`，`next5 = dp[c] * 5` 表示下一个 `5`倍的丑数；

当 `i` 在 `[1,2..n-1]` 范围内，我们更新 `dp[i]=min(next2, next3, next5)`，

然后分别比较 `dp[i]` 与 `next2`、`next3`、`next5` 是否相等，若是，则对应的指针加 `1`。

最后返回 `dp[n - 1]` 即可。

时间复杂度 $O(n)$，空间复杂度 $O(n)$。
