package temaWeek13Lambda.test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import temaWeek13Lambda.main.ReadAndWriteApp;

import static org.junit.Assert.assertTrue;


public class ReadAndWriteAppTest {
	
	@Test
	public void whenExtensionIsNullTest (){
		String input= ReadAndWriteApp.getInput();
		String extension=input.substring(input.lastIndexOf("."));
		assertTrue(extension.contains(".csv"));
	}
	
	@Test
	public void testReadAndWriteMethod() {
		String input="src"+File.separator+"temaWeek13Lambda"+File.separator+"test"+File.separator+"test.csv";
		String output="src"+File.separator+"temaWeek13Lambda"+File.separator+"test"+File.separator+"outputFromTest.csv";
		String month="08";
		ReadAndWriteApp app=new ReadAndWriteApp();
		app.readWriteToFile(input,month,output);
		File file1 = new File("src"+File.separator+"temaWeek13Lambda"+File.separator+"test"+File.separator+"outputFromTest.csv");
		File file2 = new File("src"+File.separator+"temaWeek13Lambda"+File.separator+"test"+File.separator+"outputToTest.csv");
		boolean isTwoEqual=false;
		try{isTwoEqual = FileUtils.contentEquals(file1,file2);
			
			}catch (IOException e){
				e.printStackTrace();
		}
		
		assertTrue(isTwoEqual);
		
	}
}
