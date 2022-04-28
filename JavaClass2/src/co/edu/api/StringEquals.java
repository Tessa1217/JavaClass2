package co.edu.api;

public class StringEquals {
	
	public static void main(String[] args) {
		
		String a = "1";
		String b = "1";
		
		// 힙 영역에서 같은 주소값을 참조하기에 ==을 써도 True
		if(a == b) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
		// 값을 비교하므로 True
		if(a.equals(b)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
		String c = "3";
		String d = new String("3");
		
		// 같은 1이라는 값을 넣었지만 new String() 생성자를 
		// 통해 인스턴스가 새롭게 생성되었기 때문에 주소값
		
		// 비교하는 ==을 할 경우 False
		if(c == d) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
		if(c.equals(d)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		
	}
}
