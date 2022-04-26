package listTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GradeTest {
	
	Scanner scn = new Scanner(System.in);
	Map<String, Integer> grades = new HashMap<String, Integer>();
	
	public void execute() {
		addGrade(); 
		listGrade(); 
	}
	
	private void addGrade() {
		
		// 학생의 이름을 키로 받고 점수를 값으로 맵에 저장 
		for(int i = 0; i < 5; i++) {
			System.out.println("학생 이름 >>> ");
			String name = scn.nextLine(); 
			System.out.println("학생 점수 >>> ");
			int grade = Integer.parseInt(scn.nextLine());
			grades.put(name, grade);		
		
		}
	}
	
	private void listGrade() {
		
		// 키를 세트로 저장 
		Set<String> keySet = grades.keySet(); 
		// 키 반복자 생성
		Iterator<String> keyIterator = keySet.iterator(); 
		int sum = 0; 
		
		// 각 학생들의 점수 출력과 평균 점수 출력을 위해 sum에 값 누적 
		while(keyIterator.hasNext()) {
			String key = keyIterator.next(); 
			int grade = grades.get(key);
			System.out.println(key + " 점수 : " + grade + "점");
			sum += grade;
		}
		
		// 전체 학생들의 평균 점수 출력
		System.out.println("전체 학생들의 평균 : " + (sum/keySet.size() * 1.0));
		
	}
	
	
}
