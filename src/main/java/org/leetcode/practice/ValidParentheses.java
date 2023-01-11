package org.leetcode.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(validParentheses("(]"));
    }

    private static boolean validParentheses(String s) {
        Deque<Character> parenthesesDeque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                parenthesesDeque.push(')');
            else if (c == '{')
                parenthesesDeque.push('}');
            else if (c == '[')
                parenthesesDeque.push(']');
            else if (parenthesesDeque.isEmpty() || parenthesesDeque.pop() != c) // parenthesesDeque.pop() will remove the added parentheses
                return false;
        }
        return parenthesesDeque.isEmpty();
    }
}
