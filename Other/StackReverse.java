public class solution
{
	public static void reverse(Stack<Integer> st)
	{
	if (st.isEmpty())
		return;
	else
	{
		Integer temp = st.pop();
		if (st.isEmpty())
		{
			st.push(temp);
			return;
		} else
		{
			st.push(temp);
		}
	}
	int v1 = st.pop();
	reverse(st);
	int v2 = st.pop();
	reverse(st);
	st.push(v1);
	reverse(st);
	st.push(v2);
	}
}
