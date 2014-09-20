import java.util.ArrayList;
import java.util.LinkedList;

/*You are given an array of size n. There is a sliding window of size k(<n). 
Return an array containing max element in each window position(from leftmost
window position to rightmost).
Eg.
input: A=4,7,3,6,8,2,4,3,2,5,4 k=4
output:B=7,8,8,8,8,4,5,5*/
public class SlidingWindow {
    public ArrayList<Integer> Solve(int[] A,int k){
	ArrayList<Integer> res = new ArrayList<Integer>();
	LinkedList<Element> list = new LinkedList<Element>();
	list.offer(new Element(A[0],0));
	for(int i=1;i<k;i++){
	    while(A[i]>list.peekLast().val){
		list.pollLast();
		if(list.size()==0)
		    break;
	    }
	    list.offer(new Element(A[i],i));
	}
	for(int i=k;i<A.length;i++){
	    res.add(list.peek().val);
	    if(i-list.peek().index==k){
		list.poll();
	    }
	    while(A[i]>list.peekLast().val){
		list.pollLast();
		if(list.size()==0)
		    break;
	    }
	    list.offer(new Element(A[i],i));
	}
	res.add(list.peek().val);
	return res;
	
    }
    class Element{
	int val;
	int index;
	public Element(int val,int index){
	  this.val = val;
	  this.index = index;
	}
    }
    public static void main(String[] args) {
	int[] A = {4,7,3,6,8,2,4,3,2,5,4};
	ArrayList<Integer> res = new SlidingWindow().Solve(A, 4);
	System.out.println(res);

    }

}
