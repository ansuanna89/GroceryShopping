package constants;

public class Constant {

	
	public static final String ConfigFile =System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	
	public static final String TestDataFile = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	
	
	public static final String ValidCredentialError = "User was unable to login with valid credentials";
	
	public static final String InvalidPasswordError ="User was able to login with Valid username and Invalid Password";
	
	public static final String InvalidUserNameError ="User was able to login with Invalid username and Valid Password";
	
	public static final String InvalidCredentialError = "User was able to login with Invalid credentials";
	
	public static final String UnableToCreateUser ="Unable to create new user";
	
	public static final String SearchedUserNotAvailable ="Searched User is not available in the System!!";
	
	public static final String ResetNotHappened ="Admin User Information header is still displayed, Reset is not happening properly";
	
	public static final String NewsNotCreated ="Unable to create new News, News Success Message is not Displayed!!";
	
	public static final String NewsCreatedSuccessBannerNotDisplayed ="The message 'News Created Successfully' is not displayed !!";
	
	public static final String NewsSearchIsNotWorking ="Search Results are not matching!!!";
}
