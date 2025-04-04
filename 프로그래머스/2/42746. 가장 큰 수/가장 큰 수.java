import java.util.*;

class Solution {
    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        long cnt = Arrays.stream(arr).filter(s -> s.equals("0")).count();
        if(cnt == arr.length) return "0";

        // 내림차순 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;

                if(str2.compareTo(str1) > 0) {
                    return 1;
                } else if(str1.compareTo(str2) > 0) {
                    return -1;
                } else return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String str : arr) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}