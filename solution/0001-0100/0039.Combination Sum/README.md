# [39. 组合总和](https://leetcode.cn/problems/combination-sum)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <strong>无重复元素</strong> 的整数数组&nbsp;<code>candidates</code> 和一个目标整数&nbsp;<code>target</code>&nbsp;，找出&nbsp;<code>candidates</code>&nbsp;中可以使数字和为目标数&nbsp;<code>target</code> 的 所有<em>&nbsp;</em><strong>不同组合</strong> ，并以列表形式返回。你可以按 <strong>任意顺序</strong> 返回这些组合。</p>

<p><code>candidates</code> 中的 <strong>同一个</strong> 数字可以 <strong>无限制重复被选取</strong> 。如果至少一个数字的被选数量不同，则两种组合是不同的。&nbsp;</p>

<p>对于给定的输入，保证和为&nbsp;<code>target</code> 的不同组合数少于 <code>150</code> 个。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>candidates = <code>[2,3,6,7], </code>target = <code>7</code>
<strong>输出：</strong>[[2,2,3],[7]]
<strong>解释：</strong>
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入: </strong>candidates = [2,3,5]<code>, </code>target = 8
<strong>输出: </strong>[[2,2,2,2],[2,3,3],[3,5]]</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入: </strong>candidates = <code>[2], </code>target = 1
<strong>输出: </strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= candidates.length &lt;= 30</code></li>
	<li><code>2 &lt;= candidates[i] &lt;= 40</code></li>
	<li><code>candidates</code> 的所有元素 <strong>互不相同</strong></li>
	<li><code>1 &lt;= target &lt;= 40</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：排序 + 剪枝 + 回溯（两种写法）**

我们可以先对数组进行排序，方便剪枝。

**接下来，我们设计一个函数 dfs(index, target)，表示从下标 i 开始搜索，且剩余目标值为 target，其中 i 和 s 都是非负整数，当前搜索路径为
path，答案为 ans。

写法1：在函数 dfs(index, target) 中，我们先判断 target 是否为 0，如果是，则将当前搜索路径 path 加入答案 ans 中，然后返回。如果
target < candidates[i]， 说明当前下标及后面的下标的元素都大于剩余目标值 target，路径不合法，直接返回。否则，我们从下标 i
开始搜索，搜索的下标范围是 j in [i, n)， 其中 n 为数组 candidates 的长度。在搜索的过程中，我们将当前下标的元素加入搜索路径
path，递归调用函数 dfs(j, target - candidates[j])，递归结束后，将当前下标的元素从搜索路径 path 中移除。

写法2：我们也可以将函数 dfs(index, target) 的实现逻辑改为另一种写法。在函数 dfs(index, target) 中，我们先判断 target 是否为
0， 如果是，则将当前搜索路径 path 加入答案 ans 中，然后返回。如果 i >= n 或者 target < candidates[i]，路径不合法，直接返回。
否则，我们考虑两种情况，一种是不选当前下标的元素，即递归调用函数 dfs(i + 1, target)，另一种是选当前下标的元素，即递归调用函数
dfs(i, target - candidates[i])。

在主函数中，我们只要调用函数 dfs(0, target)，即可得到答案。

时间复杂度 $O(2^n \times n)$，空间复杂度 $O(n)$。其中 $n$ 为数组 $candidates$ 的长度。由于剪枝，实际的时间复杂度要远小于 $O(
2^n \times n)$。**

相似题目：

- [40. 组合总和 II]
- [77. 组合]
- [216. 组合总和 III]

