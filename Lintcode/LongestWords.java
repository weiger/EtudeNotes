class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        ArrayList<String> res = new ArrayList<>();
        int len = 0;
        for(int i = 0; i < dictionary.length; i++){
            if(dictionary[i].length() > len){
                res.removeAll(res);
                len = dictionary[i].length();
                res.add(dictionary[i]);
            }else if(dictionary[i].length() == len){
                res.add(dictionary[i]);
            }
        }
        return res;
    }
};
