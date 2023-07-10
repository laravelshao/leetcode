# [14. 最长公共前缀](https://leetcode.cn/problems/longest-common-prefix)


## 题目描述

<!-- 这里写题目描述 -->

<p>编写一个函数来查找字符串数组中的最长公共前缀。</p>

<p>如果不存在公共前缀，返回空字符串&nbsp;<code>""</code>。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>strs = ["flower","flow","flight"]
<strong>输出：</strong>"fl"
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>strs = ["dog","racecar","car"]
<strong>输出：</strong>""
<strong>解释：</strong>输入不存在公共前缀。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
	<li><code>strs[i]</code> 仅由小写英文字母组成</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

### 方法一：字符比较

1. 首先根据字符串长度对字符串数组进行排序，获取最短的字符串最为起始子串。
2. 遍历该子串，从末尾依次减少一个字符，然后和字符串数组的前缀进行比较，判断前缀相同的个数，如果个数和字符串数组长度一样，则返回该子串前缀，否则继续减少字符。


