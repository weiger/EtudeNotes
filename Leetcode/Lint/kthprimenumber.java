/*Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.

The eligible numbers are like 3, 5, 7, 9, 15 ...

Example
If k=4, return 9.*/
//TLE
class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);list.add(5);list.add(7);
        int num = 3;
        int count = 0;
        while (true) {
            if (isValid(list,num)) {
                count++;
                if (count == k) {
                    return num;
                }
            }
            num++;
        }
    }
    
    public static boolean isValid(ArrayList<Integer> list, int num) {
        if(num==1)
            return true;
        boolean flag = false;
        for(int i=0;i<list.size();i++){
            if( num % list.get(i) == 0)
                flag = true;
            if( i==list.size()-1){
                if(flag==false)
                    return false;
            }   
        }

        for(int i=0;i<list.size();i++){
            if(num % list.get(i) == 0){
                if(isValid(list,num/list.get(i)))
                    return true;
            }
        }
        return false;
    }  
};

