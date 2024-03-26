# [169. 多数元素](https://leetcode.cn/problems/majority-element)

## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个大小为 <code>n</code><em> </em>的数组&nbsp;<code>nums</code> ，返回其中的多数元素。多数元素是指在数组中出现次数 <strong>大于</strong>&nbsp;<code>⌊ n/2 ⌋</code>&nbsp;的元素。</p>

<p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入：</strong>nums = [3,2,3]
<strong>输出：</strong>3</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,2,1,1,1,2,2]
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>
<strong>提示：</strong>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：摩尔投票法**

摩尔投票法的基本步骤如下：

初始化众数为 `x = 0`，初始投票和为 `votes = 0`，遍历数组如果是众数则加 `1`，非众数减 `1`。当投票和为0时，重新设置众数为当前元素。

一般而言，摩尔投票法需要对输入的列表进行**两次遍历**。在第一次遍历中，我们生成候选值 `x`，如果存在多数，那么该候选值就是多数值。

在第二次遍历中，只需要简单地计算候选值的频率，以确认是否是多数值。由于本题已经明确说明存在多数值，所以第一次遍历结束后，直接返回 `x` 即可，无需二次遍历确认是否是多数值。

时间复杂度 $O(n)$，其中 $n$ 是数组 $nums$ 的长度。空间复杂度 $O(1)$。

