import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = bfs(begin, target, words);
        return answer;
    }
    
    public static int bfs(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{ -1, 0 });

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0] != -1) {
                if(target.equals(words[now[0]])) {
                    return now[1];
                }
            }

            for(int i = 0; i < words.length; i++) {
                String str = (now[0] == -1) ? begin : words[now[0]];
                if(!visited[i] && isDifferOne(words[i], str)) {
                    visited[i] = true;
                    queue.add(new int[]{ i, now[1] + 1 });
                }
            }
        }

        return 0;
    }

    public static boolean isDifferOne(String s1, String s2) {
        int count = 0;

        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
        }

        return count == 1;
    }
}