import java.util.*;
import java.io.*;

public class Main {
    /* case 1) 시간 초과 발생
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++)
		    list.add(sc.nextInt());
		    
		Collections.sort(list);
		for(int i=0; i<n; i++)
		    System.out.println(list.get(i));
	}
	*/
	
	/* case 2) 시간 초과 발생
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++)
		    list.add(Integer.parseInt(br.readLine()));
		    
		Collections.sort(list);
		for(Integer i : list)
		    System.out.println(i);
	}
	*/
	
	// case 3 
	public static void main(String[] args) throws IOException {
	    Scanner sc = new Scanner(System.in);
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<n; i++)
		    list.add(sc.nextInt());
		    
		Collections.sort(list);
		for(Integer i : list)
		    bw.write(i+"\n");
		    
		bw.flush();
		bw.close();
	}
}
