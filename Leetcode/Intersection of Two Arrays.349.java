//Hash
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (Integer e: nums1) {
            set.add(e);
        }
        for (Integer e: nums2) {
            if (set.contains(e) && !list.contains(e)) {
                list.add(e);
            }
        }
        Collections.sort(list);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
//lambda
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        return Arrays.stream(nums1)
                .distinct()
                .filter(p -> {
                    return Arrays.stream(nums2)
                            .anyMatch(q -> {
                                return q == p;
                            });
                })
                .toArray();
    }
}