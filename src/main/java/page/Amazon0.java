package page;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Amazon0 {
	WebDriver driver;
	
	By productname=By.id("twotabsearchtextbox");
	By displaytype=By.xpath("//li[@id='p_n_feature_thirty-four_browse-bin/66009619031']//i[@class='a-icon a-icon-checkbox']");
	By selectedphone=By.xpath("//span[normalize-space()='Samsung Galaxy M32 Prime Edition (Black, 6GB RAM, 128GB)']");
	By imagelink=By.xpath("/html[1]/body[1]/div[2]/div[2]/div[5]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[1]/span[1]/span[1]/div[1]");
	By cartbutton=By.xpath("//a[@id='nav-cart']");
	By signin=By.xpath("//a[@id='a-autoid-0-announce']");
	By efield=By.xpath("//input[@id='ap_email']");
	By pswd=By.xpath("//input[@id='ap_password']");
	
	public Amazon0(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public void search()
	{
		driver.findElement(productname).sendKeys("samsung mobiles",Keys.ENTER);
		
	}
	public void filter()
	{
		driver.findElement(displaytype).click();
		
	}
	public void phone() throws Exception
	{
		driver.findElement(selectedphone).click();
		String parentWindow=driver.getWindowHandle();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(cartbutton));
		driver.findElement(cartbutton).click();
		driver.switchTo().window(parentWindow);
		wait.until(ExpectedConditions.visibilityOfElementLocated(signin));
		driver.findElement(signin).click();
		
	}
	public void sign()throws Exception
	{
		FileInputStream f=new FileInputStream("D:\\ECLIPSE EXCEL\\Book3.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet sh=wb.getSheet("Sheet1");
		int row =sh.getLastRowNum();
		for(int i=1;i<=row;i++)
		{
			String userid=sh.getRow(i).getCell(0).getStringCellValue();
			String password=sh.getRow(i).getCell(1).getStringCellValue();
		
			driver.findElement(efield).sendKeys(userid,Keys.ENTER);
			driver.findElement(pswd).sendKeys(password,Keys.ENTER);
			
													
	    }			
		File s=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(s,new File("D://screenshot3.png"));
				
	}
	

}
