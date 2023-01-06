package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginpage {
//define repository
	@FindBy(name = "txtUsername")
	WebElement EnterUserName;
	@FindBy(name = "txtPassword")
	WebElement EnterPassword;
	@FindBy(name ="Submit")
	WebElement ClickLoginBtn;
	//method for Login
	public void verifyLogin(String username, String password)
	{
		EnterUserName.sendKeys(username);
		EnterPassword.sendKeys(password);
		ClickLoginBtn.click();
	}
}
