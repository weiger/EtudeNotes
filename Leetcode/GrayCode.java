/*
1: 0   1
2: 00  01  11  10
3. 000 001 011 010 110 111 101 100
*/
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
        } else {
            List<Integer> list = grayCode(n - 1);
            for (Integer e: list) {
                res.add(e);
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                res.add(list.get(i) + (1 << (n - 1)));
            }
        }
        return res;
    }
}
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0 ; i < (1 << n); i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}
