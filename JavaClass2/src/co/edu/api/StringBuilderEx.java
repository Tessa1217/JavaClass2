package co.edu.api;

public class StringBuilderEx {
	public static void main(String[] args) {
		
		// String + 연산자 
		// 새로운 번지가 생기면서 새로운 주소값이 들어감 
		String a = "1";
		String b = "2";
		a = a + b;
		System.out.println(a); // "11"
		
		// 만약 + 연산자로 문자열을 계속적으로 합칠 경우 메모리에 
		// 주소값을 새롭게 생성하면서 메모리 누수 현상 발생 
		// => Stringbuilder() 사용을 통해 메모리 누수 현상 완화
		// buffer 공간을 이용하여 문자열 저장
		
		StringBuilder sb = new StringBuilder(); 
		sb.append("Hello");
		sb.append(" ");
		sb.append("World");
		sb.append("!");
		
		// 출력
		System.out.println(sb);
		System.out.println(sb.toString());
		
		// String split
		String example = "1, 2, 3, 4, 5, 6, 7";
		String[] temp = example.split(", ");
		for(String t : temp) {
			System.out.println(t);
		}	
		
		temp = example.split(", ", 5);
		for(String t : temp) {
			System.out.println(t);
		}
	}
}
