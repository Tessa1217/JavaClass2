package listTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	
	public void setTest() {
		Set<String> names = new HashSet<String>();
		
		// Add  
		names.add("홍길동");
		names.add("박길동");
		names.add("박길동");
		names.add("홍길동");
		names.add("최길동");
		names.add("박길자");
		// Set(집합)이기 때문에 중복값은 들어가지 않음
		// 인덱스로 관리하지 않기 때문에 순서에 의미가 없음
		
		// Remove
		names.remove("박길자");
		
		// Interface : Iterator<Element> 
		Iterator<String> iterator = names.iterator();
		
		// 출력
		System.out.println("While문 사용");
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		} 
		
		System.out.println();
		
		System.out.println("For Each 구문 사용");
		for(String name : names) {
			System.out.println(name);
		}
		
	}

}
