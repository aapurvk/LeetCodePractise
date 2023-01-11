package org.leetcode.practice;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder answer = new StringBuilder();
        Arrays.sort(strs);
        if (strs.length == 1) {
            return strs[0];
        }
        String firstWord = strs[0];
        int i = 0;


        while(i < firstWord.length()) {
            int j = 1;
            boolean matchChar = false;
            while(j < strs.length) {
                if (firstWord.charAt(i) == strs[j].charAt(i)) {
                    matchChar = true;
                } else {
                    if ((i > 1 && !answer.toString().equals("")) ||
                            i > answer.toString().length() - 1) {
                        return answer.toString();
                    }
                    matchChar = false;
                }
                j++;
            }
            if (matchChar) {
                answer.append(firstWord.charAt(i));
            }
            i++;
        }

        return answer.toString();
    }
}