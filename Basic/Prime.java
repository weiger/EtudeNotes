public class Prime {
    //Sieve of Eratosthenes
    public static ArrayList<Integer> getPrime(int n){ //under N
    	ArrayList<Integer> res =new ArrayList<Integer>();
    	boolean[] rec = new boolean[n];
    	for(int i=2;i<n;i++){
    	    rec[i] = true;
    	}
    	for(int i=2;i<Math.sqrt(n);i++){
    	    if(rec[i]==true){
    		for(int j=i*i;j<n;j=j+i){
    		    rec[j] = false;
    		    }
    	    }	
    	}
    	for(int i=2;i<n;i++){
    	    if(rec[i])
    		    res.add(i);
    	}
    	return res;
    }
    public static ArrayList<Integer> getNPrime(int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int current = 2;
        int sum = 0;

        while (true) {
            if (current > 2 && current % 2 == 0) {
                current++;
                continue;
            }
            int a = -1;
            for (int i = 2; i < current; i++) {
                if (current % i == 0) {
                    a = 0;
                    break;
                    }
            }
        
            if (a == -1) {
                sum++;
                res.add(current);
                }
    
            if (sum == n) {
                break;
                }
            current++;
        }
        return res;
    }
    public static boolean isPrime(int n) {
        if(n < 0)
            throw new IllegalArgumentException("negative number");
        if(n == 0 || n == 1)
            return false;
        if(n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0)
            return n == 2 || n == 3 || n == 5 || n == 7;
        for(int i = 11; i * i <= n; i += 2) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public static boolean[] isPrimeArray(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for(int i = 2; i * i <= n; i++) {
            if(prime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return prime;
    }

    public static int[] primeList(int n) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        boolean[] list = new boolean[n + 1];
        for(int i = 0; i <= n; i++)
            list[i] = true;
        for(int i = 2; i <= n; i++) {
            if(list[i]) {
                set.add(i);
                for(int j = i * i; j <= n; j += i) {
                    list[j] = false;
                }
            }
        }
        int[] primes = new int[set.size()];
        int i = 0;
        for(int value : set) {
            primes[i++] = value;
        }
        return primes;
    }
}
