import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        int h = 0;

        while(h < citations[citations.length - 1]) {
            final int nowH = h;
            int index = IntStream.range(0, citations.length)
                    .filter(i -> citations[i] >= nowH)
                    .findFirst()
                    .orElse(-1);

            if(index != -1) {
                int count = citations.length - index; // h번 이상 인용된 논문 개수
                if (count >= h) max = Math.max(max, h);
            }

            h++;
        }

        return max;
    }
}