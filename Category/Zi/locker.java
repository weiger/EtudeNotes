public boolean[] lockerState(int num, int round){
	boolean[] rec = new boolean[num + 1];
	for (int i = 1; i <= round; i++) {
		for (int j = 1; j <= num; j++) {
			if ( j % i == 0) {
				rec[j] = !rec[j];
			}
		}
	}
	return rec;
}
