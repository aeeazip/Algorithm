import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] list = new int[10000001];
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++)
		    list[i] = Integer.parseInt(br.readLine());
		    
		Arrays.sort(list);
		for(int l : list){
		    if(l!=0)
		        bw.write(l + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
