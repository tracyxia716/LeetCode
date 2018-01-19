import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by xianeng on 2018/1/16.
 */
public class LongestSubstring {
    public static void main(String[] args) {
//        System.out.println("abcd".substring());
//        System.out.println("abcde".split("").length);
//        Map<String,String> map = new HashMap<>();
//        map.put("aaa","bbb");
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring("b"));
//        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                max = Math.max(max, i - map.get(c));
            } else {
                System.out.println(c+" :"+map.size());
                map.put(c, i);
                max = Math.max(max, map.size());
            }
        }

        return max;
    }
}
