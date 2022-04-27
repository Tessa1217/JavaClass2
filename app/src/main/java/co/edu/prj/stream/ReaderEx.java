package co.edu.prj.stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderEx {
	
	public void read() {
		
		try {
			Reader reader = new FileReader("C:\\\\Temp\\\\test4.txt");
		
			while(true) {
				int data = reader.read(); 
				if(data == -1) break;
				System.out.print((char) data);
			}
		
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	public void readBuffer() {
		
		try {
			Reader reader = new FileReader("C:\\\\Temp\\\\test4.txt");
			char[] buffer = new char[60];
			
			while(true) {
				int readCharNum = reader.read(buffer);
				if(readCharNum != -1) {
					for (int i = 0; i < buffer.length; i++) {
						System.out.print(buffer[i]);
					}
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}

}
