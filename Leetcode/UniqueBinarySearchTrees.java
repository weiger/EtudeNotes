/*
 * Given n, how many structurally unique BST's (binary search trees) that store 
 * values 1...n?

 * For example,
 * Given n = 3, there are a total of 5 unique BST's.

 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 */
/*Example: n = 4 node: 1 2 3 4
  res[4] = 1*(234) + (1)*2*(34)+(12)*3*(4) + (123)*4  -- 0*(1234) (1234)*0 impossible null can't be root 
  res[4] = res[0] * res[3] + res[1]*res[2] + res[2]*[1] + res[3]*[0];
  res[0],res[1] repsents only one node
*/
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        for(int i = 2; i <= n; i++) 
            for(int j = 0; j < i; j++) 
                result[i] += result[j] * result[i - 1 - j];
        return result[n];
    }

/********************updated 2013/11/19 ***********************/

    public int numTrees(int n) {
        if(n == 0 || n == 1)
            return 1;
        int num = 0;
        for(int i = 0; i < n; i++) 
            num += numTrees(i) * numTrees(n - 1 - i);
        return num;
    }
}
