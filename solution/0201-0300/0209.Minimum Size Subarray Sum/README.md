# [209. 长度最小的子数组](https://leetcode.cn/problems/minimum-size-subarray-sum)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个含有 <code>n</code><strong> </strong>个正整数的数组和一个正整数 <code>target</code><strong> 。</strong></p>

<p>找出该数组中满足其和<strong> </strong><code>≥ target</code><strong> </strong>的长度最小的 <strong>连续子数组</strong> <code>[nums<sub>l</sub>, nums<sub>l+1</sub>, ..., nums<sub>r-1</sub>, nums<sub>r</sub>]</code> ，并返回其长度<strong>。</strong>如果不存在符合条件的子数组，返回 <code>0</code> 。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>target = 7, nums = [2,3,1,2,4,3]
<strong>输出：</strong>2
<strong>解释：</strong>子数组 <code>[4,3]</code> 是该条件下的长度最小的子数组。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>target = 4, nums = [1,4,4]
<strong>输出：</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>target = 11, nums = [1,1,1,1,1,1,1,1]
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= target <= 10<sup>9</sup></code></li>
	<li><code>1 <= nums.length <= 10<sup>5</sup></code></li>
	<li><code>1 <= nums[i] <= 10<sup>5</sup></code></li>
</ul>

<p> </p>

<p><strong>进阶：</strong></p>

<ul>
	<li>如果你已经实现<em> </em><code>O(n)</code> 时间复杂度的解法, 请尝试设计一个 <code>O(n log(n))</code> 时间复杂度的解法。</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

### 方法一：滑动窗口(推荐)

定义两个指针 start 和 end 分别表示子数组（滑动窗口窗口）的开始位置和结束位置，维护变量 sum 存储子数组中的元素和（即从 nums[start] 到 nums[end] 的元素和）。

初始状态下，start 和 end 都指向下标 0，sum 的值为 0。

每一轮迭代，将 nums[end] 加到 sum，如果 sum≥s，则更新子数组的最小长度（此时子数组的长度是 end−start+1），然后将 nums[start] 从
sum 中减去并将 start 右移，直到 sum<s，在此过程中同样更新子数组的最小长度。在每一轮迭代的最后，将 end 右移。

时间复杂度：O(n)，其中 n 是数组的长度。指针 start 和 end 最多各移动 n 次。空间复杂度：O(1)。


### 方法二：前缀和 + 二分查找

我们先预处理出数组 nums 的前缀和数组 sums，其中 s[i] 表示数组 nums 前 i 项元素之和。由于数组 nums 中的元素都是正整数，因此数组 sums 也是单调递增的。另外，我们初始化答案 minLength = length + 1，其中 length 为数组 nums 的长度。

接下来，我们遍历前缀和数组 sums，对于其中的每个元素 s[i]，我们可以通过二分查找的方法找到满足 sums[j] >= sums[i] + target 的最小下标 j，如果 j <= length，则说明存在满足条件的子数组，我们可以更新答案，即 minLength = min(minLength, j - i)。

最后，如果 minLength <= length，则说明存在满足条件的子数组，返回 minLength，否则返回 0。

时间复杂度 O(n log n)，空间复杂度 O(n)。其中 n 为数组 nums 的长度。



