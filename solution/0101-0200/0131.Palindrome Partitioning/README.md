# [131. 分割回文串](https://leetcode.cn/problems/palindrome-partitioning)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code>，请你将<em> </em><code>s</code><em> </em>分割成一些子串，使每个子串都是 <strong>回文串</strong> 。返回 <code>s</code> 所有可能的分割方案。</p>

<p><strong>回文串</strong> 是正着读和反着读都一样的字符串。</p>

<p> </p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "aab"
<strong>输出：</strong>[["a","a","b"],["aa","b"]]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "a"
<strong>输出：</strong>[["a"]]
</pre>

<p> </p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 <= s.length <= 16</code></li>
	<li><code>s</code> 仅由小写英文字母组成</li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->

### 方法一：DFS(回溯)

参考题解：https://leetcode.cn/problems/palindrome-partitioning/solutions/2059414/hui-su-bu-hui-xie-tao-lu-zai-ci-pythonja-fues/