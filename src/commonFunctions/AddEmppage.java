package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddEmppage {
     WebDriver driver;
     public AddEmppage(WebDriver driver)
     {
    	 this.driver = driver;
     }
    // define repository
     @FindBy(xpath = "(//b[normalize-space()='PIM'])[1]")
     WebElement clickpim;
     @FindBy(name = "btnAdd")
     WebElement clickAddBtn;
     @FindBy(name = "firstName")
     WebElement EnterFname;
     @FindBy(name = "middleName")
     WebElement EnterMname;
     @FindBy(name = "lastName")
     WebElement EnterLname;
     @FindBy(name = "employeeId")
     WebElement BeforeEid;
     @FindBy(id = "btnSave")
     WebElement ClickSaveBtn;
     @FindBy(name = "personal[txtEmployeeId]")
     WebElement AfterEid;
     public boolean verifyEmp(String FirstName,String MiddleName,String LastName)
     {
    	 Actions ac = new Actions(driver);
    	 ac.moveToElement(this.clickpim).click().perform();
    	 ac.moveToElement(this.clickAddBtn).click().perform();
    	 this.EnterFname.sendKeys(FirstName);
    	 this.EnterMname.sendKeys(MiddleName);
    	 this.EnterLname.sendKeys(LastName);
    	 String ExpectedEID = this.BeforeEid.getAttribute("value");
    	 this.ClickSaveBtn.click();
    	 String ActualEID = this.AfterEid.getAttribute("value");
    	 if(ExpectedEID.equalsIgnoreCase(ActualEID))
    	 {
    		 Reporter.log("Add Emp Success::"+ExpectedEID+"    "+ActualEID,true);
    		 return true;
    	 }
    	 else
    	 {
    		 Reporter.log("Add Emp Fail::"+ExpectedEID+"   "+ActualEID,true);
    		 return false;
    	 }
    			 
     }
}
