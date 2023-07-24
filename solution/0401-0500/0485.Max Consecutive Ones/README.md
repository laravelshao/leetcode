# [485. 最大连续 1 的个数](https://leetcode.cn/problems/max-consecutive-ones)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个二进制数组 <code>nums</code> ， 计算其中最大连续 <code>1</code> 的个数。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,1,0,1,1,1]
<strong>输出：</strong>3
<strong>解释：</strong>开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<b>输入：</b>nums = [1,0,1,1,0,1]
<b>输出：</b>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>nums[i]</code>&nbsp;不是&nbsp;<code>0</code>&nbsp;就是&nbsp;<code>1</code>.</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->



### 方法一：一次遍历

遍历数组，记录当前连续 1 的个数 tmpCount，以及最大连续 1 的个数 maxCount。如果当前元素为 1，则 tmpCount++，
否则更新 maxCount，并且 tmpCount=0。最后返回 max(maxCount, tmpCount) 即可。

时间复杂度 O(n)，空间复杂度 O(1)。其中 n 为数组 `nums` 的长度。

