# [283. 移动零](https://leetcode.cn/problems/move-zeroes)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个数组 <code>nums</code>，编写一个函数将所有 <code>0</code> 移动到数组的末尾，同时保持非零元素的相对顺序。</p>

<p><strong>请注意</strong>&nbsp;，必须在不复制数组的情况下原地对数组进行操作。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> nums = <code>[0,1,0,3,12]</code>
<strong>输出:</strong> <code>[1,3,12,0,0]</code>
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> nums = <code>[0]</code>
<strong>输出:</strong> <code>[0]</code></pre>

<p>&nbsp;</p>

<p><strong>提示</strong>:</p>
<meta charset="UTF-8" />

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup>&nbsp;&lt;= nums[i] &lt;= 2<sup>31</sup>&nbsp;- 1</code></li>
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b>你能尽量减少完成的操作次数吗？</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->


### 方法一：双指针

我们使用两个指针 `left` 和 `right`，初始状态都指向 `0`。然后我们遍历数组，如果遇到 `nums[right] != 0`，就将其与 `left` 指针指向的元素交换，然后将 `left` 后移一位，这样 `left` 前面就都是非零元素了。

时间复杂度 `O(n)`，其中 `n` 是数组 `nums` 的长度。空间复杂度 `O(1)`。

### 方法二：非零往前移，剩余填充0

定义非零元素下标 `index`，遍历数组，如果数组元素不为0，则` nums[index++] = nums[i]`，遍历结束后，当 index < 数组长度，则后面全部填充0。


