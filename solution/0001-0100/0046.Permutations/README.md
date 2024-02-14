# [46. 全排列](https://leetcode.cn/problems/permutations)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个不含重复数字的数组 <code>nums</code> ，返回其 <em>所有可能的全排列</em> 。你可以 <strong>按任意顺序</strong> 返回答案。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1]
<strong>输出：</strong>[[0,1],[1,0]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>[[1]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 6</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li><code>nums</code> 中的所有整数 <strong>互不相同</strong></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：DFS（回溯）**

我们设计一个函数 $dfs(i)$ 表示已经填完了前 $i$ 个位置，现在需要填第 $i+1$ 个位置。枚举所有可能的数，如果这个数没有被填过，就填入这个数，然后继续填下一个位置，直到填完所有的位置。

时间复杂度 $O(n \times n!)$，其中 $n$ 是数组的长度。一共有 $n!$ 个排列，每个排列需要 $O(n)$ 的时间来构造。

相似题目：

-   [47. 全排列 II](/solution/0001-0100/0047.Permutations%20II/README.md)

