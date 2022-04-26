package listTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import collection.dto.StudentVO;

public class MapTest {
	
	public void mapTest() {
		Scanner scn = new Scanner(System.in);
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println();
		
//		for(int i = 0; i < 3; i++) {
//			System.out.println("키");
//			String key = scn.nextLine(); 
//			System.out.println("값");
//			String value = scn.nextLine(); 
//			map.put(key, value);
//		}
		
		map.put("address", "대구광역시");
		
		Set<String> keySet = map.keySet(); 
		Iterator<String> keyIterator = keySet.iterator();
		
		System.out.println("키만 세트로");
		while(keyIterator.hasNext()) {
			String key = keyIterator.next(); 
			System.out.println(map.get(key));
		}
		System.out.println();
		
		System.out.println("키와 값 모두 세트로");
		Set<Map.Entry<String, String>> entrySet = map.entrySet(); 
		Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry<String, String> entry = entryIterator.next(); 
			String key = entry.getKey(); 
			String value = entry.getValue(); 
			System.out.println(key + ":" + value);
		}
	}
	
	public void studentMap() {
		
		Map<StudentVO, Integer> map = new HashMap<StudentVO, Integer>();
		List<StudentVO> studentList = ListTest.list();
		map.put(studentList.get(0), 95);
		map.put(studentList.get(1), 100);
		
		// Key Set 
		Set<StudentVO> keySet = map.keySet(); 
		Iterator<StudentVO> keyIterator = keySet.iterator(); 
		while(keyIterator.hasNext()) {
			System.out.println(map.get(keyIterator.next()));
		}
		
		// Key-Value Set
		Set<Map.Entry<StudentVO, Integer>> entrySet = map.entrySet(); 
		Iterator<Map.Entry<StudentVO, Integer>> entryIterator = entrySet.iterator(); 
		while(entryIterator.hasNext()) {
			Map.Entry<StudentVO, Integer> entry = entryIterator.next(); 
			StudentVO key = entry.getKey(); 
			Integer value = entry.getValue(); 
			System.out.println(key.toString());
			System.out.println("점수: " + value);
			System.out.println();
		}
		
	}

}
