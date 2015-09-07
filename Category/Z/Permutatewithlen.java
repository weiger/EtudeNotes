public class Solution {
    public List<String> getList(String str, int len){
        List<String> res = new ArrayList<>();
        if(str == null || str.length() == 0){
            return res;
        }
        char[] arr = str.toCharArray();
        per(res, arr, 0, "", len);
        return res;
    }

    public void per(List<String> res, char[] arr, int pos, String str, int len){
        if(str.length() == len){
            res.add(str);
            return;
        }
        for(int i = pos ; i < arr.length; i++){
            if(str.indexOf(arr[i]) == -1){
                per(res, arr, pos, str + arr[i], len);
            }
        }
    }

    public void com(List<String> res, char[] arr, int pos, String str, int len){
        if(str.length() == len){
            res.add(str);
            return;
        }
        for(int i = pos ; i < arr.length; i++){
            if(str.indexOf(arr[i]) == -1){
                com(res, arr, pos + 1, str + arr[i], len);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().getList("abc", 2));
    }
}
