/*
 * 题目要求：
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 限制：1 <= n <= 10000
 */

class Solution {
    /*
     * 解决方案：短路特性
     *         技巧1: 不能显式的循环，考虑使用递归；
     *         技巧2: 不用if判断递归终止怎么办呢？使用逻辑运算的“短路运算” 使用 && 或 || 的特性来替代，即执行前半部分
     *
     * 时间复杂度：O(N) 递归次数
     * 空间复杂度：O(N) 递归栈空间
     */
    public int sumNums1(int n) {
        boolean b = (n > 0) && ((n += sumNums(n - 1)) > 0);
        return n;
    }

    /*
     * 解决方案：位运算
     *       技巧1: 利用了-1和任何整数进行与运算还等于原数的特点： -1&X = X
     *             -(n + 1 >> 0 & 1)用于求从低到高第i+1位如果为0取，如果为1取-1
     *              负数在参与位运算时使用的是"补码"
     *              -1的原码是   10000000 00000000 00000000 00000001
     *              -1的反码是   11111111 11111111 11111111 11111110
     *              -1的补码是   11111111 11111111 11111111 11111111
     *              因此任何数与-1做与运算的结果任然为原数
     * 
     *       技巧2: 除以2用右移1位进行操作
     *             由等差数列求和公式可知，结果等于n*(n+1)/2，其中除以2可以通过右移1位进行操作
     * 
     *       技巧3: n*(n+1)在不允许使用乘法的情况下，只能把n或n+1其中一个拆解为2的n次幂数之和，配合另一个来进行位运算和累加
     *             因为题目设定n<10000，n可能的最大拆分项为2^13=8192，问题是如何确定2的0-13次幂什么时候需要。
     *             比如11=8+2+1，只需要2的0、1、3次幂，所以要保证我们在加上其他次幂时无效。
     *             举例：(n>>>3)&1 可以通过结果判断n的二进制第3位是0或者1，(0-((n>>>3)&1))可以决定此次相加是否有效，
     *                  如果有效(0-((n>>>3)&1))=-1，然后(n+1)&(-1)=(n+1)还是其本身,再通过左移3位实现×8的效果，
     *                  如果无效(0-((n>>>3)&1))=0，(n+1)&0=0,此时在左移3位，结果还是0.
     *       
     *       具体操作思路：将n+1拆成14个二进制位，每位分别与n相乘之后再累加。
     *                  1. 每位要么是0 or 1，所以第i位值value与n相乘 = -n & value； 参考第一个技巧
     *                  2. 第i位的值: (n + 1) >> i & 1
     *                  3. 累加14个乘积
     * 
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    public int sumNums(int n) {
        int n1 = (n & -(n + 1 >> 0 & 1)) << 0;
        int n2 = (n & -(n + 1 >> 1 & 1)) << 1;
        int n3 = (n & -(n + 1 >> 2 & 1)) << 2;
        int n4 = (n & -(n + 1 >> 3 & 1)) << 3;
        int n5 = (n & -(n + 1 >> 4 & 1)) << 4;
        int n6 = (n & -(n + 1 >> 5 & 1)) << 5;
        int n7 = (n & -(n + 1 >> 6 & 1)) << 6;
        int n8 = (n & -(n + 1 >> 7 & 1)) << 7;
        int n9 = (n & -(n + 1 >> 8 & 1)) << 8;
        int n10 = (n & -(n + 1 >> 9 & 1)) << 9;
        int n11 = (n & -(n + 1 >> 10 & 1)) << 10;
        int n12 = (n & -(n + 1 >> 11 & 1)) << 11;
        int n13 = (n & -(n + 1 >> 12 & 1)) << 12;
        int n14 = (n & -(n + 1 >> 13 & 1)) << 13;
        return (n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + n13 + n14) >> 1;
    }
}