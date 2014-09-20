public void shuffle(int[] A){
	for(int i = 0;i<A.length;i++){
	    int j = (int)(Math.random() * (A.length-i)) + i;
	    A[j] = i;
	    A[i] = j;
	 }
}
