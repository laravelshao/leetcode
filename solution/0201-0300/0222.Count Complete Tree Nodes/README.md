# [222. 完全二叉树的节点个数](https://leetcode.cn/problems/count-complete-tree-nodes)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一棵<strong> 完全二叉树</strong> 的根节点 <code>root</code> ，求出该树的节点个数。</p>

<p><a href="https://baike.baidu.com/item/%E5%AE%8C%E5%85%A8%E4%BA%8C%E5%8F%89%E6%A0%91/7773232?fr=aladdin">完全二叉树</a> 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 <code>h</code> 层，则该层包含 <code>1~ 2<sup>h</sup></code> 个节点。</p>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/14/complete.jpg" style="width: 372px; height: 302px;" />
<pre>
<strong>输入：</strong>root = [1,2,3,4,5,6]
<strong>输出：</strong>6
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>0
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>1
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点的数目范围是<code>[0, 5 * 10<sup>4</sup>]</code></li>
	<li><code>0 <= Node.val <= 5 * 10<sup>4</sup></code></li>
	<li>题目数据保证输入的树是 <strong>完全二叉树</strong></li>
</ul>

<p> </p>

<p><strong>进阶：</strong>遍历树来统计节点是一种时间复杂度为 <code>O(n)</code> 的简单解决方案。你可以设计一个更快的算法吗？</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：递归**

递归遍历整棵树，统计结点个数。

时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 为树的结点个数。

**方法二：二分查找**

对于此题，我们还可以利用完全二叉树的特点，设计一个更快的算法。

完全二叉树的特点：叶子结点只能出现在最下层和次下层，且最下层的叶子结点集中在树的左部。需要注意的是，满二叉树肯定是完全二叉树，而完全二叉树不一定是满二叉树。

若满二叉树的层数为 $h$，则总结点数为 $2^h - 1$。

我们可以先对 $root$ 的左右子树进行高度统计，分别记为 $left$ 和 $right$。

1.  若 $left = right$，说明左子树是一颗满二叉树，那么左子树的结点总数为 $2^{left} - 1$，加上 $root$ 结点，就是 $2^{left}$，然后递归统计右子树即可。
1.  若 $left \gt right$，说明右子树是一个满二叉树，那么右子树的结点总数为 $2^{right} - 1$，加上 $root$ 结点，就是 $2^{right}$，然后递归统计左子树即可。

时间复杂度 $O(\log^2 n)$。

