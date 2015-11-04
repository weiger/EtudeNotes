public class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0 ; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for(Integer i: list1){
            for(Integer j: list2){
                min = Math.min(min, Math.abs(i - j));
            }
        }
        return min;
    }
}


public class WordDistance {
    HashMap<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0 ; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int a = list1.get(i);
            int b = list2.get(j);
            if (a < b) {
                min = Math.min(min, b - a);
                i++;
            } else {
                min = Math.min(min, a - b);
                j++;
            }
        }
        return min;
    }
}
