package org.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> romanToIntegerMap = new HashMap<>();
        romanToIntegerMap.put("I",1);
        romanToIntegerMap.put("V",5);
        romanToIntegerMap.put("X",10);
        romanToIntegerMap.put("L",50);
        romanToIntegerMap.put("C",100);
        romanToIntegerMap.put("D",500);
        romanToIntegerMap.put("M",1000);

        int answer = 0;
        int i = 0;

        String[] sArray = s.split("");
        while (i < sArray.length - 1) {
            if (romanToIntegerMap.get(sArray[i]) < romanToIntegerMap.get(sArray[i+1])) {
                answer = answer + (romanToIntegerMap.get(sArray[i+1]) - romanToIntegerMap.get(sArray[i]));
                i = i+2;
            } else {
                answer = answer + romanToIntegerMap.get(sArray[i]);
                i++;
            }
        }

        if (i == sArray.length - 1) {
            answer = answer + romanToIntegerMap.get(sArray[sArray.length - 1]);
        }

        return answer;
    }
}
