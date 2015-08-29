/*
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

 * click to show follow up.

 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowonezero = false;
        boolean colonezero = false;
        for(int i = 0;i<matrix[0].length;i++)
            if(matrix[0][i]==0){
                rowonezero = true;
                break;
            }
            
        for(int i = 0;i<matrix.length;i++)
            if(matrix[i][0]==0){
                colonezero = true;
                break;
            }
        
        for(int i = 1;i<matrix.length;i++)
            for(int j = 1;j<matrix[0].length;j++)
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
                
        for(int i = 1;i<matrix[0].length;i++)
            if(matrix[0][i]==0){
                for(int j = 0;j<matrix.length;j++)
                    matrix[j][i] = 0;
            }
                
                    
        for(int i = 1;i<matrix.length;i++)
            if(matrix[i][0]==0){
                for(int j = 0;j<matrix[0].length;j++)
                    matrix[i][j] = 0;
            }
                
        if(rowonezero){
            for(int i=0;i<matrix[0].length;i++)
                matrix[0][i] = 0;
        }  
            
                
        if(colonezero){
            for(int i=0;i<matrix.length;i++)
                matrix[i][0] = 0;
        }
    }
}

//O(m+n)
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0 ; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
