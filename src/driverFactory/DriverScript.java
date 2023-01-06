package driverFactory;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.Test;
import commonFunctions.FunctionLibrary;
import config.AppUtil;
import utilities.ExcelFileUtil;
public class DriverScript extends AppUtil{
	String inputpath = "D:\\JoeSelenium1\\Primus_bank\\DataDriven_Framework\\TestInput\\TestData.xlsx";
	String outputpath = "D:\\JoeSelenium1\\Primus_bank\\DataDriven_Framework\\TestOutput\\DataDrivenResults.xlsx";
	@Test
	public void startTest()throws Throwable
	{
		//create object for excelfile util class
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//count no of rows in Login sheet
		int rc = xl.rowcount("Login");
		Reporter.log("No of rows in a sheet::"+rc,true);
		for(int i=1;i<=rc;i++) {
			String user = xl.getcelldata("Login", i, 0);
			String pass = xl.getcelldata("Login", i, 1);
			//call Login methods
			boolean res = FunctionLibrary.verifyLogin(user,pass);
			if(res)
			{
				//if res true write as login success into Results cell
				xl.setcelldata("Login", i, 2, "Login success", outputpath);
				xl.setcelldata("Login", i, 3," pass", outputpath);
				
			}
			else {
				//take screen short for fail test case
				File screen =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screen, new File("./Screenshot/Iterations/"+i+"_"+"Loginpage.png"));
				xl.setcelldata("Login", i, 2, "Login Fail", outputpath);
				xl.setcelldata("Login", i, 3, "fail", outputpath);
				
			}
		}
		
	}

}
