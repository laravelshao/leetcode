# [994. 腐烂的橘子](https://leetcode.cn/problems/rotting-oranges)

## 题目描述

<!-- 这里写题目描述 -->

<p>在给定的&nbsp;<code>m x n</code>&nbsp;网格<meta charset="UTF-8" />&nbsp;<code>grid</code>&nbsp;中，每个单元格可以有以下三个值之一：</p>

<ul>
	<li>值&nbsp;<code>0</code>&nbsp;代表空单元格；</li>
	<li>值&nbsp;<code>1</code>&nbsp;代表新鲜橘子；</li>
	<li>值&nbsp;<code>2</code>&nbsp;代表腐烂的橘子。</li>
</ul>

<p>每分钟，腐烂的橘子&nbsp;<strong>周围&nbsp;4 个方向上相邻</strong> 的新鲜橘子都会腐烂。</p>

<p>返回 <em>直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回&nbsp;<code>-1</code></em>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<p><strong><img alt="" src="https://assets.leetcode.com/uploads/2019/02/16/oranges.png" style="height: 137px; width: 650px;" /></strong></p>

<pre>
<strong>输入：</strong>grid = [[2,1,1],[1,1,0],[0,1,1]]
<strong>输出：</strong>4
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>grid = [[2,1,1],[0,1,1],[1,0,1]]
<strong>输出：</strong>-1
<strong>解释：</strong>左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>grid = [[0,2]]
<strong>输出：</strong>0
<strong>解释：</strong>因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>m == grid.length</code></li>
	<li><code>n == grid[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 10</code></li>
	<li><code>grid[i][j]</code> 仅为&nbsp;<code>0</code>、<code>1</code>&nbsp;或&nbsp;<code>2</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->


### 方法一：BFS

首先需要确定的是，网格当中存在多少个新鲜橘子，这关系到什么时候结束。
其次，腐烂橘子的坐标在哪，这些坐标要作为中心点，将腐烂传播给四方的新鲜橘子。

步骤：

1. 扫描网格，统计新鲜橘子的数量，记录腐烂橘子的坐标。
2. 如果新鲜橘子的数量为 0，返回重复 2 - 5 步骤的轮数（也就是分钟）。
3. 如果不存在**有效**的腐烂橘子，而现存的新鲜橘子不为 0，则为不可能，返回 -1。
4. 遍历当前已记录的腐烂橘子，将四方的新鲜橘子污染。如果有新鲜橘子被污染成功，便记录该橘子的坐标，在下一轮使用（不参与本轮行动）。
5. 回到第 2 步。

参考题解：https://leetcode.cn/problems/rotting-oranges/solutions/129831/li-qing-si-lu-wei-shi-yao-yong-bfsyi-ji-ru-he-xie-/