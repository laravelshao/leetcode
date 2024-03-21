# [103. 二叉树的锯齿形层序遍历](https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你二叉树的根节点 <code>root</code> ，返回其节点值的 <strong>锯齿形层序遍历</strong> 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg" style="width: 277px; height: 302px;" />
<pre>
<strong>输入：</strong>root = [3,9,20,null,null,15,7]
<strong>输出：</strong>[[3],[20,9],[15,7]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>root = [1]
<strong>输出：</strong>[[1]]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>[]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目在范围 <code>[0, 2000]</code> 内</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：BFS**

锯齿形层序遍历的原理是利用一个辅助的双端队列，根节点先入队。

然后遍历队列中所有节点出队，将它们存放到一个临时双端列表中，需要根据奇数行还是偶数行来决定方向。

`res.size` 之前添加的行列表数，当前行为 `res.size + 1`，通过 `(res.size + 1) % 2` 来判断：

- 如果是奇数行，从左到右，添加到行列表的尾部
- 如果是偶数行，从右到左，添加到行列表的头部

之后将其左右子节点入队，用于后续层级遍历。 将临时数组存储到答案数组中。

最后返回答案数组即可。


时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 为二叉树的节点数。

