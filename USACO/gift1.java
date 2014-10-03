    import java.io.*;
    import java.util.*;

    /*
    ID:yixiaom1
    LANG:JAVA
    TASK:gift1
    */
    public class gift1 {
        public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = new Scanner(new File("gift1.in"));
        PrintWriter cout = new PrintWriter(new File("gift1.out"));
        int num = Integer.parseInt(cin.nextLine());
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        ArrayList<String> lists = new ArrayList<String>();
        for(int i=0;i<num;i++){
            String str = cin.nextLine();
            map.put(str,0);
            lists.add(str);
        }
        for(int i=0;i<num;i++){
            String name = cin.nextLine();
            String moneyandnum = cin.nextLine();
            String[] strs = moneyandnum.split(" ");
            int money = Integer.parseInt(strs[0]);
            int number = Integer.parseInt(strs[1]);
            int single = 0;
            if(number!=0){
            single = money / number;
            map.put(name,map.get(name)-money+money%number);
            }
            for(int j=0;j<number;j++){
            String str = cin.nextLine();
            map.put(str, map.get(str)+single);
            }
        }
        for(int i=0;i<num;i++){
            String str = lists.get(i);
            cout.print(str+" ");
            cout.println(map.get(str));
        }
        cout.close();
        }
    }
