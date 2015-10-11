public class Solution {

    public static void masterMind(String[] guess, String[] array) {
        int RH = 0;
        int PH = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(guess[i])) {
                RH++;
            } else {
                if (!map.containsKey(array[i])) {
                    map.put(array[i], 1);
                } else {
                    map.put(array[i], map.get(array[i]) + 1);
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (!guess[i].equals(array[i]) && map.containsKey(guess[i])) {
                PH++;
                map.put(guess[i], map.get(guess[i]) - 1);
                if (map.get(guess[i]) == 0) {
                    map.remove(guess[i]);
                }
            }
        }
        System.out.println("Hits: " + RH);
        System.out.println("pseudo Hits: " + PH);
    }

    public static void main(String[] args) {
        String[] g = {"Y", "R", "G", "B"};
        String[] a = {"R", "G", "G", "B"};
        masterMind(g, a);
    }
}
