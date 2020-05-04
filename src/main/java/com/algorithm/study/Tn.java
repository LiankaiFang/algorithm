package com.algorithm.study;

/**
 * 时间复杂度公式 T(n) = O(f(n))
 * n 数据规模的大小
 * f(n) 每行代码执行的次数和
 * O 表示代码的执行时间T(n) 与 f(n) 表达式成正比
 * 时间复杂度不代表代码的真实执行时间，而是表示代码执行时间随数据规模增长的变化趋势，
 * 也称为渐进时间复杂度（asymptotic time complexity）,简称时间复杂度
 * <p>
 * 复杂度量级
 * 常量阶 O(1)
 * 对数阶 O(logn)
 * 线性阶 O(n)
 * 线性对数阶 O(nlogn)
 * 平方阶 O(n*n)、立方阶 O(n*n*n) ... k次方阶 O(n*n*...n) k个n相乘
 * 指数阶 O(2*2*...n个2相乘)
 * 阶乘阶 O(n!)
 */
public class Tn {
    /**
     * 时间复杂度计算:
     * 假设每行代码执行一次需要 unit_time =
     * 2*unit_time + n*unit_time + n*unit_time =
     * (2+2n)*unit_time
     * T(n) = O(2n+2)
     * 因为公式中的低阶、常量、系数三部分并不左右增长趋势，所以都可以忽略
     * 只需要记录一个最大量级就可以了
     * T(n) = O(n)
     */
    int cal1(int n) {
        int sum = 0;   //需要 1个 unit_time
        int i = 1; //需要 1个 unit_time
        for (; i <= n; ++i) { //需要 n 个 unit_time
            sum = sum + i; //需要 n 个unit_time
        }
        return sum;
    }

    /**
     * 时间复杂度计算：
     * 假设每行代码执行一次需要 unit_time =
     * 3*unit_time + n*unit_time + n*unit_time + n*n*unit_time + n*n*unit_time =
     * (3+2n+2n*n)*unit_time
     * T(n) = O(2n*n + 2n + 3)
     * 因为公式中的低阶、常量、系数三部分并不左右增长趋势，所以都可以忽略
     * 只需要记录一个最大量级就可以了
     * T(n) = O(n*n)
     */
    int cal2(int n) {
        int sum = 0; //1个 unit_time
        int i = 1; //1个 unit_time
        int j = 1; //1个 unit_time
        for (; i <= n; ++i) { //n 个unit_time
            j = 1; //n个 unit_time
            for (; j <= n; ++j) { //n*n 个unit_time
                sum = sum + i * j; //n*n 个unit_time
            }
        }
        return sum;
    }

    /**
     * 加法法则：总复杂度等于量级最大的那段代码的复杂度
     * 假如：T1(n) = O(f(n))  T2(n) = O(g(n))
     * 那么：T(n) = T1(n) + T2(n) =
     * max(O(f(n)) + O(g(n))) =
     * O(max(f(n), g(n)))
     * 整理后：Tn(n) = O(max(f(n), g(n)))
     * <p>
     * T1(n) = O(1) + O(n) + O(n*n) = O(n*n)
     */
    int cal3(int n) {
        //第一段代码时间复杂度 T(n) = O(1)
        int sum_1 = 0;
        int p = 1;
        for (; p < 100; ++p) {
            sum_1 = sum_1 + p;
        }

        //第二段代码时间复杂度 T(n) = O(2n+2) = O(n)
        int sum_2 = 0;
        int q = 1;
        for (; q < n; ++q) {
            sum_2 = sum_2 + q;
        }

        //第三段代码时间复杂度 T(n) = O(2*n*n + 2*n + 3) = O(n*n)
        int sum_3 = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; ++i) {
            j = 1;
            for (; j <= n; ++j) {
                sum_3 = sum_3 + i * j;
            }
        }

        return sum_1 + sum_2 + sum_3;
    }

    /**
     * 乘法法则：嵌套代码的复杂度等于嵌套内外代码复杂度的乘积
     * 假设 T1(n) = O(f(n)) T2(n) = O(g(n))
     * 那么 T(n) = T1(n) * T2(n) = O(f(n)) * O(g(n)) = O(f(n) * g(n))
     * 整理后 T(n) = O(f(n)*g(n))
     * cal4 的时间复杂度 T1(n) = O(n) f1 的时间复杂度 T2(n) = O(n)
     * 因为是嵌套关系，总的时间复杂度 T(n) = O(n) * O(n) = O(n*n)
     */
    int cal4(int n) {
        int ret = 0;
        int i = 1;
        for (; i < n; ++i) {
            ret = ret + f1(i);
        }
        return ret;
    }

    int f1(int n) {
        int sum = 0;
        int i = 1;
        for (; i < n; ++i) {
            sum = sum + i;
        }
        return sum;
    }

    /**
     * 常量阶 O(1)
     * 一般情况下，只要算法中不存在循环语句、递归语句，即使有成千上万行的代码，其时间复杂度也是Ο(1)
     */
    void cal5() {
        int i = 8;
        int j = 6;
        int sum = i + j;
    }

    /**
     * 对数阶 O(logn) / O(nlogn)
     */
    void cal6(int n) {
        int i = 1;
        while (i <= n) {
            i = i * 2;
        }
    }

    /**
     * O(m+n) O(m*n)
     * m 和 n 是表示两个数据规模。
     * 我们无法事先评估 m 和 n 谁的量级大，
     * 所以我们在表示复杂度的时候，
     * 就不能简单地利用加法法则，省略掉其中一个。
     * 所以，下面代码的时间复杂度就是 O(m+n)
     * <p>
     * 加法法则改为 T(m) + T(n) = O(f(m) + f(n))
     */
    int cal7(int m, int n) {
        int sum_1 = 0;
        int i = 1;
        for (; i < m; ++i) {
            sum_1 = sum_1 + i;
        }

        int sum_2 = 0;
        int j = 1;
        for (; j < n; ++j) {
            sum_2 = sum_2 + j;
        }

        return sum_1 + sum_2;
    }

    /**
     * 空间复杂度全称就是渐进空间复杂度（asymptotic space complexity）
     * 表示算法的存储空间与数据规模之间的增长关系
     * T(n) = O(n)
     * <p>
     * 常见的空间复杂度有 O(1) O(n) O(n*n)
     * 不常见的有 O(logn) O(nlogn)
     */
    void print(int n) {
        int i = 0;
        int[] a = new int[n];
        for (; i < n; ++i) {
            a[i] = i * i;
        }

        for (i = n - 1; i >= 0; --i) {
            print(a[i]);
        }
    }


    /**
     * 有人说，我们项目之前都会进行性能测试，再做代码的时间复杂度、空间复杂度分析，是不是多此一举呢？
     * 而且，每段代码都分析一下时间复杂度、空间复杂度，是不是很浪费时间呢？
     * 你怎么看待这个问题呢？
     *
     * 1. 做好代码的时间复杂度分析后，可以找到执行效率低下的部分，从而进行优化
     * 做好代码的空间复杂度分析，可以找出存储瓶颈在哪个地方，从而进行优化。总结一下，
     * 只有很好的进行了代码的复杂度分析后，才可以避免写出效率低下的垃圾代码。
     * 所以，不是多余的。
     * +++
     */
}
