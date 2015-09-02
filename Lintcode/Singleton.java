class Solution {
    /**
     * @return: The same instance of this class every time
     */
    static Solution s;
    private Solution(){
        
    }
    public static Solution getInstance() {
        // write your code here
        if(s == null){
            s = new Solution();
            return s;
        }else{
            return s;
        }
    }
};
