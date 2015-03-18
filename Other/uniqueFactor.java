//12 => 1*12, 2*6, 2*2*3， 3*4
public class Solution {
	public static List<List<Integer>> uniqueFactor(int n){
		List<List<Integer>> res = new ArrayList<>();
		if(n <= 0)
			return res;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(n);
		res.add(list);
		list = new ArrayList<>();
		helper(res, list, 2, n);
		return res;
	}
	public static void helper(List<List<Integer>> res, List<Integer> list, int f, int n){
		if(list.size() > 0){
			list.add(n);
			res.add(new ArrayList<>(list));
			list.remove(list.size() - 1);
		}
		for(int i = f ; i <= n / f; i++){
			if(n % i == 0 && n / i >= i){
				list.add(i);
				helper(res,list,i,n / i);
				list.remove(list.size() - 1);
			}
		}
	}
	public static void main(String args[]) throws IOException {
		List<List<Integer>> res = uniqueFactor(48);
		System.out.println(res);
	}	
}
