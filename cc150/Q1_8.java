public class Q1_8 {
    public static boolean isRotation(String s1, String s2) {
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() == s2.length()) {
            String s3 = s1 + s1;
            if (s3.indexOf(s2) >= 0)
                return true;
            else
                return false;
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] pairs = { { "apple", "pleap" },
        { "waterbottle", "erbottlewat" }, { "camera", "macera" },{"abc","bbc"} };
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);

        }
    }
}
