package co.edu.prj.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InPutStreamEx {
	
	// 바이트 읽어오기
	public void read() {
		InputStream is = null;
		
		try {	
			is = new FileInputStream("C:\\\\Temp\\\\test.txt");
			while (true) {
				int data = is.read();
				if(data == -1) {
					break;
				}
				System.out.println(data);
			}
			System.out.println("정상적으로 파일을 다 읽었습니다.");
			is.close(); 	
			
		} catch (FileNotFoundException e1) {
			System.out.println("파일을 찾기 못했습니다.");
			e1.printStackTrace();
		} catch (IOException e2) {
			System.out.println("정상적으로 수행되지 못했습니다.");
			e2.printStackTrace();
		}	
	}
	
	// 바이트 배열로 읽고 문자 리터럴로 변환하여 출력 
	public void readAry() {
		InputStream isAry = null;
		
		try {
			isAry = new FileInputStream("C:\\\\Temp\\\\test2.txt");
			// 바이트 배열 선언 
			byte[] buffer = new byte[25];
			
			// 버퍼 단위로 파일 읽기
			while (true) {
				int readByteNum = isAry.read(buffer);
				if (readByteNum == -1) break;
				for (byte buf : buffer) {
					if (buf == 0) break;
					System.out.print(buf + " ");
				}
			}
			
			System.out.println();
			
			// 바이트 배열에 담긴 요소들 문자 리터럴로 캐스팅 
			for (int i = 0; i < buffer.length; i++) {
				if (buffer[i] == 0) break;
				char character = (char)buffer[i];
				System.out.print(character);
			}
			
			System.out.println("\n" + "정상적으로 파일을 다 읽었습니다.");
			
			isAry.close(); 
			
		} catch (FileNotFoundException e1) {
			System.out.println("파일을 찾기 못했습니다.");
			e1.printStackTrace();
			
		} catch (IOException e2) {
			System.out.println("정상적으로 수행되지 못했습니다.");
			e2.printStackTrace();
		}
		
	}

}
