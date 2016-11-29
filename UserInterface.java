import java.text.SimpleDateFormat;
import java.util.*;

public class UserInterface {
	private boolean valid = false;
	public int optionChosen = -1;
	
	public UserInterface(){
	}
	
	public void PrintRecord(Date[] record, int count){
		if (count > 0){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			for (int i = 0; i < count; i++){
				System.out.println("Pattern Found: " + sdf.format(record[i]));
			}
		}else{
			System.out.println("Pattern not found.");
		}
	}
	
	//overloading - for the debug purpose
	public void PrintRecord(Date[] record, int count, boolean debugMode, String str){
		if (debugMode){
			System.out.println("---Debug message---");
			System.out.println("Debug purpose: " + str);
			System.out.println("RecordCount. " + count);
		}
			
		if (count > 0){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			for (int i = 0; i < count; i++){
				System.out.println("Pattern Found: " + sdf.format(record[i]));
			}
		}else{
			System.out.println("Pattern not found.");
		}
		System.out.println();
	}
	
	public void OptionValidation(int optionChosen, int minVal, int maxVal, boolean valid){
		if ( (optionChosen <= maxVal) && (optionChosen >= minVal) ) {
			//If optionChosen is in the range
			this.valid = true;
		}else{
			//If optionChosen is not in the range
			this.valid = false;
			System.out.println("Please input an option between 1 to 3.");
			System.out.println();
		}
	}
	
	public void OptionRequest(ReadConfig configData) throws Exception {
		do {
			try{
				Scanner keyboard = new Scanner (System.in);
				System.out.println("1. Hammer");
				System.out.println("2. Three White Soldiers");
				System.out.println("3. Bullish Kicker");
				System.out.print("Pattern: ");
				this.optionChosen = keyboard.nextInt();
				OptionValidation(optionChosen, 1, 3, valid);
				
			}
			catch (Exception e){
				System.out.println("Invalid input, please try again.");
				System.out.println();
				valid = false;
			}
		}
		while (!valid);
	}
}
