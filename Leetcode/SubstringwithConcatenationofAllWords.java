public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> res = new ArrayList<>();
        if(S==null || S.length()==0 || L.length==0 || L==null) return res;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i=0;i<L.length;i++){
            if(map.containsKey(L[i]))
                map.put(L[i],map.get(L[i])+1);
            else
                map.put(L[i],1);
        }
        for(int i=0;i<L[0].length();i++){
            HashMap<String,Integer> curMap = new HashMap<String,Integer>();
            int count = 0;
            int left = i;
            for(int j=i;j<=S.length()-L[0].length();j+=L[0].length()){
                String str = S.substring(j,j+L[0].length());
                if(map.containsKey(str)){
                    if(curMap.containsKey(str))
                        curMap.put(str,curMap.get(str)+1);
                    else
                        curMap.put(str,1);
                    if(curMap.get(str)<=map.get(str))
                        count++;
                    else{
                        while(curMap.get(str)>map.get(str)){
                            String temp = S.substring(left,left+L[0].length());
                            curMap.put(temp,curMap.get(temp)-1);
                            left+=L[0].length();
                        }
                    }
                    if(count==L.length){
                        res.add(left);
                        String temp = S.substring(left,left+L[0].length());
                        curMap.put(temp,curMap.get(temp)-1);
                        count--;
                        left+=L[0].length();
                    }
                }else{
                    curMap.clear();
                    count = 0;
                    left = j + L[0].length();
                }
            }
        }
        return res;
    }
}
