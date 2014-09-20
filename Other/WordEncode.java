/*example: input  "Home"
output
Home，Hom1，Ho1e，Ho2， H1me， H1m1， H2e ，H3， 1ome ，1om1 ，1o1e 1o2 ，2me ，2m1 ，3e， 4 */

// need to modify with String
public class Solution
{
	public static void encode(String s){
		StringBuffer sb = new StringBuffer(s);
		process(sb,0);
	}
	private static void process(StringBuffer s, int i)
	{	
		if(i==s.length()){
			System.out.print(s+" ");
			return;
		}
		StringBuffer sb = new StringBuffer(s);
		process(sb,i+1);
		if(i==0){
			s.setCharAt(i, '1');
			StringBuffer str = new StringBuffer(s);
			process(str,i+1);
		}else{
			if(!Character.isDigit((s.charAt(i-1)))){
				s.setCharAt(i, '1');
				StringBuffer str = new StringBuffer(s);
				process(str,i+1);
			}else{
				s.setCharAt(i-1, (char) (s.charAt(i-1)+1));
				StringBuffer str = new StringBuffer(s.deleteCharAt(i));
				process(str,i);
			}
		}	
	}
	public static void main(String[] args)
	{
		encode("Home");
		System.out.println();
		encode("This");
	}
}
