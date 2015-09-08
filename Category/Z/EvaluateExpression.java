public class Solution {

    public int evaluate(String str){
        Stack<Character> op = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        int i = 0;
        while(i < str.length()){
            char c = str.charAt(i);
            if(c == '['){
                nums.push((int)c);
            }else if(c >= '0' && c <= '9'){
                int j = i;
                while(str.charAt(j) >= '0' && str.charAt(j) <= '9'){
                    j++;
                }
                int val = Integer.parseInt(str.substring(i, j));
                nums.push(val);
                i = j - 1;
            }else if(c == '+' || c == '-' || c == '*' || c == '/'){
                op.push(c);
            }else if(c == ']'){
                int sum = 0;

                List<Integer> list = new ArrayList<>();
                while(nums.peek() != '['){
                    int v = nums.pop();
                    sum += v;
                    list.add(v);
                }

                int a = list.get(list.size() - 1);
                int b = list.get(list.size() - 2);

                sum -= (a + b);

                char opr = op.pop();

                int res = 0;

                if(opr == '+'){
                    res = b + a;
                }else if(opr == '-'){
                    res = b - a;
                }else if(opr == '*'){
                    res = b * a;
                }else if(opr == '/'){
                    res = b / a;
                }

                nums.pop();
                nums.push(res + sum);
            }
            i++;
        }
        return nums.pop();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.evaluate("[+, 1, 2]"));
        System.out.println(s.evaluate("[*, 3, [+, 1, 10]]"));
        System.out.println(s.evaluate("[+, 1000, 1200]"));
        System.out.println(s.evaluate("[/, 6, [+, 1, [*, 1, 1]]]"));
        System.out.println(s.evaluate("[+, 1, 2, 3]"));
        System.out.println(s.evaluate("[+, [*, 1, 2], 3]"));
        System.out.println(s.evaluate("[*, 0, 5]"));
        System.out.println(s.evaluate("[-, 2, 1]"));
        System.out.println(s.evaluate("[*,[*,1,2,3],[*,2,3]]"));
    }
}
