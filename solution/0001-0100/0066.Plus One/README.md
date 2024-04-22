# [66. 加一](https://leetcode.cn/problems/plus-one)

## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个由 <strong>整数 </strong>组成的<strong> 非空</strong> 数组所表示的非负整数，在该数的基础上加一。</p>

<p>最高位数字存放在数组的首位， 数组中每个元素只存储<strong>单个</strong>数字。</p>

<p>你可以假设除了整数 0 之外，这个整数不会以零开头。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>digits = [1,2,3]
<strong>输出：</strong>[1,2,4]
<strong>解释：</strong>输入数组表示数字 123。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>digits = [4,3,2,1]
<strong>输出：</strong>[4,3,2,2]
<strong>解释：</strong>输入数组表示数字 4321。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>digits = [0]
<strong>输出：</strong>[1]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= digits.length <= 100</code></li>
	<li><code>0 <= digits[i] <= 9</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

**方法一：模拟**

我们从数组的最后一个元素开始遍历，将当前元素加一，然后对 $10$ 取模，如果取模后的结果不为 $0$，说明当前元素没有进位，直接返回数组即可。否则，当前元素为 $0$，需要进位，继续遍历前一个元素，重复上述操作。如果遍历完数组后，仍然没有返回，说明数组中所有元素都为 $0$，需要在数组的头部插入一个 $1$。

时间复杂度 $O(n)$，其中 $n$ 是数组的长度。忽略答案的空间消耗，空间复杂度 $O(1)$。

