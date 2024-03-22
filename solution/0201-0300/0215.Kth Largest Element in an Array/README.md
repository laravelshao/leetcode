# [215. 数组中的第 K 个最大元素](https://leetcode.cn/problems/kth-largest-element-in-an-array)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定整数数组 <code>nums</code> 和整数 <code>k</code>，请返回数组中第 <code><strong>k</strong></code> 个最大的元素。</p>

<p>请注意，你需要找的是数组排序后的第 <code>k</code> 个最大的元素，而不是第 <code>k</code> 个不同的元素。</p>

<p>你必须设计并实现时间复杂度为 <code>O(n)</code> 的算法解决此问题。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> <code>[3,2,1,5,6,4],</code> k = 2
<strong>输出:</strong> 5
</pre>

<p><strong>示例&nbsp;2:</strong></p>

<pre>
<strong>输入:</strong> <code>[3,2,3,1,2,4,5,5,6], </code>k = 4
<strong>输出:</strong> 4</pre>

<p>&nbsp;</p>

<p><strong>提示： </strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup>&nbsp;&lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->


**方法一：快速选择**

随机选择一个基准值，使用「三路划分」策略，即每轮将数组划分为三个部分：小于、等于和大于基准数的所有元素。

这样当发现第 k 大数字处在“等于基准数”的子数组中时，便可以直接返回该元素。

时间复杂度 $O(n)$，其中 $n$ 表示数组 $nums$ 的长度。

