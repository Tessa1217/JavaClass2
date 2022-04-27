package co.edu.prj.stream;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterEx {
	
	// 문자 리터럴 파일에 출력 
	public void writeChar() {
		
		try {
		Writer writer = new FileWriter("C:\\\\Temp\\\\test3.txt");
		
		char a = 'A';
		char b = 'B';
		char c = 'C';
		
		writer.write(a);
		writer.write(b);
		writer.write(c);
		writer.write(a);
		
		writer.flush();
		writer.close();
		
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			
		} catch (IOException e2) {
			e2.printStackTrace();
			
		}
	}
	
	// 문자열 파일에 출력 
	public void writeString() {
		
		try {
		Writer writer = new FileWriter("C:\\\\Temp\\\\test4.txt");
		
		// 첫번째 문자 리터럴 A
		char character = 'A';
		int characterCode = (int) character;
		
		// 스트링에 문자 리터럴을 순차적으로 담기
		String alphabet = "";
		for (int i = 0; i < 26; i++) {
			alphabet += (character + " ");
			character = (char) ++characterCode;
		}
		
		writer.write(alphabet);
		
		writer.flush();
		writer.close(); 
		
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			
		} catch (IOException e2) {
			e2.printStackTrace();
			
		}
	}
	
}
