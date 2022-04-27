package co.edu.prj.app;

import co.edu.prj.stream.InPutStreamEx;
import co.edu.prj.stream.OutPutStreamEx;
import co.edu.prj.stream.ReaderEx;
import co.edu.prj.stream.WriterEx;

public class App {
    public static void main( String[] args ) {

        OutPutStreamEx ose = new OutPutStreamEx();
        ose.run();
        ose.run2(); 
        
        InPutStreamEx ise = new InPutStreamEx();
        ise.read();
        ise.readAry();
    	
    	WriterEx we = new WriterEx();
    	we.writeChar();
    	we.writeString();
        
        ReaderEx re = new ReaderEx();
        re.read();
        re.readBuffer(); 
    	
    }
}
