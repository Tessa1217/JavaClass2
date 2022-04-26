package collection;

import listTest.GradeTest;
import listTest.ListTest;
import listTest.MapTest;
import listTest.SetTest;

public class MainApp {
	public static void main(String[] args) {
		
		// String list
		ListTest list = new ListTest();
		
		list.listTest();
		
		list.studentList(); 
		
		SetTest set = new SetTest(); 
		
		set.setTest();
		
		MapTest map = new MapTest(); 
		
		map.mapTest(); 
		
		map.studentMap();
		
		GradeTest exe = new GradeTest();
		
		exe.execute();
	}
}
