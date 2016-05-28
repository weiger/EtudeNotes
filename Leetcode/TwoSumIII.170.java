public class TwoSum {
    HashMap<Integer, Integer> map;
    public TwoSum(){
        map = new HashMap<>();
    }
    // Add the number to an internal data structure.
	public void add(int number) {
	    if (!map.containsKey(number)) {
	        map.put(number, 1);
	    } else {
	        map.put(number, map.get(number) + 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (Map.Entry<Integer, Integer> e: map.entrySet()) {
	        int a = e.getKey();
	        int b = value - a;
	        if (a == b) {
	            if(e.getValue() >= 2) return true;
	        } else {
	            if(map.containsKey(b)) return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);