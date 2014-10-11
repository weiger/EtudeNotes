/*There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give? */
/*
What does the second iteration do? Only for dealing equation !
*/
public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
     int[] res = new int[ratings.length];
     res[0]=1;
     for(int i=1;i<res.length;i++){
        if(ratings[i]>ratings[i-1])
            res[i] = res[i-1]+1;
        else
            res[i] =1;
     }
     int sum=res[res.length-1];
     for(int j=res.length-2;j>=0;j--){
        if(ratings[j]>ratings[j+1])
            res[j]=Math.max(res[j],res[j+1]+1);
        sum+=res[j];
     }
     return sum;
    }
}
