# [24. 两两交换链表中的节点](https://leetcode.cn/problems/swap-nodes-in-pairs)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4]
<strong>输出：</strong>[2,1,4,3]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>head = []
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>head = [1]
<strong>输出：</strong>[1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点的数目在范围 <code>[0, 100]</code> 内</li>
	<li><code>0 &lt;= Node.val &lt;= 100</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：递归**

我们可以通过递归的方式实现两两交换链表中的节点。

递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换，直接返回该节点。

否则，我们递归交换链表 $head.next.next$，记交换后的头节点为 $t$，然后我们记 $head$ 的下一个节点为 $p$，然后令 $p$ 指向 $head$，而 $head$ 指向 $t$，最后返回 $p$。

时间复杂度 $O(n)$，空间复杂度 $O(n)$，其中 $n$ 是链表的长度。

**方法二：迭代**

我们设置一个虚拟头节点 $dummy$，初始时指向 $head$，然后设置两个指针 $pre$ 和 $cur$，初始时 $pre$ 指向 $dummy$，而 $cur$ 指向 $head$。

接下来，我们遍历链表，每次需要交换 $pre$ 后面的两个节点，因此我们先判断 $cur$ 和 $cur.next$ 是否为空，若不为空，则进行交换，否则终止循环。

时间复杂度 $O(n)$，空间复杂度 $O(1)$，其中 $n$ 是链表的长度。
