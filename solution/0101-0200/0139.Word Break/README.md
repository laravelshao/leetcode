# [139. 单词拆分](https://leetcode.cn/problems/word-break)

## 题目描述

<!-- 这里写题目描述 -->

<p>给你一个字符串 <code>s</code> 和一个字符串列表 <code>wordDict</code> 作为字典。请你判断是否可以利用字典中出现的单词拼接出 <code>s</code> 。</p>

<p><strong>注意：</strong>不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入:</strong> s = "leetcode", wordDict = ["leet", "code"]
<strong>输出:</strong> true
<strong>解释:</strong> 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入:</strong> s = "applepenapple", wordDict = ["apple", "pen"]
<strong>输出:</strong> true
<strong>解释:</strong> 返回 true 因为 <code>"</code>applepenapple<code>"</code> 可以由 <code>"</code>apple" "pen" "apple<code>" 拼接成</code>。
&nbsp;    注意，你可以重复使用字典中的单词。
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入:</strong> s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
<strong>输出:</strong> false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 300</code></li>
	<li><code>1 &lt;= wordDict.length &lt;= 1000</code></li>
	<li><code>1 &lt;= wordDict[i].length &lt;= 20</code></li>
	<li><code>s</code> 和 <code>wordDict[i]</code> 仅由小写英文字母组成</li>
	<li><code>wordDict</code> 中的所有字符串 <strong>互不相同</strong></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->


参考官方题解：https://leetcode.cn/problems/word-break/solutions/302471/dan-ci-chai-fen-by-leetcode-solution


**方法一：哈希表 + 动态规划**

我们定义 $f[i]$ 表示字符串 $s$ 的前 $i$ 个字符能否拆分成 $wordDict$ 中的单词，初始时 $f[0]=true$，其余为 $false$。答案为 $f[n]$。

考虑 $f[i]$，如果存在 $j \in [0, i)$ 使得 $f[j] \land s[j:i] \in wordDict$，则 $f[i]=true$。为了优化效率，我们可以使用哈希表存储 $wordDict$ 中的单词，这样可以快速判断 $s[j:i]$ 是否在 $wordDict$ 中。

时间复杂度 $O(n^3)$，空间复杂度 $O(n)$。其中 $n$ 为字符串 $s$ 的长度。

**方法二：前缀树 + 动态规划**

我们先将 $wordDict$ 中的单词存入前缀树中，然后使用动态规划求解。

我们定义 $f[i]$ 表示从字符串 $s$ 的第 $i$ 个字符开始往后拆分，能否拆分成 $wordDict$ 中的单词，初始时 $f[n]=true$，其余为 $false$。答案为 $f[0]$。

接下来，我们从大到小枚举 $i$，对于每个 $i$，我们从 $i$ 开始往后拆分，如果 $s[i:j]$ 在前缀树中，且 $f[j+1]=true$，则 $f[i]=true$。

时间复杂度 $O(n^2)$，空间复杂度 $O(n)$。其中 $n$ 为字符串 $s$ 的长度。

