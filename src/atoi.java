/**
 * Created by xianeng on 2018/1/19.
 */
public class atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("    010"));
    }

    public static int myAtoi(String str) {
        try {
            return Integer.parseInt(str.replace(" ",""));
        } catch (Exception e) {
            System.out.println("sdfsdf");
            return 0;
        }

//        return a;

    }
}
