package co.edu.prj;

public class BubbleSort {
	
	
	// 버블 정렬
	public void sort(int[] arr) {
		arrPrint(arr);
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		resultPrint(arr);
	}
	
	// 역순 버블 정렬
	public void reverseSort(int[] arr) {
		arrPrint(arr);
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j] < arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		resultPrint(arr);
	}
	
	// 초기 배열 출력 

	private void arrPrint(int[] arr) {
		System.out.println("버블 정렬");
		System.out.print("| ");
		for(int num : arr) {
			System.out.print(num + " | ");
		}
		System.out.println();
	}
	
	// 정렬된 배열 출력
	
	private void resultPrint(int[] arr) {
		System.out.print("| ");
		for(int num : arr) {
			System.out.print(num + " | ");
		}
		System.out.println();
	}

}
