import java.util.Stack;

public class QueueByOneStack<T>
{
	private Stack<T> st;
	public QueueByOneStack()
	{
		st = new Stack<T>();
	}
	public void addQueue(T t)
	{
		st.push(t);
	}
	public T deleteQueue()
	{
		T t = st.pop();
		if (st.isEmpty())
			return t;
		else
		{
			T s = deleteQueue();
			st.push(t);
			return s;
		}
	}
	public boolean isEmpty()
	{
		return st.isEmpty();
	}
	public static void main(String[] args)
	{
		QueueByOneStack<Integer> qs = new QueueByOneStack<Integer>();
		qs.addQueue(1);
		qs.addQueue(2);
		qs.addQueue(3);
		while (!qs.isEmpty())
		{
			System.out.print(qs.deleteQueue() + " ");
		}
	}
}
