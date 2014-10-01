/*
http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
题目：给你一天的Google搜索日志，你怎么设计算法找出是否有一个搜索词，它出现的频率占所有搜索的一半以上？如果肯定有一个搜索词占大多数，你能怎么提高你的算法找到它？再假定搜索日志就是内存中的一个数组，能否有O(1)空间，O(n)时间的算法？

分析：
首先要看清题目，说的是“一半以上”，“大多数”，"majority"，也就是大于５０％。
很多情形下，尤其在面试比较紧张的情形下，经常会下意识的很快得出一个如下的方法（这个没有错，能有解决方案胜于完全没想法）。定义一个哈希表，里面存放数组里面的每个元素以及出现的次数。可以通过两个过程来做。

       第一步是映射，将每个元素放进去，存在加一，不存在置一。同时统计元素个数。
       第二步是遍历整个哈希表，判断是否找到出现次数大于数组长度一半的。如果有，找到。否则没有。

显然，这个要求O(n)的空间在存储哈希表，并不理想
*/
public class Solution {

    public static int majorityvote(int[] data) {
        int[] res = new int[2];
        res[0] = -1;
        int idx = 0;
        while (idx < data.length) {
            if (res[0] == -1) {
                res[0] = 1;
                res[1] = data[idx];
            } else if (res[1] == data[idx]) {
                res[0]++;
            } else if (res[1] != data[idx] && res[0] != 0) {
                res[0]--;
            } else if (res[1] != data[idx] && res[0] == 0) {
                res[0] = 1;
                res[1] = data[idx];
            }
            idx++;
        }
        int count = 0;
        for (int x : data) {
            if (x == res[1])
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 'A', 'C', 'A', 'C', 'A', 'C', 'B', 'C', 'B', 'C', 'B',
        'C', 'C' };
        System.out.println(majorityvote(arr));
    }

}
