public class Solution {
    public String addComma(String str, String key){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= str.length() - key.length(); i++) {
            int j = 0;
            for (; j < key.length(); j++) {
                if (str.charAt(i + j) != key.charAt(j)) {
                    break;
                }
            }
            if (j == key.length()) {
                sb.append("\"" + key + "\"");
                i = i + j - 1;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addComma("JS haha, JS is a good JS lang.","JS"));
    }
}
