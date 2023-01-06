package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import commonFunctions.AddEmppage;
import config.AppUtil1;
import utilities.ExcelFileUtil;

public class DriverScriptPOM extends AppUtil1 {
String inputpath = "D:\\JoeSelenium1\\Primus_bank\\DataDriven_Framework\\TestInput\\Employee1.xlsx";
String outputpath = "D:\\JoeSelenium1\\Primus_bank\\DataDriven_Framework\\TestOutput\\POMResults.xlsx";
@Test
public void startTest()throws Throwable
{
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	int rc = xl.rowcount("Empdata1");
	Reporter.log("No of rows are::"+rc,true);
	for(int i=1;i<=rc;i++) {
		String fname = xl.getcelldata("EmpData1", i, 0);
		String mname = xl.getcelldata("EmpData1", i, 1);
		String lname = xl.getcelldata("EmpData1", i, 2);
		AddEmppage emp = PageFactory.initElements(driver, AddEmppage.class);
		boolean res = emp.verifyEmp(fname, mname, lname);
		if(res) {
			xl.setcelldata("EmpData1", i, 3, "Pass", outputpath);
		}
		else {
			xl.setcelldata("EmpData1", i, 3, "Fail", outputpath);
		}
	}
	
}
}
