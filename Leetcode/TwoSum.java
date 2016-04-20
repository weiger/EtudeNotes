//O(n)
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target - nums[i], i);
            } else {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }
        }
        return new int[0];
    }
}

//O(nlogn) stupid
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = {-1, -1};
        int[] copy = nums.clone();
        int A = 0; int B = 0; int sum = 0;
        Arrays.sort(copy);
        int beg = 0; int end = nums.length - 1;
        while (beg < end) {
            sum = copy[beg] + copy[end];
            if (sum == target) {
                A = copy[beg];
                B = copy[end];
                break;
            } else if (sum < target) {
                beg++;
            } else if (sum > target) {
                end--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == A || nums[i] == B) {
                if (res[0] == -1) {
                    res[0] = i;
                } else {
                    res[1] = i;
                }
            }
        }
        Arrays.sort(res);
        return res;
    }
}
