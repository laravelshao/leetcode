# [78. 子集](https://leetcode.cn/problems/subsets)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> ，数组中的元素 <strong>互不相同</strong> 。返回该数组所有可能的子集（幂集）。</p>

<p>解集 <strong>不能</strong> 包含重复的子集。你可以按 <strong>任意顺序</strong> 返回解集。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3]
<strong>输出：</strong>[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0]
<strong>输出：</strong>[[],[0]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 10</code></li>
	<li><code>-10 <= nums[i] <= 10</code></li>
	<li><code>nums</code> 中的所有元素 <strong>互不相同</strong></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

### 方法一：DFS(回溯)

我们设计一个函数 `dfs(index)`，表示从数组的第 `index` 个下标开始搜索所有子集。函数 `dfs(index)` 的执行逻辑如下：

-   如果 `index=n`，表示当前已经搜索结束，将当前得到的子集 `group` 加入答案数组 `ans` 中，然后返回；
-   否则，我们可以选择不选择当前元素，直接执行 `dfs(index+1)`；也可以选择当前元素，即把当前元素 `nums[i]` 加入子集 `group`，然后执行 `dfs(index+1)`，注意要在执行 `dfs(index+1)` 以后再将 `nums[i]` 从子集 `group` 中移除（回溯）。

在主函数中，我们调用 `dfs(0)`，即从数组的第一个元素开始搜索所有子集。最后返回答案数组 `ans` 即可。

时间复杂度 `O(n * 2^n)`，空间复杂度 `O(n)`。其中 `n` 为数组的长度。一共有 `2^n` 个子集，每个子集需要 `O(n)` 的时间来构造。

