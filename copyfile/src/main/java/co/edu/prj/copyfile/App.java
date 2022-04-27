package co.edu.prj.copyfile;

import co.edu.prj.readers.BufferEx;
import co.edu.prj.readers.FileReaderEx;
import co.edu.prj.readers.FileWriterEx;

public class App {
    public static void main( String[] args ) {
    	// 파일 읽기 실행
        FileReaderEx re = new FileReaderEx(); 
        char[] buffer = re.read(); 
        
        // 파일 출력 실행 
        FileWriterEx we = new FileWriterEx(); 
        we.write(buffer);
        we.writeString(buffer);
        we.writeString2(buffer); 
        
        BufferEx bex = new BufferEx();
        bex.copy(); 
        
    }
}
