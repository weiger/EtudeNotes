/* 
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 */
 
//easy brutal
public class Solution {
    public String strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0 || haystack.equals(needle))
            return haystack;
        for(int i=0;i<=haystack.length()-needle.length();i++)
            for(int j=0;needle.charAt(j)==haystack.charAt(i+j);j++)
                if(j==needle.length()-1)
                    return haystack.substring(i);
        return null;
    }
}
public class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0 || haystack.equals(needle))
            return 0;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            for(int j=0;j<needle.length();j++){
                if(needle.charAt(j)!=haystack.charAt(i+j))
                    break;
                if(j==needle.length()-1)
                    return i;
            }
        }
        return -1;
    }
}
//brutal 1
public class ImplementstrStr {
    public String strStr(String haystack, String needle) {
        if(needle.length() == 0 || haystack.equals(needle))
            return haystack;
        int i = 0, j = 0;
        for(; i <= haystack.length() - needle.length() && j < needle.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                for(; j < needle.length(); j++) {
                    if(haystack.charAt(i + j) != needle.charAt(j)) {
                        j = 0;
                        break;
                    }
                }
            }
        }
        return j == needle.length() ? haystack.substring(i - 1) : null;
    }
}
//brutal 2
public static String strStr(String haystack, String needle) {
	if (needle.length() == 0 || needle.equals(haystack))
	    return haystack;
	int i = 0;
	int j = 0;
	for (; i <= haystack.length() - needle.length(); i++) {
	    for (; j < needle.length(); j++) {
		if (haystack.charAt(i + j) != needle.charAt(j))
		    break;
	    }
	    if (j == needle.length())
		return haystack.substring(i);
	    else
		j = 0;
	}
	return null;
    }
//Brutal3
public class Solution {
    public String strStr(String haystack, String needle){
        if(needle==null ||needle.length()==0|| haystack.equals(needle))
            return haystack;
        for(int i=0;i<haystack.length()-needle.length();i++)
            for(int j=0;j<needle.length();j++){
                if(j==needle.length()-1 && haystack.charAt(i+j)==needle.charAt(j))
                    return haystack.substring(i);
                if(haystack.charAt(i+j)!=needle.charAt(j))
                    break;
            }
        return null;
                
    }
}
//kmp
public class Solution {
    public String strStr(String haystack, String needle) {
        if(needle.length()==0 || needle.equals(haystack))
	           return haystack;
        int[] next = makeNext(needle);
    	for(int i=0,j=0;i<haystack.length();i++){
    	    while(j>0 && needle.charAt(j)!=haystack.charAt(i))
    		j = next[j-1];
    	    if(needle.charAt(j)==haystack.charAt(i))
    		j++;
    	    if(j==needle.length())
    		return haystack.substring(i-j+1);
    	}
    	return null;
    }
    public static int[] makeNext(String pattern){
    	int[] next = new int[pattern.length()];
    	next[0] = 0;
    	for(int i=1,j=0;i<next.length;i++){
    	    while(j>0 && pattern.charAt(j)!=pattern.charAt(i))
    		j = next[j-1];
    	    if(pattern.charAt(j)==pattern.charAt(i))
    		j++;
    	    next[i] = j;
    	}
    	return next;
    }
}
//Automation kmp,sometimes it could be accepted,sometime TLE
public class Solution {
    public String strStr(String haystack, String needle){
	if(needle.length()==0 || needle.equals(haystack))
	           return haystack;
	int M = needle.length();
        int N = haystack.length();
        int[][] dfa = makeDfa(needle);
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[haystack.charAt(i)][j];
        }
        if (j == M) return haystack.substring(i - M);    // found
        return null;  
    }
    public int[][] makeDfa(String pattern){
	    int R = 256;
        // build DFA from pattern
        int M = pattern.length();
        int[][] dfa = new int[R][M]; 
        dfa[pattern.charAt(0)][0] = 1; 
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) 
                dfa[c][j] = dfa[c][X];     // Copy mismatch cases. 
            dfa[pattern.charAt(j)][j] = j+1;   // Set match case. 
            X = dfa[pattern.charAt(j)][X];     // Update restart state. 
        } 
        return dfa;
    }
}
//BoyerMoore
public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle.equals(haystack))
	    return haystack;
    	int R = 256;
    	// position of rightmost occurrence of c in the pattern
    	int[] right = new int[R];
    	for (int c = 0; c < R; c++)
    	    right[c] = -1;
    	for (int j = 0; j < needle.length(); j++)
    	    right[needle.charAt(j)] = j;
    	int M = needle.length();
    	int N = haystack.length();
    	int skip;
    	for (int i = 0; i <= N - M; i += skip) {
    	    skip = 0;
    	    for (int j = M - 1; j >= 0; j--) {
    		if (needle.charAt(j) != haystack.charAt(i + j)) {
    		    skip = Math.max(1, j - right[haystack.charAt(i + j)]);
    		    break;
    		    }
    	    }
    	    if (skip == 0)
    		return haystack.substring(i); // found
    	}
    	return null; // not found
    }
}
//short RK
public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack.equals(needle) || needle.length()==0)
            return haystack;
        if(haystack.length()<needle.length())
            return null;
        long Q = java.math.BigInteger.probablePrime(31, new java.util.Random()).longValue();
        int M = needle.length();
        int N = haystack.length();
        int R = 256;
        long RM = 1;
        for(int i=1;i<M;i++){
            RM = (RM * R)%Q;
        }
        long patternhash = hash(needle,M,R,Q);
        long txthash = hash(haystack,M,R,Q);
        if(patternhash==txthash)
            return haystack;
        for(int i=M;i<N;i++){
            txthash = (txthash + Q - RM*(haystack.charAt(i-M))%Q)%Q;
            txthash = (txthash * R + haystack.charAt(i))%Q;
            if(patternhash==txthash)
                return haystack.substring(i-M+1);
        }
        return null;
    }
    public long hash(String str,int M,int R,long Q){
        long h = 0;
        for(int i=0;i<M;i++){
            h = (R * h + str.charAt(i))%Q;
        }
        return h;
    }
}
//RabinKarp
public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle.equals(haystack))
	    return haystack;
	if(haystack.length()<needle.length()) 
	    return null;
    	int R = 256;
    	int M = needle.length();
    	int N = haystack.length();
    	long Q = java.math.BigInteger.probablePrime(31, new java.util.Random()).longValue();
    	// precompute R^(M-1) % Q for use in removing leading digit
    	long RM = 1;
    	for (int i = 1; i <= M - 1; i++)
    	    RM = (R * RM) % Q;
    	long needleHash = hash(needle, M, R, Q);
    	long haystackHash = hash(haystack, M, R, Q);
    
    	// check for match at offset 0
    	if ((needleHash == haystackHash) && check(haystack, needle, 0))
    	    return haystack;
    
    	// check for hash match; if hash match, check for exact match
    	for (int i = M; i < N; i++) {
    	    // Remove leading digit, add trailing digit, check for match.
    	    haystackHash = (haystackHash + Q - RM * haystack.charAt(i - M) % Q)
    		    % Q;
    	    haystackHash = (haystackHash * R + haystack.charAt(i)) % Q;
    
    	    // match
    	    int offset = i - M + 1;
    	    if ((needleHash == haystackHash) && check(haystack, needle, offset))
    		return haystack.substring(i - M + 1);
	}
	// no match
	return null;
    }
    
    // Compute hash for key[0..M-1].
    private static long hash(String key, int M, int R, long Q) {
    	long h = 0;
    	for (int j = 0; j < M; j++)
    	    h = (R * h + key.charAt(j)) % Q;
    	return h;
    }

    private static boolean check(String txt, String pat, int i) {
    	for (int j = 0; j < pat.length(); j++)
    	    if (pat.charAt(j) != txt.charAt(i + j))
    		return false;
    	return true;
    }
}
//Horspool
public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle.equals(haystack))
	        return haystack;
	    if (haystack.length() < needle.length())
	        return null;
        int M = needle.length();
        int N = haystack.length();
	    int R = 256;
	    int[] d = new int[R];  
        int i, pos, j;  
      
        for(i = 0; i < R; i++)  
            d[i] = M;  
        for(i = 0; i < M-1; i++)  
            d[needle.charAt(i)] = M-i-1;      
        pos = 0;  
        while(pos < (N-M)){  
            j = M-1;  
            while(j >= 0 && haystack.charAt(pos+j)==needle.charAt(j))  //matching  
                j--;  
            if(j == -1)
                return haystack.substring(pos);  
            else //not matched  
        	pos += d[haystack.charAt(pos+M-1)];  
        } 
        return null;  
    }
}
//Sunday
public class Solution {
    public String strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle.equals(haystack))
	    return haystack;
	if (haystack.length() < needle.length())
	    return null;
	int M = needle.length();
	int N = haystack.length();
	int R = 256;
	int[] next = new int[R];
	for (int j = 0; j < R; ++j)
	    next[j] = M + 1;
	for (int j = 0; j < M; ++j)
	    next[needle.charAt(j)] = M - j;
	int pos = 0;
	while (pos < (N - M))
	{
	    int i = pos;
	    int j;
	    for (j = 0; j < M; ++j, ++i) {
		if (haystack.charAt(i) != needle.charAt(j)) {
		    pos += next[haystack.charAt(pos+M)];
		    break;
		}
	    }
	    if (j == M)
		return haystack.substring(pos);
	}
	return null;
    }
}
