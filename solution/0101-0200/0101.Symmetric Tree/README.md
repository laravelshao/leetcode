# [101. 对称二叉树](https://leetcode.cn/problems/symmetric-tree)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个二叉树的根节点 <code>root</code> ， 检查它是否轴对称。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/symtree1.jpg" style="width: 354px; height: 291px;" />
<pre>
<strong>输入：</strong>root = [1,2,2,3,4,4,3]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/symtree2.jpg" style="width: 308px; height: 258px;" />
<pre>
<strong>输入：</strong>root = [1,2,2,null,3,null,3]
<strong>输出：</strong>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目在范围 <code>[1, 1000]</code> 内</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>你可以运用递归和迭代两种方法解决这个问题吗？</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：递归**

我们设计一个函数 `recur(left, right)`，用于判断两个二叉树是否对称。答案即为 `recur(left, right)`。

函数 `recur(left, right)` 的逻辑如下：

-   如果 `left` 和 `right` 都为空，则两个二叉树对称，返回 `true`；
-   如果 `left` 和 `right` 中只有一个为空，或者 `left.val != right.val`，则两个二叉树不对称，返回 `false`；
-   否则，判断 `left` 的左子树和 `right` 的右子树是否对称，以及 `left` 的右子树和 `right` 的左子树是否对称，这里使用了递归。

时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 是二叉树的节点数。

