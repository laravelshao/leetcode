# [240. 搜索二维矩阵 II](https://leetcode.cn/problems/search-a-2d-matrix-ii)


## 题目描述

<!-- 这里写题目描述 -->

<p>编写一个高效的算法来搜索&nbsp;<code><em>m</em>&nbsp;x&nbsp;<em>n</em></code>&nbsp;矩阵 <code>matrix</code> 中的一个目标值 <code>target</code> 。该矩阵具有以下特性：</p>

<ul>
	<li>每行的元素从左到右升序排列。</li>
	<li>每列的元素从上到下升序排列。</li>
</ul>

<p>&nbsp;</p>

<p><b>示例 1：</b></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/24/searchgrid2.jpg" />
<pre>
<b>输入：</b>matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
<b>输出：</b>true
</pre>

<p><b>示例 2：</b></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/24/searchgrid.jpg" />
<pre>
<b>输入：</b>matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
<b>输出：</b>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= n, m &lt;= 300</code></li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= matrix[i][j] &lt;= 10<sup>9</sup></code></li>
	<li>每行的所有元素从左到右升序排列</li>
	<li>每列的所有元素从上到下升序排列</li>
	<li><code>-10<sup>9</sup>&nbsp;&lt;= target &lt;= 10<sup>9</sup></code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：二分查找**

由于每一行的所有元素升序排列，因此，对于每一行，我们可以使用二分查找找到第一个大于等于 `target` 的元素，然后判断该元素是否等于 `target`。如果等于 `target`，说明找到了目标值，直接返回 `true`。如果不等于 `target`，说明这一行的所有元素都小于 `target`，应该继续搜索下一行。

如果所有行都搜索完了，都没有找到目标值，说明目标值不存在，返回 `false`。

时间复杂度 $O(m \times \log n)$，空间复杂度 $O(1)$。其中 $m$ 和 $n$ 分别为矩阵的行数和列数。

**方法二：从左下角或右上角搜索**

这里我们以左下角作为起始搜索点，往右上方向开始搜索，比较当前元素 `matrix[i][j]`与 `target` 的大小关系：

-   若 `matrix[i][j] == target`，说明找到了目标值，直接返回 `true`。
-   若 `matrix[i][j] > target`，说明这一行从当前位置开始往右的所有元素均大于 `target`，应该让 $i$ 指针往上移动，即 $i \leftarrow i - 1$。
-   若 `matrix[i][j] < target`，说明这一列从当前位置开始往上的所有元素均小于 `target`，应该让 $j$ 指针往右移动，即 $j \leftarrow j + 1$。

若搜索结束依然找不到 `target`，返回 `false`。

时间复杂度 $O(m + n)$，空间复杂度 $O(1)$。其中 $m$ 和 $n$ 分别为矩阵的行数和列数。

