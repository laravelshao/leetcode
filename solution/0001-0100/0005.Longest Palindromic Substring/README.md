# [5. 最长回文子串](https://leetcode.cn/problems/longest-palindromic-substring)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code>，找到 <code>s</code> 中最长的回文子串。</p>

<p>如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "babad"
<strong>输出：</strong>"bab"
<strong>解释：</strong>"aba" 同样是符合题意的答案。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "cbbd"
<strong>输出：</strong>"bb"
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>s</code> 仅由数字和英文字母组成</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

### 方法一：枚举回文中间点

我们可以枚举回文中间点，向两边扩散，找到最长的回文串。

时间复杂度 $O(n^2)$，空间复杂度 $O(1)$。其中 $n$ 是字符串 $s$ 的长度。



