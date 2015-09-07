public class Solution {
    public static long getMax(long[] arr){
        if(arr == null || arr.length <= 2){
            return 0;
        }
        long max = arr[arr.length - 1];
        long res = 0;
        for(int i = arr.length - 2; i >= 0; i--){
            if(max > arr[i]){
                res += max - arr[i];
            }
            max = Math.max(max, arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner cin = new Scanner(System.in);
        int M = cin.nextInt();
        long[] res = new long[M];
        for(int i = 0 ; i < M; i++){
            int N = cin.nextInt();
            long[] arr = new long[N];
            for(int j = 0 ; j < N; j++){
                arr[j] = cin.nextInt();
            }
            res[i] = getMax(arr);
        }
        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
