# [67. 二进制求和](https://leetcode.cn/problems/add-binary)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个二进制字符串 <code>a</code> 和 <code>b</code> ，以二进制字符串的形式返回它们的和。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1：</strong></p>

<pre>
<strong>输入:</strong>a = "11", b = "1"
<strong>输出：</strong>"100"</pre>

<p><strong>示例&nbsp;2：</strong></p>

<pre>
<strong>输入：</strong>a = "1010", b = "1011"
<strong>输出：</strong>"10101"</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= a.length, b.length &lt;= 10<sup>4</sup></code></li>
	<li><code>a</code> 和 <code>b</code> 仅由字符 <code>'0'</code> 或 <code>'1'</code> 组成</li>
	<li>字符串如果不是 <code>"0"</code> ，就不含前导零</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：模拟**

我们用一个变量 $carry$ 记录当前的进位，用两个指针 $i$ 和 $j$ 分别指向 $a$ 和 $b$ 的末尾，从末尾到开头逐位相加即可。

时间复杂度 $O(\max(m, n))$，其中 $m$ 和 $n$ 分别为字符串 $a$ 和 $b$ 的长度。空间复杂度 $O(1)$。

