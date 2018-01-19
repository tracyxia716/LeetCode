/**
 * Created by xianeng on 2018/1/18.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(2147483647));
        System.out.println(reverse(78591));
    }


    public static int reverse(int x) {
        int num = 0;

        while(x != 0) {
            int y = x % 10;
            int newnum = num * 10 + (x % 10);
            x = x / 10;
            if((newnum - y) / 10 == num) {
                num = newnum;
            } else {
                num = 0;
                break;
            }
        }



        return num;
    }
}
