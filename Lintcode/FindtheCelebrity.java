/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
//O(N^2)
public class Solution extends Relation {
    public int findCelebrity(int n) {
        for(int i = 0 ; i < n; i++){
            boolean valid = true;
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(knows(i, j) || !knows(j, i)){
                     valid = false;
                     break;
                }
            }
            if(valid){
                return i;
            }
        }
        return -1;
    }
}

//From g4g
public class Solution extends Relation {
    public int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < n; i++){
            stack.push(i);
        }
        int a = stack.pop();
        int b = stack.pop();

        while (stack.size() > 1){
            if (knows(a, b)){
                a = stack.pop();
            } else {
                b = stack.pop();
            }
        }
        int c = a;
        if(knows(a, b)) c = b;
        if(knows(b, a)) c = a;
        
        if(!stack.isEmpty()){
            c = stack.pop();
            if (knows(c, a)) c = a;
            if (knows(c, b)) c = b;
        }

        for (int i = 0 ; i < n; i++){
            if(c == i) continue;
            if(knows(c, i) || !knows(i, c)) return -1;
        }
        return c;
    }
}
