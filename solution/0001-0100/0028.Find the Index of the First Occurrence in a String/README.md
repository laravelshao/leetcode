# [28. 找出字符串中第一个匹配项的下标](https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string)


## 题目描述

<!-- 这里写题目描述 -->

<p>给你两个字符串&nbsp;<code>haystack</code> 和 <code>needle</code> ，请你在 <code>haystack</code> 字符串中找出 <code>needle</code> 字符串的第一个匹配项的下标（下标从 0 开始）。如果&nbsp;<code>needle</code> 不是 <code>haystack</code> 的一部分，则返回&nbsp; <code>-1</code><strong> </strong>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>haystack = "sadbutsad", needle = "sad"
<strong>输出：</strong>0
<strong>解释：</strong>"sad" 在下标 0 和 6 处匹配。
第一个匹配项的下标是 0 ，所以返回 0 。
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>haystack = "leetcode", needle = "leeto"
<strong>输出：</strong>-1
<strong>解释：</strong>"leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= haystack.length, needle.length &lt;= 10<sup>4</sup></code></li>
	<li><code>haystack</code> 和 <code>needle</code> 仅由小写英文字符组成</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：暴力匹配**

我们可以让字符串 `needle` 与字符串 `haystack` 的所有长度为 `m` 的子串均匹配一次。

为了减少不必要的匹配，我们每次匹配失败即立刻停止当前子串的匹配，对下一个子串继续匹配。如果当前子串匹配成功，我们返回当前子串的开始位置即可。如果所有子串都匹配失败，则返回 −1。

假设字符串 `haystack` 长度为 `n`，字符串 `needle` 长度为 `m`，则时间复杂度为 `O(n×m)`，空间复杂度 `O(1)`。

参考官方题解：https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/solutions/732236/shi-xian-strstr-by-leetcode-solution-ds6y

**方法二：Rabin-Karp 字符串匹配算法**

[Rabin-Karp 算法](https://zh.wikipedia.org/zh-hans/%E6%8B%89%E5%AE%BE-%E5%8D%A1%E6%99%AE%E7%AE%97%E6%B3%95)本质上是利用滑动窗口配合哈希函数对固定长度的字符串哈希之后进行比较，可以将比较两个字符串是否相同的时间复杂度降为 $O(1)$。

假设字符串 `haystack` 长度为 $n$，字符串 `needle` 长度为 $m$，则时间复杂度为 $O(n+m)$，空间复杂度 $O(1)$。

**方法三：KMP 字符串匹配算法**

假设字符串 `haystack` 长度为 $n$，字符串 `needle` 长度为 $m$，则时间复杂度为 $O(n+m)$，空间复杂度 $O(m)$。

