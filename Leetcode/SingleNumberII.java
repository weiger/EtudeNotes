/*
 * Given an array of integers, every element appears three times except for one. Find that single one.

 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
 public class Solution {
    public int singleNumber(int[] A) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int x:A){
            if(!map.containsKey(x)){
                map.put(x,1);
            }else{
                map.put(x,map.get(x)+1);
            }
        }
        for(int x:A){
            if(map.get(x)!=3)
                return x;
        }
        return -1;
    }
}
 
public class Solution {
    public int singleNumber(int[] A) {
        int res = 0;
        int[] rec = new int[32];
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++){
                rec[i] += (A[j]>>i)&1;
            }
            rec[i] = rec[i]%3;
            res |= rec[i]<<i;
        }
        return res;
    }
}
*/
/* 如果用二进制来表达数组中每一个数字的话，如果我们遍历一遍数组中的所有的数，即将数组中所有数的二进制表达的每位上的“1”都数一遍，那么除了需要找的那个只出现一次的整数外，其他所有的数字二进制表示中每一位“1”都出现了3k次（k为非负整数）。
如果能有办法将所有的二进制表达中这些3k个“1”清零，那么剩下的二进制表达就表示了需要找到的数。

（0）初始设定ones=0; twos=0;threes=0;

（1）用twos记录到当前为止，二进制”1“出现3k+2次的位数；
twos = twos | (ones & A[i]);

（2）用ones记录到当前为止，二进制“1”出现3k+1次的位数；
ones = ones ^ A[i];

（3）当ones和twos的某一位同时为”1“时，即该位出现二进制”1“ 3k+3次（也就是3k次），清零该位。
xthrees = ~(ones & twos); // xthrees 是二进制“1”没有出现3k次的位数
ones = ones & xthrees;
twos = twos & xthrees;

（4）遍历完数组中所有的数之后，ones记录的就是最终结果。
*/

public class Solution {
    public int singleNumber(int[] A) {
        int one=0,two=0,three=0;
        for(int x:A){
            two |= x & one;
            one ^= x;
            three = one & two;
            one = ~three & one;
            two = ~three & two;
        }
        return one;
    }
}
