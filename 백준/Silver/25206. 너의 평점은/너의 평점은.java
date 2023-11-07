import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        String[][] subjectList = new String[20][3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<20; i++){
            String[] list = br.readLine().split(" ");
            for(int j=0; j<3; j++) {
                subjectList[i][j] = list[j];
            }
        }

        Double total = 0.0;
        Double result = 0.0;

        for(int i=0; i<20; i++) {
            if(subjectList[i][2].equals("P"))
                continue;

            total += Double.parseDouble(subjectList[i][1]);

            if(subjectList[i][2].equals("A+"))
                result += Double.parseDouble(subjectList[i][1]) * 4.5;
            else if(subjectList[i][2].equals("A0"))
                result += Double.parseDouble(subjectList[i][1]) * 4.0;
            else if(subjectList[i][2].equals("B+"))
                result += Double.parseDouble(subjectList[i][1]) * 3.5;
            else if(subjectList[i][2].equals("B0"))
                result += Double.parseDouble(subjectList[i][1]) * 3.0;
            else if(subjectList[i][2].equals("C+"))
                result += Double.parseDouble(subjectList[i][1]) * 2.5;
            else if(subjectList[i][2].equals("C0"))
                result += Double.parseDouble(subjectList[i][1]) * 2.0;
            else if(subjectList[i][2].equals("D+"))
                result += Double.parseDouble(subjectList[i][1]) * 1.5;
            else if(subjectList[i][2].equals("D0"))
                result += Double.parseDouble(subjectList[i][1]) * 1.0;
        }
        System.out.println(result/total);
    }
}