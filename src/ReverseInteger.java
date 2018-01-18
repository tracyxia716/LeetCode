import java.util.ArrayList;
import java.util.List;

/**
 * Created by xianeng on 2018/1/18.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }


    public static int reverse(int x) {
        int num = 0;
        int temp = x;

        List<Integer> list = new ArrayList<>();
        while(temp != 0) {
            list.add(temp % 10);
            temp = temp / 10;
        }

        for(int i = 0;i<list.size();i++) {
            num = (int) (num + list.get(i) * Math.pow(10, list.size() - i - 1));
        }

        if(num == Integer.MAX_VALUE || num == Integer.MIN_VALUE) {
            num = 0;
        }

        return num;
    }
}
