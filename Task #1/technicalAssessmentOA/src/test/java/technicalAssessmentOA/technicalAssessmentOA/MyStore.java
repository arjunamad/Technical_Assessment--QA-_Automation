package technicalAssessmentOA.technicalAssessmentOA;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyStore{
	
	@Test(priority = 1)
	public void TC_001_NavigateToHomepage() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
	     
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.quit();
	}

	@Test(priority = 2)
	
	public void TC_002_SearchItem() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		 

		WebElement searchBox = driver.findElement(By.id("search_query_top"));
		searchBox.sendKeys("T-SHIRT");
		WebElement searchBtn = driver.findElement(By.name("submit_search"));
		searchBtn.click();
 
		driver.getPageSource().contains("1 result has been found.");
		driver.quit();
	}

	@Test(priority = 3)
	public void TC_003_filterSearch() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

		WebElement womenCat = driver.findElement(By.className("sf-with-ul"));
		womenCat.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		
		WebElement category=driver.findElement(By.id("layered_category_4"));
		category.click();
		//check category is selected or not	
		System.out.println( category.isSelected());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		
		WebElement colour=driver.findElement(By.id("layered_id_attribute_group_11"));
		colour.click();
		//check color is selected or not	
		System.out.println( colour.isSelected());
		driver.getPageSource().contains("Showing");
		 
		
		driver.quit();
	}
	@Test(priority = 4)
	public void TC_004_Addtocart() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

		WebElement item= driver.findElement(By.linkText("Faded Short Sleeve T-shirts"));
		item.click();
		//click add to cart
		WebElement addToCartBtn= driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button[1]/span[1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		addToCartBtn.click();
		driver.getPageSource().contains("Product successfully added to your shopping cart");
		 
		
		driver.quit();
	}
	

}
