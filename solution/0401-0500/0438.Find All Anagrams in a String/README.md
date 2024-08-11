# [438. 找到字符串中所有字母异位词](https://leetcode.cn/problems/find-all-anagrams-in-a-string)

## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个字符串&nbsp;<code>s</code>&nbsp;和 <code>p</code>，找到&nbsp;<code>s</code><strong>&nbsp;</strong>中所有&nbsp;<code>p</code><strong>&nbsp;</strong>的&nbsp;<strong>异位词&nbsp;</strong>的子串，返回这些子串的起始索引。不考虑答案输出的顺序。</p>

<p><strong>异位词 </strong>指由相同字母重排列形成的字符串（包括相同的字符串）。</p>

<p>&nbsp;</p>

<p><strong>示例&nbsp;1:</strong></p>

<pre>
<strong>输入: </strong>s = "cbaebabacd", p = "abc"
<strong>输出: </strong>[0,6]
<strong>解释:</strong>
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
</pre>

<p><strong>&nbsp;示例 2:</strong></p>

<pre>
<strong>输入: </strong>s = "abab", p = "ab"
<strong>输出: </strong>[0,1,2]
<strong>解释:</strong>
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
</pre>

<p>&nbsp;</p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, p.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>s</code>&nbsp;和&nbsp;<code>p</code>&nbsp;仅包含小写字母</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->


### 方法一：滑动窗口

我们不妨设字符串 `s` 的长度为 `m`，字符串 `p` 的长度为 `n`。

如果 `m < n`，那么 `s` 中不可能存在任何一个子串同 `p` 为异位词，返回空列表即可。

当 `m >= n` 时，我们可以使用一个固定长度为 `n` 的滑动窗口来维护 `s` 的子串。为了判断子串是否为 `p` 的异位词，我们可以用一个固定长度为 `26` 的数组 `pCharCount` 记录 `p` 中

每个字母的出现次数， 再用另一个数组 `windowCharCount` 记录当前滑动窗口中每个字母的出现次数，如果这两个数组相同，那么当前滑动窗口的子串就是 `p` 的异位词，我们记录下起始位置。

时间复杂度 `O(m * C)`，空间复杂度 `O(C)`。其中 `m` 是字符串 `s` 的长度；而 `C` 是字符集大小，在本题中字符集为所有小写字母，所以 `C = 26`。

### 方法二：双指针（滑动窗口优化）

我们可以对方法一进行优化，与方法一类似，我们用一个固定长度为 `26` 的数组 `pCharCount` 记录 `p` 中每个字母的出现次数，用另一个数组 `windowCharCount` 记录当前滑动窗口中每个字母的出现次数，

双指针指向滑动窗口的左右边界。 `i` 指向右边界，`j` 指向左边界，每一次移动指针 `i`，将 `windowCharCount[s[i]]` 的值加 `1`，如果当前 `windowCharCount[s[i]]` 的值大于 `pCharCount[s[i]]`，则将指针 `i` 不断右移，

直到 `windowCharCount[s[i]]` 的值不大于 `pCharCount[s[i]]`。此时，如果滑动窗口的长度等于 `p` 的长度，我们就找到了一个异位词，将起始位置加入答案。继续移动指针 `i`，重复上述操作，直到指针 `i` 移动到 `s` 的末尾。

时间复杂度 `(m + n)`，空间复杂度 `O(C)`。其中 `m` 和 `n` 分别是字符串 `s` 和 `p` 的长度；而 `C` 是字符集大小，在本题中字符集为所有小写字母，所以 `C = 26`。

