public void shuffle(int[] A){
	for(int i = 0;i<A.length;i++){
	    int j = (int)(Math.random() * (A.length-i)) + i;
	    int tmp = A[j];
	    A[j] = A[i];
	    A[i] = tmp;
	 }
}
