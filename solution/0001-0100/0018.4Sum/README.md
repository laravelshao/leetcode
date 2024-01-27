# [18. 四数之和](https://leetcode.cn/problems/4sum)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个由 <code>n</code> 个整数组成的数组&nbsp;<code>nums</code> ，和一个目标值 <code>target</code> 。请你找出并返回满足下述全部条件且<strong>不重复</strong>的四元组&nbsp;<code>[nums[a], nums[b], nums[c], nums[d]]</code>&nbsp;（若两个四元组元素一一对应，则认为两个四元组重复）：</p>

<ul>
	<li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li>
	<li><code>a</code>、<code>b</code>、<code>c</code> 和 <code>d</code> <strong>互不相同</strong></li>
	<li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li>
</ul>

<p>你可以按 <strong>任意顺序</strong> 返回答案 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,0,-1,0,-2,2], target = 0
<strong>输出：</strong>[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [2,2,2,2,2], target = 8
<strong>输出：</strong>[[2,2,2,2]]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：排序 + 双指针**

我们注意到，题目中要求找到不重复的四元组，那么我们可以先对数组进行排序，这样就可以方便地跳过重复的元素。

接下来，我们枚举四元组的前两个元素 $nums[i]$ 和 $nums[j]$，其中 $i \lt j$，在枚举的过程中，我们跳过重复的 $nums[i]$ 和 $nums[j]$。然后，我们用两个指针 $k$ 和 $l$ 分别指向 $nums[i]$ 和 $nums[j]$ 后面的两端，令 $x = nums[i] + nums[j] + nums[k] + nums[l]$，我们将 $x$ 与 $target$ 比较，进行如下操作：

-   如果 $x \lt target$，则更新 $k = k + 1$ 以得到更大的 $x$；
-   如果 $x \gt target$，则更新 $l = l - 1$ 以得到更小的 $x$；
-   否则，说明找到了一个四元组 $(nums[i], nums[j], nums[k], nums[l])$，将其加入答案，然后我们更新指针 $k$ 和 $l$，并跳过所有重复的元素，防止答案中包含重复的四元组，继续寻找下一个四元组。

时间复杂度为 $O(n^3)$，空间复杂度为 $O(\log n)$，其中 $n$ 是数组的长度。
