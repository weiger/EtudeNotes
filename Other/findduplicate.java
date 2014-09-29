/*
int[n] data contains 1-n ,return one which is duplicate 
*/
public class Solution {
    public static int findDuplicate(int[] data){
    if(data==null || data.length==0)
        return -1;
    int index = 0;
    while(index<data.length){
        if(data[index]==index+1){
        index++;
        }else{
        int val = data[index];
        if(val == data[val-1])
            return val;
        int tmp = data[val-1];
        data[val-1] = data[index];
        data[index] = tmp;
        }
    }
    return -1;
    }
    public static void main(String[] args) {
    int[] data = {5,6,2,3,4,2};
    System.out.println(findDuplicate(data));
    }

}
