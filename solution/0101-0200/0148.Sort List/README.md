# [148. 排序链表](https://leetcode.cn/problems/sort-list)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你链表的头结点&nbsp;<code>head</code>&nbsp;，请将其按 <strong>升序</strong> 排列并返回 <strong>排序后的链表</strong> 。</p>

<ul>
</ul>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_1.jpg" style="width: 450px;" />
<pre>
<b>输入：</b>head = [4,2,1,3]
<b>输出：</b>[1,2,3,4]
</pre>

<p><strong>示例 2：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/14/sort_list_2.jpg" style="width: 550px;" />
<pre>
<b>输入：</b>head = [-1,5,3,4,0]
<b>输出：</b>[-1,0,3,4,5]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<b>输入：</b>head = []
<b>输出：</b>[]
</pre>

<p>&nbsp;</p>

<p><b>提示：</b></p>

<ul>
	<li>链表中节点的数目在范围&nbsp;<code>[0, 5 * 10<sup>4</sup>]</code>&nbsp;内</li>
	<li><code>-10<sup>5</sup>&nbsp;&lt;= Node.val &lt;= 10<sup>5</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><b>进阶：</b>你可以在&nbsp;<code>O(n&nbsp;log&nbsp;n)</code> 时间复杂度和常数级空间复杂度下，对链表进行排序吗？</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

### 方法一：双指针+归并排序

先用快慢指针找到链表中点，然后分成左右两个链表，递归排序左右链表。最后合并两个排序的链表即可。


注意事项：快慢双指针定位链表中间元素时，如果 `slow = head, fast = head`，循环判断条件为 `fast != null && fast.next != null)` ，2个节点情况下会导致死循环。

死循环解决方法：

方法一：快慢指针都指向头节点，`slow = head, fast = head`，循环判断条件需要修改为 `fast.next != null && fast.next.next != null`。

方法二：快指针指向头结点下一节点，`slow = head, fast = head.next`，循环判断条件则可以使用 循环判断条件为 `fast != null && fast.next != null)`。