public class Solution {
    private int max;
    private HashMap<String, Integer> map;

    Solution(){
        max = 0;
        map = new HashMap<>();
        map.put("2",2);map.put("3",3);map.put("4",4);map.put("5",5);map.put("6",6);map.put("7",7);map.put("8",9);
        map.put("10",10);map.put("J",10);map.put("Q",10);map.put("K",10);
    }

    public int getScore(List<String> cards){
        if (cards.size() > 0) {
            helper(cards, 0, 0);
            if ( max == 0) return -1;
            else return max;
        }
        return -1;
    }

    public void helper (List<String> cards, int cur, int index) {
        if (index == cards.size()) {
            if (cur <= 21) max = Math.max(max, cur);
            return;
        }
        if (cards.get(index).equals("A")) {
            if (cur + 1 <= 21) helper(cards, cur + 1, index + 1);
            if (cur + 11 <= 21) helper(cards, cur + 11, index + 1);
        } else {
            if (cur + map.get(cards.get(index)) <= 21){
                helper(cards, cur + map.get(cards.get(index)), index + 1);
            }
        }
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList(new String[]{"A", "10"});
        Solution s = new Solution();
        System.out.println(s.getScore(input));
    }
}
