# [118. 杨辉三角](https://leetcode.cn/problems/pascals-triangle)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个非负整数 <em><code>numRows</code>，</em>生成「杨辉三角」的前 <em><code>numRows</code> </em>行。</p>

<p><small>在「杨辉三角」中，每个数是它左上方和右上方的数的和。</small></p>

<p><img alt="" src="https://pic.leetcode-cn.com/1626927345-DZmfxB-PascalTriangleAnimated2.gif" /></p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> numRows = 5
<strong>输出:</strong> [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> numRows = 1
<strong>输出:</strong> [[1]]
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 <= numRows <= 30</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->


### 方法一：模拟

我们先创建一个答案数组 result，然后将 result 的第一行元素设为 [1]。
接下来，我们从第二行开始，每一行的开头和结尾元素都是 1，其它 result[i][j] = result[i - 1][j - 1] + result[i - 1][j]。

时间复杂度 O(n^2)，空间复杂度 O(n^2)。其中 n 是行数。
