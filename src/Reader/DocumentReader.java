package Reader;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Scanner;

public class DocumentReader {
	public LinkedList<String> ReadLines(String path){
		LinkedList<String> lines = new LinkedList<String>();
		try {		
			File file = new File(path);
			Scanner fileReader = new Scanner(file);
			while (fileReader.hasNextLine()) {
				String record = fileReader.nextLine();
				byte[] bytes = record.getBytes();
				String recordUTF8=new String(bytes,StandardCharsets.UTF_8);
				lines.add(recordUTF8);
			}
			fileReader.close();
		}catch (Exception e){
			
		}
		return lines;
	}
	public String[] splitRecord(String record) {
		String[] temp=record.split(",",3);
		String[] parts = new String [3];
		for (int i =0;i<3;i++) {
			parts[i]="";
		}
		for (int i=0;i<temp.length;i++) {
			parts[i]=temp[i];
		}
		return parts;
		
	}
}
