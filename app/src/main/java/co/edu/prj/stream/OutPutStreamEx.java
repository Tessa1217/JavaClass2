package co.edu.prj.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutPutStreamEx {
	
	public void run() {
		
		OutputStream os = null;
		
		// 바이트 배열 선언하여 파일에서 출력하기 
		try {
			os = new FileOutputStream("C:\\\\Temp\\\\test2.txt");
			
			byte[] byteAry = {72, 101, 108, 108, 111, 44, 32, 77, 97, 118, 101, 110, 33};
			os.write(byteAry);
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾기 못했습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Failed");
			e.printStackTrace();
		} finally {
			try {		
				os.flush();
				os.close(); 
			} catch (IOException e) {
				e.printStackTrace();
			} 
			
		}
		
	}
	
	public void run2() {
		try {
			
			OutputStream os = new FileOutputStream("C:\\\\Temp\\\\test5.txt");
			
			byte[] byteAry = {'M', 'a', 'v', 'e', 'n'};
			os.write(byteAry);
			
			os.flush(); 
			os.close(); 
			
		} catch (FileNotFoundException e) {
			System.out.println("파일을 찾기 못했습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Failed");
			e.printStackTrace();
		}
	}
	
}
