# [199. 二叉树的右视图](https://leetcode.cn/problems/binary-tree-right-side-view)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个二叉树的 <strong>根节点</strong> <code>root</code>，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<p><img src="https://assets.leetcode.com/uploads/2021/02/14/tree.jpg" style="width: 270px; " /></p>

<pre>
<strong>输入:</strong> [1,2,3,null,5,null,4]
<strong>输出:</strong> [1,3,4]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> [1,null,3]
<strong>输出:</strong> [1,3]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> []
<strong>输出:</strong> []
</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li>二叉树的节点个数的范围是 <code>[0,100]</code></li>
	<li><meta charset="UTF-8" /><code>-100 <= Node.val <= 100</code> </li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：BFS**

使用 BFS 层序遍历二叉树，每层最后一个节点即为该层的右视图节点。

时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 为二叉树节点个数。

**方法二：DFS**

使用 DFS 深度优先遍历二叉树，每次先遍历右子树，再遍历左子树，这样每层第一个遍历到的节点即为该层的右视图节点。

时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 为二叉树节点个数。
