public Cache{
	HashMap<Integer, Integer> map;
	int num;
	public Cache () {
		map = new HashMap<>();
		num = 1;
	}

	public void set(int x) {
		map.put(x, num);
	}

	public void reset(int x) {
		map.remove(x);
	}

	public boolean exists(int x) {
		return map.get(x) != null && map.get(x) == num;
	}

	public void resetAll(){
		num++;
	}
}
