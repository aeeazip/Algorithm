import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int T = Integer.parseInt(input[1]);

        Set<Point> hole = new HashSet<>();
        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            hole.add(new Point(x, y));
        }

        int[] dX = { -2, -1, 0, 1, 2 };
        int[] dY = { -2, -1, 0, 1, 2 };

        Map<Point, Integer> map = new HashMap<>(); // distance 저장
        map.put(new Point(0, 0), 0);

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while(!queue.isEmpty()) {
            Point point = queue.poll();

            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(dX[i] == 0 && dY[j] == 0) continue; // 같은 위치

                    int newdX = point.x + dX[i];
                    int newdY = point.y + dY[j];

                    // 조건을 만족하는 홈인지 체크 + 방문 안했는지
                    if(!map.containsKey(new Point(newdX, newdY))
                            && Math.abs(newdX - point.x) <= 2 && Math.abs(newdY - point.y) <= 2
                            && hole.contains(new Point(newdX, newdY))) {
                        int now = map.get(new Point(point.x, point.y)) + 1;
                        map.put(new Point(newdX, newdY), now); // distance 계산
                        queue.add(new Point(newdX, newdY));
                    }
                }
            }
        }

        // Map에 Key가 (x, T)인게 없으면 -1
        // 있으면 그 중 가장 작은값 넣기

        int min = Integer.MAX_VALUE;
        for(Map.Entry<Point, Integer> entry : map.entrySet()) {
            Point point = entry.getKey();

            if(point.y == T) {
                min = Math.min(min, map.get(point));
            }
        }

        if(min == Integer.MAX_VALUE) {
            System.out.print("-1");
        } else {
            System.out.print(min);
        }
    }
}