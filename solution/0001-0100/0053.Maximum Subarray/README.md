# [53. 最大子数组和](https://leetcode.cn/problems/maximum-subarray)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。</p>

<p><strong>子数组 </strong>是数组中的一个连续部分。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>输出：</strong>6
<strong>解释：</strong>连续子数组&nbsp;[4,-1,2,1] 的和最大，为&nbsp;6 。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1]
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [5,4,-1,7,8]
<strong>输出：</strong>23
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>如果你已经实现复杂度为 <code>O(n)</code> 的解法，尝试使用更为精妙的 <strong>分治法</strong> 求解。</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：动态规划**

我们定义 $f[i]$ 表示以元素 $nums[i]$ 为结尾的连续子数组的最大和，初始时 $f[0] = nums[0]$，那么最终我们要求的答案即为 $\max_{0 \leq i < n} f[i]$。

考虑 $f[i]$，其中 $i \geq 1$，它的状态转移方程为：

$$
f[i] = \max \{ f[i - 1] + nums[i], nums[i] \}
$$

也即：

$$
f[i] = \max \{ f[i - 1], 0 \} + nums[i]
$$

由于 $f[i]$ 只与 $f[i - 1]$ 有关系，因此我们可以只用一个变量 $f$ 来维护对于当前 $f[i]$ 的值是多少，然后进行状态转移即可。答案为 $\max_{0 \leq i < n} f$。

时间复杂度 $O(n)$，其中 $n$ 为数组 $nums$ 的长度。我们只需要遍历一遍数组即可求得答案。空间复杂度 $O(1)$，我们只需要常数空间存放若干变量。

