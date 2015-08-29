public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        if(numRows == 1){
            return res;
        }
        for(int i = 2; i <= numRows; i++){
            List<Integer> in = new ArrayList<>();
            in.add(1);
            for(int j = 1 ; j + 1 < i; j++){
                int a = res.get(res.size() - 1).get(j - 1);
                int b = res.get(res.size() - 1).get(j);
                in.add(a + b);
            }
            in.add(1);
            res.add(in);
        }
        return res;
    }
}
