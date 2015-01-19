/* Find K-th largest element in an array.

Note
You can swap elements in the array

Example
In array [9,3,2,4,8], the 3th largest element is 4 */

class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        if (k < 1 || k > numbers.size())
        return -1;
        int beg = 0;
        int end = numbers.size() - 1;
        while (beg < end) {
            int j = partition(numbers, beg, end);
            if (j < (k-1))
                beg = j + 1;
            else if (j>(k-1))
                end = j - 1;
            else
                return numbers.get((k-1));
        }
        return numbers.get((k-1));
    }
    public int partition(ArrayList<Integer> numbers, int beg, int end) {
        if (beg > end)
            return -1;
        int index = beg;
        int pivot = numbers.get(end);
        for (int i = beg; i < end; i++) {
            if (numbers.get(i) >= pivot) {
                swap(numbers, index++, i);
            }
        }
        swap(numbers, index, end);
        return index;
    }
    
    public void swap(ArrayList<Integer> numbers, int a, int b) {
        int tmp = numbers.get(a);
        numbers.set(a, numbers.get(b));
        numbers.set(b, tmp);
    }
};

