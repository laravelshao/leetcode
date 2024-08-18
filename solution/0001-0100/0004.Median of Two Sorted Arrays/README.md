# [4. 寻找两个正序数组的中位数](https://leetcode.cn/problems/median-of-two-sorted-arrays)

## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个大小分别为 <code>m</code> 和 <code>n</code> 的正序（从小到大）数组&nbsp;<code>nums1</code> 和&nbsp;<code>nums2</code>。请你找出并返回这两个正序数组的 <strong>中位数</strong> 。</p>

<p>算法的时间复杂度应该为 <code>O(log (m+n))</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [1,3], nums2 = [2]
<strong>输出：</strong>2.00000
<strong>解释：</strong>合并数组 = [1,2,3] ，中位数 2
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums1 = [1,2], nums2 = [3,4]
<strong>输出：</strong>2.50000
<strong>解释：</strong>合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
</pre>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>nums1.length == m</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m &lt;= 1000</code></li>
	<li><code>0 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->


### 方法一：二分查找

题目要求算法的时间复杂度为 $O(\log (m + n))$，因此不能直接遍历两个数组，而是需要使用二分查找的方法。

参考题解：https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/15086/he-bing-yi-hou-zhao-gui-bing-guo-cheng-zhong-zhao-/


时间复杂度 $O(\log(min(m, n)))$，我们把更短的数组设置为 nums1，使用二分查找法，在它的长度的对数时间复杂度内完成搜索；空间复杂度 $O(1)$。其中 $m$ 和 $n$ 分别是数组 $nums1$ 和 $nums2$ 的长度。

