# AlogorithmExs

算法课程作业习题解答

主要涉及：`递归`、`分治`、`动态规划`、`贪心算法`

## 递归

### demo1（打靶问题）

> 一个射击运动员打靶,靶一共有10环,连开10枪打中90环的可能性有多少种?
> 
> 具体解答过程：https://starry-hu.github.io/2019/03/13/shootingProblem/

### demo2（猴子吃桃）

> 猴子吃桃子问题：猴子第一天摘下N个桃子，当时就吃了一半，还不过瘾，就又吃了一个。第二天又将剩下的桃子吃掉一半，又多吃了一个。以后每天都吃前一天剩下的一半零一个。到第10天在想吃的时候就剩一个桃子了,求第一天共摘下来多少个桃子？
> 
> 具体解答过程：https://starry-hu.github.io/2019/03/13/eatPeachProblem/

### demo3（回文串判定）

> 输入一串字符（长度小于100），判断该串字符是否是回文串（正序读与逆序读内容相同）。
> 比如 level,dad,noon,12321......
> 
> 具体解答过程：https://starry-hu.github.io/2019/03/14/huiwenProblem/

## 分治

### demo4（循环赛日程）

> 问题描述：
> 设有n = 2^k个运动员要进行网球循环赛。现要设计一个满足以下要求的比赛日程表：
> （1）每个选手必须与其他n-1个选手各赛一次；
> （2）每个选手一天只能赛一次；
> （3）循环赛一共进行n-1天。
> 
> 具体解答过程：https://starry-hu.github.io/2019/03/20/gameTableDesign/

### demo5（求序列中最大子序列和）`动态规划+分治`

> 有长度为n的整数序列，求一段连续的子序列，要求该子序列的和为最大，并求出最大值。
> 如，给定序列为：4，-3，5，-2，-1，2，6，-2
> 结果最大子序列为：4，-3，5，-2，-1，2，6；和最大为11.
> 
> 具体解答过程：https://starry-hu.github.io/2019/03/21/maxSubsequeTotal/

### demo6（汉诺塔问题）

> 汉诺塔问题是一个经典的问题。汉诺塔（Hanoi Tower），又称河内塔，源于印度一个古老传说。大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。并且规定，任何时候，在小圆盘上都不能放大圆盘，且在三根柱子之间一次只能移动一个圆盘。问应该如何操作？
> 
> 具体解答过程：https://starry-hu.github.io/2019/03/21/hanNuoSolution/

## 动态规划

### demo5（求序列中最大子序列和）`动态规划+分治`

> 有长度为n的整数序列，求一段连续的子序列，要求该子序列的和为最大，并求出最大值。
> 如，给定序列为：4，-3，5，-2，-1，2，6，-2
> 结果最大子序列为：4，-3，5，-2，-1，2，6；和最大为11.
> 
> 具体解答过程：https://starry-hu.github.io/2019/03/21/maxSubsequeTotal/

### demo7（数塔问题）

> 如下图所示，从顶部出发在每一个节点可以选择向左或者向右走，一直走到底层，要求找出一条路径，使得路径上的数字之和最大.
> 
> 具体解答过程：https://starry-hu.github.io/2019/04/19/numberTower/

### demo8（levenshtein 编辑距离）

> 字符串的编辑距离，又称为Levenshtein距离，由俄罗斯的数学家Vladimir Levenshtein在1965年提出。是指利用字符操作，把字符串A转换成字符串B所需要的最少操作数。其中，字符操作包括：
删除一个字符 a) Insert a character
插入一个字符 b) Delete a character
修改一个字符 c) Replace a character
例如对于字符串”if”和”iff”，可以通过插入一个’f’或者删除一个’f’来达到目的。
> 给定两个字符串S和T，求字符串S至少经过多少步字符操作变成字符串T。即求两串的编辑距离
> 
> 具体解答过程：https://starry-hu.github.io/2019/04/20/levenshtein/

### demo9（导弹拦截/最长非递增序列）

> 某国为了防御敌国的导弹袭击，开发出一种导弹拦截系统。但是这种导弹拦截系统有一个缺陷：虽然它的第一发炮弹能够到达任意的高度，但是以后每一发炮弹都不能高于前一发的高度。某天，雷达捕捉到敌国的导弹来袭，并观测到导弹依次飞来的高度，请计算这套系统最多能拦截多少导弹。拦截来袭导弹时，必须按来袭导弹袭击的时间顺序，不允许先拦截后面的导弹，再拦截前面的导弹。、
现给出数个导弹的高度( <=50000的正整数 )，计算一套导弹拦截系统最多可以拦截多少导弹，如果需要拦截全部导弹最少需要多少套导弹拦截系统？
> 
> 具体参考代码：https://starry-hu.github.io/2019/04/20/maxNoIncreaseSequ/

### demo10（挖地雷问题）

> 在一个地图上有n个地窖（n<=200）,每个地窖中埋有一定数量的地雷。
同时，给出地窖之间的连接路径，并规定路径都是单向的,也不存在可以从一个地窖出发经过若干地窖后又回到原来地窖的路径。
某人可以从任一处开始挖地雷，然后沿着指出的连接往下挖（仅能选择一条路径），当无连接时挖地雷工作结束。
设计一个挖地雷的方案，使他能挖到最多的地雷。(用动态规划求解)
> 
> 具体参考代码：https://starry-hu.github.io/2019/04/20/waDileiProblem/

----------------

以下列题的实验要求，均为动态规划，同时背包问题用贪心算法解答

### trial1（矩阵连乘的最优相乘次数-动态规划）

> 给定n个矩阵{A1，A2，……，An},其中Ai与Ai+1是可乘的，i=1，2，……，n-1。
计算三个矩阵连乘{A1，A2，A3}；维数分别为10100 , 1005 , 550
按此顺序计算需要的次数（（A1A2）A3）:10X100X5+10X5X50=7500次
按此顺序计算需要的次数（A1（A2*A3））:10X5X50+10X100X50=75000次
所以要解决的问题是：如何确定矩阵连乘积A1A2，……An的计算次序
> 使得按此计算次序计算矩阵连乘积需要的数乘次数达到最小化。
> 
> 具体解答过程：https://starry-hu.github.io/2019/03/31/matrixMultiplyOptimal/
> 
> 前边为分析+ppt例子
> 后边为具体代码测试

### trial2 （最长公共子序列-动态规划）

> 给定两个字符串，求解这两个字符串的最长公共子序列（Longest Common Sequence）。
> 比如字符串1：BDCABA；字符串2：ABCBDAB
> 则这两个字符串的最长公共子序列长度为4，最长公共子序列是：BCBA
> 
> 此处需要注意
> 子序列：原串按原次序选取若干字符（可不连续）组成的字符串。也称原串删去若干字符剩下的字符串。
> 子串：原串中连续的若干字符组成的字符串。
> 
> 具体解答过程：https://starry-hu.github.io/2019/04/08/longestComSubsequ/

### trial3（0-1背包问题-动态规划）

> 问题描述:
给定一个固定大小的背包，背包的容量为 C.
有一组物品U={u1,u2,…,un}，存在对应的价值vj和重量sj (i<=j<=n)
要求找出一个最佳的解决方案，使得装入背包的物品总重量不超过背包容量 C，而且总价值最大。
注意: 物品只有选与不选(0/1),不可只选一部分装入.
> 
> 具体解答过程：https://starry-hu.github.io/2019/04/18/knapsack0-1/

### trial4（背包问题-贪心算法）

> 问题描述:
给定一个固定大小的背包，背包的容量为 C.
有一组物品U={u1,u2,…,un}，存在对应的价值vj和重量sj (i<=j<=n)
要求找出一个最佳的解决方案，使得装入背包的物品总重量不超过背包容量 C，而且总价值最大。
注意: 不同于0-1背包,此时可以选择物品的一部分装入
> 
> 具体解答过程：https://starry-hu.github.io/2019/04/18/knapsackGreedy/