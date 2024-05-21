# [124. 二叉树中的最大路径和](https://leetcode.cn/problems/binary-tree-maximum-path-sum)


## 题目描述

<!-- 这里写题目描述 -->

<p>二叉树中的<strong> 路径</strong> 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 <strong>至多出现一次</strong> 。该路径<strong> 至少包含一个 </strong>节点，且不一定经过根节点。</p>

<p><strong>路径和</strong> 是路径中各节点值的总和。</p>

<p>给你一个二叉树的根节点 <code>root</code> ，返回其 <strong>最大路径和</strong> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg" style="width: 322px; height: 182px;" />
<pre>
<strong>输入：</strong>root = [1,2,3]
<strong>输出：</strong>6
<strong>解释：</strong>最优路径是 2 -&gt; 1 -&gt; 3 ，路径和为 2 + 1 + 3 = 6</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/13/exx2.jpg" />
<pre>
<strong>输入：</strong>root = [-10,9,20,null,null,15,7]
<strong>输出：</strong>42
<strong>解释：</strong>最优路径是 15 -&gt; 20 -&gt; 7 ，路径和为 15 + 20 + 7 = 42
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>树中节点数目范围是 <code>[1, 3 * 10<sup>4</sup>]</code></li>
	<li><code>-1000 &lt;= Node.val &lt;= 1000</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：递归**

我们思考二叉树递归问题的经典套路：

1. 终止条件（何时终止递归）
2. 递归处理左右子树
3. 合并左右子树的计算结果

对于本题，我们设计一个函数 `dfs(root)`，它返回以 `root` 为根节点的二叉树的最大路径和。

函数 `dfs(root)` 的执行逻辑如下：

如果 `root` 不存在，那么 `dfs(root)` 返回 `0`；

否则，我们递归计算 `root` 的左子树和右子树的最大路径和，分别记为 `left` 和 `right`。如果 `left` 小于 `0`，那么我们将其置为 `0`，同理，如果 `right` 小于 `0`，那么我们将其置为 `0`。

然后，我们用 `root.val + left + right` 更新答案。最后，函数返回 `root.val + max(left, right)`。

在主函数中，我们调用 `dfs(root)`，即可得到每个节点的最大路径和，其中的最大值即为答案。

时间复杂度 `O(n)`，空间复杂度 `O(n)`。其中 `n` 是二叉树的节点数。

