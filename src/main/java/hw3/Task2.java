package hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import org.apache.logging.log4j.LogManager;

@SuppressWarnings("uncommentedmain")
public class Task2 {

    private Task2() {
    }

    private final static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();

    public static String clusterize(String str) {
        List<String> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        String tmp = "\"";
        int len = str.length();
        boolean stackChecker = true;
        for (int i = 0; i < len && stackChecker; i++) {
            if (str.charAt(i) == '(') {
                tmp = tmp + str.charAt(i);
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ')') {
                if (stack.empty() || stack.pop() != '(') {
                    stackChecker = false;
                } else {
                    tmp = tmp + str.charAt(i);
                }

            } else {
                stackChecker = false;
            }
            if (stack.empty()) {
                list.add(tmp + "\"");
                tmp = "\"";
            }
        }

        return (stackChecker && stack.empty() ? list.toString() : "");
    }

    public static void main(String[] args) {
        String check = clusterize("((()))(())");
        LOGGER.info(check);
    }

}
