# [15. 三数之和](https://leetcode.cn/problems/3sum)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个整数数组 <code>nums</code> ，判断是否存在三元组 <code>[nums[i], nums[j], nums[k]]</code> 满足 <code>i != j</code>、<code>i != k</code> 且 <code>j != k</code> ，同时还满足 <code>nums[i] + nums[j] + nums[k] == 0</code> 。请</p>

<p>你返回所有和为 <code>0</code> 且不重复的三元组。</p>

<p><strong>注意：</strong>答案中不可以包含重复的三元组。</p>

<p>&nbsp;</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>nums = [-1,0,1,2,-1,-4]
<strong>输出：</strong>[[-1,-1,2],[-1,0,1]]
<strong>解释：</strong>
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,1,1]
<strong>输出：</strong>[]
<strong>解释：</strong>唯一可能的三元组和不为 0 。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>nums = [0,0,0]
<strong>输出：</strong>[[0,0,0]]
<strong>解释：</strong>唯一可能的三元组和为 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;= 3000</code></li>
	<li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：排序 + 双指针**

我们注意到，题目不要求我们按照顺序返回三元组，因此我们不妨先对数组进行排序，这样就可以方便地跳过重复的元素。

先升序排列，然后每次固定三元组的最小元素为 nums[k]，其中 0 <= k < n - 2。对于每个 k，我们可以通过维护两个指针 i = k + 1 和 j = n - 1，从而找到满足 $nums[k] + nums[i] + nums[j] = 0。在枚举的过程中，我们需要跳过重复的元素，以避免出现重复的三元组。

具体判断逻辑如下：

如果 nums[k] > 0，因为已经升序排列，三数之和肯定不满足，跳出循环。

如果 $k > 0 并且 nums[k] = nums[k - 1]，则说明当前枚举的元素与上一个元素相同，我们可以直接跳过，因为不会产生新的结果。


否则，我们令左指针 i = k + 1，右指针 j = n - 1，当 i < j 时，执行循环，计算三数之和 $sum = nums[k] + nums[i] + nums[j]，并与 0 比较：

-   如果 sum < 0，则说明 nums[i] 太小，我们需要将 i 右移一位。
-   如果 sum > 0，则说明 nums[j] 太大，我们需要将 j 左移一位。
-   否则，说明我们找到了一个合法的三元组，将其加入答案，并将 i 右移一位，将 j 左移一位，同时跳过所有重复的元素，继续寻找下一个合法的三元组。

枚举结束后，我们即可得到三元组的答案。

时间复杂度 $O(n^2)$，空间复杂度 $O(\log n)$。其中 $n$ 为数组的长度。

