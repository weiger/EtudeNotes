/*
In data structure Hash, hash function is used to convert a string(or any other type) into an integer smaller than hash size and bigger or equal to zero. The objective of designing a hash function is to "hash" the key as unreasonable as possible. A good hash function can avoid collision as less as possible. A widely used hash function algorithm is using a magic number 33, consider any string as a 33 based big integer like follow:

hashcode("abcd") = (ascii(a) * 333 + ascii(b) * 332 + ascii(c) *33 + ascii(d)) % HASH_SIZE 

                              = (97* 333 + 98 * 332 + 99 * 33 +100) % HASH_SIZE

                              = 3595978 % HASH_SIZE

here HASH_SIZE is the capacity of the hash table (you can assume a hash table is like an array with index 0 ~ HASH_SIZE-1).

Given a string as a key and the size of hash table, return the hash value of this key.f

Example
For key="abcd" and size=100, return 78
*/
class Solution {
    public int hashCode(char[] key, int HASH_SIZE) {
        long v = 0;
    
        for (int i = 0; i < key.length; i++) {
            v = (v * 33 % HASH_SIZE + key[i] % HASH_SIZE) % HASH_SIZE;
        }
        return (int) v;
    }
}

//TLE
class Solution {
    public int hashCode(char[] key,int HASH_SIZE) {
    	long res = 0;
    	int len = key.length;
    	for (int i = 0; i < key.length; i++) {
    	    char c = key[i];
    	    long tmp = 1;
    	    int n = len - 1 - i;
    	    while (n >= 1) {
        		tmp *= 33;
        		n--;
        		while (tmp > Integer.MAX_VALUE)
        		    tmp %= HASH_SIZE;
    	    }
    	    res += c * tmp;
    	}
    	return (int) (res % HASH_SIZE);
    }
}
