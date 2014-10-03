
import java.io.*;
import java.util.*;

/*
 ID:yixiaom1
 LANG:JAVA
 TASK:friday
 */
 public class friday {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner cin = new Scanner(new File("friday.in"));
        PrintWriter cout = new PrintWriter(new File("friday.out"));
        int num = cin.nextInt();
        int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] res = new int[7];
        int cur = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 12; j++) {
                int w = (12 + cur) % 7;
                res[w]++;
                if (isLeap(i + 1900)) {
                    if (j == 1)
                        cur += days[j] + 1;
                    else
                        cur += days[j];
                } else
                cur += days[j];
            }
        }
        cout.print(res[5]);
        cout.print(" ");
        cout.print(res[6]);
        cout.print(" ");
        cout.print(res[0]);
        cout.print(" ");
        cout.print(res[1]);
        cout.print(" ");
        cout.print(res[2]);
        cout.print(" ");
        cout.print(res[3]);
        cout.print(" ");
        cout.println(res[4]);
        cout.close();
    }

    private static boolean isLeap(int i) {
        if (i % 100 == 0) {
            return i % 400 == 0;
        } else {
            return i % 4 == 0;
        }
    }

}
