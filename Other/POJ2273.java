//http://poj.org/problem?id=2273
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (true) {
            String str = cin.nextLine();
            if (str.equals("R0C0"))
                break;
            int index = 0;
            while (str.charAt(index) != 'C') {
                index++;
            }
            int a = Integer.parseInt(str.substring(1, index));
            int b = Integer.parseInt(str.substring(index + 1));
            String res = "";
            res = getC(b) + res;
            while (true) {
                if (b / 26.0 > 1) {
                    if (b % 26 != 0) {
                        b = b / 26;
                        res = getC(b) + res;
                    } else {
                        b = b / 26;
                        b--;
                        res = getC(b) + res;
                    }
                } else
                break;
            }
            System.out.println(res + a);
        }
    }

    public static char getC(int letter) {

        if (letter % 26 == 0)
            return 'Z';
        else
            return (char) (letter % 26 + 'A' - 1);
    }

}
