/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

 * A region is captured by flipping all 'O's into 'X's in that surrounded region .

 * For example,

 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:

 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */
public class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        Queue<Integer> rowQ = new LinkedList<Integer>();
        Queue<Integer> colQ = new LinkedList<Integer>();
        for(int i=0;i<board.length;i++){
        	if(board[i][0] == 'O'){
        		rowQ.offer(i);
        		colQ.offer(0);
        	}
        	if(board[i][board[0].length-1]=='O'){
        		rowQ.offer(i);
        		colQ.offer(board[0].length-1);
        	}	
        }

        for(int i=1;i<board[0].length-1;i++){
        	if(board[0][i]=='O'){
        		rowQ.offer(0);
        		colQ.offer(i);
        	}
        	if(board[board.length-1][i]=='O'){
        		rowQ.offer(board.length-1);
        		colQ.offer(i);
        	}
        }
        while(!rowQ.isEmpty() && !colQ.isEmpty()){
        	int row = rowQ.poll();
        	int col = colQ.poll();
        	board[row][col] = 'Y';
        	if(row>=1 && board[row-1][col] =='O'){
        		rowQ.offer(row-1);
        		colQ.offer(col);
        	}
        	if(row<board.length-1 && board[row+1][col]=='O'){
        		rowQ.offer(row+1);
        		colQ.offer(col);
        	}
        	if(col>=1 && board[row][col-1]=='O'){
        		rowQ.offer(row);
        		colQ.offer(col-1);
        	}
        	if(col<board[0].length-1 && board[row][col+1]=='O'){
        		rowQ.offer(row);
        		colQ.offer(col+1);
        	}

        }
        for(int i=0;i<board.length;i++)
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]=='Y')
        			board[i][j] ='O';
        		else if(board[i][j]=='O')
        			board[i][j] ='X';
        	}

    }
}
