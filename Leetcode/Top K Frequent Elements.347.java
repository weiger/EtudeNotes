public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer e: nums) {
            if (!map.containsKey(e)) {
                map.put(e, 1);
            } else {
                map.put(e, map.get(e) + 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= k; i++) {
            int max = 0;
            int key = 0;
            for (Map.Entry<Integer, Integer> e: map.entrySet()) {
                if (e.getValue() > max) {
                    max = e.getValue();
                    key = e.getKey();
                }
            }
            res.add(key);
            map.remove(key);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        System.out.println(new Solution().topKFrequent(arr, 2));

    }
}