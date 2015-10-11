public class Solution {

    public static List<String> findAnagrams(String str, List<String> list) {
        List<String> res = new ArrayList<>();
        char[] A = str.toCharArray();
        Arrays.sort(A);
        String newstr = new String(A);
        for (String s : list) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            if (newstr.equals(new String(arr))) {
                res.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"abc", "aaa", "bbb"});
        System.out.println(findAnagrams("bca", list));
    }
}
