# [739. 每日温度](https://leetcode.cn/problems/daily-temperatures)


## 题目描述

<!-- 这里写题目描述 -->

<p>给定一个整数数组&nbsp;<code>temperatures</code>&nbsp;，表示每天的温度，返回一个数组&nbsp;<code>answer</code>&nbsp;，其中&nbsp;<code>answer[i]</code>&nbsp;是指对于第 <code>i</code> 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用&nbsp;<code>0</code> 来代替。</p>

<p>&nbsp;</p>

<p><strong>示例 1:</strong></p>

<pre>
<strong>输入:</strong> <code>temperatures</code> = [73,74,75,71,69,72,76,73]
<strong>输出:</strong>&nbsp;[1,1,4,2,1,1,0,0]
</pre>

<p><strong>示例 2:</strong></p>

<pre>
<strong>输入:</strong> temperatures = [30,40,50,60]
<strong>输出:</strong>&nbsp;[1,1,1,0]
</pre>

<p><strong>示例 3:</strong></p>

<pre>
<strong>输入:</strong> temperatures = [30,60,90]
<strong>输出: </strong>[1,1,0]</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;=&nbsp;temperatures.length &lt;= 10<sup>5</sup></code></li>
	<li><code>30 &lt;=&nbsp;temperatures[i]&nbsp;&lt;= 100</code></li>
</ul>

## 解法

<!-- 这里可写通用的实现逻辑 -->


### 方法一：单调栈

单调栈常见模型：[找出每个数左/右边**离它最近的**且**比它大/小的数**。模板：

```python
stk = []
for i in range(n):
    while stk and check(stk[-1], i):
        stk.pop()
    stk.append(i)
```

可以维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。

正向遍历温度列表。对于温度列表中的每个元素 $temperatures[i]$，如果栈为空，则直接将 $i$ 进栈，

如果栈不为空，则比较栈顶元素 $prevIndex$ 对应的温度 $temperatures[stack.peek()]$ 和当前温度 $temperatures[i]$，如果 $temperatures[i] > temperatures[stack.peek()]$，

则将栈顶元素移除，并将对应的等待天数赋为 $ans[val] = i - val$，重复上述操作直到栈为空或者栈顶元素对应的温度小于等于当前温度，然后将 $i$ 进栈。

参考官方题解：https://leetcode.cn/problems/daily-temperatures/solutions/283196/mei-ri-wen-du-by-leetcode-solution/

时间复杂度 $O(n)$，空间复杂度 $O(n)$。其中 $n$ 为 $temperatures$ 数组的长度。

