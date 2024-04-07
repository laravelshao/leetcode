# [100. 相同的树](https://leetcode.cn/problems/same-tree)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两棵二叉树的根节点 <code>p</code> 和 <code>q</code> ，编写一个函数来检验这两棵树是否相同。</p>

<p>如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex1.jpg" style="width: 622px; height: 182px;" />
<pre>
<strong>输入：</strong>p = [1,2,3], q = [1,2,3]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex2.jpg" style="width: 382px; height: 182px;" />
<pre>
<strong>输入：</strong>p = [1,2], q = [1,null,2]
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/12/20/ex3.jpg" style="width: 622px; height: 182px;" />
<pre>
<strong>输入：</strong>p = [1,2,1], q = [1,1,2]
<strong>输出：</strong>false
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>两棵树上的节点数目都在范围 <code>[0, 100]</code> 内</li>
	<li><code>-10<sup>4</sup> <= Node.val <= 10<sup>4</sup></code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：DFS**

我们可以使用 DFS 递归的方法来解决这个问题。

首先判断两个二叉树的根节点是否相同，如果两个根节点都为空，则两个二叉树相同，如果两个根节点中有且只有一个为空，则两个二叉树一定不同。如果两个根节点都不为空，则判断它们的值是否相同，如果不相同则两个二叉树一定不同，如果相同，则分别判断两个二叉树的左子树是否相同以及右子树是否相同。当以上所有条件都满足时，两个二叉树才相同。

时间复杂度 $O(\min(m, n))$，空间复杂度 $O(\min(m, n))$。其中 $m$ 和 $n$ 分别是两个二叉树的节点个数。空间复杂度主要取决于递归调用的层数，递归调用的层数不会超过较小的二叉树的节点个数。

