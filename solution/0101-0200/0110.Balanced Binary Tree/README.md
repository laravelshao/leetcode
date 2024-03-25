# [110. 平衡二叉树](https://leetcode.cn/problems/balanced-binary-tree)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个二叉树，判断它是否是高度平衡的二叉树。</p>

<p>本题中，一棵高度平衡二叉树定义为：</p>

<blockquote>
<p>一个二叉树<em>每个节点 </em>的左右两个子树的高度差的绝对值不超过 1 。</p>
</blockquote>

<p> </p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/06/balance_1.jpg" style="width: 342px; height: 221px;" />
<pre>
<strong>输入：</strong>root = [3,9,20,null,null,15,7]
<strong>输出：</strong>true
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/06/balance_2.jpg" style="width: 452px; height: 301px;" />
<pre>
<strong>输入：</strong>root = [1,2,2,3,3,null,null,4,4]
<strong>输出：</strong>false
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>root = []
<strong>输出：</strong>true
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中的节点数在范围 <code>[0, 5000]</code> 内</li>
	<li><code>-10<sup>4</sup> <= Node.val <= 10<sup>4</sup></code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：后序遍历 + 剪枝 （从底至顶）**

定义函数 `recur(root)` 计算二叉树的高度，处理逻辑如下：

-   如果二叉树 `root` 为空，返回 `0`。
-   否则，递归计算左右子树的高度，分别为 `left` 和 `right`。如果 `left` 和 `right` 为 `-1`， 或者 `left` 和 `right` 的差的绝对值大于 `1`，则返回 `-1`，否则返回 `max(left, right) + 1`。

那么，如果函数 `recur(root)` 返回的是 `-1`，则说明二叉树 `root` 不是平衡二叉树，否则是平衡二叉树。

时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 是二叉树的节点数。

