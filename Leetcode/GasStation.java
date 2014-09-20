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
