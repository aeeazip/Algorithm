import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {    
    
    static ArrayList<Integer> list;
    static boolean[] visited;
    static int[] num;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // n개의 정수를 입력
        int n = scan.nextInt();
        num = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            num[i] = scan.nextInt();
        }
        
        // 순서대로 사이클이 발생하는지 dfs로 확인
        list = new ArrayList<>();
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        
        Collections.sort(list); // 오름차순 정렬
        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }    
    
    public static void dfs(int start, int target) {
        if(!visited[num[start]]) {
            visited[num[start]] = true;
            dfs(num[start], target);
            visited[num[start]] = false;
        }
        
        if(num[start] == target) 
            list.add(target); // 사이클 발생시 해당 숫자를 list에 담기
    }
}
