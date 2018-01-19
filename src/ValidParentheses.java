import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xianeng on 2018/1/19.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("{"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] characters = s.toCharArray();
        for (char c : characters) {
            if(stack.isEmpty()) {
                if(c == '}' || c == ']' || c == ')') {
                    return false;
                }
            } else {
                if(c == '}' || c == ']' || c == ')') {
                    char a = stack.pop();
                    switch (c) {
                        case '}':
                            if (a != '{') {
                                return false;
                            }
                            break;
                        case ')':
                            if (a != '(') {
                                return false;
                            }
                            break;
                        case ']':
                            if (a != '[') {
                                return false;
                            }
                            break;
                    }
                }
            }

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
        }


        return stack.isEmpty();
    }
}
