# [3. 无重复字符的最长子串](https://leetcode.cn/problems/longest-substring-without-repeating-characters)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个字符串 <code>s</code> ，请你找出其中不含有重复字符的&nbsp;<strong>最长子串&nbsp;</strong>的长度。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = "abcabcbb"
<strong>输出: </strong>3 
<strong>解释:</strong> 因为无重复字符的最长子串是 <code>"abc"</code>，所以其长度为 3。
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "bbbbb"
<strong>输出: </strong>1
<strong>解释: </strong>因为无重复字符的最长子串是 <code>"b"</code>，所以其长度为 1。
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入: </strong>s = "pwwkew"
<strong>输出: </strong>3
<strong>解释: </strong>因为无重复字符的最长子串是&nbsp;<code>"wke"</code>，所以其长度为 3。
&nbsp;    请注意，你的答案必须是 <strong>子串 </strong>的长度，<code>"pwke"</code>&nbsp;是一个<em>子序列，</em>不是子串。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code>&nbsp;由英文字母、数字、符号和空格组成</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：双指针 + 哈希表**

定义一个哈希表记录字符的最后一次出现的索引，记 i 和 j 分别表示不重复子串的开始位置和结束位置，无重复字符子串的最大长度记为 `res`。

遍历字符串 `s` 的每个字符 c，如果哈希表中已存在则更新左指针索引 `i` 的值为 `max(i, map[c])`，更新哈希表中当前字符的索引为 `j`，更新 `res = max(res, j - i)`。

最后返回 `res` 即可。

时间复杂度 $O(n)$，其中 $n$ 表示字符串 `s` 的长度。
