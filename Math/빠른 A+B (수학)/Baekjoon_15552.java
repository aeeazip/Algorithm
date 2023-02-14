import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            bw.write(Integer.parseInt(str[0]) + Integer.parseInt(str[1]) + "\n");
        }
        
        bw.flush();
        bw.close();
    }
}