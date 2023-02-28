import java.util.*;
import java.io.*;

public class Main {
    public static boolean isConstructor(String n, int decomposition){
        String[] num = n.split("");
        int total = Integer.parseInt(n);
        
        for(int i=0; i<num.length; i++)
            total += Integer.parseInt(num[i]);
            
        if(total == decomposition)
            return true;
        return false;
    }
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String num = br.readLine();
		int digits = num.length();
	    int result = 0;
	    int n = Integer.parseInt(num);
	    
	    for(int i=n-digits*9; i<n; i++){
	        if(i < 0) i = 0;
	        
	        if(isConstructor(String.valueOf(i), n)){
	            result = i;
	            break;
	        }
	    }
	    System.out.println(result);
	}

}
