# [6. N 字形变换](https://leetcode.cn/problems/zigzag-conversion)


## 题目描述

<!-- 这里写题目描述 -->

<p>将一个给定字符串 <code>s</code> 根据给定的行数 <code>numRows</code> ，以从上往下、从左到右进行 Z 字形排列。</p>

<p>比如输入字符串为 <code>"PAYPALISHIRING"</code> 行数为 <code>3</code> 时，排列如下：</p>

<pre>
P   A   H   N
A P L S I I G
Y   I   R</pre>

<p>之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如：<code>"PAHNAPLSIIGYIR"</code>。</p>

<p>请你实现这个将字符串进行指定行数变换的函数：</p>

<pre>
string convert(string s, int numRows);</pre>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "PAYPALISHIRING", numRows = 3
<strong>输出：</strong>"PAHNAPLSIIGYIR"
</pre>

<strong>示例 2：</strong>

<pre>
<strong>输入：</strong>s = "PAYPALISHIRING", numRows = 4
<strong>输出：</strong>"PINALSIGYAHRPI"
<strong>解释：</strong>
P     I    N
A   L S  I G
Y A   H R
P     I
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>s = "A", numRows = 1
<strong>输出：</strong>"A"
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 1000</code></li>
	<li><code>s</code> 由英文字母（小写和大写）、<code>','</code> 和 <code>'.'</code> 组成</li>
	<li><code>1 <= numRows <= 1000</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

行索引从0 开始，到 numRows - 1 结束，然后再从 numRows - 1 开始，到 0 结束，如此反复。

创建一个长度为 numRows 的字符串列表，用于保存每个行的字符串。 在遍历 s 的过程中，将每个字符添加到对应的行索引的字符串中，最后将所有行的字符串拼接起来即可。

设置初始 flag = -1，当遍历的行索引等于 0 或 numRows - 1 时，将 flag 取反。可以实现 0 -> numRows - 1 -> 0 -> numRows - 1 的变换。


时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 为字符串 $s$ 的长度。

