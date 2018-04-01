package Facebook;

/**
 * 
 * 给一个int array, 大致是sorted，返回是否只有两个数进行对调了。follow up 是如果array 很大怎么办，（还有一道easy/medium level的题忘记了）. 
 * 
 * 第二题举例：

[ 1 9  5 7 3 ] 给定这个array，它是sorted, 可以看出9 和 3 swap 了， 那么返回index [1,4]，开始的题目要求是:如果有有且仅有一对被swap, 也可能没有。
follow up的话是array很长，且可能有多对，如果多对直接返回-1。

我自己的做法是用的双指针，两边分别找第一个数比第二数大的pair，左边的取pair中第一个，右边的取pair中第二个，如果指针碰到还没有pair就是没有swap。
follow up的话就不用双指针了一旦找到第一个数比第二数大的pair多于4个，就可以直接返回-1了。

 * @author Shengyi
 *
 */

public class _01_sorted_array_except_two {
1
}
