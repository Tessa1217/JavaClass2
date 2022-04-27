package co.edu.prj.readers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferEx {
	
	private String source = "C:\\\\Temp\\\\sourcefile.txt";
	private String target = "C:\\\\Temp\\\\targetfile.txt";
	
	public void copy() {
		try {
		InputStream is = new FileInputStream(source);
		BufferedInputStream bis = new BufferedInputStream(is);
		OutputStream os = new FileOutputStream(target);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		while(true) {
			int data = is.read();
			if(data == -1) {
				break;
			}
			os.write(data);
		}
		
		is.close(); 
		bis.close(); 
		os.close(); 
		bos.close(); 
		
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
