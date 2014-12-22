/*Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
Example
Given height = [2,1,5,6,2,3],
return 10
*/

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        int step = 0;
        int res = 0;
        int len = height.length;
        while(i < height.length || !stack.isEmpty()){
            if(i < height.length && (stack.isEmpty() || height[i] > height[stack.peek()])){
                stack.push(i++);
            }else{
                int tmp = stack.pop();
                if(!stack.isEmpty()){
                    step = (i - stack.peek() - 1) * height[tmp];
                }else{
                    step = i *  height[tmp];
                }
            }
            res = Math.max(res,step);
        }
        return res;
    }
}

