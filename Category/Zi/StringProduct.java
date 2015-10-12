public class Solution {
    public int largestProduct(String[] A){
        if (A == null || A.length == 0) {
            return 0;
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return 0;
                }else if (o1.length() > o2.length()) {
                    return 1;
                }else{
                    return -1;
                }
            }
        };
        int res = 0;
        Arrays.sort(A, comp);
        HashMap<String, Integer> map = getMask(A);
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int product = A[i].length() * A[j].length();
                if (product < res) continue;
                int bitA = map.get(A[i]);
                int bitB = map.get(A[j]);
                if ( (bitA & bitB) == 0 ) {
                    res = Math.max(res, product);
                }
            }
        }
        return res;
    }

    public HashMap<String, Integer> getMask(String[] A){
        HashMap<String, Integer> map = new HashMap<>();
        for (String str: A) {
            if (!map.containsKey(str)) {
                int mask = 0;
                for (int i = 0; i < str.length(); i++) {
                    int pos = str.charAt(i) - 'a';
                    mask |= (1 << pos);
                }
                map.put(str, mask);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        String[] A = {"abc","ade","uvwxyz"};
        int res = test.largestProduct(A);
        System.out.println(res);
    }
}
