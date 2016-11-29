/*	This is the starting point of the whole program,
 	All classes will be called here.
 */

public class IS3230_L05_3 {
	public static String startDateStr;
	public static String endDateStr;
	public static String optionVal;
	
	public static void main(String[] args) throws Exception {
		startDateStr = args[0];
		endDateStr = args[1];
		
		//Read System config 
		//(Contains debugMode, raw data folder name, raw data file name)
		ReadConfig configData = new ReadConfig();
		
		if (configData.debugMode) {
			System.out.println("DebugMode: " + configData.debugMode);
			System.out.println("RawDataFolder: " + configData.rawDataFolder);
			System.out.println("RawDataFile: " + configData.rawDataFile);
			System.out.println("Path: " + configData.getPath());
			System.out.println("startDateStr endDateStr: " + startDateStr + " " + endDateStr);
		}
		
		//Display UserInterface to get the choice from user
		UserInterface ui = new UserInterface();
		ui.OptionRequest(configData);
		
		//Read CSV data
		ReadCSV csvData = new ReadCSV(configData, startDateStr, endDateStr, ui.optionChosen);
		
		//Choose the corresponding class to new
		if (ui.optionChosen == 1){
			Hammer checkHammer = new Hammer(csvData, configData.debugMode);
			if (configData.debugMode){
				String str = "To display the num of record is in hammer pattern.";
				ui.PrintRecord(checkHammer.record, checkHammer.recordCount, configData.debugMode, str);
			}else{
				ui.PrintRecord(checkHammer.record, checkHammer.recordCount);
			}
		}
		
		if (ui.optionChosen == 2){
			ThreeWhiteSoldiers checkTWS = new ThreeWhiteSoldiers(csvData, configData.debugMode);
			if (configData.debugMode){
				String str = "To display those data fulfill the 2nd condition: 2 days pattern in up market + with Litter lower and upper.";
				ui.PrintRecord(checkTWS.recordCon2, checkTWS.recordCon2Count, configData.debugMode, str);
			
				str = "To display those data fulfill the 3rd condition.";
				ui.PrintRecord(checkTWS.record, checkTWS.recordCount, configData.debugMode, str);
			}else{
				ui.PrintRecord(checkTWS.record, checkTWS.recordCount);
			}
		}
		
		if (ui.optionChosen == 3){
			BullishKicker checkBK = new BullishKicker(csvData, configData.debugMode);
			
			if (configData.debugMode){
				String str = "To display those data fulfill the 2nd condition: 3 days pattern in down market + with Litter lower and upper.";
				ui.PrintRecord(checkBK.recordCon2, checkBK.recordCon2Count, configData.debugMode, str);
				
				str = "To display those data fulfill the 3rd condition.";
				ui.PrintRecord(checkBK.record, checkBK.recordCount, configData.debugMode, str);
			}else{
				
				ui.PrintRecord(checkBK.record, checkBK.recordCount);
			}
		}
	}
}
