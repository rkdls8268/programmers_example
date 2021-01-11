import java.util.*;

public class Lev6_2_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String res = "";
        String buf = "";

         for (char ch : str.toCharArray()) {
           if (Character.isUpperCase(ch)) {
//               System.out.println(ch);
               buf += ch;
//               System.out.println(buf);
               buf = buf.toLowerCase();
           } else {
               buf += ch;
               System.out.println(buf);

               buf = buf.toUpperCase();
           }
           res += buf;
           buf = "";
         }
         System.out.println(res);
    }
}
