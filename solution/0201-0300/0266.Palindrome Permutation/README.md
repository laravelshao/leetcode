# [266. 回文排列](https://leetcode.cn/problems/palindrome-permutation)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code> ，如果该字符串的某个排列是 <strong>回文</strong> ，则返回 <code>true</code> ；否则，返回<em> </em><code>false</code><em> </em>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "code"
<strong>输出：</strong>false
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "aab"
<strong>输出：</strong>true
</pre>

<p><strong class="example">示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "carerac"
<strong>输出：</strong>true
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 5000</code></li>
	<li><code>s</code> 仅由小写英文字母组成</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->


**方法一：哈希表**

注意事项：字符串的某个排列是否是回文串，不是字符串本身是回文串

回文有2种情况：
- 字符数为偶数位，每个字符都出现偶数次数
- 字符数为奇数位，仅有一个字符是奇数次数

利用哈希表来维护元素出现次数，判断有多少个字符出现的次数是奇数，如果有超过1个字符出现奇数次数，则不是回文串。


时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 是字符串的长度。

