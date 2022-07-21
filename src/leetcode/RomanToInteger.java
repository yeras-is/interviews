package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// task 13
public class RomanToInteger {

        private final List<String> doubledINumberList = new ArrayList(Arrays.asList("V", "X"));
        private final List<String> doubledXNumberList = new ArrayList(Arrays.asList("L", "C"));
        private final List<String> doubledCNumberList = new ArrayList(Arrays.asList("D", "M"));

        public int romanToInt(String s) {
            int index = 0;
            int length = s.length()-1;
            int sum = 0;
            String[] array = s.split("");

            while (index <= length) {
                String letter = array[index];
                boolean hasNext = index < length;
                if (letter.equals("I") && hasNext) {
                    String nextLetter = array[index + 1];
                    if (doubledINumberList.contains(nextLetter)){
                        sum+=mapper(letter.concat(nextLetter));
                        index++;
                    }else{
                        sum+=mapper(letter);
                    }
                } else if (letter.equals("X") && hasNext) {
                    String nextLetter = array[index + 1];
                    if (doubledXNumberList.contains(nextLetter)){
                        sum+=mapper(letter.concat(nextLetter));
                        index++;
                    }else{
                        sum+=mapper(letter);
                    }
                } else if (letter.equals("C") && hasNext) {
                    String nextLetter = array[index + 1];
                    if (doubledCNumberList.contains(nextLetter)){
                        sum+=mapper(letter.concat(nextLetter));
                        index++;
                    }else{
                        sum+=mapper(letter);
                    }
                } else {
                    sum += mapper(letter);
                }
                index++;
            }
            return sum;
        }

//    private void


        private int mapper(String romanNumber) {
            switch (romanNumber) {
                case "I":
                    return 1;
                case "V":
                    return 5;
                case "X":
                    return 10;
                case "L":
                    return 50;
                case "C":
                    return 100;
                case "D":
                    return 500;
                case "M":
                    return 1000;
                case "IV":
                    return 4;
                case "IX":
                    return 9;
                case "XL":
                    return 40;
                case "XC":
                    return 90;
                case "CD":
                    return 400;
                case "CM":
                    return 900;
                default:
                    return 0;
            }

        }

}
