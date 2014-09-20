/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"

 * Minimum window is "BANC".

 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".

 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
 //Good and easy to read, from
 //http://zhongyinzhang.wordpress.com/2014/03/16/minimum-window-substring/
public class Solution {
    public String minWindow(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        for(int i=0;i<tLen;i++)
            needToFind[T.charAt(i)]++;
        int minWindowLen = Integer.MAX_VALUE;
        int minWindowBegin = 0;
        int minWindowEnd = 0;
        int count = 0;
        for(int begin=0,end=0;end<sLen;end++){
            char c = S.charAt(end);
            if(needToFind[c]==0) continue;
            hasFound[c]++;
            if(hasFound[c]<=needToFind[c])
                count++;
            if(count==tLen){
                while(hasFound[S.charAt(begin)]==0 || hasFound[S.charAt(begin)]>needToFind[S.charAt(begin)]){
                    if(hasFound[S.charAt(begin)]>needToFind[S.charAt(begin)])
                        hasFound[S.charAt(begin)]--;
                    begin++;
                }
                int currentLen = end - begin + 1;
                if(currentLen<minWindowLen){
                    minWindowLen = currentLen;
                    minWindowBegin = begin;
                    minWindowEnd = end;
                }
            }
        }
        if(minWindowLen == Integer.MAX_VALUE)
            return "";
        return S.substring(minWindowBegin, minWindowEnd+1);
    }
}

public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		String result = "";
		int sLen = S.length();
		int tLen = T.length();
		int count = 0;
		int minWindowLen = Integer.MAX_VALUE;	
		int[] hasFound = new int[256];
		int[] needToFound = new int[256];
		Arrays.fill(hasFound, 0);
		Arrays.fill(needToFound, 0);
		for(int i = 0; i < tLen; i++)
			needToFound[T.charAt(i)]++;
		
		for(int begin = 0, end = 0; end < sLen; end++) {
			if(needToFound[S.charAt(end)] == 0)
				continue;
			hasFound[S.charAt(end)]++;
			if(hasFound[S.charAt(end)] <= needToFound[S.charAt(end)])
				count++;
			
			if(count == tLen) {
				while(needToFound[S.charAt(begin)] == 0 || 
						hasFound[S.charAt(begin)] > needToFound[S.charAt(begin)]) {
					if(hasFound[S.charAt(begin)] > needToFound[S.charAt(begin)])
						hasFound[S.charAt(begin)]--;
					begin++;
				}
				int windowLen = end - begin + 1;
				if(windowLen < minWindowLen) {
					minWindowLen = windowLen;
					result = S.substring(begin, end + 1);
				}
			}
		}
		return result;
	}
}
//Same Approach
    public String minWindow(String S, String T) {  
        if(S == null || T == null || S.length()==0 || T.length()==0)  
            return "";  
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();  
        for(int i=0;i<T.length();i++)  
        {  
            if(map.containsKey(T.charAt(i)))  
            {  
                map.put(T.charAt(i), map.get(T.charAt(i))+1);  
            }  
            else  
                map.put(T.charAt(i), 1);  
        }  
        int count = 0;  
        int pre = 0;  
        String res = "";  
        int minLen = S.length()+1;  
        for(int i=0;i<S.length();i++)  
        {  
            if(map.containsKey(S.charAt(i)))  
            {  
                map.put(S.charAt(i),map.get(S.charAt(i))-1);  
                if(map.get(S.charAt(i))>=0)  
                    count++;  
                while(count == T.length())  
                {  
                    if(map.containsKey(S.charAt(pre)))  
                    {  
                        map.put(S.charAt(pre),map.get(S.charAt(pre))+1);  
                        if(map.get(S.charAt(pre))>0)  
                        {  
                            if(minLen>i-pre+1)  
                            {  
                                res = S.substring(pre,i+1);  
                                minLen = i-pre+1;  
                            }  
                            count--;  
                        }  
                    }  
                    pre++;  
                }  
            }  
        }  
        return res;  
    }  
