# [61. 旋转链表](https://leetcode.cn/problems/rotate-list)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个链表的头节点 <code>head</code> ，旋转链表，将链表每个节点向右移动&nbsp;<code>k</code><em>&nbsp;</em>个位置。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/rotate1.jpg" style="width: 450px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4,5], k = 2
<strong>输出：</strong>[4,5,1,2,3]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/roate2.jpg" style="width: 305px; height: 350px;" />
<pre>
<strong>输入：</strong>head = [0,1,2], k = 4
<strong>输出：</strong>[2,0,1]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表中节点的数目在范围 <code>[0, 500]</code> 内</li>
	<li><code>-100 &lt;= Node.val &lt;= 100</code></li>
	<li><code>0 &lt;= k &lt;= 2 * 10<sup>9</sup></code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：快慢指针 + 链表拼接**

我们先判断链表节点数是否小于 $2$，如果是，直接返回 $head$ 即可。

否则，我们先统计链表节点数 $n$，然后将 $k$ 对 $n$ 取模，得到 $k$ 的有效值。

如果 $k$ 的有效值为 $0$，说明链表不需要旋转，直接返回 $head$ 即可。

否则，我们用快慢指针，让快指针先走 $k$ 步，然后快慢指针同时走，直到快指针走到链表尾部，此时慢指针的下一个节点就是新的链表头节点。

最后，我们将链表拼接起来即可。

时间复杂度 $O(n)$，其中 $n$ 是链表节点数，空间复杂度 $O(1)$。

