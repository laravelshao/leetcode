# [416. 分割等和子集](https://leetcode.cn/problems/partition-equal-subset-sum)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个 <strong>只包含正整数 </strong>的 <strong>非空 </strong>数组 <code>nums</code> 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,5,11,5]
<strong>输出：</strong>true
<strong>解释：</strong>数组可以分割成 [1, 5, 5] 和 [11] 。</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [1,2,3,5]
<strong>输出：</strong>false
<strong>解释：</strong>数组不能分割成两个元素和相等的子集。
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= nums.length <= 200</code></li>
	<li><code>1 <= nums[i] <= 100</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

### 方法一：动态规划

我们先计算出数组的总和 $s$ ，如果总和是奇数，那么一定不能分割成两个和相等的子集，直接返回 $false$。如果总和是偶数，我们记目标子集的和为 $target = s/2$，那么问题就转化成了：是否存在一个子集，使得其元素的和为 $target$。

我们定义 $dp(i, j)$ 表示从数组下标 $[0, i]$ 中选择若干个数的总和是否存在为 $j$。初始时 $f[0][0] = true$。

1. 选择了下标为 $i$ 的数 $nums[i]$，$dp(i, j) = dp(i - 1, j - nums[i])$
2. 未选择下标为 $i$ 的数 $nums[i]$，$dp(i, j) = dp(i - 1, j)$

因此状态转移方程为：$dp(i, j) = dp(i - 1, j) || dp(i - 1, j - nums[i])$

最终答案为 $dp[n][target]$。

因为每一行的 $dp$ 值只与上一行的 $dp$ 值有关，因此我们可以将二维数组压缩成一维数组。

转移方程为：$dp(j) = dp(j) || dp(j - nums[i])$

时间复杂度 $O(n*target)$，空间复杂度 $O(target)$。其中 $n$ 是数组的长度，而 $target$ 是数组的总和的一半。


参考题解：https://leetcode.cn/problems/partition-equal-subset-sum/solutions/2785266/0-1-bei-bao-cong-ji-yi-hua-sou-suo-dao-d-ev76/


