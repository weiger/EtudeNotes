import java.util.HashMap;

public class topcoder {
	public int getValue(String key, String code){
		HashMap<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i = 0 ; i < key.length(); i++){
			map.put(key.charAt(i), (i + 1)% 10);
		}
		int res = 0;
		for(int i = 0 ; i < code.length(); i++){
			if(!map.containsKey(code.charAt(i))){
				continue;
			}
			res = res * 10 + map.get(code.charAt(i));
		}
		return res;	
	}
}

