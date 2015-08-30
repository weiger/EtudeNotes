class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        // write your code here
        if(k < 1 || k > numbers.size()){
            return -1;
        }
        int beg = 0; int end = numbers.size() - 1;
        while(beg < end){
            int n = partition(numbers, beg, end);
            if(n == (k - 1)){
                return numbers.get(k - 1);
            }else if(n < (k - 1)){
                beg = n + 1;
            }else if(n > (k - 1)){
                end = n - 1;
            }
        }
        return numbers.get(k - 1);
    }
    
    public int partition(ArrayList<Integer> numbers, int beg, int end){
        if(beg > end){
            return -1;
        }
        int index = beg;
        int pivot = numbers.get(end);
        for(int i = beg; i < end; i++){
            if(numbers.get(i) >= pivot){
                swap(numbers, index++, i);
            }
        }
        swap(numbers, index, end);
        return index;
    }
    
    public void swap(ArrayList<Integer> nums, int a, int b){
        int tmp = nums.get(a);
        nums.set(a, nums.get(b));
        nums.set(b, tmp);
    }
};
