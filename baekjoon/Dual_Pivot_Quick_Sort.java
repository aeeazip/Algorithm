package baekjoon;

import java.util.Random;

public class Dual_Pivot_Quick_Sort {
	static int TEST_SIZE = 129;
	static int ARRAY_SIZE = 10000;
	static int RANDOM_SIZE = 100;
	
	static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void dualPivotQuickSort(int[] arr,
			int low, int high)
	{
		if (low < high)
		{

			int[] piv;
			piv = partition(arr, low, high);

			if(arr.length > TEST_SIZE) {
				dualPivotQuickSort(arr, low, piv[0] - 1);
				dualPivotQuickSort(arr, piv[0] + 1, piv[1] - 1);
				dualPivotQuickSort(arr, piv[1] + 1, high);
			} else
				insertion_sort(arr);
		}
	}
	static void insertion_sort(int[] arr) {
		int temp = 0, prev = 0;

		for(int i=1; i<arr.length; i++) {
			temp = arr[i];
			prev = i - 1;
			
			while(prev >= 0 && arr[prev] > temp) {
				arr[prev + 1] = arr[prev];
				prev--;
			}
			arr[prev + 1] = temp;	
		}
	}

	static int[] partition(int[] arr, int low, int high)
	{
		if (arr[low] > arr[high])
			swap(arr, low, high);

		int j = low + 1;
		int g = high - 1, k = low + 1,
				p = arr[low], q = arr[high];

		while (k <= g)
		{
			if (arr[k] < p)
			{
				swap(arr, k, j);
				j++;
			}
			else if (arr[k] >= q)
			{
				while (arr[g] > q && k < g)
					g--;

				swap(arr, k, g);
				g--;

				if (arr[k] < p)
				{
					swap(arr, k, j);
					j++;
				}
			}
			k++;
		}
		j--;
		g++;

		swap(arr, low, j);
		swap(arr, high, g);
		return new int[] { j, g };
	}
	
	static int[] newArr(int ARRAY_SIZE) {
		int[] arr = new int[ARRAY_SIZE];
		
		Random random = new Random();
		for(int i=0; i<ARRAY_SIZE; i++) {
			arr[i] = random.nextInt(ARRAY_SIZE);
		}
		return arr;
	}
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		int[] arr = newArr(ARRAY_SIZE);

		dualPivotQuickSort(arr, 0, ARRAY_SIZE-1);

		long finishTime = System.currentTimeMillis();
		long elapsedTime = finishTime - startTime;

		System.out.println();
		System.out.println(elapsedTime);
	}
}
