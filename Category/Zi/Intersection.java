public class Solution {
    public List<String> intersection1(String[] A, String[] B){
        List<String> res = new ArrayList<>();
        for (int i = 0;i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i].equals(B[j])) {
                    res.add(A[i]);
                }
            }
        }
        return res;
    }

    public List<String> intersection2(String[] A, String[] B){
        List<String> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0;i < A.length; i++) {
            set.add(A[i]);
        }
        for (int j = 0; j < B.length; j++) {
            if (set.contains(B[j])) {
                res.add(B[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        String[] A = {"A", "B", "C"};
        String[] B = {"B", "C", "D", "E"};
        System.out.println(test.intersection1(A, B));
        System.out.println(test.intersection2(A, B));
    }
}
