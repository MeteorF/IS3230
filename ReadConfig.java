import java.io.*;
import java.util.*;

public class ReadConfig {
	
	private String[] temp = new String[10];
	public boolean debugMode;
	public String rawDataFolder;
	public String rawDataFile;
	
	//Constructor
	public ReadConfig() throws IOException {
		
		try{
			String fileName = "config.txt";
			
			File file = new File(fileName);
			Scanner inputFile = new Scanner(file);
			
			int idx = 0;
			
			while (inputFile.hasNext()){
				temp[idx] = inputFile.next();
				idx++;
			}
			inputFile.close();
			
			setDebugMode();
			setRawDataFolder();
			setRawDataFile();
		}catch(FileNotFoundException e){
			System.out.println ("config.txt not found.");
			System.exit(0); //terminate the program
		}
	}
	
	public void setDebugMode() {
		if (temp[0].equals("true")) {
			debugMode = true;
		}else{
			debugMode = false;
		}
	}
	
	public void setRawDataFolder() {
		rawDataFolder = temp[1];
	}
	
	public void setRawDataFile() {
		rawDataFile = temp[2];
	}
	
	public String getPath(){
		return (rawDataFolder + "/" + rawDataFile);
	}
}
