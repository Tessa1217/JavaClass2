package co.edu.prj.readers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderEx {
	
	// 소스 파일 읽기 
	public char[] read() {
		
		char[] buffer = new char[100];
		
		try {
			Reader reader = new FileReader("C:\\\\Temp\\\\sourcefile.txt");
			
			int readCharNum = reader.read(buffer);
			
			reader.close(); 
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		return buffer;
	
	}

}
