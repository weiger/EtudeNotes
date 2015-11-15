public class TwoSum {
    HashMap<Integer, Integer> map;
    public TwoSum(){
        map = new HashMap<>();
    }
    
	public void add(int number) {
	    if (!map.containsKey(number)) {
	        map.put(number, 1);
	    } else {
	        map.put(number, map.get(number) + 1);
	    }
	}

	public boolean find(int value) {
	    for (Map.Entry<Integer, Integer> e: map.entrySet()) {
	        int a = e.getKey();
	        int b = value - a;
	        if (a == b) {
	            if (e.getValue() >= 2) return true;
	        } else {
	            if (map.containsKey(b)) return true;
	        }
	    }
	    return false;
	}
}
