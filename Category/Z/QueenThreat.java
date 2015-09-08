public class Solution {
    static int maxThreats(int[] A){
        HashMap<Integer, Integer> X = new HashMap<>();
        HashMap<Integer, Integer> Y = new HashMap<>();
        int[] threat = new int[A.length];
        for(int i = 0 ; i < A.length; i++){
            if(!X.containsKey(A[i] + i) && !Y.containsKey(A[i] - i)){
                if(!X.containsKey(A[i] + i)){
                    X.put(A[i] + i, i);
                }
                if(!Y.containsKey(A[i] - i)){
                    Y.put(A[i] - i, i);
                }
            }else{
                if(X.containsKey(A[i] + i)){
                    int nearX = X.get(A[i] + i);
                    threat[nearX]++;
                    threat[i]++;
                    X.put(A[i] + i, i);
                    System.out.println("*");
                }
                if(Y.containsKey(A[i] - i)){
                    int nearY = Y.get(A[i] - i);
                    threat[nearY]++;
                    threat[i]++;
                    Y.put(A[i] - i, i);
                }
            }
        }
        int res = 0;
        for(int x: threat){
            res = Math.max(res, x);
        }
        return res;
    }

    public static void main(String args[] ) throws Exception {
        /*Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int[] arr = new int[N];
        for(int i = 0 ; i < N; i++){
            arr[i] = cin.nextInt();
        }*/
        int[] arr = {0, 3, 2, 1, 4};
        int res = maxThreats(arr);
        System.out.println(res);
    }
}
