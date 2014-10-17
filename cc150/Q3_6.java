import java.util.PriorityQueue;
import java.util.Random;
import java.util.Stack;

public class Q3_6 {
    public static Stack<Integer> stackSort1(Stack<Integer> stack){
        Stack<Integer> help = new Stack<Integer>();
        while(!stack.isEmpty()){
            int tmp = stack.pop();
            while(!help.isEmpty() && help.peek()>tmp){
                stack.push(help.pop());
            }
            help.push(tmp);
        }
        return help;
    }
    public static void stackSort2(Stack<Integer> stack){
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        while(!stack.isEmpty()){
            q.offer(stack.pop());
        }
        while(!q.isEmpty()){
            stack.push(q.poll());
        }
    }
    public static void main(String[] args) {
        int size = 10;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<size;i++){
            Random rand = new Random();
            stack.push(rand.nextInt(10));
        }
        System.out.println(stack);
    //stack = stackSort1(stack);
        stackSort2(stack);
        System.out.println(stack);

    }

}
