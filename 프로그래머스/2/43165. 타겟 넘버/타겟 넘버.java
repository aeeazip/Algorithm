import java.util.*;

class Solution {
    public static int result = 0;
    
    public int solution(int[] numbers, int target) {
        String last = String.valueOf(numbers[numbers.length - 1]);
        checkTarget(numbers.length - 1, numbers, target, last);
        return result;
    }
    
    public static void checkTarget(int start, int[] numbers, int target, String exp) {
        if(start == 0) {
            // 앞에 +/-든 붙이고 연산
            int sum1 = sum("+" + exp);
            int sum2 = sum("-" + exp);

            if(sum1 == target) result++;
            if(sum2 == target) result++;
            return;
        }

        checkTarget(start - 1, numbers, target, numbers[start - 1] + "+" + exp);
        checkTarget(start - 1, numbers, target, numbers[start - 1] + "-" + exp);
    }

    public static int sum(String exp) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < exp.length(); i++) {
            if(exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                int j = i + 1; String num = "";

                while(j <= exp.length() - 1 && exp.charAt(j) != '+' && exp.charAt(j) != '-') {
                    num += String.valueOf(exp.charAt(j++));
                }

                list.add(exp.charAt(i) == '-' ? -1 * Integer.parseInt(num) : Integer.parseInt(num));
                i = j - 1;
            }
        }

        return list.stream().mapToInt(Integer::intValue).sum();
    }
}