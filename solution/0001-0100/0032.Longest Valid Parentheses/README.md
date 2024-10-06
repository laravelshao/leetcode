# [32. 最长有效括号](https://leetcode.cn/problems/longest-valid-parentheses)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个只包含 <code>'('</code> 和 <code>')'</code> 的字符串，找出最长有效（格式正确且连续）括号子串的长度。</p>

<p> </p>

<div class="original__bRMd">
<div>
<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "(()"
<strong>输出：</strong>2
<strong>解释：</strong>最长有效括号子串是 "()"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = ")()())"
<strong>输出：</strong>4
<strong>解释：</strong>最长有效括号子串是 "()()"
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = ""
<strong>输出：</strong>0
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 <= s.length <= 3 * 10<sup>4</sup></code></li>
	<li><code>s[i]</code> 为 <code>'('</code> 或 <code>')'</code></li>
</ul>
</div>
</div>

## 解法


### 方法一：使用栈

-   使用栈来存储左括号的索引，栈底元素初始化为 $-1$，用于辅助计算有效括号的长度。
-   遍历字符串，对于每个字符：
    -   如果是左括号，将当前位置压入栈。
    -   如果是右括号，弹出栈顶元素表示匹配了一个左括号。
        -   如果栈为空，说明当前右括号无法匹配，将当前位置压入栈作为新的起点。
        -   如果栈不为空，计算当前有效括号子串的长度，更新最大长度。
-   最终返回最大长度。

总结：这个算法的关键在于维护一个线，栈内存放的是左括号的索引，通过弹出和压入的操作来更新有效括号子串的长度。

时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 为字符串的长度。




