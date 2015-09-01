class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long v = 0;
        for (int i = 0; i < key.length; i++) {
            v = (v * 33 % HASH_SIZE + key[i] % HASH_SIZE) % HASH_SIZE;
        }
        return (int) v;
    }
};
