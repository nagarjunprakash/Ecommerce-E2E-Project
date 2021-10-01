package utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringIntegerUtils {

	
	
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString.toLowerCase();
	}
	
	
//	public static int randomInteger(){
//		
//		String generatedInteger=RandomStringUtils.randomNumeric(10);
//	
//		return	Integer.parseInt(generatedInteger);
//	}
	
public static int randomIntegerRtInt(){
		
		String generatedInteger=RandomStringUtils.randomNumeric(10);
	
		return	Integer.parseInt(generatedInteger);
	}

public static String randomIntegerRtString(){
	
	String generatedInteger=RandomStringUtils.randomNumeric(10);

	return	generatedInteger;
}
	
	
	public static String randomAlphaNumeric()
	{
		
		String generatedAlphaNumeric=RandomStringUtils.randomAlphanumeric(10);
		
		return	generatedAlphaNumeric;
	}
	
	
	
	
	
	

}
