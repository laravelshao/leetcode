# [63. 不同路径 II](https://leetcode.cn/problems/unique-paths-ii)


## 题目描述

<!-- 这里写题目描述 -->

<p>一个机器人位于一个<meta charset="UTF-8" />&nbsp;<code>m x n</code>&nbsp;网格的左上角 （起始点在下图中标记为 “Start” ）。</p>

<p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。</p>

<p>现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？</p>

<p>网格中的障碍物和空位置分别用 <code>1</code> 和 <code>0</code> 来表示。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/robot1.jpg" />
<pre>
<strong>输入：</strong>obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
<strong>输出：</strong>2
<strong>解释：</strong>3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 <code>2</code> 条不同的路径：
1. 向右 -&gt; 向右 -&gt; 向下 -&gt; 向下
2. 向下 -&gt; 向下 -&gt; 向右 -&gt; 向右
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/04/robot2.jpg" />
<pre>
<strong>输入：</strong>obstacleGrid = [[0,1],[0,0]]
<strong>输出：</strong>1
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m ==&nbsp;obstacleGrid.length</code></li>
	<li><code>n ==&nbsp;obstacleGrid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>obstacleGrid[i][j]</code> 为 <code>0</code> 或 <code>1</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：动态规划**


状态定义：`dp[i, j]` 为指定索引下标的路径数，只能由左或上移动

转移方程：`dp[i, j] = dp[i, j - 1] + dp[i - 1, j]`

初始状态：第一行第一列，碰到障碍物(1)后停止 `dp[0, j] = 1`，`dp[i, 0] = 1`

构建其它行其它列，如果 `obstacleGrid[i][j] == 0`，则 `dp[i, j] = dp[i, j - 1] + dp[i - 1, j]`；否则碰到障碍物(1)后跳过执行下一循环

最后返回 `dp[m - 1][n - 1]` 即可。

时间复杂度 $O(m \times n)$，空间复杂度 $O(m \times n)$。其中 $m$ 和 $n$ 分别是网格的行数和列数。

