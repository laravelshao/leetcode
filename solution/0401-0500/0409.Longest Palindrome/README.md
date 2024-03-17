# [409. 最长回文串](https://leetcode.cn/problems/longest-palindrome)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个包含大写字母和小写字母的字符串<meta charset="UTF-8" />&nbsp;<code>s</code>&nbsp;，返回&nbsp;<em>通过这些字母构造成的 <strong>最长的回文串</strong></em>&nbsp;。</p>

<p>在构造过程中，请注意 <strong>区分大小写</strong> 。比如&nbsp;<code>"Aa"</code>&nbsp;不能当做一个回文字符串。</p>

<p>&nbsp;</p>

<p><strong>示例 1: </strong></p>

<pre>
<strong>输入:</strong>s = "abccccdd"
<strong>输出:</strong>7
<strong>解释:</strong>
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong>s = "a"
<strong>输出:</strong>1
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入:</strong>s = "aaaaaccc"
<strong>输出:</strong>7</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2000</code></li>
	<li><code>s</code>&nbsp;只由小写 <strong>和/或</strong> 大写英文字母组成</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：哈希表计数**

一个合法的回文字符串，最多存在一个出现奇数次数的字符，其余字符出现次数均为偶数。

因此，我们可以先遍历字符串 s，统计每个字符出现的次数，记录在数组或哈希表中。

遍历哈希表，将每个字符的的次数向下取偶数，并计入 res 中，如果存在字符次数是奇数，则最后 res + 1。

最后，我们返回 ans 即可。
