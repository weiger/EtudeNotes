public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Integer can1 = null; int cnt1 = 0;
        Integer can2 = null; int cnt2 = 0;
        for (int x: nums) {
            if (can1 != null && can1 == x) {
                cnt1++;
            } else if (can2 != null && can2 == x) {
                cnt2++;
            } else if (cnt1 == 0) {
                can1 = x;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                can2 = x;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0; cnt2 = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int x: nums) {
            if (can1 != null && x == can1) cnt1++;
            if (can2 != null && x == can2) cnt2++;
        }
        if (cnt1 > n / 3) list.add(can1);
        if (cnt2 > n / 3) list.add(can2);
        return list;
    }
}
