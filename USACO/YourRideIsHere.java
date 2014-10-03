    /*
    ID:yixiaom1
    LANG:JAVA
    TASK:ride
    */
    import java.io.*;
    import java.util.*;

    class ride {
        public static void main(String[] args) throws IOException {
        /*BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
            "ride.out")));*/
        Scanner f = new Scanner(new File("ride.in"));
        PrintWriter out = new PrintWriter(new File("ride.out"));
        String s1 = f.nextLine().trim(); // first integer
        String s2 = f.nextLine().trim(); // second integer
        int res1 = 1;
        int res2 = 1;
        int temp;
        for (int i = 0; i < s1.length(); i++) {
            temp = s1.charAt(i) - 'A' + 1;
            res1 = res1 * temp;
        }
        for (int i = 0; i < s2.length(); i++) {
            temp = s2.charAt(i) - 'A' + 1;
            res2 = res2 * temp;
        }
        if (res1 % 47 == res2 % 47)
            out.println("GO");
        else
            out.println("STAY");
        out.close(); 
        }
    }
