# [152. 乘积最大子数组](https://leetcode.cn/problems/maximum-product-subarray)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code>&nbsp;，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。</p>

<p>测试用例的答案是一个&nbsp;<strong>32-位</strong> 整数。</p>

<p><strong>子数组</strong> 是数组的连续子序列。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = [2,3,-2,4]
<strong>输出:</strong> <code>6</code>
<strong>解释:</strong>&nbsp;子数组 [2,3] 有最大乘积 6。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = [-2,0,-1]
<strong>输出:</strong> 0
<strong>解释:</strong>&nbsp;结果不能为 2, 因为 [-2,-1] 不是子数组。</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li><code>nums</code> 的任何前缀或后缀的乘积都 <strong>保证</strong>&nbsp;是一个 <strong>32-位</strong> 整数</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->


### 方法一：动态规划

我们定义两个变量 `maxF` 和 `minF`，其中 `maxF` 表示以 `nums[i]` 结尾的乘积最大子数组的乘积，而 `minF` 表示以 `nums[i]` 结尾的乘积最小子数组的乘积。初始时 `maxF` 和 `minF` 都等于 `nums[0]`。答案为所有 `maxF` 中的最大值。

从 `i=1` 开始，我们可以考虑将第 `i` 个数 `nums[i]` 添加到前面的乘积最大或者乘积最小的子数组乘积的后面，或者单独作为一个子数组乘积（即此时子数组长度只有 `1`）。

我们将此前的乘积最大值记为 `mx`，乘积最小值记为 `mn`，那么 `maxF = max(nums[i], mx * nums[i], mn * nums[i])`，而 `minF = min(nums[i], mx * nums[i], mn * nums[i])`。

接下来，我们更新答案 `ans = max(ans, maxF)`，然后继续计算下一个位置。

最后的答案即为 `ans`。

时间复杂度 `O(n)`，其中 `n` 是数组 `nums` 的长度。我们只需要遍历数组一次即可求得答案。空间复杂度 `O(1)`。

