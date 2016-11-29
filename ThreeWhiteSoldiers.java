import java.util.Date;

public class ThreeWhiteSoldiers {
	final int dataSize = 10000;
	
	public Date[] record = new Date[dataSize];
	public int recordCount = 0;
	
	public Date[] recordCon2 = new Date[dataSize];
	public int recordCon2Count = 0;
	
	public ThreeWhiteSoldiers (ReadCSV data, Boolean debugMode){
		if (debugMode){
			System.out.println("This is ThreeWhiteSoldiers checking.");
		}
		
		//Raw are in reverse chronological order
		/*
						[0] 2014-11-01
						[1] 2014-10-31
						[2] 2014-10-30
		Start here->	[3] 2014-10-29
		//*/
		for (int i = data.elementCount-1; i >= 2; i-- ){
			
			//Condition 1 : check Up market (Close > Open)
			// 3 days are in up market
			if ( (data.close[i] > data.open[i]) &&
				 (data.close[i-1] > data.open[i-1]) &&
				 (data.close[i-2] > data.open[i-2]) )
			{
				
				//Condition 2 : check shape (Litter lower & litter upper)
				// 4 days are in the similar shape
				if ( ((data.body[i] > (data.upper[i]*2)) && (data.body[i] > (data.lower[i]*2))) &&
					 ((data.body[i-1] > (data.upper[i-1]*2)) && (data.body[i-1] > (data.lower[i-1]*2))) &&
					 ((data.body[i-2] > (data.upper[i-2]*2)) && (data.body[i-2] > (data.lower[i-2]*2))) )
				{
					if (debugMode){
						//To ensure the algorithm of 3rd condition is correct, 
						//while there is not data that can fulfill the condition.
						recordCon2[recordCon2Count] = data.date[i-2];
						recordCon2Count++;
					}
					
					//Condition 3 : make comparison with the previous 2 days 
					//(n th's close > n-1 th's close) & (n th's open > n-1 th's open)
					if ( ((data.close[i] < data.close[i-1]) && (data.open[i] < data.open[i-1])) &&
						 ((data.close[i-1] < data.close[i-2]) && (data.open[i-1] < data.open[i-2])) )
						{
						record[recordCount] = data.date[i-2];
						recordCount++;
					}
				}
			}
		}
	}
}
