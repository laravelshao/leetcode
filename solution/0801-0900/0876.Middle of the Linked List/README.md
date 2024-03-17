# [876. 链表的中间结点](https://leetcode.cn/problems/middle-of-the-linked-list)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你单链表的头结点 <code>head</code> ，请你找出并返回链表的中间结点。</p>

<p>如果有两个中间结点，则返回第二个中间结点。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist1.jpg" style="width: 544px; height: 65px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4,5]
<strong>输出：</strong>[3,4,5]
<strong>解释：</strong>链表只有一个中间结点，值为 3 。
</pre>

<p><strong class="example">示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/07/23/lc-midlist2.jpg" style="width: 664px; height: 65px;" />
<pre>
<strong>输入：</strong>head = [1,2,3,4,5,6]
<strong>输出：</strong>[4,5,6]
<strong>解释：</strong>该链表有两个中间结点，值分别为 3 和 4 ，返回第二个结点。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li>链表的结点数范围是 <code>[1, 100]</code></li>
	<li><code>1 &lt;= Node.val &lt;= 100</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：快慢指针**

定义快慢指针 `fast` 和 `slow`，初始时均指向链表的头结点。

快指针 `fast` 每次走两步，慢指针 `slow` 每次走一步。当快指针走到链表的尾部时，慢指针所指的结点即为中间结点。

时间复杂度 $O(n)$，空间复杂度 $O(1)$。其中 $n$ 是链表的长度。

