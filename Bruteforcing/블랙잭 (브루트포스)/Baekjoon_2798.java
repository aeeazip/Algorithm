import java.util.*;
import java.io.*;

public class Main {
    public static int blackJack(Integer[] card, int n, int m){
        int max = 0;
        
        for(int i=0; i<=n-3; i++){
		    for(int j=i+1; j<=n-2; j++){
		        int total = 0;
		        for(int k=j+1; k<=n-1; k++){
		            total = card[i] + card[j] + card[k];
		            
		            if(total == m)
		                return total;
		            else if(total > m)
		                continue;
		            else if(total > max && total < m)
		                max = total;
		        }
		    }
		}
		
		return max;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split(" ");
		String[] cNum = br.readLine().split(" ");
		
		int n = Integer.parseInt(num[0]);
		int m = Integer.parseInt(num[1]);
		Integer[] card = new Integer[n];
		
		for(int i=0; i<n; i++)
		    card[i] = Integer.parseInt(cNum[i]);
		    
		Arrays.sort(card);
		System.out.println(blackJack(card, n, m));
	}
	
	
}
