package co.edu.prj.app;

import java.util.Arrays;

import co.edu.prj.BubbleSort;
import co.edu.prj.SelectionSort;

public class SortingApp {
	
	public static void main(String[] args) {
		
		// 선택 정렬 
		
		SelectionSort selectSort = new SelectionSort();
		
		int[] data = {9, 6, 4, 2, 3, 1, 5, 7, 8, 10};

		selectSort.sort(data);
		
		int[] data2 = {200, 500, 444, 900, 666, 777, 100};
		
		selectSort.sort2(data2);		
		
		int[] data3 = {9, 6, 4, 2, 3, 1, 5, 7, 8, 10};
		
		selectSort.reverseSort(data3);
	
		Arrays.sort(data); // 오른차순 정렬
		System.out.println("===Array.sort 사용===");
		for(int num : data) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		// 버블 정렬
		
		BubbleSort bubbleSort = new BubbleSort();
		
		int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		bubbleSort.sort(arr);
		
		bubbleSort.reverseSort(arr);
		
		

	}

}
