/*POJ 3974 还不太懂
best explanation
http://blog.csdn.net/love_cppandc/article/details/9715195
http://leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
http://blog.sina.com.cn/s/blog_3fe961ae0101iwc2.html
http://blog.sina.com.cn/s/blog_70811e1a01014esn.html
http://blog.csdn.net/geniusluzh/article/details/8639759
*/

import java.util.Scanner;

public class Main {
    public static int fast(String p)
    {
        p = "#"+p;
	int ans = 1;
        for (int i = 1; i<p.length(); ++i)
        {
            int s = i, e = i, t;
            while (e + 1 <p.length()  && p.charAt(e + 1) == p.charAt(i)) ++e;
            i = e;
            while ( e + 1 <p.length() && p.charAt(s - 1) == p.charAt(e + 1)) {--s; ++e;}
            if ((t = e - s + 1) > ans) ans = t;
        }
        return ans;
    }

    public static void main(String[] args) {
	Scanner cin = new Scanner(System.in);
	String str = null;

	int m = 0;
	m = cin.nextInt();
	int[] res = new int[m];
	for (int i = 0; i < m; i++) {
	    str = cin.next();
	    res[i] = fast(str);
	}
	for(int x:res)
	    System.out.println(x);

    }
}





import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int getPalindromeLength(String str) {
    // 1.构造新的字符串
    // 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'，将所有回文变成奇数回文
        StringBuilder newStr = new StringBuilder();
        newStr.append('#');
        for (int i = 0; i < str.length(); i++) {
            newStr.append(str.charAt(i));
            newStr.append('#');
        }

    // rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
        int[] rad = new int[newStr.length()];
    // right表示已知的回文中，最右的边界的坐标
        int right = -1;
    // id表示已知的回文中，拥有最右边界的回文的中点坐标
        int id = -1;
    // 2.计算所有的rad
    // 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。
        for (int i = 0; i < newStr.length(); i++) {
        // 2.1.确定一个最小的半径
            int r = 1;
            if (i <= right) {
                r = Math.min(rad[id] - i + id, rad[2 * id - i]);
            }
        // 2.2.尝试更大的半径
            while (i - r >= 0 && i + r < newStr.length()
                && newStr.charAt(i - r) == newStr.charAt(i + r)) {
                r++;
        }
        // 2.3.更新边界和回文中心坐标
        if (i + r - 1 > right) {
            right = i + r - 1;
            id = i;
        }
        rad[i] = r;
    }

    // 3.扫描一遍rad数组，找出最大的半径
    int maxLength = 0;
    for (int r : rad) {
        if (r > maxLength) {
            maxLength = r;
        }
    }
    return maxLength - 1;
}

public static void main(String[] args) {
    Scanner cin = new Scanner(System.in);
    String str = null;

    int m = 0;
    m = cin.nextInt();
    int[] res = new int[m];
    for (int i = 0; i < m; i++) {
        str = cin.next();
        res[i] = getPalindromeLength(str);
    }
    for(int x:res)
        System.out.println(x);

}
}
