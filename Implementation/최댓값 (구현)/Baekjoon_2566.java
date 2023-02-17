package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_2566 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[9][9];
		for(int i=0; i<9; i++){
		    for(int j=0; j<9; j++)
		        arr[i][j] = sc.nextInt();
		}
		
		int max = -1;
		int mX = -1, mY = -1;
		for(int i=0; i<9; i++){
		    for(int j=0; j<9; j++){
		        if(arr[i][j] > max){
		            max = arr[i][j];
		            mX = i+1;
		            mY = j+1;
		        }
		    }
		}
		
		System.out.println(max);
		System.out.println(mX + " " + mY);
	}
}
