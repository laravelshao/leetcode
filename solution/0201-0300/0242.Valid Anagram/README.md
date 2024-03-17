# [242. 有效的字母异位词](https://leetcode.cn/problems/valid-anagram)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定两个字符串 <code><em>s</em></code> 和 <code><em>t</em></code> ，编写一个函数来判断 <code><em>t</em></code> 是否是 <code><em>s</em></code> 的字母异位词。</p>

<p><strong>注意：</strong>若 <code><em>s</em></code> 和 <code><em>t</em></code><em> </em>中每个字符出现的次数都相同，则称 <code><em>s</em></code> 和 <code><em>t</em></code><em> </em>互为字母异位词。</p>

<p> </p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> <em>s</em> = "anagram", <em>t</em> = "nagaram"
<strong>输出:</strong> true
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> <em>s</em> = "rat", <em>t</em> = "car"
<strong>输出: </strong>false</pre>

<p> </p>

<p><strong>提示:</strong></p>

<ul>
	<li><code>1 <= s.length, t.length <= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> 和 <code>t</code> 仅包含小写字母</li>
</ul>

<p> </p>

<p><strong>进阶: </strong>如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？</p>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：计数**

我们先判断两个字符串的长度是否相等，如果不相等，说明两个字符串中的字符肯定不同，返回 `false`。

否则，我们用哈希表或者一个长度为 $26$ 的数组来记录字符串 $s$ 中每个字符出现的次数，然后遍历另一个字符串 $t$，
每遍历到一个字符，就将哈希表中对应的字符次数减一，如果减一后的次数等于 0，则从哈希表中移除。
遍历完成后判断哈希表是否为空，如果为空则说明两个字符串是字母异位词，否则不是。

```java

时间复杂度 $O(n)$，空间复杂度 $O(C)$，其中 $n$ 是字符串的长度；而 $C$ 是字符集的大小，本题中 $C=26$。

