/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 * Return the starting gas station's index if you can travel around the circuit once, otherwise 
 * return -1.

 * Note:
 * The solution is guaranteed to be unique.
 */
 /*
 1.if final sum <0 , no solution exists
 2.when rem<0: The start point should be i + 1 why?
   start ... i <0 if K is a solution between start ..i that k..i rem>0 then start ..i must be < 0
   we can't reach k .
 */
/*
从i开始，j是当前station的指针，sum += gas[j] – cost[j] （从j站加了油，再算上从i开始走到j剩的油，走到j+1站还能剩下多少油）
如果sum < 0，说明从i开始是不行的。那能不能从i..j中间的某个位置开始呢？假设能从k (i <=k<=j)走，那么i..j < 0，若k..j >=0，
说明i..k – 1更是<0，那从k处就早该断开了，根本轮不到j。
*/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas==null || cost==null || gas.length!=cost.length)
            return -1;
        int rem = 0;
        int sum = 0;
        int j = -1;
        for(int i=0;i<gas.length;i++){
            rem += (gas[i] - cost[i]);
            sum += (gas[i] - cost[i]);
            if(rem<0){
                j = i;
                rem = 0;
            }
        }
        if(sum>=0)
            return j+1;
        else
            return -1;
    }
}
