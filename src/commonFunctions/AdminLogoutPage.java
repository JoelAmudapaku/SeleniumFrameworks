package commonFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogoutPage {
@FindBy(id = "welcome")
WebElement clickWelcom;
@FindBy(linkText = "Logout")
WebElement clickLogout;
public void verifyLogout()
{
	clickWelcom.click();
	clickLogout.click();
}
}
