# [40. 组合总和 II](https://leetcode.cn/problems/combination-sum-ii)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个候选人编号的集合&nbsp;<code>candidates</code>&nbsp;和一个目标数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中所有可以使数字和为&nbsp;<code>target</code>&nbsp;的组合。</p>

<p><code>candidates</code>&nbsp;中的每个数字在每个组合中只能使用&nbsp;<strong>一次</strong>&nbsp;。</p>

<p><strong>注意：</strong>解集不能包含重复的组合。&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入:</strong> candidates =&nbsp;<code>[10,1,2,7,6,1,5]</code>, target =&nbsp;<code>8</code>,
<strong>输出:</strong>
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> candidates =&nbsp;[2,5,2,1,2], target =&nbsp;5,
<strong>输出:</strong>
[
[1,2,2],
[5]
]</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;candidates.length &lt;= 100</code></li>
	<li><code>1 &lt;=&nbsp;candidates[i] &lt;= 50</code></li>
	<li><code>1 &lt;= target &lt;= 30</code></li>
</ul>

## 解法

**方法一：排序 + 剪枝 + 回溯（两种写法）**

我们可以先对数组进行排序，方便剪枝以及跳过重复的数字。

接下来，我们设计一个函数 $dfs(i, s)$，表示从下标 $i$ 开始搜索，且剩余目标值为 $s$，其中 $i$ 和 $s$ 都是非负整数，当前搜索路径为 $t$，答案为 $ans$。

在函数 $dfs(i, s)$ 中，我们先判断 $s$ 是否为 $0$，如果是，则将当前搜索路径 $t$ 加入答案 $ans$ 中，然后返回。如果 $i \geq n$，或者 $s \lt candidates[i]$，说明当前路径不合法，直接返回。否则，我们从下标 $i$ 开始搜索，搜索的下标范围是 $j \in [i, n)$，其中 $n$ 为数组 $candidates$ 的长度。在搜索的过程中，如果 $j \gt i$ 并且 $candidates[j] = candidates[j - 1]$，说明当前数字与上一个数字相同，我们可以跳过当前数字，因为上一个数字已经搜索过了。否则，我们将当前数字加入搜索路径 $t$ 中，然后递归调用函数 $dfs(j + 1, s - candidates[j])$，然后将当前数字从搜索路径 $t$ 中移除。

我们也可以将函数 $dfs(i, s)$ 的实现逻辑改为另一种写法。如果我们选择当前数字，那么我们将当前数字加入搜索路径 $t$ 中，然后递归调用函数 $dfs(i + 1, s - candidates[i])$，然后将当前数字从搜索路径 $t$ 中移除。如果我们不选择当前数字，那么我们可以跳过与当前数字相同的所有数字，然后递归调用函数 $dfs(j, s)$，其中 $j$ 为第一个与当前数字不同的数字的下标。

在主函数中，我们只要调用函数 $dfs(0, target)$，即可得到答案。

时间复杂度 $O(2^n \times n)$，空间复杂度 $O(n)$。其中 $n$ 为数组 $candidates$ 的长度。由于剪枝，实际的时间复杂度要远小于 $O(2^n \times n)$。

相似题目：

-   [39. 组合总和](/solution/0001-0100/0039.Combination%20Sum/README.md)
-   [77. 组合]
-   [216. 组合总和 III]

