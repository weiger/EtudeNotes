/*
 * Given an array of integers, find two numbers such that they add up to a 
 * specific target number.

 * The function twoSum should return indices of the two numbers such that they 
 * add up to the target, where index1 must be less than index2. Please note 
 * that your re * turned answers (both index1 and index2) are not zero-based.

 * You may assume that each input would have exactly one solution.

 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 */
//O(n)
public class TowSum {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) 
                map.put(target - numbers[i], i + 1);
            else {
                res[0] = map.get(numbers[i]);
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }
}
//O(n^2) Brutal ,Time Limit Exceed
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
	for(int i=0;i<numbers.length-1;i++)
	    for(int j=i+1;j<numbers.length;j++)
		if(numbers[i]+numbers[j]==target)
		{
		    res[0]=i+1;
		    res[1]=j+1;
		    break;
		}
	return res;
    }
}
//O(nlogn) stupid
public static int[] twoSum(int[] numbers, int target) {
	int[] res = {-1,-1};
	int[] temp = numbers.clone();
	Arrays.sort(temp);
	int i=0,j=temp.length-1,sum=0;
	int add1 = 0,add2=0;
	while(i<j){
	    sum = temp[i]+temp[j];
	    if(sum>target)
		j--;
	    else if(sum<target)
		i++;
	    else if(sum==target)
	    {
		add1 = temp[i];
		add2 = temp[j];
		break;
	    }
	}
	for(int k=0;k<numbers.length;k++){
	   if(numbers[k]==add1 || numbers[k]==add2)
	   {
	       if(res[0]==-1)
		   res[0]=k+1;
	       else
		   res[1]=k+1;
	   }
	}
	Arrays.sort(res);
	return res;
    }
