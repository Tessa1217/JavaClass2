package co.edu.prj.readers;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterEx {
	
	// buffer 배열을 받아서 파일에 출력 
	public void write(char[] buffer) {
		
		try {
			Writer writer = new FileWriter("C:\\\\Temp\\\\object.txt");
			
			writer.write(buffer);
			
			writer.flush(); 
			writer.close(); 
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		
	}
	
	// buffer 배열을 받아서 문자열로 변환 후 파일에 출력 
	public void writeString(char[] buffer) {
		
		try {
			Writer writer = new FileWriter("C:\\\\Temp\\\\object2.txt");
			
			String content = new String(buffer);
			
			writer.write(content);
			
			writer.flush(); 
			writer.close(); 
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
	}
	
	// buffer 배열을 받아서 문자열로 변환 후 파일에 출력 2
	public void writeString2(char[] buffer) {
		
		try {
			Writer writer = new FileWriter("C:\\\\Temp\\\\object3.txt");
			
			String content = String.valueOf(buffer);
			
			writer.write(content);
			
			writer.flush(); 
			writer.close(); 
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
	}

}
