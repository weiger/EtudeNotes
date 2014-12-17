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

import java.math.BigInteger;
class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
    	BigInteger res = new BigInteger("0");
    	for (int i = 0; i < key.length; i++) {
    	    int c = key[i];
    	    BigInteger tmp = new BigInteger("33");
    	    BigInteger ch = new BigInteger(String.valueOf(c));
    	    res = res.add(ch.multiply(tmp.pow(key.length-1-i)));
    	    res = res.mod(new BigInteger(String.valueOf(HASH_SIZE)));
    	}
    	
    	res.mod(new BigInteger(String.valueOf(HASH_SIZE)));
    	return res.intValue();
    }
};
