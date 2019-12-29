import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testSample {
	
	@Test(dataProvider = "getData")
	public void testLogin(String userName, String password, String browser) throws MalformedURLException {
		
		System.out.println(browser);
		
		
		DesiredCapabilities cap=null;
		
		if (browser.equals("firefox")) {
			cap=DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
			
		}else if(browser.equals("chrome")) {
			cap=DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
			
		}else if(browser.equals("ie")) {
			cap=DesiredCapabilities.internetExplorer();
			cap.setBrowserName("iexplorer");
			cap.setPlatform(Platform.WINDOWS);
			
		}
		
		
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://gmail.com");
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@class='RveJvd snByac']")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		driver.quit();
		
		
		
	}
	
	@DataProvider(parallel = true)
	public Object [][] getData() {
		
		Object data[][]=new Object[3][3];
		
		//firstrow
		data[0][0]="manishtest006@gmail.com";
		data[0][1]="Password_1";
		data[0][2]="firefox";
		
		//2ndrow
		data[1][0]="mkatepallewar@gmail.com";
		data[1][1]="Password_1";
		data[1][2]="chrome";
				
		//3rd row
		data[2][0]="jkatepallewar@gmail.com";
		data[2][1]="Password_1";
		data[2][2]="chrome";
		
		return data;
		
	}
}
