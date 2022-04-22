package co.edu.prj;

public class SelectionSort {
	
	private int i;
	private int j;
	private int min;
	
	// 인덱스 값을 이용해 스왑을 줄인 선택 정렬
	
	public void sort(int[] arr) {		
		// 초기데이터 출력 
		arrPrint(arr);
		
		for(i = 0; i < arr.length - 1; i++) {
			min = i; 
			for(j = i + 1; j < arr.length; j++) { // 요소 비교
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			if(min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		
		resultPrint(arr);
	}
		
	// 선택 정렬 
	
	public void sort2(int[] arr) {
		
		arrPrint(arr);
		
		for(i = 0; i < arr.length - 1; i++) {
			for(j = i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		resultPrint(arr);
		
	}
	
	// 내림차순 정렬 
	
	public void reverseSort(int[] arr) {		
		// 초기데이터 출력 
		arrPrint(arr);
		
		for(i = 0; i < arr.length - 1; i++) {
			min = i; 
			for(j = i + 1; j < arr.length; j++) { // 요소 비교
				if(arr[min] < arr[j]) {
					min = j;
				}
			}
			if(min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
		
		resultPrint(arr);
	}
	
	// 초기 배열 출력 
	
	private void arrPrint(int[] arr) {
		System.out.println("선택 정렬");
		System.out.print("| ");
		for(int element : arr) {
			System.out.print(element + " | ");
		}
		System.out.println();
	}
	
	// 정렬된 배열 출력
	
	private void resultPrint(int[] arr) {
		System.out.print("| ");
		for(int element : arr) {
			System.out.print(element + " | ");
		}
		System.out.println();
	}
		
}
