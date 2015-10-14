public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if(nums == null){
            return null;
        }
        int[] res = new int[nums.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        
        res[0] = nums[0];
        maxHeap.add(nums[0]);
        
        for(int i=1; i<nums.length; i++) {
            int x = maxHeap.peek();
            if(nums[i] <= x) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            if(maxHeap.size() > minHeap.size()+1 ) {
                minHeap.add(maxHeap.poll());
            } else if(maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            res[i] = maxHeap.peek();
        }
        return res;
    }
}
