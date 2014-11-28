/*Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.

The eligible numbers are like 3, 5, 7, 9, 15 ...

Example
If k=4, return 9.*/

class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
    	int count3 = 0;
        int count5 = 0;
        int count7 = 0;

        ArrayList<Long> list = new ArrayList<Long>();
        list.add((long) 1);
        long m = 0;
        for(int i=1;i<=k;i++)
        {
            m = Math.min(Math.min(list.get(count3) * 3, list.get(count5) * 5), list.get(count7) * 7);

            list.add(m);
            if (m == list.get(count3) * 3) count3++;
            if (m == list.get(count5) * 5) count5++;
            if (m == list.get(count7) * 7) count7++;
        }
        return m;
    }
};

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

