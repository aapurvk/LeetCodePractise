package org.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(1060));

    }

    public static String getAppendedRomanString (Map<Integer, String> romanToIntegerMap, int quotientInNum, int place) {
        StringBuilder romanChar = new StringBuilder();
        if (romanToIntegerMap.containsKey(quotientInNum * place)) {
            romanChar.append(romanToIntegerMap.get(quotientInNum * place));
        } else if (quotientInNum < 4 && quotientInNum != 0) {
            romanChar.append(romanToIntegerMap.get(quotientInNum * place).repeat(quotientInNum));
        } else if (quotientInNum > 5 && quotientInNum < 9) {
            romanChar.append(romanToIntegerMap.get(5 * place));
            romanChar.append(romanToIntegerMap.get(place).repeat(quotientInNum - 5));
        }
        return romanChar.toString();
    }

    public static String intToRoman(int num) {
        if (num <= 0) {
            return null;
        }

        Map<Integer, String> romanToIntegerMap = new HashMap<>();
        romanToIntegerMap.put(1,"I");
        romanToIntegerMap.put(4,"IV");
        romanToIntegerMap.put(5,"V");
        romanToIntegerMap.put(9,"IX");
        romanToIntegerMap.put(10,"X");
        romanToIntegerMap.put(40,"XL");
        romanToIntegerMap.put(50,"L");
        romanToIntegerMap.put(90,"XC");
        romanToIntegerMap.put(100,"C");
        romanToIntegerMap.put(400,"CD");
        romanToIntegerMap.put(500,"D");
        romanToIntegerMap.put(900,"CM");
        romanToIntegerMap.put(1000,"M");

        StringBuilder romanNumber = new StringBuilder();

        if(num >= 1000) {
            int thousandQ = num/1000;
            romanNumber.append(romanToIntegerMap.get(1000).repeat(thousandQ));

            int hundredQ = (num - thousandQ * 1000) / 100;
            romanNumber.append(getAppendedRomanString(romanToIntegerMap, hundredQ, 100));

            int tenQ = (num - thousandQ * 1000 - hundredQ * 100) / 10;
            int tenPlace = tenQ * 10;
            romanNumber.append(getAppendedRomanString(romanToIntegerMap, tenQ, 10));

            int unitQ = (num - thousandQ * 1000 - hundredQ * 100 - tenPlace);
            romanNumber.append(getAppendedRomanString(romanToIntegerMap, unitQ, 1));

        } else if (num < 1000 && num >= 100) {

            int hundredQ = num / 100;
            romanNumber.append(getAppendedRomanString(romanToIntegerMap, hundredQ, 100));

            int tenQ = (num - hundredQ * 100) / 10;
            int tenPlace = tenQ * 10;
            romanNumber.append(getAppendedRomanString(romanToIntegerMap, tenQ, 10));

            int unitQ = (num - hundredQ * 100 - tenPlace);
            romanNumber.append(getAppendedRomanString(romanToIntegerMap, unitQ, 1));

        } else if (num < 100) { //1994
            int tenQ = (num) / 10;
            romanNumber.append(getAppendedRomanString(romanToIntegerMap, tenQ, 10));

            int unitQ = (num - tenQ * 10);
            romanNumber.append(getAppendedRomanString(romanToIntegerMap, unitQ, 1));
        }

        return romanNumber.toString();
    }
}
