# [105. 从前序与中序遍历序列构造二叉树](https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个整数数组&nbsp;<code>preorder</code> 和 <code>inorder</code>&nbsp;，其中&nbsp;<code>preorder</code> 是二叉树的<strong>先序遍历</strong>， <code>inorder</code>&nbsp;是同一棵树的<strong>中序遍历</strong>，请构造二叉树并返回其根节点。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree.jpg" style="height: 302px; width: 277px;" />
<pre>
<strong>输入</strong><strong>:</strong> preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
<strong>输出:</strong> [3,9,20,null,null,15,7]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> preorder = [-1], inorder = [-1]
<strong>输出:</strong> [-1]
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= preorder.length &lt;= 3000</code></li>
	<li><code>inorder.length == preorder.length</code></li>
	<li><code>-3000 &lt;= preorder[i], inorder[i] &lt;= 3000</code></li>
	<li><code>preorder</code>&nbsp;和&nbsp;<code>inorder</code>&nbsp;均 <strong>无重复</strong> 元素</li>
	<li><code>inorder</code>&nbsp;均出现在&nbsp;<code>preorder</code></li>
	<li><code>preorder</code>&nbsp;<strong>保证</strong> 为二叉树的前序遍历序列</li>
	<li><code>inorder</code>&nbsp;<strong>保证</strong> 为二叉树的中序遍历序列</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：递归**

前序序列的第一个结点 `preorder[0]` 为根节点，我们在中序序列中找到根节点的位置 `pivot`，可以将中序序列划分为左子树 $inorder[0..pivot]$ 、右子树 $inorder[pivot+1..]$。

通过左右子树的区间，可以计算出左、右子树节点的个数，假设为 $m$ 和 $n$。然后在前序节点中，从根节点往后的 $m$ 个节点为左子树，再往后的 $n$ 个节点为右子树。

递归求解即可。

> 前序遍历：先遍历根节点，再遍历左右子树；中序遍历：先遍历左子树，再遍历根节点，最后遍历右子树。

时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 为二叉树节点个数。

如果题目中给定的节点值存在重复，那么我们只需要记录每个节点值出现的所有位置，然后递归构建即可。

