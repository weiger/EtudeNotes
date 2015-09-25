/*
You are given a binary tree as a sequence of parent-child pairs. For example, the tree represented by the node pairs below:
(A,B) (A,C) (B,G) (C,H) (E,F) (B,D) (C,E)
may be illustrated in many ways, with two possible representations below:
     A
   /   \
  B     C
/  \   /  \
G  D  E   H
       \    
        F       
    A
   /  \
  B    C
/  \   / \
D  G  H   E
         /
        F
Below is the recursive definition for the S-expression of a tree:

S-exp(node) = ( node->val (S-exp(node->first_child))(S-exp(node->second_child))), if node != NULL
                         = "", node == NULL
   where, first_child->val < second_child->val (lexicographically smaller)
This tree can be represented in a S-expression in multiple ways. The lexicographically smallest way of expressing this is as follows:
(A(B(D)(G))(C(E(F))(H)))
We need to translate the node-pair representation into an S-expression (lexicographically smallest one), and report any errors that do not conform to the definition of a binary tree.

The list of errors with their codes is as follows:

Error Code      Type of error
E1                 More than 2 children
E2                 Duplicate Edges
E3                 Cycle present
E4                 Multiple roots
E5                 Any other error   

Input Format:
Input must be read from standard input.
Input will consist of on line of parent-child pairs. Each pair consists of two node names separated by a single comma and enclosed in parentheses. A single space separates the pairs.

Output:. from: 1point3acres.com/bbs 
The function must write to standard output.
Output the given tree in the S-expression representation described above.
There should be no spaces in the output.

Constraints:
There is no specific sequence in which the input (parent,child) pairs are represented.
The name space is composed of upper case single letter (A-Z) so the maximum size is 26 nodes.
Error cases are to be tagged in the order they appear on the list. For example, if one input pair raises both error cases 1 and 2, the output must be E1.

Sample Input #00
(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)
Sample Output #00

(A(B(D(E(G))))(C(F))). 
Sample Input #01
(A,B) (A,C) (B,D) (D,C)
Sample Output #01
E3
Explanation
Node D is both a child of B and a parent of C, but C and B are both child nodes of A. Since D tries to attach itself as parent to a node already above it in the tree, this forms a cycle.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public static class TreeNode{
        char val;
        boolean isVisited;
        TreeNode left, right;
        public TreeNode(char val){
            this.val = val;
            isVisited = false;
            left = right = null;
        }
    }

    private static String helper(TreeNode root){
        if (root == null){
            return "";
        }
        if (root.isVisited){
            return "E3";
        }
        root.isVisited = true;
        String left = helper(root.left);
        String right = helper(root.right);
        if (left.equals("E3") || right.equals("E3")){
            return "E3";
        }
        return "(" + root.val + left + right + ")";
    }

    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner cin = new Scanner(System.in);
        Set<Character> parents = new HashSet<Character>();
        Set<Character> children = new HashSet<Character>();
        Map<Character, TreeNode> total = new HashMap<Character, TreeNode>();
        boolean[] errors = new boolean[5];
        String line = cin.nextLine();
        String[] pairs = line.split(" ");
        for (String s: pairs){
            char parent = s.charAt(1);
            char child = s.charAt(3);
            if (!total.containsKey(parent)){
                total.put(parent, new TreeNode(parent));
            }
            if (!total.containsKey(child)){
                total.put(child, new TreeNode(child));
            }
            if (total.get(parent).left == null){
                total.get(parent).left = total.get(child);
            }else if (total.get(parent).right == null){
                if (total.get(parent).left.val == child){
                    errors[1] = true;
                }
                if (child - total.get(parent).left.val > 0){
                    total.get(parent).right = total.get(child);
                }else{
                    total.get(parent).right = total.get(parent).left;
                    total.get(parent).left = total.get(child);
                }
            }else{
                if (total.get(parent).left.val == child || total.get(parent).right.val == child){
                    errors[1] = true;
                }
                errors[0] = true;
            }
            parents.add(parent);
            children.add(child);
        }
        if (errors[0]){
            System.out.println("E1");
            return;
        }
        if (errors[1]){
            System.out.println("E2");
            return;
        }
        if (total.size() < 1){
            System.out.println("E5");
            return;
        }
        List<TreeNode> roots = new ArrayList<TreeNode>();
        for (Character c: parents){
            if (!children.contains(c)){
                roots.add(total.get(c));
            }
        }
        if (roots.size() > 1){
            errors[3] = true;
        }
        if (roots.size() < 1){
            System.out.println("E3");
            return;
        }
        String rst = null;
        for (TreeNode root: roots){
            rst = helper(root);
            if (rst.equals("E3")){
                System.out.println("E3");
                return;
            }
        }
        if (errors[3]){
            System.out.println("E4");
            return;
        }
        System.out.println(rst);
    }
}
